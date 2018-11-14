package securityccb.paiban.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.area.pojo.Area;
import securityccb.chu.action.chuAdd;
import securityccb.chu.pojo.Chu;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class PaiBanCheckName {
	private static final Log log = LogFactory.getLog(PaiBanCheckName.class);
	private String areaid;	
	private String name;	
	private String newnumber;
	private String tel;
	private String chushiid;

	
	



	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getChushiid() {
		return chushiid;
	}
	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}
	public String execute() throws Exception
	{
	
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		try {	
			chushiid=findchushiid1(areaid,session);
			List <UserInfo> mylist;
		    newnumber="0";
			tel="0";
			name =  java.net.URLDecoder.decode(name , "UTF-8");
						
			String sql="select * from userinfo where name='"+name+"'";//and mid(position,9,17)='"+areaid+"'";
			System.out.println(sql);
			
			query = session.createSQLQuery(sql).addEntity(UserInfo.class);		
			mylist = query.list();	
		
			if(mylist != null && mylist.size() >= 1){
						
				for (int j=0;j<mylist.size();j++){
										
					if(mylist.get(j).getPosition().substring(3, 9).equals(chushiid))
					{
						newnumber=mylist.get(j).getNewnumber();
						tel=mylist.get(j).getTel();
					}
					
			
				}
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

	public String findchushiid1(String areaid,Session session) //通过机构ID查询机构全称
    {
		Query query1;			
		String chushiid="";
		 String sql="SELECT * from area where areaid = "+"'"+areaid+"'";			
			System.out.println(sql);
			query1 = session.createSQLQuery(sql).addEntity(Area.class);		
			List<Area> list2 = query1.list();				
			
			if(list2 != null && list2.size() >= 1)
			{

			chushiid=list2.get(0).getChushiid();
				
			}			
		return chushiid;
		
	}
}