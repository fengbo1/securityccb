package securityccb.userinfo.action;



import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;
import securityccb.jigou.action.JigouAction;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class UserChange {
	private static final Log log = LogFactory.getLog(UserChange.class);
	private String newnumber;
	private String chushi;
	private String chushiid;
	private List<Chu> chulist;
	private List<UserInfo> ulist;
	private String zhufenbiaozhi;
	private String quanxian;
	private Integer id;
	private String password;
	private String name;
	private String position;

	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<UserInfo> uulist=null;
		
		try {			
            ChuDAO cd =new ChuDAO();
			String sql="select * from userinfo where newnumber = "+"'"+newnumber+"'";	
			System.out.println(sql);
			query  = session.createSQLQuery(sql).addEntity(UserInfo.class);		
			uulist=query.list();	
			chulist=cd.findchushinamebyjigouid(uulist.get(0).getPosition().substring(0, 3));
			ulist=uulist;
			name=ulist.get(0).getName();
			newnumber=ulist.get(0).getNewnumber();
			position=ulist.get(0).getPosition();
			chushiid=position.substring(3, 9);
			quanxian=(position.substring(9, 11));
			password=ulist.get(0).getPassword();
	        id=(uulist.get(0).getId());
			
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

	private void setCharacterEncoding(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}

	public String getQuanxian() {
		return quanxian;
	}



	public void setZhufenbiaozhi(String zhufenbiaozhi) {
		this.zhufenbiaozhi = zhufenbiaozhi;
	}

	public String getZhufenbiaozhi() {
		return zhufenbiaozhi;
	}




	public String getNewnumber() {
		return newnumber;
	}




	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}




	public String getChushi() {
		return chushi;
	}




	public void setChushi(String chushi) {
		this.chushi = chushi;
	}




	public String getChushiid() {
		return chushiid;
	}




	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}




	public List<Chu> getChulist() {
		return chulist;
	}




	public void setChulist(List<Chu> chulist) {
		this.chulist = chulist;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPosition() {
		return position;
	}




	public void setPosition(String position) {
		this.position = position;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}



	}
	

	