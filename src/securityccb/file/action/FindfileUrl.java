package securityccb.file.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.chu.pojo.Chu;
import securityccb.file.pojo.File;
import securityccb.util.Util;
import ccb.hibernate.HibernateSessionFactory;

public class FindfileUrl {
	private static final Log log = LogFactory.getLog(FindfileUrl.class);
	private String id;
	private List <File>mylist=null;


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





	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		
		
			
		 

		return "success";
	}
	public String[] sqlfindurl(String id) //查到文件位置名字
    {
		String path=Util.basepath+"/upload/upload_file/";
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String [] arr=null;
		try {
		
			String sql="SELECT * from file where id = '"+id+"'";	
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(File.class);				
			setMylist(query.list());	
			if(mylist.get(0).getUrl()!=null){			    
				
				if(mylist.get(0).getUrl().indexOf("|")!=-1){
					 arr=mylist.get(0).getUrl().split("\\|");
					 for (int i=0;i<arr.length;i++){
						 arr[i]=path+arr[i];
					 }
					 
				}else{
					arr=mylist.get(0).getUrl().split("@#%$");
					arr[0]=path+arr[0];
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
		 

		return arr;
		
	}
	
}
