package securityccb.userinfo.action;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class AddressChange {
	private static final Log log = LogFactory.getLog(AddressChange.class);
	private String newnumber;
	private String position;

	private String relation;
	private String address;
	private List<UserInfo> ulist;
	private String tel;
	private String namesos;
	private Integer id;
	private String telsos;
	private String name;


	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		try {			

			String sql="select * from userinfo where newnumber = "+"'"+newnumber+"'";	
			System.out.println(sql);
			query  = session.createSQLQuery(sql).addEntity(UserInfo.class);		
			ulist=query.list();		      
	
			
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

	public String getNewnumber() {
		return newnumber;
	}






	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}






	public String getRelation() {
		return relation;
	}






	public void setRelation(String relation) {
		this.relation = relation;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}






	public List<UserInfo> getUlist() {
		return ulist;
	}






	public void setUlist(List<UserInfo> ulist) {
		this.ulist = ulist;
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






	public Integer getId() {
		return id;
	}






	public void setId(Integer id) {
		this.id = id;
	}






	public String getTelsos() {
		return telsos;
	}






	public void setTelsos(String telsos) {
		this.telsos = telsos;
	}






	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}




	}
	

	