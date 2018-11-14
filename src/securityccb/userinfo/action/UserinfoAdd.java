package securityccb.userinfo.action;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.pojo.JiGou;
import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;

import ccb.hibernate.HibernateSessionFactory;

public class UserinfoAdd {
	private static final Log log = LogFactory.getLog(UserinfoAdd.class);
	private String chushi;	
	private String jigouid;	

	

	

	public void setChushi(String chushi) {
		this.chushi = chushi;
	}


	public String getChushi() {
		return chushi;
	}


	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}


	public String getJigouid() {
		return jigouid;
	}


	public String execute() throws Exception
	{
		String newchushiid=findmaxchushiid();
 		String newid=findmaxid();
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
 		try {
			Chu newchu=new Chu();
			ChuDAO cd=new ChuDAO();
			
			newchu.setChushi(chushi);
			newchu.setChushiid(newchushiid);
			newchu.setJigouid(jigouid);
			newchu.setId(Integer.parseInt(newid));
			
			cd.save(newchu);
			
		
			
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

	public String findmaxchushiid() //获取下一处室的id
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();			
		String newchushiid="";
		List<Chu>  list;
		
		try {

	        String hql="from Chu order by chushiid desc";		
	        
			System.out.println(hql);
						
			query=session.createQuery(hql);
			
	     	list = query.list();	
	     	
	     	String chushiid=list.get(0).getChushiid();	
							
			newchushiid=addOne(chushiid.substring(0,3))+"000";
				
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return newchushiid;
		
	}
	public String findmaxid() //获取下一条数据的id
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();			
		String newchushiid="";
		List<Chu>  list;
		
		try {

	        String hql="from Chu order by id desc";		
	        
			
						
			query=session.createQuery(hql);
			
	     	list = query.list();	
	     	
	     	String id=list.get(0).getId().toString();
							
			newchushiid=addOne(id);
				
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return newchushiid;
		
	}

	public static String addOne(String testStr){
	    String[] strs = testStr.split("[^0-9]");//根据不是数字的字符拆分字符串
	    String numStr = strs[strs.length-1];//取出最后一组数字
	    if(numStr != null && numStr.length()>0){//如果最后一组没有数字(也就是不以数字结尾)，抛NumberFormatException异常
	        int n = numStr.length();//取出字符串的长度
	        int num = Integer.parseInt(numStr)+1;//将该数字加一
	        String added = String.valueOf(num);
	        n = Math.min(n, added.length());
	        //拼接字符串
	        return testStr.subSequence(0, testStr.length()-n)+added;
	    }else{
	        throw new NumberFormatException();
	    }
	}



}

