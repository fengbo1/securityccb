package securityccb.ndzj.action;
import java.io.File;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import ccb.hibernate.HibernateSessionFactory;

public class NdzjDel {
	
	
	private String id;
	private String rtitle;
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}


	public String getRtitle() {
		return rtitle;
	}
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	public String execute() throws Exception
	{   
	   	
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		try {				
			
			
			String sql="DELETE from ndzj where rtitle = '"+rtitle+"'";	
			System.out.println(sql);
			query = session.createSQLQuery(sql);				
		    query.executeUpdate(); 			
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


	
	
}
