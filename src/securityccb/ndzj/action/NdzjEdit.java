package securityccb.ndzj.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import securityccb.gzjh.dao.GzjhDAO;
import securityccb.gzjh.pojo.Gzjh;
import securityccb.jgxq.dao.JgxqDAO;
import securityccb.jgxq.pojo.Jgxq;
import securityccb.ndzj.dao.NdzjDAO;
import securityccb.ndzj.pojo.Ndzj;

import securityccb.util.Util;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
//修改机构详情
public class NdzjEdit {
	
private String jigouid;
private String rfileFileName;//文件名
private String year;
private File rfile;//上传的文件


public void setRfile(File rfile) {
	this.rfile = rfile;
}

public File getRfile() {
	return rfile;
}
public void setRfileFileName(String rfileFileName) {
	this.rfileFileName = rfileFileName;
}

public String getRfileFileName() {
	return rfileFileName;
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
	//上传年度总结
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    Ndzj ndzj=new Ndzj();
 	    NdzjDAO zjdao=new NdzjDAO();
 	    Date now = new Date();
 	    if (rfile != null) {
	       File savefile = new File(new File(Util.jgxqpath), rfileFileName);
	       if (!savefile.getParentFile().exists())
	            savefile.getParentFile().mkdirs();
	           FileUtils.copyFile(rfile, savefile);
	       }
	    else
	    {
	    	rfileFileName = "--";
	    }
 	    SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYYMMdd");
		String date = bartDateFormat.format(now);
		try 
		{
			ndzj.setDate(date);
			ndzj.setJigouid(jigouid);
			ndzj.setRtitle(rfileFileName);
		    
		    zjdao.merge(ndzj);
	    	    
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
