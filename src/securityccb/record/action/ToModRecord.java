package securityccb.record.action;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import securityccb.record.pojo.Record;
import securityccb.util.DateTimeUtil;

public class ToModRecord {

	private String bid;
	private String eid;
	private Record record;
	private String ltmd;
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
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	public String getLtmd() {
		return ltmd;
	}
	public void setLtmd(String ltmd) {
		this.ltmd = ltmd;
	}
	public String execute() throws Exception
	{
		String result = "success";
		String sql = "";
		record = new Record();
		DateTimeUtil dtu = new DateTimeUtil();
		ltmd = dtu.getLastJMonthDate(3);
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		sql = "from Record where id="+bid;
    		List<Record> list = session.createQuery(sql).list();
    		record = list.get(0);
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
