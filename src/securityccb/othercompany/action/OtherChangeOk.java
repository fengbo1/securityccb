package securityccb.othercompany.action;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.othercompany.dao.OtherCompanyDAO;
import securityccb.othercompany.pojo.OtherCompany;
import securityccb.plan.pojo.Plan;
import ccb.hibernate.HibernateSessionFactory;



public class OtherChangeOk {
	private static final Log log = LogFactory.getLog(OtherChangeOk.class);
	private String position;
	private String company;
	private String department;
	private String job;
	private String name;
	private String tel;
	private String phone;
	private String remark;
	private Integer id;


	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		String jigouid=position.substring(0,3); 
		
		try {

			OtherCompany oc=new OtherCompany();
			
			oc.setCompany(company);
			oc.setDepartment(department);
			oc.setJigouid(jigouid);
			oc.setJob(job);
			oc.setName(name);
			oc.setPhone(phone);
			oc.setRemark(remark);
			oc.setTel(tel);
			oc.setId(id);
			
			
			OtherCompanyDAO ocd=new OtherCompanyDAO();
			
			ocd.merge(oc);
				
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


	




	public Integer getId() {
		return id;
	}







	public void setId(Integer id) {
		this.id = id;
	}







	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
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
