package securityccb.paiban.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.area.pojo.Area;
import securityccb.paiban.pojo.PaiBan;
import securityccb.util.DateTimeUtil;

import ccb.hibernate.HibernateSessionFactory;

public class PaiBanDel {

	private int id;
	private String areaid;
	private List<PaiBan> list;
	private String year;
	private List<String> listyear;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public List<PaiBan> getList() {
		return list;
	}
	public void setList(List<PaiBan> list) {
		this.list = list;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public List<String> getListyear() {
		return listyear;
	}
	public void setListyear(List<String> listyear) {
		this.listyear = listyear;
	}
	public String execute() throws Exception
	{
		DateTimeUtil dtu = new DateTimeUtil();
		String sql = "delete from paiban where id="+id;
		listyear = new ArrayList<String>();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		try {
	        session.createSQLQuery(sql).executeUpdate();	
	        
	        sql="SELECT * from paiban where areaid = "+"'"+areaid+"' order by begindate desc";
			
	        Query query = session.createSQLQuery(sql).addEntity(PaiBan.class);		
			list = query.list();	
			listyear.add(String.valueOf(dtu.getThisYear()));
			listyear.add(String.valueOf(dtu.getThisYear()-1));
			listyear.add(String.valueOf(dtu.getThisYear()-2));
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
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
