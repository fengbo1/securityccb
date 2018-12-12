package securityccb.chu.action;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.pojo.JiGou;
import securityccb.util.FileReadAndWrite;
import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;

import ccb.hibernate.HibernateSessionFactory;

public class chuAdd {
	private static final Log log = LogFactory.getLog(ChuAction.class);
	private String chushi;	
	private String jigouid;	
	private String anbaobiaozhi;	
	private String message;

	public void setChushi(String chushi) {
		this.chushi = chushi;
	}


	public String getChushi() {
		return chushi;
	}


	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}


	public String getJigouid() {
		return jigouid;
	}


	public void setAnbaobiaozhi(String anbaobiaozhi) {
		this.anbaobiaozhi = anbaobiaozhi;
	}


	public String getAnbaobiaozhi() {
		return anbaobiaozhi;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String execute() throws Exception
	{
		FileReadAndWrite fraw = new FileReadAndWrite();
		message = "添加成功";
		ChuDAO cd =new ChuDAO();
		String newchushiid=cd.findmaxchushiid(); 
		newchushiid = fraw.readandwrite("CHU", newchushiid)+"000";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction(); 		
		if (anbaobiaozhi!=null)
        if(anbaobiaozhi.equals("on")){//是安保管理部门最后加1
			newchushiid=newchushiid.substring(0, 5)+"1";
		}	
		try {
			Chu chu = cd.findByJigouAndChushi(jigouid, chushi);
			if(chu!=null)
			{
				message = "已有【"+chushi+"】,失败";
			}
			else
			{
				Chu newchu=new Chu();			
				newchu.setChushi(chushi);
				newchu.setChushiid(newchushiid);
				newchu.setJigouid(jigouid);
				cd.merge(newchu);		
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}	
		return "success";
	
	}

}

