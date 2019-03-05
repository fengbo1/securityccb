package securityccb.jigou.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.jigou.pojo.JiGou;
import ccb.hibernate.HibernateSessionFactory;

public class JiGouAddBefore {

	private List<JiGou> list;

	public List<JiGou> getList() {
		return list;
	}

	public void setList(List<JiGou> list) {
		this.list = list;
	}
	public String execute() throws Exception //通过机构ID查询主分中心
    {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		try {
			String hql = "from JiGou where jigouid!='000' and quanxian='1'";
			list = session.createQuery(hql).list();
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
