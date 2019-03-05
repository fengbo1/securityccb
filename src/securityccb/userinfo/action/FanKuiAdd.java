package securityccb.userinfo.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.userinfo.dao.FankuiDAO;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.Fankui;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.DateTimeUtil;
import securityccb.util.Util;

import ccb.hibernate.HibernateSessionFactory;

public class FanKuiAdd {

	private String message;
	private String position;
	private String newnumber;
	private String title;
	private String content;
	private File file;
	private String fileFileName;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String execute() throws Exception
	{
		FankuiDAO fkdao = new FankuiDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		DateTimeUtil dtu = new DateTimeUtil();
		UserInfo ui = uidao.findAllByNewnumber(newnumber);
		if(ui!=null)
		{
			String jigou = ui.getPosition().substring(0, 3);
			int rnd = (int) (Math.random()*100);
			String houzui = fileFileName.split("\\.")[fileFileName.split("\\.").length-1];
			if (file != null) {
				fileFileName = "fankui"+jigou+rnd+"."+houzui;
			       File savefile = new File(new File(Util.userinfopath), fileFileName);
			       if (!savefile.getParentFile().exists())
			            savefile.getParentFile().mkdirs();
			           FileUtils.copyFile(file, savefile);
			     }
			else
			{
				fileFileName = "--";
			}
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();	
			try {
				Fankui fk = new Fankui();
				fk.setDate(dtu.getStringDate());
				fk.setTime(dtu.getTime());
				fk.setTitle(title);
				fk.setContent(content);
				fk.setNewnumber(newnumber);
				fk.setFujian(fileFileName);
				fk.setJigou(jigou);
				fkdao.merge(fk);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				trans.commit();
				session.flush();
				session.clear();
				session.close();
			}
		}
		return "success";
	}
}
