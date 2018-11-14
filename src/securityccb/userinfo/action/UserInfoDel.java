package securityccb.userinfo.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class UserInfoDel {
	private static final Log log = LogFactory.getLog(UserInfoDel.class);
	private String newnumber;	
	

	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		
		try {
			
		
			String sql="delete  from userinfo where newnumber = "+"'"+newnumber+"'";	
			System.out.println(sql);			
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

