package securityccb.area.action;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.area.pojo.Area;
import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;
import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import ccb.hibernate.HibernateSessionFactory;

public class areaUpdate {
	private static final Log log = LogFactory.getLog(AreaAction.class);
	private String chushiid;
	private String chushi;

	private String area;
	private String areaid;
	private String url;
	private String areaname;
	private String position;
	private Integer id;
	private List<Chu> chulist ;
	private String jigou;

	
	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}


	public String getChushiid() {
		return chushiid;	}

	public void setArea(String area) {
		this.area = area;
	}


	public String getArea() {
		return area;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUrl() {
		return url;
	}




	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}


	public String getAreaname() {
		return areaname;
	}


	public String getAreaid() {
		return areaid;
	}


	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}


	public String execute() throws Exception
	{   
		JiGouDAO jgd=new JiGouDAO();
		ChuDAO cd=new ChuDAO();
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		
		try {
			    String sql="SELECT * from area where areaid = "+"'"+areaid+"'";			
				System.out.println(sql);
				query = session.createSQLQuery(sql).addEntity(Area.class);		
				List<Area> list = query.list();	
				if(list!=null){
					area=list.get(0).getArea();
					areaname=list.get(0).getAreaname();
					chushiid=list.get(0).getChushiid();
					url=list.get(0).getUrl();
					id=(list.get(0).getId());	
					chushi=(cd.findchushinamebychushiid(list.get(0).getChushiid()));
					chulist=cd.findchushiidbyjigouid(position.substring(0, 3));
			        jigou=jgd.findJigouNameByJigouid(position.substring(0, 3));
				    areaid=list.get(0).getAreaid();
//				    if(!url.equals("")){
//				    	url=url.substring(63, 82);
//				    }
				    
				    
				}
				
			
			
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
	public void setChushi(String chushi) {
		this.chushi = chushi;
	}


	public String getChushi() {
		return chushi;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}


	public void setJigou(String jigou) {
		this.jigou = jigou;
	}


	public String getJigou() {
		return jigou;
	}


	public void setChulist(List chulist) {
		this.chulist = chulist;
	}


	public List getChulist() {
		return chulist;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	public String getPosition() {
		return position;
	}



}

