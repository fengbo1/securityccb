package securityccb.chu.action;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class chuUpdate {
	private static final Log log = LogFactory.getLog(ChuAction.class);
	private String chushiid;
	private String chushi;	
	
	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}


	public String getChushiid() {
		return chushiid;
	}

	

	public void setChushi(String chushi) {
		this.chushi = chushi;
	}


	public String getChushi() {
		return chushi;
	}


	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		
		try {
			

			String sql="update chu set chushi = "+"'"+chushi+"' where chushiid = "+"'"+chushiid+"'";	
			
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







}

