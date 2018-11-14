package securityccb.userinfo.action;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import securityccb.userinfo.pojo.UserInfo;

import ccb.hibernate.HibernateSessionFactory;

public class UserModify extends ActionSupport{
	private int id;
	private String message;
	private String username;
	private String oldpassword;
	private String newpassword;
	private String newpassword2;
	private Session h_session;
    private Transaction trans;
    private String hql;
    private Query query;
    private UserInfo ui;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getNewpassword2() {
		return newpassword2;
	}
	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}
	public Session getH_session() {
		return h_session;
	}
	public void setH_session(Session hSession) {
		h_session = hSession;
	}
	public Transaction getTrans() {
		return trans;
	}
	public void setTrans(Transaction trans) {
		this.trans = trans;
	}
	public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String execute() throws Exception
	{
		String hqltemp="";
		try {
		  h_session=HibernateSessionFactory.getSession();
		  trans=h_session.beginTransaction();
		  hql="select user from UserInfo as user where user.id="+id;
		  query=h_session.createQuery(hql);
		  System.out.println(username);
          List l=query.list();
   
     	  
     		  UserInfo u=(UserInfo)(l.get(0));
     		  ui = u;
     		  if(!oldpassword.equals(u.getPassword()))
     		  {
        			 this.addFieldError("用户","旧密码错误");
       			  	 return "false";
     		  }
     		 else if(newpassword.length()>8)
    		  {
    			 this.addFieldError("用户","密码长度不能超过8位");
  			  	 return "false";
    		  }
     		  else if(!newpassword.equals(newpassword2))
     		  {
     			 this.addFieldError("用户","两次输入的密码不一致");
   			  	 return "false";
     		  }
     		  else
     		  {
     			 hqltemp = "update UserInfo as ui set ui.password='"+newpassword2+"' where ui.id="+id;
     			 h_session.createQuery(hqltemp).executeUpdate();
     			 message="修改成功";
     		  }
			} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();
			}finally{
				trans.commit();
				h_session.flush();
				h_session.clear();
				h_session.close();
			} 
//        	  HttpSession session=null;
//        	  session.setAttribute("user", this.getUsername());
        	  return "success";
     	  
     	 
	}
}
