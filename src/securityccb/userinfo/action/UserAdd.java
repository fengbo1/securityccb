package securityccb.userinfo.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.chu.action.ChuAction;
import securityccb.chu.action.chuAdd;
import securityccb.chu.pojo.Chu;
import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class UserAdd {
	private static final Log log = LogFactory.getLog(UserInfo.class);
	private String chushiid;	
	private String quanxian;	
	private String newnumber;
	private String name;
	private String areaname;
	private String zhiwu;	



	public String getChushiid() {
		return chushiid;
	}

	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}

	public String getQuanxian() {
		return quanxian;
	}

	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
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



	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getAreaname() {
		return areaname;
	}

	public String execute() throws Exception
	{
		String areaid=areaname;	
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		try {			
			JiGouDAO jgd=new JiGouDAO();
			
			quanxian=zhiwu.substring(1,2);
			String role=zhiwu.substring(0,1);
			areaid="";
			String position=jgd.findJigouidByChuid(chushiid)+chushiid+areaid+role+quanxian;
			
			
			UserInfo ui=new UserInfo();
			UserInfoDAO uid=new UserInfoDAO();
			
			ui.setName(name);
			ui.setNewnumber(newnumber);
			ui.setPosition(position);
			ui.setPassword("000000");			
			ui.setQuanxian(quanxian);
			ui.setRole(role);
			uid.save(ui);
			
			
		
	
			
			
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