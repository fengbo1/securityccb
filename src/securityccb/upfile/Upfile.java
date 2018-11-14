package securityccb.upfile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import securityccb.util.Util;

import com.opensymphony.xwork2.ActionSupport;

//文件上传Action
public class Upfile extends ActionSupport {
	
	//String path1="C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/securityccb";
//	String path2="C:\\Program Files\\Apache Software Foundation/Tomcat 7.0\\webapps\\securityccb";
	
	
	//上传文件存放路径
	//private final static String UPLOADDIR = "E:/upload/upload_userinfo";
	//上传文件集合
	private List<String> file;
	//上传文件名集合
	private List<String> fileFileName;
	//上传文件内容类型集合
	private List<String> fileContentType;
	
	private String jigouid;
	
	private String type;
	
	private String files;	
	




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

	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}

	public String getJigouid() {
		return jigouid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getFiles() {
		return files;
	}

	public void setFile(List<String> file) {
		this.file = file;
	}

	public String execute() throws Exception {	
		
		String myfile=file.get(0);		
		String myname="yujia"+fileFileName.get(0);
		String dir="upload_userinfo";

		
		
		String jlkj=uploadFile(myfile,dir,myname);
		
		return null;		
		
	}


	//执行上传功能
	public String uploadFile(String file,String dir,String filename) throws FileNotFoundException, IOException {
		try {
			//file 是input传入list中的  filename 是文件名
			//String path2=Util.yudayepath;

			dir=Util.basepath+"upload/"+dir;//dir 是 upload路径下的文件夹名称
			InputStream in = new FileInputStream(file);	
			
			File uploadFile = new File(dir,filename);
			 if (!uploadFile.getParentFile().exists())
				 uploadFile.getParentFile().mkdirs();
			System.out.println("上传文件名:"+filename);
			System.out.println("上传文件路径:"+dir);
	
			OutputStream out = new FileOutputStream(uploadFile);
			byte[] buffer = new byte[1024 * 1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			
			return filename;
			
		   
						
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		finally{}
		return null;
	}
}