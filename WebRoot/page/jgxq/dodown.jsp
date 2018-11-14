<%@ page contentType="application/x-download" import="java.io.*" %> 
<%@ page import="securityccb.util.Util"%>
<%request.setCharacterEncoding("utf-8");%>
<% 
String a=Util.basepath;  
String phkk=request.getParameter("a");
String filename = phkk.substring(phkk.lastIndexOf("/")+1);
int status=0; 
byte buffer[]=new byte[1024]; 

String pathfile=a+phkk;
InputStream in = new BufferedInputStream(new FileInputStream(pathfile));; 
OutputStream out2=null;
try
{ 
   
   
   filename = java.net.URLEncoder.encode(filename, "UTF-8");
   response.reset();
   response.setCharacterEncoding("UTF-8");
   response.setHeader("content-disposition","attachment; filename="+filename ); 
   response.setContentType("application/x-download");
   out2=new BufferedOutputStream(response.getOutputStream()); 
   int len = 0;
   while ((len = in.read(buffer)) > 0) {
       out2.write(buffer, 0, len);
   }  
   out2.flush(); 
   out2.close();
   out2=null;
   response.flushBuffer();
   out.clear();
   out = pageContext.pushBody();
} 
catch(Exception e) 
{ 
   System.out.println(e); 
   response.sendRedirect(filename); 
} 
finally
{ 
   if(in!=null) 
      in.close(); 
   if(out2 !=null) 
      out2.close(); 
} 
%>