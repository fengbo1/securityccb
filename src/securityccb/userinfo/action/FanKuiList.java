package securityccb.userinfo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.userinfo.pojo.Fankui;

import ccb.hibernate.HibernateSessionFactory;

public class FanKuiList {

	private String position;
	private String newnumber;
	private List<Fankui> list;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public List<Fankui> getList() {
		return list;
	}
	public void setList(List<Fankui> list) {
		this.list = list;
	}
	public String execute() throws Exception
	{
		String hql = "";
		String result="success";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		try {
			if(position!=null&&newnumber!=null&&position.length()>5)
			{
				String jigou=position.substring(0, 3);
				if(jigou.equals("000"))
				{
					hql = "from Fankui order by id desc";
					list = session.createQuery(hql).list();
					result = "successanbao";
				}
				else
				{
					hql = "from Fankui where jigou='"+jigou+"' order by id desc";
					list = session.createQuery(hql).list();
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
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
