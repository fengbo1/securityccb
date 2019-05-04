package securityccb.jigou.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import ccb.hibernate.HibernateSessionFactory;

public class JiGouToMod {

	private int id;
	private JiGou jg;
	private List<String> listjc;
	private List<JiGou> listjg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public JiGou getJg() {
		return jg;
	}
	public void setJg(JiGou jg) {
		this.jg = jg;
	}
	public List<String> getListjc() {
		return listjc;
	}
	public void setListjc(List<String> listjc) {
		this.listjc = listjc;
	}
	public List<JiGou> getListjg() {
		return listjg;
	}
	public void setListjg(List<JiGou> listjg) {
		this.listjg = listjg;
	}
	public String execute() throws Exception 
    {
		JiGouDAO jgdao = new JiGouDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		try {
			JiGou jigou = jgdao.findAllById(id);
			String hql = "from JiGou where jigouid!='000' and quanxian='1'";
			listjg = session.createQuery(hql).list();
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
