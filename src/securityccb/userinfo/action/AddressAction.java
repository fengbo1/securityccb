package securityccb.userinfo.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import securityccb.area.pojo.Area;
import securityccb.chu.action.ChuAction;
import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.zhiban.pojo.ZhiBanC;


import ccb.hibernate.HibernateSessionFactory;

public class AddressAction {
	private static final Log log = LogFactory.getLog(AddressAction.class);
	private String newnumber;
	private String address;
	private String tel;
	private String namesos;
	private String telsos;
	private String relation;
	private String position;
	private String name;
	private String chushi;
	private List <UserInfo>alladdress;
	private List <AddressList>addlist;



	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
	try{
		UserInfoDAO uid=new UserInfoDAO();
		//position.substring(9, 10)).equals("1")机构安全岗查询本机构全部人员信息
		System.out.print("substring(0, 9)):"+position.substring(9, 10));
		if(position.substring(10, 11).equals("1")){
	
			alladdress=uid.findadressbyjigouid(position.substring(0, 3));
		}//position.substring(9, 10).equals("2")处室安全岗查询本处室全部人员信息
		else if(position.substring(10, 11).equals("2")){
			
			alladdress=uid.findadressbychushiid(position.substring(3, 9));
		}
		
		else{	//普通员工查询自己信息	
			List<UserInfo> ulist=new ArrayList<UserInfo>();
			ulist=uid.findadressbynewnumber(newnumber);
			alladdress=ulist;		
		}		
		List<AddressList >addlist2 = new ArrayList();
		for (int i=0;i<alladdress.size();i++){
			String position1=alladdress.get(i).getPosition();
			String chushiid=position1.substring(3, 9);
			
			ChuDAO cd =new ChuDAO();
			String chushi=cd.findchushinamebychushiid(chushiid);			
			
			AddressList aa=new AddressList();
			
			aa.setChushi(chushi);
			aa.setName(alladdress.get(i).getName());
			aa.setNamesos(alladdress.get(i).getNamesos());
			aa.setNewnumber(alladdress.get(i).getNewnumber());
			aa.setPosition(alladdress.get(i).getPosition());
			aa.setRelation(alladdress.get(i).getRelation());
			aa.setTel(alladdress.get(i).getTel());
			aa.setTelsos(alladdress.get(i).getTelsos());
			aa.setAddress(alladdress.get(i).getAddress()); 
			
			addlist2.add(aa);
			
			
		}
		addlist=addlist2;
	}catch (Exception e) {
			e.printStackTrace();
	}finally{
		trans.commit();
		session.flush();
		session.clear();
		session.close();
	}
		return "success";

	
	
	}



	public String getNewnumber() {
		return newnumber;
	}



	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getNamesos() {
		return namesos;
	}



	public void setNamesos(String namesos) {
		this.namesos = namesos;
	}



	public String getTelsos() {
		return telsos;
	}



	public void setTelsos(String telsos) {
		this.telsos = telsos;
	}



	public String getRelation() {
		return relation;
	}



	public void setRelation(String relation) {
		this.relation = relation;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getChushi() {
		return chushi;
	}



	public void setChushi(String chushi) {
		this.chushi = chushi;
	}



	public List<UserInfo> getAlladdress() {
		return alladdress;
	}



	public void setAlladdress(List<UserInfo> alladdress) {
		this.alladdress = alladdress;
	}



	public List<AddressList> getAddlist() {
		return addlist;
	}



	public void setAddlist(List<AddressList> addlist) {
		this.addlist = addlist;
	}


	}
	

	