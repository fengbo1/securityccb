package securityccb.userinfo.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.chu.pojo.Chu;
import securityccb.jigou.pojo.JiGou;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.Util;


import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;
public class WriteToUser extends ActionSupport{
private String jigouid; 
	
public String getJigouid() {
		return jigouid;
	}
public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}

/**
	 * 把Excele表读出的数据，组装成一个List,统一导入数据库
	 * @param uploadFileFileName
	 */
//	String path1=Util.yudayepath+"/securityccb";//"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/securityccb";
//	String path2="C:\\Program Files\\Apache Software Foundation/Tomcat 7.0\\webapps\\securityccb";
public String loadRoleInfo(String uploadFileFileName,String jigouid){
	String message="success";
	String directory = Util.basepath+"upload/upload_userinfo"; 
	String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
	File target = new File(directory,uploadFileFileName);
	//List roleList = new ArrayList();
	ArrayList<UserInfo> roleList = new ArrayList();
	Session se;
	Transaction tr;
	se = HibernateSessionFactory.getSession();
	tr = se.beginTransaction();
	try{		
		
		UserInfoDAO ud =new UserInfoDAO();
		
		FileInputStream fi = new FileInputStream(target);
		Workbook wb = new HSSFWorkbook(fi);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum()+1;
		List <UserInfoUp> alist=new ArrayList();
		List <UserInfo> blist=new ArrayList();

							
		for(int i=1;i<rowNum;i++){
			
			String name="";
			String newnumber="";
			String chushi="";
			String zhiwu="";			
			String password="";
            String chushiid="";
            String address="";
            String tel="";
            String namesos="";
            String telsos="";
            String relation="";

            

        	
            Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for(int j=0;j<cellNum;j++){
				Cell cell = row.getCell(j);
				String cellValue = null;
				if(cell!=null){
					
				
				switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
					case 0 : cellValue = String.valueOf((int)cell.getNumericCellValue()); break;
					case 1 : cellValue = cell.getStringCellValue(); break;
					case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
					case 3 : cellValue = ""; break;
					case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
					case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
				}
				}
				switch(j){//通过列数来判断对应插如的字段
					case 0 : {
						name=cellValue;
						System.out.println("姓名读取内容："+name);
						break;
					}
					case 1 : {
						chushi=cellValue;
						System.out.println("处室信息读取内容："+chushi)	;
						break;
						
					}
					case 2 : { 
						newnumber=cellValue;	
						System.out.println("新一代员工编号："+newnumber)	;					
						break;
					}
					case 3 : {
						password=cellValue;
						break;
					}
					case 4 :  { 
						zhiwu=cellValue;	
						System.out.println("系统角色读取内容："+zhiwu);												
						break;
					}
					case 5 :{
						address=cellValue;
						System.out.println("家庭住址："+address);
						break;
					}		
					case 6 :{
						tel=cellValue;
						System.out.println("电话："+tel);

						break;
					}	
					case 7 :{
						namesos=cellValue;
						System.out.println("应急联系人姓名："+namesos);

						break;
					}	
					case 8 :{
						telsos=cellValue;
						System.out.println("应急联系人电话："+telsos);

						break;
					}	
					case 9 :{
						relation=cellValue;
						System.out.println("应急联系人关系："+relation);

						break;
					}	
				}						
					
								
			}
			UserInfoUp uiup=new UserInfoUp();

			uiup.setName(name);
			uiup.setChushi(chushi);
			uiup.setNewnumber(newnumber);
			uiup.setPassword(password);
			uiup.setZhiwu(zhiwu);
			uiup.setAddress(address);
			uiup.setTel(tel);
			uiup.setSosname(namesos);
			uiup.setSostel(telsos);
			uiup.setRelation(relation);
			alist.add(uiup);			
		}	
		for(int i=0;i<alist.size();i++){
			UserInfo ui=new UserInfo();
			//判断名字是否超长
			if(alist.get(i).getName().length()>32){
				message="第"+i+"行名字超长，上传失败";
				return message;				
			}else{
				ui.setName(alist.get(i).getName());
			}
			//判断处室是否存在,判断系统角色是否存在
			String chushiid=findchushiid(alist.get(i).getChushi(),jigouid,se);
			String zhiwu=findzhiwu(alist.get(i).getZhiwu());
			if(!chushiid.equals("")&&!zhiwu.equals("")){
				ui.setPosition(jigouid+chushiid+zhiwu);
				ui.setRole(zhiwu.substring(0, 1));
				ui.setQuanxian(zhiwu.substring(1, 2));				
			}if(chushiid.equals("")){
				message="第"+i+"处室名称不存在，上传失败";
				
				return message;
			}if(chushiid.equals("")){
				zhiwu="第"+i+"职务不存在，上传失败";
				
				return message;
				
			}
			
			//判断newnumber是否合规； a的初始值是9  ；b的初始值是0
			int a=checknewnumberbyall(alist.get(i).getNewnumber(),se);//看看newnumber在全量中的数量
		  
			int c=checknewnumberbyjigouid1(alist.get(i).getNewnumber(),jigouid,se);//查看在非本机构中newnumber数量
			
			int b=checknewnumberbylist(alist,alist.get(i).getNewnumber());//看看newnumber在上传中的数量
			
			if(b>1){
				message="上传文件中，新一代员工编号存在重复";
				
				return message;
			}
//			if(a>1&&a!=9){
//				String upjigouid=findjigouidbynewnumber(alist.get(i).getNewnumber(),se);
//			    	if(upjigouid!=jigouid){
//			    		message="上传文件中，新一代员工编号存在重复"+alist.get(i).getNewnumber();
//			    	
//						return message;
//			    	}
//			}
			if(c>=1){
				String jigouname=findjigouname(findjigouidbynewnumber(alist.get(i).getNewnumber(),se),se);
				message="新一代员工编号:"+alist.get(i).getNewnumber()+",其他机构("+jigouname+")已经使用，请联系系统管理员。";
		    	
				return message;
			}
			ui.setNewnumber(alist.get(i).getNewnumber());
			
			//判断password
			ui.setPassword(alist.get(i).getPassword());

			//判断Address
			ui.setAddress(alist.get(i).getAddress());
			
			//判断Tel
			ui.setTel(alist.get(i).getTel());
			
			//判断Namesos
			ui.setNamesos(alist.get(i).getSosname());

			//判断Telsos
			ui.setTelsos(alist.get(i).getSostel());
			//判断Telsos
			ui.setRelation(alist.get(i).getRelation());		
			
			UserInfoDAO uid=new UserInfoDAO();
			ui.setId(uid.findmaxuserinfoid(i));
			
			blist.add(ui);			
			
		}
		
		
		
//		//删除jigouid下全部人员信息
		String sql="delete  from userinfo where mid(position,1,3) = '"+jigouid+"'";	
	    se.createSQLQuery(sql).executeUpdate();
	for(int k=0;k<blist.size();k++){
		
		ud.mysave(blist.get(k));	
	
	}
		
	
	}	
			catch(IOException e){
				tr.rollback();//出错回滚
			e.printStackTrace();
			}finally{
				tr.commit();
				se.flush();
				se.clear();
				se.close();
				}		
	
     return message; 
	}
