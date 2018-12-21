package securityccb.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.config.dao.ScoreFlagDAO;
import securityccb.config.pojo.ScoreFlag;
import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.kpxm.dao.KpxmDAO;
import securityccb.kpxm.pojo.Kpxm;
import securityccb.paiban.pojo.PaiBan;
import securityccb.score.dao.ScoreDAO;
import securityccb.score.pojo.Score;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;

import securityccb.zhiban.pojo.ZhiBan;


import java.lang.Integer;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 考核审批相关的小工具
 * @author htzx
 *
 */
public class Util {

	/**
	 * 
	 * @param type
	 * @return
	 */

//	public static final String basepath ="C:/Program Files/apache-tomcat-7.0.59/webapps/securityccb/";
//	public static final String yudayepath ="C:/Program Files/apache-tomcat-7.0.59/webapps/";

//	public static final String basepath ="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/securityccb/";
//	public static final String yudayepath ="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/";

	public static final String basepath = "/securityccb/";
//32位
//	public static final String basepath = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/securityccb/";
//	public static final String yudayepath1 = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/";
//64位	
//	public static final String basepath = "C:/Program Files (x86)/Apache Software Foundation/Tomcat 7.0/webapps/securityccb/";
//	public static final String yudayepath = "C:/Program Files (x86)/Apache Software Foundation/Tomcat 7.0/webapps/";

	public static final String downloadpath = basepath+"derive/" ;//下载
	
	public static final String recordpath = basepath+"upload/upload_record";
	public static final String jgxqpath = basepath+"upload/upload_jgxq";
	public static final String jglike = "___________";//11位
	//根据quanxian判断是否可以点击操作类按钮 处长主任老总均不可操作
	public static boolean CanOperate(String newnumber)
	{
		boolean result;
		UserInfo ui=new UserInfo();
		UserInfoDAO uidao=new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    String quanxian="";
 	    if(uidao.findByNewnumber(newnumber).isEmpty())
 	    {
 	    	
 	    }else
 	    {
 	    	ui=(UserInfo)uidao.findByNewnumber(newnumber).get(0);
 	    	quanxian=ui.getQuanxian();
		}
 	    if(quanxian.trim().equals("3")||quanxian.trim().equals("2")||quanxian.trim().equals("4"))
 	    	result=false;
 	    else
 	    	result=true;
 	        
		trans.commit();
 		session.flush();
 		session.clear();
 		session.close();
		return result;
		
	}
	//是否可以评分
	public static boolean CanPingfen()
	{
		boolean result=false;
		ScoreFlag sflag=new ScoreFlag();
		ScoreFlagDAO uidao=new ScoreFlagDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    
 	    if(uidao.findAll().isEmpty())
 	    {
 	    	result=false;
 	    }else 
 	    {
 	    	sflag=(ScoreFlag)uidao.findAll().get(0);
 	    	if(sflag.getFlag()==1)
 	    	    
 	 	    	result=true;
 	    }	
 	    	
 	        
		trans.commit();
 		session.flush();
 		session.clear();
 		session.close();
		return result;
		
	}
	//根据quanxian判断是否可以对本处室进行排班
	public static boolean CanPaiban(String newnumber)
	{
		boolean result;
		UserInfo ui=new UserInfo();
		UserInfoDAO uidao=new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    String quanxian="";
 	    if(uidao.findByNewnumber(newnumber).isEmpty())
 	    {
 	    	
 	    }else
 	    {
 	    	ui=(UserInfo)uidao.findByNewnumber(newnumber).get(0);
 	    	quanxian=ui.getQuanxian();
		}
 	    if(quanxian.trim().equals("3"))
 	    	result=false;
 	    else
 	    	result=true;
 	        
		trans.commit();
 		session.flush();
 		session.clear();
 		session.close();
		return result;
		
	}

