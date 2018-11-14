package securityccb.userinfo.action;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;



public class UserAddFindNewnumber {
	private static final Log log = LogFactory.getLog(UserAddFindNewnumber.class);
	private String newnumber;
	private String newnumberfind;

	private String findresult;	
	private List<UserInfo> ulist;

	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getFindresult() {
		return findresult;
	}
	public void setFindresult(String findresult) {
		this.findresult = findresult;
	}
	public void setUlist(List<UserInfo> ulist) {
		this.ulist = ulist;
	}
	public List<UserInfo> getUlist() {
		return ulist;
	}
	public void setNewnumberfind(String newnumberfind) {
		this.newnumberfind = newnumberfind;
	}
	public String getNewnumberfind() {
		return newnumberfind;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		newnumberfind="0";
 		List<UserInfo> ulist=null;
 		
 		ulist=findnewnumber(newnumber);		
 		
 		if (ulist.size()==0){
 			newnumberfind="1";
 		}
			
	return "success";

	}

	public List findnewnumber(String newnumber) //通过机构ID查询机构全称
    {
		Query query;			
 		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<UserInfo> list = null;
		try {
	        String sql="SELECT * from userinfo where newnumber = "+"'"+newnumber+"'";	
			
			query = session.createSQLQuery(sql).addEntity(UserInfo.class);		
			list = query.list();				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}		
		return list;		
	}
	
}
