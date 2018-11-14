package securityccb.userinfo.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.userinfo.pojo.UserInfo;

import ccb.hibernate.HibernateSessionFactory;

public class UserToModify {

	private int id;
	private UserInfo ui;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String execute() throws Exception
	{
		List<UserInfo> list = new ArrayList<UserInfo>();
		String hql = "from UserInfo as ui where ui.id="+id;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		list = session.createQuery(hql).list();
		if(!list.isEmpty())
		{
			ui = list.get(0);
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
		
	}
}
