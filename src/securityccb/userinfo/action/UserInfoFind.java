package securityccb.userinfo.action;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.pojo.JiGou;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;

import ccb.hibernate.HibernateSessionFactory;

public class UserInfoFind {
	private static final Log log = LogFactory.getLog(UserInfoFind.class);
	private String newnumber;	
	private String name;
	private String chushi;
	private String chushiid;	
	private String jigou;	
	private String jigouid;	
	private String role;
	private String quanxian;


	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getJigou() {
		return jigou;
	}

	public void setJigou(String jigou) {
		this.jigou = jigou;
	}

	public String getJigouid() {
		return jigouid;
	}

	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getQuanxian() {
		return quanxian;
	}

	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}

	public UserInfo finduserinfobynewnumber(String newnumber) 
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();			
		UserInfo name = null;
		List<UserInfo>  list;		
		try {

	        String hql="from UserInfo as ui where ui.newnumber='"+newnumber+"'";		
	        
			System.out.println(hql);
						
			query=session.createQuery(hql);
			
	     	list = query.list();	
	     	
	     	name=list.get(0);				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return name;
		
	}

	
    public String findnamebynewnumber(String newnumber) 
	
    {
		UserInfoFind uif=new UserInfoFind();
		
		String name=uif.finduserinfobynewnumber(newnumber).getName();		
		
		return name;
		
	}


	
	
	
	
}

