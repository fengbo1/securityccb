package securityccb.score.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.pojo.JiGou;
import securityccb.jigou.pojo.JiGouEx;
import securityccb.khps.pojo.Khps;
import securityccb.khps.pojo.KhpsEx;
import securityccb.operate.pojo.Operate;
import securityccb.operate.pojo.OperateEx;
import securityccb.score.pojo.Score;
import securityccb.score.pojo.ScoreEx;
import securityccb.util.ExportExcel;
import securityccb.util.Util;

import ccb.hibernate.HibernateSessionFactory;

public class SoreExport {
	private String year;
	private String position;
	private String Path;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String execute() throws Exception{
		String filePath = "";
		List<ScoreEx> list_score_ex = new ArrayList<ScoreEx>();
		List<JiGouEx> list_jigou_ex = new ArrayList<JiGouEx>();
		List<KhpsEx> list_khps_ex = new ArrayList<KhpsEx>();
		List<OperateEx> list_operate_ex = new ArrayList<OperateEx>();
		ExportExcel<ScoreEx> score_ex = new ExportExcel<ScoreEx>();
		ExportExcel<JiGouEx> jigou_ex = new ExportExcel<JiGouEx>();
		ExportExcel<KhpsEx> khps_ex = new ExportExcel<KhpsEx>();
		ExportExcel<OperateEx> operate_ex = new ExportExcel<OperateEx>();
		String[] headers_score = {"year","pnumber","sub"
				,"newnumber","jigouid","item","num","indx"
				,"score","scoretemp","ifabb","ifxz","stdscore"
				,"yuanscore","xzreason","remark","remarktemp"};
		String[] headers_jigou = {"jigouid","jigou","quanxian","remark1"};
		String[] headers_khps = {"jigouid","pnumber","item"
				,"date","jindu","status","preunder","thisunder"
				,"initiator","name","remark1","remark2","remark3"
				,"score"};
		String[] headers_operate = {"jigouid","pnumber","otime"
				,"odate","viewernum","viewername","viewoption"
				,"remark1","remark2","remark3","score"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		//score
		String hql = "from Score as s where s.year='"+year+"' and s.jigouid='"+position.substring(0, 3)+"'";
		System.out.println(hql);
		query = session.createQuery(hql);
		List<Score> list_score = query.list();
		for(int i=0;i<list_score.size();i++)
		{
			Score score = list_score.get(i);
			ScoreEx se = new ScoreEx();
			se.setYear(score.getYear());
			se.setPnumber(score.getPnumber());
			se.setSub(score.getSub());
			se.setNewnumber(score.getNewnumber());
			se.setJigouid(score.getJigouid());
			se.setItem(score.getItem());
			se.setNum(score.getNum());
			se.setIndx(score.getIndx());
			se.setScore(score.getScore());
			se.setScoretemp(score.getScoretemp());
			se.setIfabb(score.getIfabb());
			se.setIfxz(score.getIfxz());
			se.setStdscore(score.getStdscore());
			se.setYuanscore(score.getYuanscore());
			se.setXzreason(score.getXzreason());
			se.setRemark(score.getRemark());
			se.setRemarktemp(score.getRemarktemp());
			list_score_ex.add(se);
		}
		//jigou
		hql = "from JiGou where jigouid='"+position.substring(0, 3)+"'";
		System.out.println(hql);
		query = session.createQuery(hql);
		List<JiGou> list_jigou = query.list();
		for(int i=0;i<list_jigou.size();i++)
		{
			JiGou jigou = list_jigou.get(i);
			JiGouEx je = new JiGouEx();
			je.setJigouid(jigou.getJigouid());
			je.setJigou(jigou.getJigou());
			je.setQuanxian(jigou.getQuanxian());
			je.setRemark1(jigou.getRemark1());
			list_jigou_ex.add(je);
		}
		//khps
		hql = "from Khps where jigouid='"+position.substring(0, 3)+"' and remark3='"+year+"'";
		System.out.println(hql);
		query = session.createQuery(hql);
		List<Khps> list_khps = query.list();
		for(int i=0;i<list_khps.size();i++)
		{
			Khps khps = list_khps.get(i);
			KhpsEx ke = new KhpsEx();
			ke.setJigouid(khps.getJigouid());
			ke.setPnumber(khps.getPnumber());
			ke.setItem(khps.getItem());
			ke.setDate(khps.getDate());
			ke.setJindu(khps.getJindu());
			ke.setStatus(khps.getStatus());
			ke.setPreunder(khps.getPreunder());
			ke.setThisunder(khps.getThisunder());
			ke.setInitiator(khps.getInitiator());
			ke.setName(khps.getName());
			ke.setRemark1(khps.getRemark1());
			ke.setRemark2(khps.getRemark2());
			ke.setRemark3(khps.getRemark3());
			ke.setScore(khps.getScore());
			list_khps_ex.add(ke);
			
			//operate
			hql = "from Operate where pnumber='"+khps.getPnumber()+"'";
			System.out.println(hql);
			query = session.createQuery(hql);
			List<Operate> list_operate = query.list();
			for(int j=0;j<list_operate.size();j++)
			{
				Operate operate = list_operate.get(j);
				OperateEx oe = new OperateEx();
				oe.setJigouid(operate.getJigouid());
				oe.setPnumber(operate.getPnumber());
				oe.setOtime(operate.getOtime());
				oe.setOdate(operate.getOdate());
				oe.setViewernum(operate.getViewernum());
				oe.setViewername(operate.getViewername());
				oe.setViewoption(operate.getViewoption());
				oe.setRemark1(operate.getRemark1());
				oe.setRemark2(operate.getRemark2());
				oe.setRemark3(operate.getRemark3());
				oe.setScore(operate.getScore());
				list_operate_ex.add(oe);
			}
		}
		
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		//导出
		 try {
			 	filePath=Util.downloadpath+"score"+year+".xls";
				Path = "score"+year+".xls";
				OutputStream out = new FileOutputStream(filePath);
				 // 声明一个工作薄
		        HSSFWorkbook workbook = new HSSFWorkbook();
		        score_ex.exportExcelAddOne(workbook,"score", headers_score, list_score_ex);
		        jigou_ex.exportExcelAddOne(workbook,"jigou", headers_jigou, list_jigou_ex);
		        khps_ex.exportExcelAddOne(workbook,"khps", headers_khps, list_khps_ex);
		        operate_ex.exportExcelAddOne(workbook,"operate", headers_operate, list_operate_ex);
				try {
		            workbook.write(out);
		        } catch (IOException e) {
		        	System.out.println("100 i=");
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
				out.close();
				System.out.println("excel导出成功！");
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return "success";
	}
}
