package securityccb.jigou.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;

import ccb.hibernate.HibernateSessionFactory;

public class JiGouAdd {

	private String jigouname;
	private String shangji;
	public String getJigouname() {
		return jigouname;
	}
	public void setJigouname(String jigouname) {
		this.jigouname = jigouname;
	}
	public String getShangji() {
		return shangji;
	}
	public void setShangji(String shangji) {
		this.shangji = shangji;
	}
	public String execute() throws Exception 
    {
		JiGouDAO jgdao = new JiGouDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		try {
			JiGou jigou = new JiGou();
			jigou.setJigou(jigouname);
			jigou.setJigouid(jgdao.findMaxJigou());
			if(shangji.equals("wu"))
			{
				jigou.setQuanxian("1");
			}
			else
			{
				jigou.setQuanxian("2");
				jigou.setRemark1(shangji);
			}
			jgdao.merge(jigou);
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
