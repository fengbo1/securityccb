package securityccb.paiban.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.paiban.pojo.PaiBan;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class PaiBanCheck {
	private static final Log log = LogFactory.getLog(PaiBanCheck.class);
	private String areaid;	
	private Date begindate;
	private Date enddate;
	private String returns;

	
	
	public Date getBegindate() {
		return begindate;
	}
	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public void setReturns(String returns) {
		this.returns = returns;
	}
	public String getReturns() {
		return returns;
	}
	
	public static String dateToStrLong(java.util.Date dateDate) {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    String dateString = formatter.format(dateDate);
		    return dateString;
		}
	public String execute() throws Exception
	{
		returns="yes";		
	  
	    	Query query;			
    		Session session = HibernateSessionFactory.getSession();
    		Transaction trans = session.beginTransaction();		    	
	    	try
	    	{				
	    		String begin=dateToStrLong(begindate);	
	    		String end=dateToStrLong(enddate);
	    		
	    		//String sql="select * from paiban where areaid='"+areaid+"'and (begindate>='"+begin+"' or enddate<='"+end+"')";
	    		String sql="select * from paiban where areaid='"+areaid+"' and (('"+begin+"' BETWEEN begindate and enddate) or ('"+end+"' BETWEEN begindate and enddate) or (('"+begin+"'<begindate ) and ('"+end+"'>enddate)))";   
	    		
	    		System.out.println(sql);
			
	    		query = session.createSQLQuery(sql).addEntity(PaiBan.class);		
				
	    		if(query.list() != null && query.list().size() >= 1)
	    		{
	    			returns="havepaiban";	
				
				
				}				
			}
			
		    catch (Exception e) 
		    {
		    	// TODO: handle exception
		    	e.printStackTrace();
		    }finally
		    {
				trans.commit();
				session.flush();
				session.clear();
				session.close();
		    }
	   
		
		
		return "success";
		 
	
	}
}