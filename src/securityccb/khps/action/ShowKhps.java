package securityccb.khps.action;



import java.util.ArrayList;
import java.util.List;

import securityccb.process.action.FindNextUnder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.operate.dao.OperateDAO;
import securityccb.operate.pojo.Operate;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;
//当前待评审事项
public class ShowKhps {

	private String newnumber;
	private Khps khps;
    private String pnumber;
    private Operate operate;
    private List<UserInfo> list;
    private  String item;
   
    private int xiugaibz;//是否可修改评分标志
    private int chaxunbz;//查询还是处理标志位
   
    private int tuihuibz;//退回标志
   
    private String daohang;
    private int lasttime;//总行安保部长最后一次审批
    private String thisunder;
    private String jigouc;
    private String year;
    private String anbaob;
    
    public void setJigouc(String jigouc) {
		this.jigouc = jigouc;
	}
	public String getJigouc() {
		return jigouc;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getYear() {
		return year;
	}
    public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String getThisunder() {
		return thisunder;
	}
    public void setLasttime(int lasttime) {
		this.lasttime = lasttime;
	}
	public int getLasttime() {
		return lasttime;
	}
 
    private List<Operate> oplist;
    
    public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item= item;
	}
    public void setListui(List<UserInfo> list) {
		this.list = list;
	}

    
	public List<UserInfo> getList() {
		return list;
	}
    public void setOperate(Operate operate) {
		this.operate = operate;
	}

    public void setOplist(List<Operate> oplist) {
		this.oplist = oplist;
	}
	public List<Operate> getOplist() {
		return oplist;
	}
	public Operate getOperate() {
		return operate;
	}
    public void setKhps(Khps khps) {
		this.khps = khps;
	}


	public Khps getKhps() {
		return khps;
	}

	public void setAnbaob(String anbaob) {
		this.anbaob = anbaob;
	}
	public String getAnbaob() {
		return anbaob;
	}
	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public void setChaxunbz(int chaxunbz) {
		this.chaxunbz = chaxunbz;
	}
	public int getChaxunbz() {
		return chaxunbz;
	}
		
	public void setXiugaibz(int xiugaibz) {
		this.xiugaibz = xiugaibz;
	}
	public int getXiugaibz() {
		return xiugaibz;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}


	public String getPnumber() {
		return pnumber;
	}
	
	public void setTuihuibz(int tuihuibz) {
		this.tuihuibz = tuihuibz;
	}
	public int getTuihuibz() {
		return tuihuibz;
	}

	//获取单一考核评审以及下一审批人

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
 	   
 	    FindNextUnder fnu = new FindNextUnder();
 	    
 	    KhpsDAO khdao = new KhpsDAO();
 	    OperateDAO opdao= new OperateDAO();
 	    int boss=0;
 	   
 	    List l =khdao.findByPnumber(pnumber);
 	    oplist=opdao.findByPnumber(pnumber);
 	    JiGouDAO jgdao = new JiGouDAO();
 	    UserInfo ui=new UserInfo();
 	    UserInfoDAO uidao=new UserInfoDAO();
 	    newnumber=(String)ActionContext.getContext().getSession().get("newnumber");
 	   
 	    
 	    ui=(UserInfo)uidao.findByNewnumber(newnumber).get(0);
 	    if(ui.getRole().equals("0"))
 	    	boss=1;
 	   		   
 	    //处理没有评审项目的异常情况
 	    if( l.isEmpty())
 	    {
 	    	khps=new Khps();
 	    	
 	     	    	
 	    }else//正常流程
 	    {
 	    	
 	    	khps=(Khps) khdao.findByPnumber(pnumber).get(0);
 	    	year=khps.getRemark3();
 	    	List listjg = jgdao.findByJigouid(khps.getJigouid());
 	 		if(!listjg.isEmpty())
 	 		{
 	 			JiGou jg = (JiGou) listjg.get(0);
 	 			jigouc = jg.getJigou();
 	 		}
 	    	item=""+khps.getItem();//分中心还是主中心流程
 	        //安保部处长提交不需要选下一级审批人，系统帮他选择主中心综合处长
 	 	   UserInfo testui=new UserInfo();
 	 	   testui=uidao.findZhChuz();
 	 	   
 	 	   if(testui.getNewnumber().equals(newnumber.trim()))
 	 		   lasttime=1;
 	 			   
 	 	   if(chaxunbz==1 )//查询和boss不用找下一审批人
	    	  list = new ArrayList<UserInfo>();
	   	   else
 	 	    list=fnu.findNextUnder(item, pnumber);
 	 	    
 	 	   if(lasttime==1&&chaxunbz==0)//安保部处长不显示下一级审批人，但是仍然有
 	       {
 	    	   UserInfo temp=new UserInfo();
 	    	   temp=(UserInfo)fnu.findNextUnder(item, pnumber).get(0);
 	    	   thisunder=temp.getNewnumber().trim();
	       }
 	       else if(lasttime==0&&chaxunbz==0)
 	 	   {
 	 	       list=fnu.findNextUnder(item, pnumber);
 	 	       
 	 	    }
  	    	String t=khps.getStatus().trim();
 	    	String p=ui.getNewnumber().trim();
 	    	String r=khps.getInitiator().trim();
 	 
 	    	//判断是否可以修改分数      总行安保部处长在副主任确认前可以修改
 	    	if(ui.getRole().equals("3")&&ui.getPosition().substring(0, 5).equals("00000"))//确定总行安保处长
 	    	{
 	    		daohang = "考核管理->机构考核 ";
 	    		if(khps.getItem()==1&&Integer.parseInt(khps.getJindu())<=4&&Integer.parseInt(khps.getJindu())>=2)//主中心流程
 	    		{
 	    			xiugaibz=1;
 	    			
 	    		}
 	    		else if(khps.getItem()==2&&Integer.parseInt(khps.getJindu())<=6&&Integer.parseInt(khps.getJindu())>=4)//分中心流程
 	    		{ 	    			
 	    			xiugaibz=1;
 	    		}
 	    		else
 	    			xiugaibz=0;
 	    		
 	    	}
 	    	else
 	    	{
 	    		daohang = "考核管理->自评考核 ";
 	    		xiugaibz=0;
 	 	    	
 	    	}
 	    		
 	    	//综合处长在第一次处理时可以退回
 	    	if(Integer.parseInt(khps.getJindu())==1)
 	    	    tuihuibz=1;
 	    	else 
 	    		tuihuibz=0;
	    		
	     }
	    	    
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
	
	
}
