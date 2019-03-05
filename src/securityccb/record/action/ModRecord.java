package securityccb.record.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.record.pojo.Record;
import ccb.hibernate.HibernateSessionFactory;

public class ModRecord {

	private String bid;
	private String eid;
	private String date;
	private String content1;
	private String people;
	private String remark;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String execute() throws Exception
	{
		String sql = "";
		String result = "success";
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		sql = "update record set date='"+date+"',content1='"+content1+"',people='"+people+"',remark='"+remark+"' where id>='"+bid+"' and id<='"+eid+"'";
    		session.createSQLQuery(sql).executeUpdate();
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return result;
	}
}
