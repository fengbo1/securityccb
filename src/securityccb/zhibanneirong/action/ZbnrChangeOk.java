package securityccb.zhibanneirong.action;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import securityccb.area.pojo.Area;
import securityccb.chu.pojo.Chu;
import securityccb.zhibanneirong.dao.ZhiBanNeirongDAO;
import securityccb.zhibanneirong.pojo.ZhiBanNeirong;


import ccb.hibernate.HibernateSessionFactory;

public class ZbnrChangeOk {
	private static final Log log = LogFactory.getLog(ZbnrChangeOk.class);
	private List<ZbnrChangeOk> zbnrlist;
	private String newnumber;
	private String position;
	private Integer id;
	private String areaid;
	private String zhibanneirong;




	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		try {
		
		ZhiBanNeirong zbnradd=new ZhiBanNeirong();
		ZhiBanNeirongDAO zbnrdao=new ZhiBanNeirongDAO();

	
		zbnradd.setAreaid(areaid);
		zbnradd.setZhibanneirong(zhibanneirong);
		zbnradd.setId(id);
		
		zbnrdao.merge(zbnradd);
		
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
	
	
	



	public List<ZbnrChangeOk> getZbnrlist() {
		return zbnrlist;
	}




	public void setZbnrlist(List<ZbnrChangeOk> zbnrlist) {
		this.zbnrlist = zbnrlist;
	}




	public String getNewnumber() {
		return newnumber;
	}




	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}




	public String getPosition() {
		return position;
	}




	public void setPosition(String position) {
		this.position = position;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getAreaid() {
		return areaid;
	}




	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}




	public String getZhibanneirong() {
		return zhibanneirong;
	}




	public void setZhibanneirong(String zhibanneirong) {
		this.zhibanneirong = zhibanneirong;
	}




	public static Log getLog() {
		return log;
	}

	
}
