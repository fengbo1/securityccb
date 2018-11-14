package securityccb.gzjh.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import securityccb.gzjh.dao.GzjhDAO;
import securityccb.gzjh.pojo.Gzjh;
import securityccb.jgxq.dao.JgxqDAO;
import securityccb.jgxq.pojo.Jgxq;

import securityccb.util.Util;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
//修改机构详情
public class GzjhEdit {
	
private String jigouid;
private String pfileFileName;//文件名
private String year;
private File pfile;//上传的文件

public void setPfile(File pfile) {
	this.pfile = pfile;
}

public File getPfile() {
	return pfile;
}
public void setPfileFileName(String pfileFileName) {
	this.pfileFileName = pfileFileName;
}

public String getPfileFileName() {
	return pfileFileName;
}

public void setYear(String year) {
	this.year = year;
}

public String getYear() {
	return year;
}

public void setJigouid(String jigouid) {
	this.jigouid = jigouid;
}

public String getJigouid() {
	return jigouid;
}
	//上传工作计划
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    Gzjh gzjh=new Gzjh();
 	    GzjhDAO jhdao=new GzjhDAO();
 	    Date now = new Date();
 	    if (pfile != null) {
	       File savefile = new File(new File(Util.jgxqpath), pfileFileName);
	       if (!savefile.getParentFile().exists())
	            savefile.getParentFile().mkdirs();
	           FileUtils.copyFile(pfile, savefile);
	       }
	    else
	    {
	    	pfileFileName = "--";
	    }
 	    SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYYMMdd");
		String date = bartDateFormat.format(now);
		try 
		{
		    gzjh.setDate(date);
		    gzjh.setJigouid(jigouid);
		    gzjh.setPtitle(pfileFileName);
		    
		    jhdao.merge(gzjh);
	    	    
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return "success";
	}

}
