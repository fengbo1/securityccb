package securityccb.userinfo.action;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class AddressChange {
	private static final Log log = LogFactory.getLog(AddressChange.class);
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
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {			
//			String sql="select * from userinfo where newnumber = "+"'"+newnumber+"'";	
//			System.out.println(sql);
//			query  = session.createSQLQuery(sql).addEntity(UserInfo.class);		
			ui=uidao.findAllById(id);		      
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
	

	