package securityccb.plan.action;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.plan.dao.PlanDAO;
import securityccb.plan.pojo.Plan;
import securityccb.util.UploadUtil;
import securityccb.util.Util;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class WriteToPlan extends ActionSupport{
private String jigouid; 
public String getJigouid() {
		return jigouid;
	}
public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
public String loadRoleInfo(String uploadFileFileName,String jigouid){
	Util util = new Util();
	UploadUtil uu = new UploadUtil();
	String directory = Util.basepath+"upload/upload_plan"; 
	//File target = new File(directory,uploadFileFileName);
	Session se = HibernateSessionFactory.getSession();
	Transaction tr = se.beginTransaction();
	try{		
		PlanDAO ud =new PlanDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//FileInputStream fi = new FileInputStream(target);
		Workbook wb = uu.getWorkbook(directory+"/"+uploadFileFileName);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum()+1;
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
					if(cell.getCellStyle().getDataFormatString().contains("yy"))
					{
						cellValue =  sdf.format(cell.getDateCellValue());
					}
					else
					{
						cellValue =  util.getCellValue(cell, 0);
					}
				switch(j){//通过列数来判断对应插如的字段
					case 0 : {
						year=cellValue;
						break;
					}
					case 1 : {
						month=cellValue;
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
						break;
					}
					case 3 : {
						content2=cellValue;
						break;
					}
					case 4 :  { 
						people=cellValue;	
						break;
					}
					case 5 :{
						plandate=cellValue;
						break;
					}		
					case 6 :{
						remark=cellValue;
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
