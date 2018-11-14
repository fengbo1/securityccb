package securityccb.chu.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import securityccb.jigou.pojo.JiGou;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.area.pojo.Area;
import securityccb.chu.pojo.Chu;


import ccb.hibernate.HibernateSessionFactory;

public class chuDel {
	private static final Log log = LogFactory.getLog(ChuAction.class);
	private String chushiid;
	private String position;	
	private String message;
	

	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		message=null;
		message=findchu(chushiid,session);
		if(message.equals("")){
			message=findarea(chushiid,session);
		}
		if(message.equals("undel")||message.equals("undelarea")){			 

			return "unsuccess";
		}
		
		try {			
		
			String sql="delete  from chu where chushiid = "+"'"+chushiid+"'";	
			query =session.createSQLQuery(sql);
			query.executeUpdate();			
			
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


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getPosition() {
		return position;
	}



	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}


	public String getChushiid() {
		return chushiid;
	}

	public String findchu(String chushiid,Session session)//查询处室下有人，有人不能删除 
	{
		String message=null;
		Query query;
		List <UserInfo>ulist=null;
		try {			
		
			String sql="SELECT *  from userinfo where mid(position,4,7)= "+"'"+chushiid+"'";	
			
			query = session.createSQLQuery(sql).addEntity(UserInfo.class);	
			ulist=query.list();
			if(ulist.size()==0){
				message="";
			}if(ulist.size()>0){
				message="undel";
			}
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
		return message;

	
	
	}
	public String findarea(String chushiid,Session session)//查询处室下有人，有人不能删除 
	{
		String message=null;
		Query query;
		List <Area>alist=null;
		try {			
		
			String sql="SELECT * from area where chushiid= "+"'"+chushiid+"'";	
			
			query = session.createSQLQuery(sql).addEntity(Area.class);	
			alist=query.list();
			if(alist.size()==0){
				message="";
			}if(alist.size()>0){
				message="undelarea";
			}
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
		return message;

	
	
	}


}

