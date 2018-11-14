package securityccb.zhibanneirong.action;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.zhibanneirong.pojo.ZhiBanNeirong;
import ccb.hibernate.HibernateSessionFactory;

public class ZbnrChange {
	private static final Log log = LogFactory.getLog(ZbnrChange.class);
	private String areaid;
	private String areaname;
	private String zhibanneirong;
	private String position;
	private String newnumber;
	private Integer id;
	private List<ZhiBanNeirong> zbnrlist;

	



	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		try {			

			String sql="select * from zhibanneirong where id = "+"'"+id+"'";	
			System.out.println(sql);
			query  = session.createSQLQuery(sql).addEntity(ZhiBanNeirong.class);		
			zbnrlist=query.list();		      
			//areaname=new String(areaname.getBytes("iso-8859-1"),"utf-8");
			
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




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public void setZbnrlist(List<ZhiBanNeirong> zbnrlist) {
		this.zbnrlist = zbnrlist;
	}




	public List<ZhiBanNeirong> getZbnrlist() {
		return zbnrlist;
	}




	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}




	public String getAreaname() {
		return areaname;
	}




	}
	

	