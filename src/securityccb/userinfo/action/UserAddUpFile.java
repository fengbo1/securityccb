package securityccb.userinfo.action;

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

public class UserAddUpFile {
	private static final Log log = LogFactory.getLog(UserInfo.class);
	private String chushiid;	
	private String jigouid;
	private String quanxian;	
	private String newnumber;
	private String name;
	private String zhiwu;
	private String message;
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

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String execute() throws Exception
	{   
				
		Date now = new Date();		
		SimpleDateFormat TimeFormats = new SimpleDateFormat("YYYYMMddHHmmssms");		
		String nametime=TimeFormats.format(now);		
		//把选择的文件存放到指定文件夹中
		
		Upfile uf=new Upfile();
		String myfile=file.get(0);
		String dir="upload_userinfo";
		String myfilename=nametime+"_"+fileFileName.get(0);
		
		uf.uploadFile(myfile, dir, myfilename);
		//把文件中文件读出来，写入数据库
          WriteToUser wtu=new WriteToUser();
		
		 message=wtu.loadRoleInfo(myfilename,jigouid);		
		
		if(message.equals("success")){
			
			return "success";
		}else{
			return "false";

		}
		
		
		

	
	
	}


}