public void noidsave(UserInfo ui)  {
	Session se;
	Transaction tr;
	se = HibernateSessionFactory.getSession();
	tr = se.beginTransaction();
	
	try{					
	UserInfoDAO dao=new UserInfoDAO();
	dao.save(ui);
	}
	finally{
		tr.commit();
		se.flush();
		se.clear();
		se.close();
		}
	}
public void idmerge(UserInfo ui)  {
	Session se;
	Transaction tr;
	se = HibernateSessionFactory.getSession();
	tr = se.beginTransaction();
	
	try{					
	UserInfoDAO dao=new UserInfoDAO();
	dao.merge(ui);
	}
	finally{
		tr.commit();
		se.flush();
		se.clear();
		se.close();
		}
	}
public Integer findid(String name)  {
	Integer id=0;
	List<UserInfo> l=new ArrayList<UserInfo>();
	Session session=HibernateSessionFactory.getSession();
    Transaction trans=session.beginTransaction();
    Query query;
    	
    String hql="from UserInfo as ui where ui.name=:nd";
    query=session.createQuery(hql);
    query.setString("nd",name);          
    	
    l = query.list();
    trans.commit();
    session.flush();
    session.close();
    if(l.size()==1){
    	id=l.get(0).getId();
    }
	
	return id;

}

public String findzhiwu(String zhiwu)  {
	String zhiwu1="";
	if(zhiwu.equals("机构主要负责人")){
		zhiwu1="13";
	}
	if(zhiwu.equals("机构其他负责人")){
		zhiwu1="23";
	}
	if(zhiwu.equals("机构其他负责人（分管安保）")){
		zhiwu1="24";
	}
	if(zhiwu.equals("机构主要负责人（兼分管安保）")){
		zhiwu1="14";
	}
	if(zhiwu.equals("综合部门负责人")){
		zhiwu1="33";
	}
	if(zhiwu.equals("机构安全岗")){
		zhiwu1="51";
	}
	if(zhiwu.equals("处室安全岗")){
		zhiwu1="52";
	}
	if(zhiwu.equals("普通员工")){
		zhiwu1="53";
	}	
	return zhiwu1;

}