	//判断当天 责任区值班完成情况
	public static String zhibanarea(String newnumber,String areaid) {
	    Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String today=dateFormat.format(now);
		String jieguo1=null;

		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<ZhiBan> list = null;
		
		try {
	        String sql="SELECT * from zhiban where date = '"+today+"' and areaid='"+areaid+"'" ;			
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(ZhiBan.class);		
			list = query.list();	
	
			sql="SELECT * from paiban where begindate <= '"+today+"' and enddate>='"+today+"' and areaid='"+areaid+"'" ;			
			System.out.println(sql);//判断是否有排班记录
			query = session.createSQLQuery(sql).addEntity(PaiBan.class);
			List<PaiBan> listpb = query.list();
		
			if(listpb.isEmpty()){//未排班
				jieguo1="99"; 
			}
			else if(list.size()==0){
			jieguo1="0"; //可以进入值班页面
			}
			else if(null!=list&&list.size()==2){
				jieguo1="2";  //已经有两个人在此区域值班了，不能进入值班页面
			}
			else if(list.size()==1&&list.get(0).getNewnumber().equals(newnumber)){
				jieguo1="3";  //有一个值班，而且还是本人，不能进入值班页面
			}
			else if(list.size()==1&&!list.get(0).getNewnumber().equals(newnumber)){
				jieguo1="4"; //有一个值班，不是本人，能进入值班页面
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
		
		
		return jieguo1;		

	}
       public static String rolequanxianToString(String input)
       {
    	   String roledesc = "";
    	   if(input.equals("13"))
	       {
    		   roledesc = "机构主要负责人";
	       }
    	   else if(input.equals("14"))
    	   {
    		   roledesc = "机构主要负责人（分管安保）";
    	   }
    	   else if(input.equals("23"))
    	   {
    		   roledesc = "机构其他负责人";
    	   }
    	   else if(input.equals("24"))
    	   {
    		   roledesc = "机构其他负责人（分管安保）";
    	   }
    	   else if(input.equals("33"))
    	   {
    		   roledesc = "综合部门负责人";
    	   }
    	   else if(input.equals("51"))
    	   {
    		   roledesc = "机构安全岗";
    	   }
    	   else if(input.equals("52"))
    	   {
    		   roledesc = "处室安全岗";
    	   }
    	   else//53
    	   {
    		   roledesc = "普通员工";
    	   }
    	   return roledesc;
       }
       public static String zhiwuTorolequanxian(String zhiwu)  {
    		String zhiwu1="";
    		zhiwu = zhiwu.trim();
    		
    		if(zhiwu.contains("机构其他负责人")&&zhiwu.contains("分管安保")){
    			zhiwu1="24";
    		}
    		else if(zhiwu.contains("机构主要负责人")&&zhiwu.contains("分管安保")){
    			zhiwu1="14";
    		}
    		else if(zhiwu.contains("机构主要负责人")){
    			zhiwu1="13";
    		}
    		else if(zhiwu.contains("机构其他负责人")){
    			zhiwu1="23";
    		}
    		else if(zhiwu.contains("综合部门负责人")){
    			zhiwu1="33";
    		}
    		else if(zhiwu.contains("机构安全岗")){
    			zhiwu1="51";
    		}
    		else if(zhiwu.contains("处室安全岗")){
    			zhiwu1="52";
    		}
    		else{
    			zhiwu1="53";
    		}	
    		return zhiwu1;
    	}
       
     //根据newnumber查找对应系统角色名称
       public static String numberToRoledesc(String newnumber) {
		
		
	    String roledesc="";

		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		UserInfo user=new UserInfo();
		UserInfoDAO udao=new UserInfoDAO();
		JiGou jigou=new JiGou();
		JiGouDAO jdao=new JiGouDAO();
		String position="";
		int flag=0;
		try {
			user=(UserInfo)udao.findByNewnumber(newnumber).get(0);
			position=user.getPosition();
			String sql="SELECT * from userinfo where role='1' and substr(position,1,3) = "+position.substring(0,3) +" ";	
			query = session.createSQLQuery(sql).addEntity(UserInfo.class);		
			List<UserInfo> list = query.list();	
	        jigou=(JiGou)jdao.findByJigouid(position.substring(0, 3)).get(0);
	        roledesc = rolequanxianToString(position.substring(9, 11));
		    	
		   
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}		
		
		
		return roledesc;		

	}
	
       public static String dateToStandard(String date)
       {
    	   if(date!=null)
    	   {
    		   if(date.length()==8)
    		   {
    			   date = date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8);
    		   }
    	   }
    	   return date;
       }
       
       /**
        * 取单元格的值
        * @param cell 单元格对象
        * @param treatAsStr 0:数字，字符；1：日期；2时间
        * @return
        */
       public String getCellValue(Cell cell, int type) {
           if (cell == null) {
               return "";
           }
           if (type==0) {
               // 虽然excel中设置的都是文本，但是数字文本还被读错，如“1”取成“1.0”
               // 加上下面这句，临时把它当做文本来读取
               cell.setCellType(Cell.CELL_TYPE_STRING);
           }
           else if(type==1)
           {
       		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       		return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
           }
           else if(type==2)
           {
           	String temp = "";
           	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
           	temp = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
           	if(temp.startsWith("12"))
           	{
           		return "00"+temp.substring(2,8);
           	}
           	else
           	{
           		return temp;
           	}
           }
           if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
               return String.valueOf(cell.getBooleanCellValue());
           } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
           	
               return String.valueOf(cell.getNumericCellValue());
           } else {
               return String.valueOf(cell.getStringCellValue());
           }
       }
}


///////////////////////////////


