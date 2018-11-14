package securityccb.file.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.file.pojo.File;
import securityccb.util.Util;
import ccb.hibernate.HibernateSessionFactory;

public class FileShow {
	private static final Log log = LogFactory.getLog(FileShow.class);
	private String date;
	private String nowdate;
	private String title;
	private String id;
	private List <File>mylist;
	private List<TitleAndUrl> url;


	

	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getNowdate() {
		return nowdate;
	}



	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}




	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getId() {
		return id;
	}






	public void setMylist(List <File> mylist) {
		this.mylist = mylist;
	}



	public List <File> getMylist() {
		return mylist;
	}




	public void setUrl(List<TitleAndUrl> url) {
		this.url = url;
	}



	public List<TitleAndUrl> getUrl() {
		return url;
	}




	public class TitleAndUrl{

		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getTitle() {
			return title;
		}
		private String title; 
		private String url;
		
		
		
		  
		}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		String path=Util.basepath+"upload_file/";
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		try {
		
			String sql="SELECT * from file where id = '"+id+"'";	
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(File.class);				
			setMylist(query.list());	
			if(mylist.get(0).getUrl()!=null){
			    
				String [] arr=null;
				if(mylist.get(0).getUrl().indexOf("|")!=-1){
					 arr=mylist.get(0).getUrl().split("\\|");
				}else{
					arr=mylist.get(0).getUrl().split("@#%$");
				}
					
				
				List urls = new ArrayList();
				for(int i=0;i<arr.length;i++){
					
					TitleAndUrl tau=new TitleAndUrl();
					tau.setUrl(path+arr[i]);
					
					int begin=arr[i].indexOf("_");
					int end=arr[i].length();
					String t=arr[i].substring(begin+1, end);
					tau.setTitle(t);
					urls.add(tau);
				}
				url=urls; 
				
				
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
	
	
}
