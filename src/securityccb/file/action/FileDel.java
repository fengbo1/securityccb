package securityccb.file.action;
import java.io.File;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.util.Util;

import ccb.hibernate.HibernateSessionFactory;

public class FileDel {
	private static final Log log = LogFactory.getLog(FileDel.class);
	private String date;
	private String nowdate;
	private String title;
	private String id;
	private String type;


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
		public String getJigou() {
			return jigou;
		}
		public void setJigou(String jigou) {
			this.jigou = jigou;
		}
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
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getUrl1() {
			return url1;
		}
		public void setUrl1(String url1) {
			this.url1 = url1;
		}
		private String title; 
		private String url;
		private String jigou;
		private String date;
		private String nowdate;
		private String type;
		private String url1;
		
		
		
		
		  
		}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{   FindfileUrl fs=new FindfileUrl();
	    String [] arr=fs.sqlfindurl( id);		
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		try {				
			
			String sql="DELETE from file where id = '"+id+"'";	
			System.out.println(sql);
			query = session.createSQLQuery(sql);				
		    query.executeUpdate(); 			
		    if(arr!=null&&arr.length>0){
		    	for(int i=0;i<arr.length;i++){
		    		boolean jieguo=deleteFile(arr[i]);
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
	
	public String[] delfujian(String id,Session session,String url)
	{
		String path=Util.basepath+"upload/upload_file/";
		Query query;		
		String [] arr=null;
		try {
		
			String sql="SELECT * from file where id = '"+id+"'";	
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(TitleAndUrl.class);				
			List<TitleAndUrl> mylist=query.list();	
			
			if(mylist.get(0).getUrl()!=null){
			    
				
				if(mylist.get(0).getUrl().indexOf("|")!=-1){
					 arr=mylist.get(0).getUrl().split("\\|");
				}else{
					arr=mylist.get(0).getUrl().split("@#%$");
				}			
				
				List urls = new ArrayList();
				for(int i=0;i<arr.length;i++){
					arr[i]=path=arr[i];
				}				
			}			
			
 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
			
		 
		return arr;
	}
	/**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }



	public void setType(String type) {
		this.type = type;
	}



	public String getType() {
		return type;
	}
	
	
}
