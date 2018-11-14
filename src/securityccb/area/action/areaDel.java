package securityccb.area.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.area.dao.AreaDAO;
import securityccb.area.pojo.Area;
import securityccb.file.action.FileDel;
import securityccb.jigou.pojo.JiGou;
import securityccb.util.Util;


import ccb.hibernate.HibernateSessionFactory;

public class areaDel {
	private static final Log log = LogFactory.getLog(AreaAction.class);
	
	private String position;	
	private String areaid;

	public String execute() throws Exception
	{   
		AreaDAO ad =new AreaDAO();
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String path=Util.basepath+"upload/upload_area/";
 //       String url="";
 //       String DelAreaShow="";
//        url=ad.FindAreaUrl(areaid);
//        if(!url.equals("")){
//    		DelAreaShow=path+url;
//        }		
		try {				
			String sql="delete  from area where areaid = "+"'"+areaid+"'";	
			System.out.println(sql);
			query =session.createSQLQuery(sql);
			query.executeUpdate();
//             if(DelAreaShow.length()>0){
//            	 boolean  delresult=FileDel.deleteFile(DelAreaShow);
//             }           
			
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


	public void setPosition(String position) {
		this.position = position;
	}


	public String getPosition() {
		return position;
	}





}

