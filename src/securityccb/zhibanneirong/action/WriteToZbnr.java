package securityccb.zhibanneirong.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.area.pojo.Area;
import securityccb.chu.pojo.Chu;
import securityccb.plan.dao.PlanDAO;
import securityccb.plan.pojo.Plan;
import securityccb.util.Util;
import securityccb.zhibanneirong.dao.ZhiBanNeirongDAO;
import securityccb.zhibanneirong.pojo.ZhiBanNeirong;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class WriteToZbnr extends ActionSupport{
private String jigouid; 
private String position; 
private String chushi;
private String chushiid;
private String areaname;
private String areaid;

	

public String getJigouid() {
	return jigouid;
}
public void setJigouid(String jigouid) {
	this.jigouid = jigouid;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public String getChushi() {
	return chushi;
}
public void setChushi(String chushi) {
	this.chushi = chushi;
}
public String getChushiid() {
	return chushiid;
}
public void setChushiid(String chushiid) {
	this.chushiid = chushiid;
}
public String getAreaname() {
	return areaname;
}
public void setAreaname(String areaname) {
	this.areaname = areaname;
}
public void setAreaid(String areaid) {
	this.areaid = areaid;
}
public String getAreaid() {
	return areaid;
}
/**
	 * 把Excele表读出的数据，组装成一个List,统一导入数据库
	 * @param uploadFileFileName
	 */
     //String path1=Util.yudayepath+"/securityccb";//"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/securityccb";

   // String path1="C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/securityccb";
//	String path2="C:\\Program Files\\Apache Software Foundation/Tomcat 7.0\\webapps\\securityccb";
public String loadRoleInfo(String uploadFileFileName,String jigouid){
	String message=null;
	String directory = Util.basepath+"upload/upload_zbnr"; 
	String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
	File target = new File(directory,uploadFileFileName);
	//List roleList = new ArrayList();
	ArrayList<Plan> roleList = new ArrayList();
	Session se;
	Transaction tr;
	se = HibernateSessionFactory.getSession();
	tr = se.beginTransaction();
	try{		
		ZhiBanNeirongDAO ud =new ZhiBanNeirongDAO();
		
		FileInputStream fi = new FileInputStream(target);
		Workbook wb = new HSSFWorkbook(fi);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum()+1;
		List <ZhiBanNeirong>alist=new ArrayList();

							
		for(int i=1;i<rowNum;i++){
			
			String areaid="";
			String zhibanneirong="";
			String chushi="";

          

            

        	
            Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for(int j=0;j<cellNum;j++){
				Cell cell = row.getCell(j);
				String cellValue = null;
				if(cell!=null){
					//cell.setCellValue("");
					//cell.setCellType(1);
				//	cell.setCellValue(arg0)
				
					cellValue =  Util.getCellValue(cell, 0);
				
				}
				switch(j){//通过列数来判断对应插如的字段
					case 0 : {
						areaname=cellValue;
						System.out.println("值班区域读取内容："+areaname)	;
						break;
					}
					case 1 : {
						zhibanneirong=cellValue;
						System.out.println("值班内容取内容："+zhibanneirong);
						break;
					}
				}						
								
			}
			List<WriteToZbnr> arealist=findareabyjigouid(jigouid,se);	
			
			for (int n=0;n<arealist.size();n++){
				if(areaname.equals(arealist.get(n).getAreaname())){
					areaid=arealist.get(n).getAreaid();
				}
			}
			ZhiBanNeirong z=new ZhiBanNeirong ();
             z.setAreaid(areaid);
             z.setZhibanneirong(zhibanneirong);
			ud.merge(z);		
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
	public List<WriteToZbnr> findareabyjigouid(String jigouid,Session session){
		
            List<Chu> chulist;	
            List<Area> arealist;
           // List <WriteToZbnr> zbnrlist ;
            List <WriteToZbnr> zbnrlist=new ArrayList();
		try {
			
			chulist=findchushiidbyjigouid(jigouid,session);
			
			
			for(int i=0;i<chulist.size();i++){
				
				arealist=findareabychushiid(chulist.get(i).getChushiid(),session);
				
								
				for(int j=0;j<arealist.size();j++){
					
					WriteToZbnr wtz=new WriteToZbnr();
					
					wtz.setChushi(chulist.get(i).getChushi());
					wtz.setChushiid(chulist.get(i).getChushiid());
					wtz.setAreaname(arealist.get(j).getAreaname());
					wtz.setAreaid(arealist.get(j).getAreaid());
					
					zbnrlist.add(wtz);				
				
				
				}
				
			}		
			
							
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return zbnrlist;	
	
	
	}
	public List findchushiidbyjigouid(String jigouid,Session session){
		       Query query;
		       List<Chu> chulist = null;
		try {

	        String sql="SELECT * from chu where jigouid = "+"'"+jigouid+"'";			
			System.out.println(sql);
			query  = session.createSQLQuery(sql).addEntity(Chu.class);		
		    chulist = query.list();						
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return chulist;		
	
	}
	public List findareabychushiid(String chushiid,Session session){
	       Query query;
	       List<Area> alist = null;
	try {

        String sql="SELECT * from area where chushiid = "+"'"+chushiid+"'";			
		System.out.println(sql);
		query  = session.createSQLQuery(sql).addEntity(Area.class);		
		alist = query.list();						
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return alist;		

}
}
