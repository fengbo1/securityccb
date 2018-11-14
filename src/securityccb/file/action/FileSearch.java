package securityccb.file.action;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.file.pojo.File;


import ccb.hibernate.HibernateSessionFactory;

public class FileSearch {
	private static final Log log = LogFactory.getLog(FileSearch.class);
	private String type;
	private List<File> mylist;
	private String position;
	private String keyword;

	
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String jigouid=position.substring(0, 3);
		
		
		try {
		
			String sql="SELECT * from file where jigouid='"+jigouid+"' and title like '"+keyword+"%'" ;	
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(File.class);				
			mylist=query.list();			
 
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
	


	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return position;
	}



	public void setMylist(List<File> mylist) {
		this.mylist = mylist;
	}



	public List<File> getMylist() {
		return mylist;
	}



	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



	public String getKeyword() {
		return keyword;
	}

	
}
