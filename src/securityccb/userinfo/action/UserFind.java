package securityccb.userinfo.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import securityccb.jigou.action.JigouAction;
import securityccb.jigou.pojo.JiGou;
import securityccb.userinfo.pojo.UserInfo;

import securityccb.area.pojo.Area;
import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;


import ccb.hibernate.HibernateSessionFactory;

public class UserFind {
	private static final Log log = LogFactory.getLog(UserFind.class);
	private String jigou;
	private String jigouid;
	private List<UserFind> mylist;
	private String position;
	private String chushiid;
	private String chushi;
	private String name;
	private String newnumber;
	private String areaname;
	private String role;
	private String zhiwu;
	private String quanxian;
	private String zhufenbiaozhi;
	private List<Chu> chulist;

	
	public void setJigou(String jigou) {
		this.jigou = jigou;
	}
	public String getJigou() {
		return jigou;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	public String getJigouid() {
		return jigouid;
	}
	public void setChushi(String chushi) {
		this.chushi = chushi;
	}
	public String getChushi() {
		return chushi;
	}

	public List<UserFind> getMylist() {
		return mylist;
	}
	public void setMylist(List<UserFind> mylist) {
		this.mylist = mylist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}
	public String getQuanxian() {
		return quanxian;
	}
	public String getZhufenbiaozhi() {
		return zhufenbiaozhi;
	}
	public void setZhufenbiaozhi(String zhufenbiaozhi) {
		this.zhufenbiaozhi = zhufenbiaozhi;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
        ChuDAO cd =new ChuDAO();
		List <securityccb.userinfo.pojo.UserInfo> list = null ;
		Query query;
		String hql = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		mylist=new ArrayList<UserFind>();	
		
		jigouid=position.substring(0, 3);
		String sql="SELECT * from userinfo where mid(position,1, 3) = "+"'"+jigouid+"'";	
		
		if(!chushiid.equals("")){
			String chushisql="and mid(position,4, 6)='"+chushiid+"'";
				sql=sql+chushisql;
		}
		if(!name.equals("")){
			String namesql="and name like "+"'%"+name+"%'";
				sql=sql+namesql;
		}
		if(!newnumber.equals("")){
			String newnumbersql="and newnumber="+"'"+newnumber+"'";
				sql=sql+newnumbersql;
		}
		if(!zhiwu.equals("")){
			role=zhiwu.substring(0, 1);
			quanxian=zhiwu.substring(1, 2);
			String rolesql="and role="+"'"+role+"'";
			String quanxiansql="and quanxian="+"'"+quanxian+"'";
				sql=sql+rolesql+quanxiansql;
		}
		sql=sql+" order by position";
		try {
		
			query = session.createSQLQuery(sql).addEntity(UserInfo.class);		
			list = query.list();			
			ActionContext.getContext().getSession().put("position",position);		
			
			chulist=findchulist(jigouid,session);
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		if(list != null && list.size() >= 1){
			
			for (int i=0;i<list.size();i++){

			  
				UserFind ui = new UserFind();
				
				
				ui.setChushi(cd.findchushinamebychushiid(list.get(i).getPosition().substring(3, 9)));
	
				ui.setPosition(list.get(i).getPosition());
				ui.setName(list.get(i).getName());
				ui.setNewnumber(list.get(i).getNewnumber());
				ui.setQuanxian(list.get(i).getQuanxian());
				ui.setRole(list.get(i).getRole());
				
				mylist.add(ui);
				
			}
			
		}
		

		return "success";
	}
	

	public String findareaname(String areaid) 
    {
		Query query1;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		String areaname="";
		try {

	        String sql="SELECT * from area where areaid = "+"'"+areaid+"'";			
			System.out.println(sql);
			query1 = session.createSQLQuery(sql).addEntity(Area.class);		
			List<Area> list2 = query1.list();				
			
			if(list2 != null && list2.size() >= 1)
			{

		    areaname=list2.get(0).getAreaname();
				
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
		
		return areaname;
		
	}
	public List<Chu> findchulist(String jigouid,Session session) 
    {
		Query query;		
		List <Chu>chulist=null;
		try {
	        String sql="SELECT * from chu where jigouid = "+"'"+jigouid+"'";			
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(Chu.class);		
			chulist = query.list();				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}		
		return chulist;		
	}
	
	
	
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return position;
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
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}
	public String getZhiwu() {
		return zhiwu;
	}
	
}
