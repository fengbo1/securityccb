package securityccb.zhibanneirong.action;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.area.dao.AreaDAO;
import securityccb.util.UploadUtil;
import securityccb.util.Util;
import securityccb.zhibanneirong.dao.ZhiBanNeirongDAO;
import securityccb.zhibanneirong.pojo.ZhiBanNeirong;
import ccb.hibernate.HibernateSessionFactory;

public class WriteToZbnr{
public String loadRoleInfo(String uploadFileFileName,String jigouid){
	UploadUtil uu = new UploadUtil();
	Util util = new Util();
	AreaDAO areadao = new AreaDAO();
	String directory = Util.basepath+"upload/upload_zbnr"; 
	//File target = new File(directory,uploadFileFileName);
	Session se = HibernateSessionFactory.getSession();
	Transaction tr = se.beginTransaction();
	try{		
		ZhiBanNeirongDAO ud =new ZhiBanNeirongDAO();
		//FileInputStream fi = new FileInputStream(target);
		//Workbook wb = new HSSFWorkbook(fi);
		Workbook wb = uu.getWorkbook(directory+"/"+uploadFileFileName);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum()+1;
		for(int i=1;i<rowNum;i++){
			String areaid="";
			String areaname="";
			String zhibanneirong="";
            Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for(int j=0;j<cellNum;j++){
				Cell cell = row.getCell(j);
				String cellValue = null;
				if(cell!=null){
					cellValue =  util.getCellValue(cell, 0);
				}
				switch(j){//通过列数来判断对应插如的字段
					case 0 : {
						areaname=cellValue;
						break;
					}
					case 1 : {
						zhibanneirong=cellValue;
						break;
					}
				}						
			}
			areaid = areadao.findAreaidByAreanameAndJigouid(areaname, jigouid);
			if(areaid!="")
			{
				ZhiBanNeirong z=new ZhiBanNeirong ();
	            z.setAreaid(areaid);
	            z.setZhibanneirong(zhibanneirong);
				ud.merge(z);		
			}
		}	
	}	
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				tr.commit();
				se.flush();
				se.clear();
				se.close();
				}		
	
     return "success"; 
	}
}
