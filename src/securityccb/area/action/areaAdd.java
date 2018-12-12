package securityccb.area.action;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.area.dao.AreaDAO;
import securityccb.area.pojo.Area;
import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;
import securityccb.upfile.Upfile;
import securityccb.util.FileReadAndWrite;

import ccb.hibernate.HibernateSessionFactory;

public class areaAdd {
	private static final Log log = LogFactory.getLog(Area.class);
	private String chushiid;	
	private String area;	
	private String areaname;	
	private String url;	
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getFile() {
		return file;
	}

	public void setFile(List<String> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String execute() throws Exception
	{
		FileReadAndWrite fraw = new FileReadAndWrite();
		AreaDAO ad=new AreaDAO();
		String myfile="";
		String myfilename="";
		String dir="upload_area";
		String fileTyle="";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		try {		
			String newareaid=ad.findmaxareaid();
			newareaid = fraw.readandwrite("AREA", newareaid);
			if(file!=null&&fileFileName!=null){
				myfilename=fileFileName.get(0);
				myfile=file.get(0);
				fileTyle=myfilename.substring(myfilename.lastIndexOf("."),myfilename.length()); 
				url=chushiid+"_"+newareaid+fileTyle;
			    Upfile uf=new Upfile();
			    uf.uploadFile(myfile, dir, url);
			}
			Area na=new Area();
			na.setArea(area);
			na.setAreaid(newareaid);
			na.setAreaname(areaname);
			na.setChushiid(chushiid);
			na.setUrl(url);		
			ad.merge(na);
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

