package securityccb.file.action;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.upfile.Upfile;
import securityccb.util.PinyinTool;
import securityccb.util.PinyinTool.Type;
import securityccb.file.dao.FileDAO;
import securityccb.file.pojo.File;
import ccb.hibernate.HibernateSessionFactory;

public class FileAdd {
	private static final Log log = LogFactory.getLog(FileAdd.class);
	private String type1; //用来存放从何处进来的  制度 通告 预案
	private String type2; //用来存选择何种级别的 总行 分行 等

	
	private List<File> myfile;
	private String type;

	private String title;
	private String position;
	private Date nowdate;
	private Date date;
	
	private List<String> file;
	//上传文件名集合
	private List<String> fileFileName;
	//上传文件内容类型集合


	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return position;
	}
	public void setMyfile(List<File> myfile) {
		this.myfile = myfile;
	}
	public List<File> getMyfile() {
		return myfile;
	}


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType2() {
		return type2;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType1() {
		return type1;
	}

	public void setNowdate(Date nowdate) {
		this.nowdate = nowdate;
	}
	public Date getNowdate() {
		return nowdate;
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
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		PinyinTool pt = new PinyinTool();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		nowdate=getNowDateShort();
		String url="";
		String url1 = "";
		
		//前台得到的list转为数组
		if(file!=null&&file.size()>0){
			String[] myfile = new String[file.size()];
			file.toArray(myfile);
			String[] myfilename = new String[fileFileName.size()];
			fileFileName.toArray(myfilename);
		    if(myfilename.length>0){
		    	for(int i=0;i<myfilename.length;i++)
		    	{
		    		String zwname = myfilename[i];
		    		url1+=zwname;
		    		url1+="|";
		    		Upfile upf=new Upfile();		
					upf.uploadFile(myfile[i], "upload_file",zwname);
		    	}
		    	if(url1.length()>0)
		    	{
		    		url1=url1.substring(0, url1.length()-1);
		    	}
				url =StringUtils.join(myfilename, "|");
			}
		
//			if(myfile.length>0){
//				for (int i=0;i<myfile.length;i++){
//					Upfile upf=new Upfile();		
//					upf.uploadFile(myfile[i], "upload_file", myfilename[i]);
//				}
//			}			  
		}
		if(type2==null){
			type2="";
		}
		 type=type1.substring(0, 2)+type2;
		
		if(type1.equals("ya")){
			type="ya";
		}
		
		
		
		File f =new File();
		f.setDate(date);
		f.setJigouid(position.substring(0, 3));
		f.setTitle(title);
		f.setType(type);
		f.setNowdate(nowdate);
		f.setUrl(url);//存放上传文件	
		f.setUrl1(url1);
		 
		FileDAO fd=new FileDAO();
		
		fd.merge(f);
		
		
		
		
		
		try {
		
			//sql="SELECT * from file where jigouid = '"+jigouid+"' and type='"+type+"'";	
			//System.out.println(sql);
			//query = session.createSQLQuery(sql).addEntity(File.class);				
			//mylist = query.list();			
 
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
	public static Date getNowDateShort() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String dateString = formatter.format(currentTime);  
	    ParsePosition pos = new ParsePosition(0);  
	    Date currentTime_2 = formatter.parse(dateString, pos);  
	    return currentTime_2;  
	}


	
}
