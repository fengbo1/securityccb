package securityccb.othercompany.action;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.othercompany.pojo.OtherCompany;
import securityccb.plan.pojo.Plan;
import ccb.hibernate.HibernateSessionFactory;



public class OtherAction {
	private static final Log log = LogFactory.getLog(OtherAction.class);
	private String jigouid;
	private String position;
	private List<OtherCompany> olist;


	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		jigouid=position.substring(0, 3); 
		List<OtherCompany> otherlist;
		try {

	        String sql="SELECT * from othercompany where jigouid = "+"'"+jigouid+"'";			
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(OtherCompany.class);		
			otherlist = query.list();		
			olist=otherlist;
			
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



	public String getJigouid() {
		return jigouid;
	}



	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public List<OtherCompany> getOlist() {
		return olist;
	}



	public void setOlist(List<OtherCompany> olist) {
		this.olist = olist;
	}
}
