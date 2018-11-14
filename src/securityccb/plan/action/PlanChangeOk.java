package securityccb.plan.action;


import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.plan.dao.PlanDAO;
import securityccb.plan.pojo.Plan;
import ccb.hibernate.HibernateSessionFactory;



public class PlanChangeOk {
	private static final Log log = LogFactory.getLog(PlanChangeOk.class);
	private String jigouid;
	private String year;
	private String month;
	private String week;
	private String content;
	private String people;
	private Date plandate;
	private Date overdate;
	private String position;
	private String result;
	private String remark;
	private Integer id;


	private List<Plan> plist;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		
		
		try {
			jigouid=position.substring(0, 3);
			
			Plan p=new Plan();
			PlanDAO pd=new PlanDAO();

			
			p.setContent(content);
			p.setJigouid(jigouid);
			p.setMonth(month);
			p.setOverdate(overdate);
			p.setPlandate(plandate);
			p.setPeople(people);
			p.setRemark(remark);
			p.setYear(year);
			p.setWeek(week);
			p.setResult(result);
			p.setId(id);
			
			pd.merge(p);
	    			
			
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



	
		public String getRemark() {
		return remark;
	}




	public void setRemark(String remark) {
		this.remark = remark;
	}




		public Date getPlandate() {
		return plandate;
	}




	public void setPlandate(Date plandate) {
		this.plandate = plandate;
	}




	public Date getOverdate() {
		return overdate;
	}




	public void setOverdate(Date overdate) {
		this.overdate = overdate;
	}




		public String getJigouid() {
		return jigouid;
	}




	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}




	public String getYear() {
		return year;
	}




	public void setYear(String year) {
		this.year = year;
	}




	public String getMonth() {
		return month;
	}




	public void setMonth(String month) {
		this.month = month;
	}




	public String getWeek() {
		return week;
	}




	public void setWeek(String week) {
		this.week = week;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public String getPeople() {
		return people;
	}




	public void setPeople(String people) {
		this.people = people;
	}





	public String getPosition() {
		return position;
	}




	public void setPosition(String position) {
		this.position = position;
	}




	public String getResult() {
		return result;
	}




	public void setResult(String result) {
		this.result = result;
	}




	public List<Plan> getPlist() {
		return plist;
	}




	public void setPlist(List<Plan> plist) {
		this.plist = plist;
	}




		public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




		public List<Plan> findallplan(String jigouid) //通过机构ID查询机构全称
    {
		Query query1;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<Plan> plist = null;
		try {

	        String sql="SELECT * from plan where jigouid = "+"'"+jigouid+"'";			
			System.out.println(sql);
			query1 = session.createSQLQuery(sql).addEntity(Plan.class);		
			plist = query1.list();				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return plist;
	
}
}
