package securityccb.zhibanneirong.action;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;



public class ZbnrDel {
	private static final Log log = LogFactory.getLog(ZbnrDel.class);
	private String position;
	private String id;
	


	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		
		
		try {
			String sql="delete  from zhibanneirong where id = "+"'"+id+"'";	
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


	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}


}
