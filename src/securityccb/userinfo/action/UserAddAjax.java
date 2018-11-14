package securityccb.userinfo.action;


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

public class UserAddAjax {
	private static final Log log = LogFactory.getLog(UserAddAjax.class);
	private String chushi;
	private String chushiid;
	private List <Area> arealist;



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



	public void setArealist(List <Area> arealist) {
		this.arealist = arealist;
	}



	public List <Area> getArealist() {
		return arealist;
	}



	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
	
		
		try {
			

			String sql="select * from area where chushiid = "+"'"+chushiid+"'";	
			System.out.println(sql);
			query  = session.createSQLQuery(sql).addEntity(Area.class);		
			arealist=query.list();	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		
		
		return "areaname";

	
	
	}



	}
	

	