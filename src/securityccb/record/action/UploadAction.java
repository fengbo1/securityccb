package securityccb.record.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

//文件上传Action
public class UploadAction extends ActionSupport {
	
	String path1="C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/securityccb";
	String path2="C:\\Program Files\\Apache Software Foundation/Tomcat 7.0\\webapps\\securityccb";
	
	
	
	//上传文件存放路径
	private final static String UPLOADDIR = "E:/upload/upload_record";
	//上传文件集合
	private List<File> file;
	//上传文件名集合
	private List<String> fileFileName;
	//上传文件内容类型集合
	private List<String> fileContentType;

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String execute() throws Exception {
		String name1="--";
		String name2="--";
		String name3="--";
		String name4="--";
		String name5="--";
		String name6="--";
		String name7="--";
		String name8="--";
		
		
	
		if(file!=null)
		{
			for (int i = 0; i < file.size(); i++) 
			{
				//循环上传每个文件
				if (i==0){
					name1=uploadFile(i);
				}
				if (i==1){
					name2=uploadFile(i);
				}
				if (i==2){
					name3=uploadFile(i);
				}
				if (i==3){
					name4=uploadFile(i);
				}
				if (i==4){
					name5=uploadFile(i);
				}
				if (i==5){
					name6=uploadFile(i);
				}
				if (i==6){
					name7=uploadFile(i);
				}
				if (i==7){
					name8=uploadFile(i);
				}
			
			}
		}else{}
		
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		
		response.setContentType("text/html;charset=utf-8");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		String position = request.getParameter("position");
		String people = request.getParameter("people");
		String remark = request.getParameter("remark");
		String time = request.getParameter("time");
		String id1 = request.getParameter("1");
		String sys = request.getParameter("sys");
		
		/*
		//获取系统时间，给content文件命名并保存
		Date date = new Date();
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYYMMddHHmm");
		String str = bartDateFormat.format(date);
		String file_name="D:/Program Files/apache-tomcat-7.0.59/webapps/security/content/"+title+"_"+str+".txt";
		File file = new File(file_name);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(content);
		fileWriter.close();*/
	
		//Date date = new Date();
		Upload upload=new Upload();
		/*
		 * title 标题  
		 * file_name内容文本文件存放路径
		 * name1 附件文件存放路径（文件名由 ：时间+原文件名  构成）
		 */
		
		
    	Session session = HibernateSessionFactory.getSession();;
    	Transaction trans=session.beginTransaction();
		try {
			 String title=position.substring(0, 3);//title 作为机构标识区分机构
			
			 DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			 Date date=format1.parse(time);
			 String content1="";
			 String content2="";

			 
			 
			 if(content.length()>255){
			 content1=content.substring(0, 254);
			 content2=content.substring(255, content.length());				 
			 }else{
				 content1=content;
			 }
			
			
			upload.add(date,type,title,content1,content2,people,remark,name1,name2,name3,name4,name5,name6,name7,name8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		  trans.commit();
          session.flush();
          session.close();
		}
		
	
	
		return "success";
	}

	//执行上传功能
	private String uploadFile(int i) throws FileNotFoundException, IOException {
		try {
			Date date = new Date();
			SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYYMMddHHmmssms");
			String str = bartDateFormat.format(date);
			
			
			InputStream in = new FileInputStream(file.get(i));
			//String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);
			String dir=path2+"\\upload\\upload_record";
			File uploadFile = new File(dir, str+"_"+this.getFileFileName().get(i));
			String name=this.getFileFileName().get(i);
			OutputStream out = new FileOutputStream(uploadFile);
			byte[] buffer = new byte[1024 * 1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			
			return "/upload/upload_record/"+str+"_"+name;
			
		   
						
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}