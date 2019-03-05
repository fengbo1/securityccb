package securityccb.userinfo.action;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class FanKuiDel {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String execute() throws Exception
	{
		String result = "success";
		String sql = "";
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		sql = "delete from fankui where id='"+id+"'";
    		session.createSQLQuery(sql).executeUpdate();
    		
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return result;
    	}
}
