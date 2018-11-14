package securityccb.score.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ScoreDel {
	private String year;
	private String message;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		String result = "success";
		String sql = "";
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		sql = "delete from scoreflag where year='"+year+"'";//所有最新标志位置0；
			session.createSQLQuery(sql).executeUpdate();
    		sql = "delete from score where year='"+year+"'";//所有最新标志位置0；
			session.createSQLQuery(sql).executeUpdate();
			sql = "delete from khps where remark3='"+year+"'";//所有最新标志位置0；
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
