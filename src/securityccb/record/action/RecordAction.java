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

import securityccb.kpxm.dao.KpxmDAO;
import securityccb.record.pojo.Record;
import securityccb.record.pojo.RecordBean;
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
	private List<RecordBean> rlist;
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
	public List<RecordBean> getRlist() {
		return rlist;
	}
	public void setRlist(List<RecordBean> rlist) {
		this.rlist = rlist;
	}
	public static Log getLog() {
		return log;
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
		KpxmDAO kdao = new KpxmDAO();
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
			sql+=" order by date desc,content1";
			System.out.println(sql);		
			query  = session.createSQLQuery(sql).addEntity(Record.class);		
			List<Record> list=query.list();	
			int m=0;
			int n=1;
			String tmp="";
			String temptype="";
			rlist = new ArrayList<RecordBean>();
			for(int i=0;i<list.size();i++)
			{
				Record record = list.get(i);
				RecordBean rb = new RecordBean();
				if(tmp.equals(record.getContent1()))
				{
					n+=1;
					temptype += "、";
					temptype += kdao.findByItemAndNum(record.getType(), 1).getRemark2();
				}
				if(!tmp.equals(record.getContent1())||(i+1==list.size()))
				{
					if(i>0)
					{
						Record recordtmp = list.get(m);
						Record recordend = list.get(i-1);
						rb.setBeginid(recordtmp.getId());
						rb.setEndid(recordend.getId());
						rb.setJigouid(recordtmp.getJigouid());
						rb.setSyssum(0);
						rb.setType(temptype);
						rb.setDate(recordtmp.getDate().toString().split(" ")[0]);
						rb.setTitle(recordtmp.getTitle());
						rb.setContent1(recordtmp.getContent1());
						rb.setContent2(recordtmp.getContent2());
						rb.setPeople(recordtmp.getPeople());
						rb.setRemark(recordtmp.getRemark());
						rb.setUrl1(recordtmp.getUrl1());
						rb.setUrl2(recordtmp.getUrl2());
						rb.setUrl3(recordtmp.getUrl3());
						rb.setUrl4(recordtmp.getUrl4());
						rb.setUrl5(recordtmp.getUrl5());
						rb.setUrl6(recordtmp.getUrl6());
						rb.setUrl7(recordtmp.getUrl7());
						rb.setUrl8(recordtmp.getUrl8());
						rb.setRemark2(recordtmp.getRemark2());
						rb.setRemark3(recordtmp.getRemark3());
						rb.setRemark4(recordtmp.getRemark4());
						rlist.add(rb);
					}
					m=i;
					n=1;
					temptype = kdao.findByItemAndNum(record.getType(), 1).getRemark2();
				}
				tmp=record.getContent1();
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
	

	