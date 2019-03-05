package securityccb.jigou.action;


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
import securityccb.jigou.pojo.JiGou;
import securityccb.kpxm.pojo.Kpxm;
import securityccb.process.action.FindNextUnder;
import securityccb.userinfo.action.UserInfoFind;


import ccb.hibernate.HibernateSessionFactory;

public class JigouAction {
	private static final Log log = LogFactory.getLog(JigouAction.class);
	private List kpxm;
	private List jigoulist;
	
	

	
	public void setKpxm(List kpxm) {
		this.kpxm = kpxm;
	}
	public List getKpxm() {
		return kpxm;
	}

	public void setJigoulist(List jigoulist) {
		this.jigoulist = jigoulist;
	}
	public List getJigoulist() {
		return jigoulist;
	}


	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
       jigoulist=findalljigou();
       
       return "success";
		
	}
	
		public List  findalljigou() //通过机构ID查询主分中心
	    {
			Query query ;			
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();		
			List<JiGou> jigoulist = null;
			
			try {

		        String sql="SELECT * from jigou where jigouid!='000'";			
				
				query  = session.createSQLQuery(sql).addEntity(JiGou.class);		
				jigoulist = query.list();				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				trans.commit();
				session.flush();
				session.clear();
				session.close();
			}
				
		  return jigoulist;
	}	
		public String  findjigouzhufen(String jigouid) //通过机构ID查询主分中心
	    {
			Query query;
			String hql = "";
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();
			
					
			List<JiGou> jigoulist = null;
			String biaozhi=null;
			try {

		        String sql="SELECT * from jigou where jigouid='"+jigouid+"'";			
				
				query  = session.createSQLQuery(sql).addEntity(JiGou.class);		
				jigoulist = query.list();	
				biaozhi=jigoulist.get(0).getQuanxian();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally{
				trans.commit();
				session.flush();
				session.clear();
				session.close();
			}
				
		  return biaozhi;
		  
		
	}	
	
	
}
