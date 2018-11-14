package securityccb.plan.action;


import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.plan.pojo.Plan;
import ccb.hibernate.HibernateSessionFactory;

public class PlanChange {
	private static final Log log = LogFactory.getLog(PlanChange.class);
	private String jigouid;
	private String year;
	private String month;
	private String week;
	private String content;
	private String id;
	private String people;
	private Date plandate;
	private String remark;
	private List<Plan> plist;



	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();				

		 try {
	
				plist=findallplan(jigouid,session);
				jigouid=plist.get(0).getJigouid();
				year=plist.get(0).getYear();
				month=plist.get(0).getMonth();
				week=plist.get(0).getWeek();
				content=plist.get(0).getContent();
				people=plist.get(0).getPeople();
				setPlandate(plist.get(0).getPlandate());
				remark=plist.get(0).getRemark();
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


	
	public List<Plan> findallplan(String jigouid,Session session) //通过机构ID查询机构全称
    {
		Query query1;			
	
		try {

	        String sql="SELECT * from plan where id = "+"'"+id+"'";			
			System.out.println(sql);
			query1 = session.createSQLQuery(sql).addEntity(Plan.class);		
			plist = query1.list();				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return plist;
	
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



		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
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



		public List<Plan> getPlist() {
			return plist;
		}



		public void setPlist(List<Plan> plist) {
			this.plist = plist;
		}



		public void setPlandate(Date plandate) {
			this.plandate = plandate;
		}



		public Date getPlandate() {
			return plandate;
		}
}
