package securityccb.plan.action;
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
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.plan.dao.PlanDAO;
import securityccb.plan.pojo.Plan;
import securityccb.util.Util;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class WriteToPlan extends ActionSupport{
private String jigouid; 
private String position; 

	
public String getJigouid() {
		return jigouid;
	}
public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}

/**
	 * 把Excele表读出的数据，组装成一个List,统一导入数据库
	 * @param uploadFileFileName
	 */
//String path1=Util.yudayepath+"/securityccb";//"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/securityccb";
//String path2="C:\\Program Files\\Apache Software Foundation/Tomcat 7.0\\webapps\\securityccb";	

//String path1="C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/securityccb";
//String path2="C:\\Program Files\\Apache Software Foundation/Tomcat 7.0\\webapps\\securityccb";
public String loadRoleInfo(String uploadFileFileName,String jigouid){
	String message=null;
	String directory = Util.basepath+"upload/upload_plan"; 
	String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
	File target = new File(directory,uploadFileFileName);
	//List roleList = new ArrayList();
	ArrayList<Plan> roleList = new ArrayList();
	Session se;
	Transaction tr;
	se = HibernateSessionFactory.getSession();
	tr = se.beginTransaction();
	try{		
		PlanDAO ud =new PlanDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		FileInputStream fi = new FileInputStream(target);
		Workbook wb = new HSSFWorkbook(fi);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum()+1;
		List <Plan>alist=new ArrayList();

							
		for(int i=1;i<rowNum;i++){
			
			String year="";
			String week="";
			String month="";
			String content2="";			
			String plandate="";
            String people="";
            String remark="";
          

            

        	
            Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for(int j=0;j<cellNum;j++){
				Cell cell = row.getCell(j);
				String cellValue = null;
				if(cell!=null){
					//cell.setCellValue("");
					//cell.setCellType(1);
				//	cell.setCellValue(arg0)
				
//					cellValue =  Util.getCellValue(cell, 0);
					if(cell.getCellStyle().getDataFormatString().contains("yy"))
					{
						cellValue =  sdf.format(cell.getDateCellValue());
					}
					else
					{
						cellValue =  Util.getCellValue(cell, 0);
					}
//				switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
//					case 0 : cellValue = String.valueOf((int)cell.getNumericCellValue()); break;
//					case 1 : cellValue = cell.getStringCellValue(); break;
//					case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
//					case 3 : cellValue = ""; break;
//					case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
//					case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
//				}
				switch(j){//通过列数来判断对应插如的字段
					case 0 : {
						year=cellValue;
						System.out.println("年读取内容："+year)	;
						break;
					}
					case 1 : {
						month=cellValue;
						System.out.println("月读取内容："+month);
						break;
					}
					case 2 : { 
						week=cellValue;	
						if(week.contains("常规"))
						{
							week = "6";
						}
						if(week.contains("待定"))
						{
							week = "7";
						}
						System.out.println("周："+week)	;					
						break;
					}
					case 3 : {
						content2=cellValue;
						System.out.println("工作计划读取内容："+content2);
						break;
					}
					case 4 :  { 
						people=cellValue;	
						System.out.println("责任人读取内容："+people);												
						break;
					}
					case 5 :{
						plandate=cellValue;
						System.out.println("计划完成时间："+plandate);
						break;
					}		
					case 6 :{
						remark=cellValue;
						System.out.println("备注："+remark);

						break;
					}	
									}	
				}						
					
								
			}
			Plan p=new Plan ();
			if(content2!=null&&content2.length()>1)
		    {
				 p.setContent(content2);
				    p.setJigouid(jigouid);
				    p.setMonth(month);
				    p.setPeople(people);
				   if(plandate==null){
					   plandate="0000-00-00";
				   }
				   if(plandate.equals("")){
					   plandate="0000-00-00";
				   }
				    p.setPlandate(sdf.parse(plandate+" 00:00:00"));
				    p.setRemark(remark);
				    p.setWeek(week);
				    p.setYear(year);
				    ud.merge(p);
		    }
			//alist.add(p);			
		}	
	
//		for(int i=0;i<alist.size();i++){
//			ud.save(alist.get(i));
//		}
		
		
	
	}	
			catch(IOException e){
				tr.rollback();//出错回滚
			e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
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
