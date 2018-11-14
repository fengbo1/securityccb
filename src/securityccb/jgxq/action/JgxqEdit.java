package securityccb.jgxq.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import securityccb.gzjh.dao.GzjhDAO;
import securityccb.gzjh.pojo.Gzjh;
import securityccb.jgxq.dao.JgxqDAO;
import securityccb.jgxq.pojo.Jgxq;
import securityccb.ndzj.dao.NdzjDAO;
import securityccb.ndzj.pojo.Ndzj;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
//修改机构详情
public class JgxqEdit {
	
private String jigouid;
private String desc;

public void setDesc(String desc) {
	this.desc = desc.trim();
}

public String getDesc() {
	return desc.trim();
}
public void setJigouid(String jigouid) {
	this.jigouid = jigouid;
}

public String getJigouid() {
	return jigouid;
}
	//修改机构详情
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    Jgxq jgxq=new Jgxq();
 	    
 	    
 	    JgxqDAO xqdao=new JgxqDAO();
 	    Date now = new Date();
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYYMMdd");
		String date = bartDateFormat.format(now);
		try 
		{
		    if(xqdao.findByJigouid(jigouid).isEmpty())
		    	jgxq=new Jgxq();
		    else
			    jgxq=(Jgxq)xqdao.findByJigouid(jigouid).get(0);
			
		    jgxq.setJigoudesc(desc.trim());
	        jgxq.setJigouid(jigouid);
	        jgxq.setRecordDate(date);
	        jgxq.setRemark1("");
	        jgxq.setRemark2("");
	        xqdao.merge(jgxq);
	    	    
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
		
		return "success";
	}

	
	
	
}
