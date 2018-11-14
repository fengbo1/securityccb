package securityccb.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.kpxm.dao.KpxmDAO;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 考核审批相关的小工具
 * @author htzx
 *
 */
public class KhpsUtil {

	/**
	 * 
	 * @param type
	 * @return
	 */
	
	
	public static String JigouidToName(String jigouid)
	{
		
		JiGou jg=new JiGou();
		JiGouDAO jgdao=new JiGouDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		jg=(JiGou)jgdao.findByJigouid(jigouid).get(0);
		String result=jg.getJigou();
		trans.commit();
 		session.flush();
 		session.clear();
 		session.close();
		return result;
	}
	public static String FindStatusByjgid(String jigouid)
	{
		
		JiGou jg=new JiGou();
		Khps kp=new Khps();
		String status;
		List<Khps> list = new ArrayList<Khps>();
		KhpsDAO kpdao=new KhpsDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	   list=(List<Khps>)kpdao.findByJigouid(jigouid);
 	   if(list.isEmpty())
 	   {
 		  status="未开始";
 	   }
 	   else
 	   {
 		  kp=(Khps)kpdao.findByJigouid(jigouid).get(0);
 		  status=StatustoName(kp.getStatus(),kp);
 	   }
		
		
		trans.commit();
 		session.flush();
 		session.clear();
 		session.close();
		return status;
	}
	public static String KhxmItemToString(String item)
	{
		KpxmDAO kdao = new KpxmDAO();
		String result = "";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    if(item!=null)
		{
			result = kdao.findByItemAndNum(item, 1).getRemark2();
		}
		trans.commit();
 		session.flush();
 		session.clear();
 		session.close();
		return result;
		
	}
	public static String OptionToString(Integer option)
	{
		
		String result;
		if(option==2)
			result="不同意";
			
		else if(option==1)
			result="同意";
		else 
			result="提交";
		return result;
	}
	
	public static String IdtoName(String userid)
	{
		String result="";
		UserInfo ui=new UserInfo();
		UserInfoDAO uidao=new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    if(uidao.findByNewnumber(userid).isEmpty())
 	    {
 	    	
 	    }else
 	    {
 	    	ui=(UserInfo)uidao.findByNewnumber(userid).get(0);
			result=ui.getName();
		}
 	        
		trans.commit();
 		session.flush();
 		session.clear();
 		session.close();
		return result;
	}
	

	//根据进度显示不同的状态
	public static String StatustoName(String status,Khps kh)
	{
		
		String result="";
		int jindu=0;
		if(kh!=null)
		    jindu=Integer.parseInt(kh.getJindu());
		else
			return "考核未开始";
		
		
		if(status.equals("1"))
		{
			result="机构自评";
			if(kh.getItem()==1)
			{
				
				if(jindu==6)
				    result="待总行审批";
				else if(jindu==7)
				    result="已提交审批";
				else if(jindu>=2&jindu<=5)
					result="总行评审";
								
			}else if(kh.getItem()==2)
			{
				if(jindu==8)
					result="待总行审批";
				else if(jindu==9)
				    result="已提交审批";
				else if(jindu>=3&jindu<=7)
					result="总行评审";
			}
					
		}			
		else if(status.equals("2"))
			result="已退回待处理";
		else if(status.equals("4"))
			result="考核结束";
		else if(status.equals("0"))
			result="机构自评";
		
		return result;
	}
	/*
	 *double保留小数点后两位 
	 *
	 */
	public static Double DoubleTo2(Double num)
	{
		double result=0.0;
		BigDecimal b = new BigDecimal(num+0.0000000001);
		
		result = b.setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
		
	}
	/*
	 *double保留小数点后1位 
	 *
	 */
	public static Double DoubleTo1(Double num)
	{
		double result=0.0;
		BigDecimal b = new BigDecimal(num+0.0000000001);
		
		result = b.setScale(1, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
		
	}
	
	
	
}




