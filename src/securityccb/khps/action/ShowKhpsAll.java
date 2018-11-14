package securityccb.khps.action;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.operate.dao.OperateDAO;
import securityccb.operate.pojo.Operate;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;
//取出所有待评审事项
public class ShowKhpsAll {

	private String newnumber;
	private List <Khps> list;
	private List <Khps> flist;
	private Integer chu;
	private String position;
	private String role;
	private String daohang;
	private boolean ifanbaobz;
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
 	    
 	    UserInfo ui=new UserInfo();
 	    UserInfoDAO uidao=new UserInfoDAO();
 	    ui=uidao.findZhChuz();
 	    String uianbao=uidao.findAnBaobz().getNewnumber();
 	    if(uianbao.equals(newnumber))
 	    	ifanbaobz=true;
 	    if(newnumber.equals(ui.getNewnumber().trim()))
 	    {
 	    	list=(List<Khps>)khdao.findUndoByZhcz(newnumber);
 	    }
 	    else
 	        list=(List<Khps>)khdao.findUndoByThisunder(newnumber);
 	    flist=opdao.findAllByViewernum(newnumber);
 	    ui=(UserInfo)uidao.findByNewnumber(newnumber).get(0);
 	    role=ui.getRole().trim();
 	    if(ui.getPosition().substring(0, 5).equals("00000"))
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


	public void setIfanbaobz(boolean ifanbaobz) {
		this.ifanbaobz = ifanbaobz;
	}


	public boolean isIfanbaobz() {
		return ifanbaobz;
	}


}
