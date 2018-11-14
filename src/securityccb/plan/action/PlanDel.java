package securityccb.plan.action;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import securityccb.plan.pojo.Plan;
import ccb.hibernate.HibernateSessionFactory;



public class PlanDel {
	private static final Log log = LogFactory.getLog(PlanDel.class);
	private String position;
	private String id;
	


	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		
		
		try {
			String sql="delete  from plan where id = "+"'"+id+"'";	
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


	public List<Plan> findallplan(String jigouid) //通过机构ID查询机构全称
    {
		Query query1;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<Plan> plist = null;
		try {

	        String sql="SELECT * from plan where jigouid = "+"'"+jigouid+"'";			
			System.out.println(sql);
			query1 = session.createSQLQuery(sql).addEntity(Plan.class);		
			plist = query1.list();				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return plist;
	
}



}
