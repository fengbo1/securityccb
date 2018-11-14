package securityccb.khps.action;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.operate.dao.OperateDAO;

import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;
//评审事项查询
public class KhpsCx {

	private String newnumber;
	private List <Khps> list;
	private List <Khps> flist;
	private Integer chu;
	private String position;
	private String role;
	private String daohang;
	public void setFlist(List <Khps> flist) {
		this.flist = flist;
	}


	public List <Khps> getFlist() {
		return flist;
	}


	public void setList(List <Khps> list) {
		this.list = list;
	}


	public List <Khps> getList() {
		return list;
	}



	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public Integer getChu() {
		return chu;
	}


	public void setChu(Integer chu) {
		this.chu = chu;
	}

		

	public void setRole(String role) {
		this.role = role;
	}


	public String getRole() {
		return role;
	}

	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getDaohang() {
		return daohang;
	}


	public void setDaohang(String daohang) {
		this.daohang = daohang;
	}


	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    KhpsDAO khdao = new KhpsDAO();
 	    OperateDAO opdao=new OperateDAO();
 	    
 	    UserInfo ui_zh=new UserInfo();
 	    UserInfo ui=new UserInfo();
 	    UserInfoDAO uidao=new UserInfoDAO();
 	    ui_zh=uidao.findZhChuz();
 	    ui=(UserInfo)uidao.findByNewnumber(newnumber).get(0);
 	   //查询本人处理过的考核事项
 	    flist=opdao.findAllByViewernum(newnumber);
 	    if(flist.size()==0)
 	    {
 	    	flist=opdao.findAllByjigouid(ui.getPosition());
 	    }
 	   ui_zh=(UserInfo)uidao.findByNewnumber(newnumber).get(0);
 	    role=ui_zh.getRole().trim();
 	    if(ui_zh.getPosition().substring(0, 6).equals("000000"))
 	    {
 	    	daohang = "考核管理->机构考核 ";
 	    }
 	    else
 	    {
 	    	daohang = "考核管理->自评考核 ";
 	    }
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}


}
