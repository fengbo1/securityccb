package securityccb.record.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.record.pojo.Record;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.DateTimeUtil;
import ccb.hibernate.HibernateSessionFactory;

public class RecordAction {
	private static final Log log = LogFactory.getLog(RecordAction.class);
	private String beginDate;
	private String endDate;
	private String type;
	private String content1;
	private String people;
	private String remark;
	private List<Record> rlist;
	private String position;
	private String last_three_month_date;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void setRlist(List<Record> rlist) {
		this.rlist = rlist;
	}
	public List<Record> getRlist() {
		return rlist;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return position;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLast_three_month_date() {
		return last_three_month_date;
	}
	public void setLast_three_month_date(String lastThreeMonthDate) {
		last_three_month_date = lastThreeMonthDate;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		DateTimeUtil dtu = new DateTimeUtil();
		last_three_month_date = dtu.getLastJMonthDate(3);
		String jgid = position.substring(0, 3);
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		try {			
			String sql="select * from record where jigouid='"+jgid+"'";	
			if(beginDate!=null&&!beginDate.equals(""))
			{
				sql+=" and date>='"+beginDate+"'";
			}
			if(endDate!=null&&!endDate.equals(""))
			{
				sql+=" and date<='"+endDate+"'";
			}
			if(type!=null&&!type.equals("")&&!type.equals("all"))
			{
				sql+=" and type='"+type+"'";
			}
			if(content1!=null&&!content1.equals(""))
			{
				sql+=" and content1 like '%"+content1+"%'";
			}
			if(people!=null&&!people.equals(""))
			{
				sql+=" and people like '%"+people+"%'";
			}
			if(remark!=null&&!remark.equals(""))
			{
				sql+=" and remark like '%"+remark+"%'";
			}
			sql+=" order by date desc";
			System.out.println(sql);		
			query  = session.createSQLQuery(sql).addEntity(Record.class);		
			rlist=query.list();	
			
			
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
	public List findallrecord(String jigouid) 
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<Record> rlist=null;
		
		try {			
			String sql="select * from record where jigouid='"+jigouid+"' order by date desc";	
			System.out.println(sql);		
			query  = session.createSQLQuery(sql).addEntity(Record.class);		
			rlist=query.list();	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}			
		return rlist;	
	}

	}
	

	