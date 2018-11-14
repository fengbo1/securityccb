package securityccb.khps.action;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import org.hibernate.Session;
import ccb.hibernate.HibernateSessionFactory;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.operate.dao.OperateDAO;
import securityccb.operate.pojo.Operate;
import securityccb.process.dao.ProcessDAO;
import securityccb.process.pojo.Process;
import securityccb.score.dao.ScoreDAO;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.KhpsUtil;


public class KhShenpi {

	private String thisunder;
	private String xuanze;
	private String number;
	private String textfield;
	private String radio;
	private String message;
	private String newnumber;
	private String name;
    private String pnumber;
    private String item;
    private double score;
    
    public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getPnumber() {
		return pnumber;
	}
    public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item= item;
	}
	
    public String getThisunder() {
		return thisunder;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String getXuanze() {
		return xuanze;
	}
	public void setXuanze(String xuanze) {
		this.xuanze = xuanze;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTextfield() {
		return textfield;
	}
	public void setTextfield(String textfield) {
		this.textfield = textfield;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 public Double getScore() {
	        return this.score;
	    }
	    
	    public void setScore(Double score) {
	        this.score = score;
	    }
	public String execute() throws Exception
	{
		String result = "success";
		message = "审批成功";
		String sql = "";
		double sumscore = 0.0;
		OperateDAO opdao = new OperateDAO();
		Operate op=new Operate();//审批意见写在operate中
		ScoreDAO sdao = new ScoreDAO();
		Process p=new Process();
		UserInfoDAO uidao = new UserInfoDAO();
		ProcessDAO pdao = new ProcessDAO();
		UserInfo ui =new UserInfo();
		Date now = new Date();
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYYMMdd");
		SimpleDateFormat bartTimeFormat = new SimpleDateFormat("HH:mm:ss");
		
        int intjd=0;
		
		String date = bartDateFormat.format(now);
		String time = bartTimeFormat.format(now);
		Khps kp =new Khps();
		KhpsDAO kpdao=new KhpsDAO();
		
		if(radio==null)
		{
			message = "失败！请选择审批意见";
			return "success";
		}
		if(name!=null&&name.contains("选择")&&radio.equals("agree"))
		{
			message = "失败！请选择下一级审批人";
			return "success";
		}
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			
 		    kp = (Khps)kpdao.findByPnumber(pnumber).get(0);//处理考核评审事项
 			p = (Process)pdao.findByItem(String.valueOf(kp.getItem())).get(0);//选择进程
 			ui=(UserInfo)uidao.findByNewnumber(newnumber).get(0);//处理人信息
 			
 			if(ui.getPosition().startsWith("000"))//安保部领导
 			{
 				sql = "update score set ifabb=1 where score!=scoretemp and pnumber='"+pnumber+"'";
 				session.createSQLQuery(sql).executeUpdate();
 			}
 			
 			sql = "update score set score=scoretemp where pnumber='"+pnumber+"'";
			session.createSQLQuery(sql).executeUpdate();
			sumscore = sdao.findSumByPnumber(pnumber,"scoretemp");
 			
 			intjd =Integer.parseInt( kp.getJindu());
 						 			
 			op.setJigouid(ui.getPosition().substring(0, 3));
 			op.setPnumber(pnumber);
 			op.setOtime(time);
 			op.setViewername(ui.getName());
 			op.setViewernum(newnumber);
 			op.setOdate(date);
 			op.setScore(sumscore);
 			op.setRemark1(textfield);
 			op.setRemark2("");
 			op.setRemark3("");
 			
 			if(thisunder==null||thisunder.equals("999"))//只改分不影响流程
 			{
 				op.setViewoption(4);
 			}
 			else if(radio.equals("agree"))//审批人决定//1 通过 2 不通过
 				{
 				    op.setViewoption(1);
 				    
 				   if(ui.getRole().equals("0"))//总行安保部领导审批，最后一个流程
 				   {
 					   kp.setStatus("4");
 					   kp.setThisunder(kp.getInitiator());//下一个处理人是申请人自己
 				   }
 				   else
 				   {
 					   kp.setStatus("1");
					   kp.setThisunder(thisunder);//下一个处理人是选择的
 				   }
 						   
 				    kp.setPreunder(newnumber);
 					intjd=intjd+1;
 				    kp.setJindu(""+intjd);
 				}
 				else
 			    {
 					op.setViewoption(2);//不同意
					kp.setThisunder(kp.getInitiator());//发起人
					kp.setJindu("0");
					kp.setStatus("2");//退回
 				
 			    }
 			
 				if(newnumber.equals(kp.getInitiator()))
 				{
 					op.setViewoption(0);//本人提交
 				}
 				kp.setScore(sumscore);
 				opdao.merge(op);
 	 			kpdao.merge(kp);
 			
 			
 			
 		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
	
}
