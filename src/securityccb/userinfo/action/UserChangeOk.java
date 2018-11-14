package securityccb.userinfo.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.chu.action.chuAdd;
import securityccb.chu.pojo.Chu;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class UserChangeOk {
	private static final Log log = LogFactory.getLog(UserInfo.class);
	private String chushiid;	
	private String zhiwu;	
	private String newnumber;
	private String name;
	private int id;
	private String password;



	public String getChushiid() {
		return chushiid;
	}

	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}


	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
	try {
		
		UserInfoDAO uid=new UserInfoDAO();
		UserInfo ui=uid.findAllById(id);
		
		String role=zhiwu.substring(0, 1);
		String quanxian=zhiwu.substring(1, 2);
		String jigouid=ui.getPosition().substring(0, 3);
		String position=jigouid+chushiid+role+quanxian;
		
		ui.setName(name);
		ui.setNewnumber(newnumber);
		ui.setPosition(position);
		ui.setQuanxian(quanxian);
		ui.setRole(role);
		ui.setPassword(password);
		
		uid.merge(ui);
			
			
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