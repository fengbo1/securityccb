package securityccb.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitAction extends HttpServlet {  
  
	/**
	 * 没用
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * tomcat启动时执行一次该代码
	 */
    public void init() throws ServletException {  
    	
    	List<String> listpath = new ArrayList<String>();
    	listpath.add("C:/securityccb/upload/upload_file");
    	listpath.add("C:/securityccb/upload/upload_area");
    	listpath.add("C:/securityccb/upload/upload_jgxq");
    	listpath.add("C:/securityccb/upload/upload_plan");
    	listpath.add("C:/securityccb/upload/upload_record");
    	listpath.add("C:/securityccb/upload/upload_userinfo");
    	listpath.add("C:/securityccb/upload/upload_zbnr");
    	for(int i=0;i<listpath.size();i++)
    	{
    		File savefile = new File(new File(listpath.get(i)), "test");
        	if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
    	}
     }  
}
