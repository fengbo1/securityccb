package securityccb.plan.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.chu.action.chuAdd;
import securityccb.chu.pojo.Chu;

import securityccb.upfile.Upfile;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class PlanUpFile {
	private static final Log log = LogFactory.getLog(UserInfo.class);
	private String chushiid;	
	private String jigouid;
	private String quanxian;	
	private String newnumber;
	private String name;
	private String zhiwu;
	private List<String> file;
	//上传文件名集合
	private List<String> fileFileName;
	//上传文件内容类型集合




	public String getChushiid() {
		return chushiid;
	}

	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}

	public String getQuanxian() {
		return quanxian;
	}

	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}


	public void setFile(List<String> file) {
		this.file = file;
	}

	public List<String> getFile() {
		return file;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public String getJigouid() {
		return jigouid;
	}

	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}

	public String execute() throws Exception
	{   
				
		Date now = new Date();		
		SimpleDateFormat TimeFormats = new SimpleDateFormat("YYYYMMddHHmmssms");		
		String nametime=TimeFormats.format(now);		
		//把选择的文件存放到指定文件夹中
		
		Upfile uf=new Upfile();
		String myfile=file.get(0);
		String dir="upload_plan";
		String myfilename=nametime+"_"+fileFileName.get(0);
		
		uf.uploadFile(myfile, dir, myfilename);
		//把文件中文件读出来，写入数据库
          WriteToPlan wtu=new WriteToPlan();
		
		  wtu.loadRoleInfo(myfilename,jigouid);		
		
		return "success";

	
	
	}
	public String findjigouid(String chushiid) //通过机构ID查询机构全称
    {
		Query query1;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		String jigouid="";
		try {

	        String sql="SELECT * from chu where chushiid = "+"'"+chushiid+"'";			
			System.out.println(sql);
			query1 = session.createSQLQuery(sql).addEntity(Chu.class);		
			List<Chu> list2 = query1.list();	
			
			
			if(list2 != null && list2.size() >= 1)
			{

				jigouid=list2.get(0).getJigouid();
				
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
		return  jigouid;

}
	public int findmaxuserinfoid() //获取下一处室的id
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();			
		List<UserInfo>  list;
		int newuserinfoid=0;
		try {

	        String hql="from UserInfo order by id desc";		
	        
			System.out.println(hql);
						
			query=session.createQuery(hql);
			
	     	list = query.list();	
	     	
	     	int userinfoid=list.get(0).getId();
	     	
	     	chuAdd ca =new chuAdd();
							
			 newuserinfoid=userinfoid+1;
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return newuserinfoid;
		
	}

}