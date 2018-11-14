package securityccb.area.action;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import securityccb.area.pojo.Area;
import securityccb.chu.action.ChuAction;
import securityccb.chu.pojo.Chu;


import ccb.hibernate.HibernateSessionFactory;

public class areafindchushi {
	private static final Log log = LogFactory.getLog(areafindchushi.class);
	private String jigou;
	private String jigouid;

	private List<Chu> chulist;
	private String position;
	private String chushiid;


	public String getJigou() {
		return jigou;
	}


	public void setJigou(String jigou) {
		this.jigou = jigou;
	}


	public String getJigouid() {
		return jigouid;
	}


	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getChushiid() {
		return chushiid;
	}


	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}


	public void setChulist(List<Chu> chulist) {
		this.chulist = chulist;
	}


	public List<Chu> getChulist() {
		return chulist;
	}


	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
	
		
		try {			

			String sql="select * from chu where jigouid = "+"'"+jigouid+"'";	
			System.out.println(sql);
			query  = session.createSQLQuery(sql).addEntity(Chu.class);	
			chulist=query.list();				
			
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
	

	