public String findchushiid(String chushi,String jigouid,Session session) // 
{
	Query query;
//	Session session = HibernateSessionFactory.getSession();
//	Transaction trans = session.beginTransaction();
    List <Chu> chulist=null;
	String chushiid="";
    
	try {			

		String sql="select * from chu where jigouid = "+"'"+jigouid+"' and chushi='"+chushi+"'";	
		System.out.println(sql);
		query  = session.createSQLQuery(sql).addEntity(Chu.class);	
		chulist=query.list();	
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
//		trans.commit();
//		session.flush();
//		session.clear();
//		session.close();
	}
	
	if(chulist != null && chulist.size() >= 1){
		chushiid=chulist.get(0).getChushiid();
	
	}
	
	
	return chushiid;

}
public int checknewnumberbyall(String newnumber,Session session) // 检查新一代员工编号唯一性
{
	Query query;
//	Session session = HibernateSessionFactory.getSession();
//	Transaction trans = session.beginTransaction();
    List <UserInfo> ulist=null;
	int ui=9;
    
	try {			

		String sql="select * from userinfo where newnumber = "+"'"+newnumber+"'";	
		System.out.println(sql);
		query  = session.createSQLQuery(sql).addEntity(UserInfo.class);	
		ulist=query.list();	
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
//		trans.commit();
//		session.flush();
//		session.clear();
//		session.close();
	}
	if(ulist != null){
		ui=ulist.size();	
	}
	
	return ui;

}
public int checknewnumberbyjigouid1(String newnumber,String jigouid,Session session) // 检查新一代员工编号唯一性
{
	Query query;
//	Session session = HibernateSessionFactory.getSession();
//	Transaction trans = session.beginTransaction();
    List <UserInfo> ulist=null;
	int ui=9;
    
	try {			

		String sql="select * from userinfo where newnumber = "+"'"+newnumber+"' and mid(position,1,3)<>'"+jigouid+"'";	
		System.out.println(sql);
		query  = session.createSQLQuery(sql).addEntity(UserInfo.class);	
		ulist=query.list();	
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
//		trans.commit();
//		session.flush();
//		session.clear();
//		session.close();
	}
	if(ulist != null){
		ui=ulist.size();	
	}
	
	return ui;

}


public int checknewnumberbylist(List<UserInfoUp> alist,String newnumber) // 检查新一代员工编号在上传中的数量
{
	int ii=0;
	for (int kk=0;kk<alist.size();kk++){
		if(newnumber.equals(alist.get(kk).getNewnumber())){
			ii=ii+1;
		}
	}
	
	return ii;

}




public String checknewnumberbyjigouid(String newnumber,String jigouid,Session session) // 检查新一代员工编号唯一性
{
	Query query;

    List <UserInfo> ulist=null;
	String ui="";
    
	try {			

		String sql="select * from userinfo where newnumber = "+"'"+newnumber+"' and jigouid='"+jigouid+"'";	
		System.out.println(sql);
		query  = session.createSQLQuery(sql).addEntity(UserInfo.class);	
		ulist=query.list();	
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{

	}
	if(ulist != null && ulist.size() >= 1){
		ui=ulist.get(0).getPosition();
		ui=findjigouname(ui.substring(0, 2),session);
	
	}
	
	return ui;

}	
public Integer findid1(String newnumber,Session session) // 检查新一代员工编号唯一性
{
	Query query;

    List <UserInfo> ulist=null;
	Integer ui=0;
    
	try {			

		String sql="select * from userinfo where newnumber = "+"'"+newnumber+"'";	
		System.out.println(sql);
		query  = session.createSQLQuery(sql).addEntity(UserInfo.class);	
		ulist=query.list();	
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{

	}
	if(ulist != null && ulist.size() >= 1){
		ui=ulist.get(0).getId();
		
	
	}
	
	return ui;

}	
public String findjigouname(String jigouid,Session session) // 查询机构名字
{
	Query query;

    List <JiGou> jlist=null;
	String jg="";
    
	try {			

		String sql="select * from jigou where jigouid = "+"'"+jigouid+"'";	
		System.out.println(sql);
		query  = session.createSQLQuery(sql).addEntity(JiGou.class);	
		jlist=query.list();	
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{

	}
	
	if(jlist != null && jlist.size() >= 1){
		jg=jlist.get(0).getJigou();
	
	}
	return jg;

}	
public String findjigouidbynewnumber(String newnumber,Session session) // 通过newnumber查jigouid
{
	Query query;
//	Session session = HibernateSessionFactory.getSession();
//	Transaction trans = session.beginTransaction();
    List <UserInfo> ulist=null;   
    String jigouid2=null;
	try {	
		String sql="select * from userinfo where newnumber = "+"'"+newnumber+"'";	
		System.out.println(sql);
		query  = session.createSQLQuery(sql).addEntity(UserInfo.class);	
		ulist=query.list();
		jigouid2=ulist.get(0).getPosition().substring(0, 3);		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{

	}

	return jigouid2;

}



}
