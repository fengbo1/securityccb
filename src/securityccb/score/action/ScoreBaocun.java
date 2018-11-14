package securityccb.score.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.config.dao.ScoreFlagDAO;
import securityccb.config.pojo.ScoreFlag;
import ccb.hibernate.HibernateSessionFactory;

public class ScoreBaocun {
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
		String sql="";
		ScoreFlagDAO sfdao = new ScoreFlagDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		ScoreFlag sf = sfdao.findByYear(year);
    		sf.setFlag(2);
			sfdao.merge(sf);
    		
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
