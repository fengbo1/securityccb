package securityccb.userinfo.action;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class AddressChangeOk {
	private static final Log log = LogFactory.getLog(UserInfo.class);
	private String telsos;	
	private String address;	
	private String tel;
	private String namesos;
	private int id;
	private String relation;


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
	try {
		
		UserInfoDAO uid=new UserInfoDAO();
		UserInfo ui=uid.findAllById(id);
		
		ui.setAddress(address);
		ui.setId(id);
		ui.setNamesos(namesos);
		ui.setTelsos(telsos);
		ui.setTel(tel);
		ui.setRelation(relation);		
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


	public String getTelsos() {
		return telsos;
	}


	public void setTelsos(String telsos) {
		this.telsos = telsos;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getNamesos() {
		return namesos;
	}


	public void setNamesos(String namesos) {
		this.namesos = namesos;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRelation() {
		return relation;
	}


	public void setRelation(String relation) {
		this.relation = relation;
	}


}