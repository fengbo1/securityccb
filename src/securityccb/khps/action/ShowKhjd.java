package securityccb.khps.action;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.operate.dao.OperateDAO;
import securityccb.operate.pojo.Operate;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;
//取出所有待评审事项
public class ShowKhjd {

	private String newnumber;
	private List <Khps> flist;
	private List<JiGou> waitlist;
	private List <Khps> unflist;
	private List <Khps> waitsplist;
	private List <Khps> liuzhuanlist;
	private Integer chu;
	private String position;
	private String role;
	private int tuisongbz;
	public void setLiuzhuanlist(List <Khps> liuzhuanlist) {
		this.liuzhuanlist = liuzhuanlist;
	}


	public List <Khps> getLiuzhuanlist() {
		return liuzhuanlist;
	}

	public void setWaitsplist(List <Khps> waitsplist) {
		this.waitsplist = waitsplist;
	}


	public List <Khps> getWaitsplist() {
		return waitsplist;
	}
	
	public void setTuisongbz(int tuisongbz) {
		this.tuisongbz = tuisongbz;
	}


	public int getTuisongbz() {
		return tuisongbz;
	}
	
	public void setWaitlist(List<JiGou> waitlist) {
		this.waitlist = waitlist;
	}


	public List<JiGou> getWaitlist() {
		return waitlist;
	}

	public void setUnflist(List <Khps> unflist) {
		this.unflist = unflist;
	}


	public List <Khps> getUnflist() {
		return unflist;
	}
	public void setFlist(List <Khps> flist) {
		this.flist = flist;
	}


	public List <Khps> getFlist() {
		return flist;
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
//安保部处长查询，返回待刘总审批、流转中和已全部审批完成三个list
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    KhpsDAO khdao = new KhpsDAO();
 	    OperateDAO opdao=new OperateDAO();
 	    
 	    UserInfo ui=new UserInfo();
 	    UserInfoDAO uidao=new UserInfoDAO();
 	    
 	    JiGouDAO jgdao=new JiGouDAO();
 	    int jigounum=0;
 	    List<JiGou> jglist=new ArrayList<JiGou>();
 	    jglist=( List<JiGou>)jgdao.findAll();
 	    jigounum=jglist.size();
 	    //刘总审批完成list
 	    flist=(List<Khps>)khdao.findflist();
 	     //查询所有流转到安保部处长名下待推送刘总的list
 	    unflist=(List<Khps>)khdao.findUnflist();
 	    //未开始的jigoulist
 	    setWaitlist((List<JiGou>)khdao.findwaitlist());
 	   //已推送刘总等审批list
 	    waitsplist=(List<Khps>)khdao.findwaitsplist();
 	    //流转中未到推送状态的list
 	   liuzhuanlist=(List<Khps>)khdao.findlzlist();
 	   
 	    if(jigounum-1<=unflist.size())//去掉安保部
 	    	tuisongbz=1;
 	    
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}

