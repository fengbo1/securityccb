package securityccb.downfile;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import securityccb.jigou.action.JigouAction;
import securityccb.jigou.pojo.JiGou;
import securityccb.plan.pojo.Plan;
import securityccb.userinfo.action.UserInfoUp;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.Util;

import securityccb.area.pojo.Area;
import securityccb.chu.pojo.Chu;


import ccb.hibernate.HibernateSessionFactory;

public class DownPlan {
	private static final Log log = LogFactory.getLog(DownPlan.class);
	private String year;
	private String month;
	private String week;
	private String content;
	private String people;
	private Date plandte;
	private String remark;
	private String position;
	private String fileurl;
	private List<Plan> mylist;

	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
        //根据jigouid查出本机机构所人员，装到mylist中。
		
		Query query;		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		
		try {
			 //根据jigouid查出本机机构plan放到mylist中。
			String jigouid=position.substring(0, 3);
			mylist=findallbyjigouid(jigouid, session);
			List<Plan> udownlist=new ArrayList();
			
			 //把mylist中对象装到udownlist中，为写文件下载做准备。
			
				
	
			   
				udownlist=mylist;
			
		
			//把udownlist中数据放到数组bb中去啊
				//String k=Util.yudayepath;
				String filePath = Util.basepath+"downfile/down_plan";
			String [][] bb=new String[udownlist.size()][7];
			String dd[]={"年份","月份","周","工作内容","责任人","计划完成时间","备注"};
			for (int i=0;i<udownlist.size();i++)
			{
				 bb[i][0]=udownlist.get(i).getYear();
				 bb[i][1]=udownlist.get(i).getMonth();
				 
				 bb[i][2]=udownlist.get(i).getWeek();
				 
				 bb[i][3]=udownlist.get(i).getContent();
				 
				 bb[i][4]=udownlist.get(i).getPeople();
				 
				 bb[i][5]=udownlist.get(i).getPlandate().toString();	
				 
				 bb[i][6]=udownlist.get(i).getRemark();	
				  

				 
				 System.out.println("工作计划下载中"+udownlist.get(i).getId()+"导出正常！");
			}
			
			     Date now = new Date();
			     SimpleDateFormat DateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
			     String today=DateFormat.format(now);
			
			    //打开文件
				FileOutputStream file = new FileOutputStream(filePath+"/"+jigouid+"_"+today+"_plan.xls");
				fileurl="/securityccb/downfile/down_plan/"+jigouid+"_"+today+"_plan.xls";
				WritableWorkbook book=Workbook.createWorkbook(file);
				
			
				//生成名为“第一页”的工作表，参数0表示这是第一页
				WritableSheet sheet=book.createSheet("工作计划",0);
				//设置列宽
				sheet.setColumnView(0,20);
				sheet.setColumnView(1,10);				
				sheet.setColumnView(2,15);
				sheet.setColumnView(3,30);				
				sheet.setColumnView(4,20);
				sheet.setColumnView(5,50);				
				sheet.setColumnView(6,20);
				sheet.setColumnView(7,20);
				sheet.setColumnView(8,20);
		
									
					for (int i=0;i<udownlist.size();i++)
					{
						for (int j=0;j<7;j++)
						{
							///WritableFont font=new WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.RED);
							//WritableCellFormat cFormat=new WritableCellFormat(font);
							//cFormat.setBackground(Colour.BLUE_GREY);
							
							
							//在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
							//以及单元格内容为test
							Label label=new Label(j,i+1,bb[i][j]);
					
							//将定义好的单元格添加到工作表中
							sheet.addCell(label);
						}
						    
					}
					for (int j=0;j<7;j++)
					{
						//在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
						//以及单元格内容为test
						Label label=new Label(j,0,dd[j]);
				
						//将定义好的单元格添加到工作表中
						sheet.addCell(label);
					}
					/*生成一个保存数字的单元格
					必须使用Number的完整包路径，否则有语法歧义
					单元格位置是第二列，第一行，值为789.123*/
			//		jxl.write.Number number = new jxl.write.Number(1,0,789.123);
			//		sheet.addCell(number);
					
					//写入数据并关闭文件
					book.write();
					book.close();
					file.close();
					
					//OutputStream out = new FileOutputStream(filePath+"/dddd.xls");
					//out.close();
			
			
			

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

	public List<Plan> findallbyjigouid(String jigouid,Session session) //通过机构ID查询机构全称
    {
		Query query;			
		List<Plan> list = null ;
		try {

	        String sql="SELECT * from plan where jigouid = "+"'"+jigouid+"'";			
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(Plan.class);		
			list = query.list();			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
		
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public Date getPlandte() {
		return plandte;
	}

	public void setPlandte(Date plandte) {
		this.plandte = plandte;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public List<Plan> getMylist() {
		return mylist;
	}

	public void setMylist(List<Plan> mylist) {
		this.mylist = mylist;
	}

	
	
	

	
	
}
