package securityccb.score.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.operate.dao.OperateDAO;
import securityccb.operate.pojo.Operate;
import securityccb.score.dao.ScoreDAO;
import securityccb.score.pojo.Score;
import securityccb.util.UploadUtil;
import securityccb.util.Util;

public class ScoreImport {
	private String message;
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String execute() throws Exception {
		message="导入成功";
		String sql = "";
		JiGouDAO jgdao = new JiGouDAO();
		KhpsDAO kpdao = new KhpsDAO();
		OperateDAO opdao = new OperateDAO();
		ScoreDAO scdao = new ScoreDAO();
		UploadUtil uu = new UploadUtil();
		String realpath = Util.basepath+"upload/";
		String realpathfile = realpath+fileFileName;
		if (file != null) {
            File savefile = new File(new File(realpath), fileFileName);
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            FileUtils.copyFile(file, savefile);
        }
		else
        {
			message="传入文件有误";
        }
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		try {	
			// 获得第一个工作表对象
			Workbook workbook = uu.getWorkbook(realpathfile);
			//第二个表
			Sheet sheet2 = workbook.getSheetAt(1);
			int nn = sheet2.getLastRowNum()+1;
			for (int i = 1; i < nn; i++) {
				Row currentRow = sheet2.getRow(i);
				String jigouid = uu.getCellValue(currentRow.getCell(0), 0).trim();
				if(jigouid!=null&&jigouid.length()>0)
				{
					String jigouname = uu.getCellValue(currentRow.getCell(1), 0).trim();
					JiGou jg1 = jgdao.findJigouByJigouid(jigouid);
					JiGou jg2 = jgdao.findJigouByJigouname(jigouname);
					if(jg1!=null&&!jg1.getJigou().equals(jigouname))
					{
						message="导入失败！！！，导入数据时在数据库中发现机构id【"+jigouid+"】相同，机构名称不同";
						return "success";
					}
					else if(jg2!=null&&!jg2.getJigouid().equals(jigouid))
					{
						message="导入失败！！！，导入数据时在数据库中发现机构名称【"+jigouname+"】相同，机构id不同";
						return "success";
					}
					else
					{
						JiGou jg = jgdao.findJigouByJigouidNullNew(jigouid);
						jg.setJigou(uu.getCellValue(currentRow.getCell(1), 0).trim());
						jg.setQuanxian(uu.getCellValue(currentRow.getCell(2), 0).trim());
						jg.setRemark1(uu.getCellValue(currentRow.getCell(3), 0).trim());
						jgdao.merge(jg);
					}
				}
			}
			
			//第三个表
			Sheet sheet3 = workbook.getSheetAt(2);
			nn = sheet3.getLastRowNum()+1;
			for (int i = 1; i < nn; i++) {
				Row currentRow = sheet3.getRow(i);
				String jigouid = uu.getCellValue(currentRow.getCell(0), 0).trim();
				if(jigouid!=null&&jigouid.length()>0)
				{
					String year = uu.getCellValue(currentRow.getCell(12), 0).trim();
					String pnum = uu.getCellValue(currentRow.getCell(1), 0).trim();
					sql = "delete from operate where pnumber='"+pnum+"'";
					session.createSQLQuery(sql).executeUpdate();
					sql = "delete from score where jigouid='"+jigouid+"' and year='"+year+"'";
					session.createSQLQuery(sql).executeUpdate();
					Khps khps = kpdao.findByJgidAndYearNullNew(jigouid, year);
					khps.setPnumber(pnum);
					khps.setItem(Integer.valueOf(uu.getCellValue(currentRow.getCell(2), 0).trim()));
					khps.setDate(uu.getCellValue(currentRow.getCell(3), 0).trim());
					khps.setJindu(uu.getCellValue(currentRow.getCell(4), 0).trim());
					khps.setStatus(uu.getCellValue(currentRow.getCell(5), 0).trim());
					khps.setPreunder(uu.getCellValue(currentRow.getCell(6), 0).trim());
					khps.setThisunder(uu.getCellValue(currentRow.getCell(7), 0).trim());
					khps.setInitiator(uu.getCellValue(currentRow.getCell(8), 0).trim());
					khps.setName(uu.getCellValue(currentRow.getCell(9), 0).trim());
					khps.setScore(Double.valueOf(uu.getCellValue(currentRow.getCell(13), 0).trim()));
					kpdao.merge(khps);
				}
			}
			//第四个表
			Sheet sheet4 = workbook.getSheetAt(3);
			nn = sheet4.getLastRowNum()+1;
			for (int i = 1; i < nn; i++) {
				Row currentRow = sheet4.getRow(i);
				String pnumber = uu.getCellValue(currentRow.getCell(1), 0).trim();
				if(pnumber!=null&&pnumber.length()>0)
				{
					String otime = uu.getCellValue(currentRow.getCell(2), 0).trim();
					String odate = uu.getCellValue(currentRow.getCell(3), 0).trim();
					Operate op = opdao.findByJgPnOtOd(pnumber, otime, odate);
					op.setJigouid(uu.getCellValue(currentRow.getCell(0), 0).trim());
					op.setViewernum(uu.getCellValue(currentRow.getCell(4), 0).trim());
					op.setViewername(uu.getCellValue(currentRow.getCell(5), 0).trim());
					op.setViewoption(Integer.valueOf(uu.getCellValue(currentRow.getCell(6), 0).trim()));
					op.setRemark1(uu.getCellValue(currentRow.getCell(7), 0).trim());
					op.setRemark2(uu.getCellValue(currentRow.getCell(8), 0).trim());
					op.setRemark3(uu.getCellValue(currentRow.getCell(9), 0).trim());
					op.setScore(Double.valueOf(uu.getCellValue(currentRow.getCell(10), 0).trim()));
					opdao.merge(op);
				}
			}
			//第一个表
			Sheet sheet1 = workbook.getSheetAt(0);
			nn = sheet1.getLastRowNum()+1;
			for (int i = 1; i < nn; i++) {
				Row currentRow = sheet1.getRow(i);
				String jigouid = uu.getCellValue(currentRow.getCell(4), 0).trim();
				if(jigouid!=null&&jigouid.length()>0)
				{
					Score sc = new Score();
					sc.setYear(uu.getCellValue(currentRow.getCell(0), 0).trim());
					sc.setPnumber(uu.getCellValue(currentRow.getCell(1), 0).trim());
					sc.setSub(uu.getCellValue(currentRow.getCell(2), 0).trim());
					sc.setNewnumber(uu.getCellValue(currentRow.getCell(3), 0).trim());
					sc.setJigouid(jigouid);
					sc.setItem(uu.getCellValue(currentRow.getCell(5), 0).trim());
					sc.setNum(Integer.valueOf(uu.getCellValue(currentRow.getCell(6), 0).trim()));
					sc.setIndx(Integer.valueOf(uu.getCellValue(currentRow.getCell(7), 0).trim()));
					sc.setScore(Double.valueOf(uu.getCellValue(currentRow.getCell(8), 0).trim()));
					sc.setScoretemp(Double.valueOf(uu.getCellValue(currentRow.getCell(9), 0).trim()));
					sc.setIfabb(Integer.valueOf(uu.getCellValue(currentRow.getCell(10), 0).trim()));
					sc.setIfxz(Integer.valueOf(uu.getCellValue(currentRow.getCell(11), 0).trim()));
					sc.setStdscore(Double.valueOf(uu.getCellValue(currentRow.getCell(12), 0).trim()));
					sc.setYuanscore(Double.valueOf(uu.getCellValue(currentRow.getCell(13), 0).trim()));
					sc.setXzreason(uu.getCellValue(currentRow.getCell(14), 0).trim());
					sc.setRemark(uu.getCellValue(currentRow.getCell(15), 0).trim());
					sc.setRemarktemp(uu.getCellValue(currentRow.getCell(16), 0).trim());
					scdao.merge(sc);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}		
		
		return "success";
	}
}
