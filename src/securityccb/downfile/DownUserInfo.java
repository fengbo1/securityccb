package securityccb.downfile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.pojo.JiGou;
import securityccb.userinfo.action.UserInfoUp;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.ExportExcel;
import securityccb.util.Util;
import securityccb.chu.pojo.Chu;


import ccb.hibernate.HibernateSessionFactory;

public class DownUserInfo {
	private static final Log log = LogFactory.getLog(DownUserInfo.class);
	private static Logger logger = Logger.getLogger(DownUserInfo.class);
	private String jigou;
	private String jigouid;
	private List<UserInfo> mylist;
	private List<UserInfoUp> udownlist;
	private String position;
	private String chushiid;
	private String chushi;
	private String name;
	private String newnumber;
	private String areaname;
	private String role;
	private String quanxian;	
	private String zhufenbiaozhi;
	private String fileurl;
	private List<Chu> chulist;


	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Date now = new Date();
	    SimpleDateFormat DateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
	    String today=DateFormat.format(now);
		String filePath = "";
		List<UserInfo> list;
		List<UserInfoUp> uiulist = new ArrayList<UserInfoUp>();
		ExportExcel<UserInfoUp> ex = new ExportExcel<UserInfoUp>();
		String[] headers = {"姓名","处室","新一代员工编号","密码","系统角色","住址","电话","应急联系人","应急联系人电话","应急联系人关系"};
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		list = findallbyjigouid(jigouid, session);
		for(int i=0;i<list.size();i++)
		{
			UserInfoUp uiu = new UserInfoUp();
			UserInfo ui = list.get(i);
			String chushi=findchushibychushiid(ui.getPosition().substring(3, 9),session);
			uiu.setChushi(chushi);
			uiu.setName(ui.getName());
			uiu.setNewnumber(ui.getNewnumber());
			uiu.setAddress(ui.getAddress());
			uiu.setPassword(ui.getPassword());
			String zhiwu=findzhiwubyposition(ui.getPosition(),session);				
			uiu.setZhiwu(zhiwu);
			uiu.setRelation(ui.getRelation());
			uiu.setTel(ui.getTel());
			uiu.setSostel(ui.getTelsos());
			uiu.setSosname(ui.getNamesos());	
			uiulist.add(uiu);
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		//导出
		 try {
			 	fileurl=jigouid+"_"+today+"_uesrinfo.xls";
			 	filePath=Util.basepath+"downfile/down_userinfo/"+fileurl;
			 	logger.info("导出路径"+filePath);
			 	
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, uiulist, out);
				out.close();
				System.out.println("excel导出成功！");
				
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return "success";
	}
        //根据jigouid查出本机机构所人员，装到mylist中。
		
//		Query query;		
//		Session session = HibernateSessionFactory.getSession();
//		Transaction trans = session.beginTransaction();
//		
//		
//		try {
//			 //根据jigouid查出本机机构所人员，装到mylist中。
//			
//			mylist=findallbyjigouid(jigouid, session);
//			List<UserInfoUp> udownlist=new ArrayList();
//			
//			 //把mylist中对象装到udownlist中，为写文件下载做准备。
//			for(int i=0;i<mylist.size();i++){
//				UserInfoUp uiu=new UserInfoUp();
//				
//				String chushi=findchushibychushiid(mylist.get(i).getPosition().substring(2, 8),session);
//				uiu.setChushi(chushi);
//				
//				uiu.setName(mylist.get(i).getName());
//				
//				uiu.setNewnumber(mylist.get(i).getNewnumber());
//				
//				uiu.setAddress(mylist.get(i).getAddress());
//				
//				uiu.setPassword(mylist.get(i).getPassword());
//				
//				String zhiwu=findzhiwubyposition(mylist.get(i).getPosition(),session);				
//				
//				uiu.setZhiwu(zhiwu);
//				
//				uiu.setRelation(mylist.get(i).getRelation());
//				
//				uiu.setTel(mylist.get(i).getTel());
//				
//				uiu.setSostel(mylist.get(i).getTelsos());
//				
//				uiu.setSosname(mylist.get(i).getNamesos());	
//			   
//				udownlist.add(uiu);
//			
//			}
//			//把udownlist中数据放到数组bb中去啊
//			
//			//String k=Util.yudayepath;
//			String filePath = Util.basepath+"downfile/down_userinfo";
//
//			String [][] bb=new String[udownlist.size()][10];
//			String dd[]={"处室","姓名","新一代员工编号","密码","系统角色","住址","电话","应急联系人","应急联系人电话","应急联系人关系",};
//			for (int i=0;i<udownlist.size();i++)
//			{
//				 bb[i][0]=udownlist.get(i).getChushi();
//				
//				 bb[i][1]=udownlist.get(i).getName();
//				 
//				 bb[i][2]=udownlist.get(i).getNewnumber();
//				 
//				 bb[i][3]=udownlist.get(i).getPassword();
//				 
//				 bb[i][4]=udownlist.get(i).getZhiwu();
//				 
//				 bb[i][6]=udownlist.get(i).getTel();
//				 
//				 bb[i][5]=udownlist.get(i).getAddress();	
//				 
//				 bb[i][7]=udownlist.get(i).getSosname();	
//				  
//				 bb[i][8]=udownlist.get(i).getSostel();
//				   
//				 bb[i][9]=udownlist.get(i).getRelation();	
//				 
//				 
//			}
//			
//			     Date now = new Date();
//			     SimpleDateFormat DateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
//			     String today=DateFormat.format(now);
//			
//			    //打开文件
//				FileOutputStream file = new FileOutputStream(filePath+"/"+jigouid+"_"+today+"_uesrinfo.xls");
//				fileurl=jigouid+"_"+today+"_uesrinfo.xls";
//				WritableWorkbook book=Workbook.createWorkbook(file);
//				
//			
//				//生成名为“第一页”的工作表，参数0表示这是第一页
//				WritableSheet sheet=book.createSheet("员工信息",0);
//				//设置列宽
//				sheet.setColumnView(0,20);
//				sheet.setColumnView(1,10);				
//				sheet.setColumnView(2,15);
//				sheet.setColumnView(3,30);				
//				sheet.setColumnView(4,20);
//				sheet.setColumnView(5,50);				
//				sheet.setColumnView(6,20);
//				sheet.setColumnView(7,20);
//				sheet.setColumnView(8,20);
//		
//									
//					for (int i=0;i<udownlist.size();i++)
//					{
//						for (int j=0;j<10;j++)
//						{
//							///WritableFont font=new WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.RED);
//							//WritableCellFormat cFormat=new WritableCellFormat(font);
//							//cFormat.setBackground(Colour.BLUE_GREY);
//							
//							
//							//在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
//							//以及单元格内容为test
//							Label label=new Label(j,i+1,bb[i][j]);
//					
//							//将定义好的单元格添加到工作表中
//							sheet.addCell(label);
//						}
//						    
//					}
//					for (int j=0;j<10;j++)
//					{
//						//在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
//						//以及单元格内容为test
//						Label label=new Label(j,0,dd[j]);
//				
//						//将定义好的单元格添加到工作表中
//						sheet.addCell(label);
//					}
//					/*生成一个保存数字的单元格
//					必须使用Number的完整包路径，否则有语法歧义
//					单元格位置是第二列，第一行，值为789.123*/
//			//		jxl.write.Number number = new jxl.write.Number(1,0,789.123);
//			//		sheet.addCell(number);
//					
//					//写入数据并关闭文件
//					book.write();
//					book.close();
//					file.close();
//					
//					//OutputStream out = new FileOutputStream(filePath+"/dddd.xls");
//					//out.close();
//			
//			
//			
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally{
//			trans.commit();
//			session.flush();
//			session.clear();
//			session.close();
//		}
		

//		return "success";
//	}

	public List<UserInfo> findallbyjigouid(String jigouid,Session session) //通过机构ID查询机构全称
    {
		Query query;			
		List<UserInfo> list = null ;
		try {

	        String sql="SELECT * from userinfo where mid(position,1,3) = "+"'"+jigouid+"'";			
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(UserInfo.class);		
			list = query.list();			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
		
	}
	public String findzhiwubyposition(String position,Session session) //通过机构ID查询机构全称
    {
		Query query;		
		List <UserInfo>ulist=null;
		String zhiwu=null;
		String z=position.substring(9,11);
		try {
	        
	         if(z.equals("13")){
	        	 zhiwu="机构主要负责人";
	         }
	         if(z.equals("23")){
	        	 zhiwu="机构其他负责人";
	         }
	         if(z.equals("24")){
	        	 zhiwu="机构其他负责人（分管安保）";
	         }
	         if(z.equals("14")){
	        	 zhiwu="机构主要负责人（兼分管安保）";
	         }
	         if(z.equals("33")){
	        	 zhiwu="综合部门负责人";
	         }
	         if(z.equals("51")){
	        	 zhiwu="机构安全岗";
	         }
	         if(z.equals("52")){
	        	 zhiwu="处室安全岗";
	         }
	         if(z.equals("53")){
	        	 zhiwu="普通员工";
	         }			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}		
		return zhiwu;		
	}
	public String findzhufenbyjigouid(String jigouid,Session session) // 
    {
		Query query;		
		List <JiGou>jlist=null;
		String zhufen=null;
		try {
	        String sql="SELECT * from jigou where jigouid = "+"'"+jigouid+"'";			
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(JiGou.class);		
			jlist = query.list();
			zhufen=jlist.get(0).getQuanxian();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}		
		return zhufen;		
	}
	public String findchushibychushiid(String chushiid,Session session) // 
    {
		Query query;		
		List <Chu>clist=null;
		String chushi = null;
		try {
	        String sql="SELECT * from chu where chushiid = "+"'"+chushiid+"'";			
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(Chu.class);		
			clist = query.list();	
			chushi=clist.get(0).getChushi();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}		
		return chushi;		
	}

	public String getJigou() {
		return jigou;
	}

	public void setJigou(String jigou) {
		this.jigou = jigou;
	}

	public String getJigouid() {
		return jigouid;
	}

	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}

	public List<UserInfo> getMylist() {
		return mylist;
	}

	public void setMylist(List<UserInfo> mylist) {
		this.mylist = mylist;
	}

	public List<UserInfoUp> getUdownlist() {
		return udownlist;
	}

	public void setUdownlist(List<UserInfoUp> udownlist) {
		this.udownlist = udownlist;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getChushiid() {
		return chushiid;
	}

	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}

	public String getChushi() {
		return chushi;
	}

	public void setChushi(String chushi) {
		this.chushi = chushi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getQuanxian() {
		return quanxian;
	}

	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}

	public String getZhufenbiaozhi() {
		return zhufenbiaozhi;
	}

	public void setZhufenbiaozhi(String zhufenbiaozhi) {
		this.zhufenbiaozhi = zhufenbiaozhi;
	}

	public List<Chu> getChulist() {
		return chulist;
	}

	public void setChulist(List<Chu> chulist) {
		this.chulist = chulist;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getFileurl() {
		return fileurl;
	}
	
	
	

	
	
}
