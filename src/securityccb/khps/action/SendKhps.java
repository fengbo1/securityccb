package securityccb.khps.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.operate.dao.OperateDAO;
import securityccb.operate.pojo.Operate;
import securityccb.process.action.FindNextUnder;
import securityccb.process.dao.ProcessDAO;
import securityccb.process.pojo.Process;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;
//取出所有待评审事项
public class SendKhps {

	private String newnumber;
	private List <Khps> unflist;
	
	
	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public void setUnflist(List <Khps> unflist) {
		this.unflist = unflist;
	}


	public List <Khps> getUnflist() {
		return unflist;
	}
	

	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    KhpsDAO khdao = new KhpsDAO();
 	    OperateDAO opdao=new OperateDAO();
 	   
		
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo nextui = new UserInfo();
		ProcessDAO pdao = new ProcessDAO();
		UserInfo ui =new UserInfo();
		Date now = new Date();
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYYMMdd");
		SimpleDateFormat bartTimeFormat = new SimpleDateFormat("HH:mm:ss");
		FindNextUnder fnu=new FindNextUnder();
		Khps kp =new Khps();
	    Operate op=new Operate();//审批意见写在operate中
		String date = bartDateFormat.format(now);
		String time = bartTimeFormat.format(now);
		
		KhpsDAO kpdao=new KhpsDAO();
		
		ui=(UserInfo)uidao.findByNewnumber(newnumber).get(0);//处理人信息
 	    
		unflist=(List<Khps>)khdao.findUnflist();
 	    for(int i=0;i<unflist.size();i++)
 	    {
 	    	kp=new Khps();
 	    	kp=unflist.get(i);
 	    	op=new Operate();
 	    	op.setJigouid(ui.getPosition().substring(0, 3));
 			op.setPnumber(kp.getPnumber());
 			op.setOtime(time);
 			op.setViewername(ui.getName());
 			op.setViewernum(newnumber);
 			op.setOdate(date);
 			op.setScore(kp.getScore());
 			op.setViewoption(1);
 			nextui=(UserInfo)fnu.findNextUnder(""+kp.getItem(), kp.getPnumber()).get(0);
 			
			kp.setThisunder(nextui.getNewnumber());//转到安保部老总名下
			kp.setJindu(""+(Integer.parseInt(kp.getJindu())+1));
 			kp.setPreunder(newnumber);
			opdao.merge(op);
	 	    kpdao.merge(kp);
 			
 	    }
 	    
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}

}
