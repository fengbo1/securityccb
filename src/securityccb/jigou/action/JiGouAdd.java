package securityccb.jigou.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class JiGouAdd {

	private String title;
	private String shangji;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShangji() {
		return shangji;
	}
	public void setShangji(String shangji) {
		this.shangji = shangji;
	}
	public String execute() throws Exception 
    {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		try {
			
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
