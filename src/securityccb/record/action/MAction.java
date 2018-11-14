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
import ccb.hibernate.HibernateSessionFactory;

public class MAction {
	//private static final Log log = LogFactory.getLog(MAction.class);
	private Date date;
	private String type;
	private String content1;
	private String content2;
	private String people;
	private String remark;
	private String url1;
	private String url2;
	private String url3;
	private String url4;
	private String url5;
	private String url6;
	private String url7;
	private String url8;
	private List<Record> rlist;
	private String position;

	


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
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
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
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
	public String getUrl1() {
		return url1;
	}
	public void setUrl1(String url1) {
		this.url1 = url1;
	}
	public String getUrl2() {
		return url2;
	}
	public void setUrl2(String url2) {
		this.url2 = url2;
	}
	public String getUrl3() {
		return url3;
	}
	public void setUrl3(String url3) {
		this.url3 = url3;
	}
	public String getUrl4() {
		return url4;
	}
	public void setUrl4(String url4) {
		this.url4 = url4;
	}
	public String getUrl5() {
		return url5;
	}
	public void setUrl5(String url5) {
		this.url5 = url5;
	}
	public String getUrl6() {
		return url6;
	}
	public void setUrl6(String url6) {
		this.url6 = url6;
	}
	public String getUrl7() {
		return url7;
	}
	public void setUrl7(String url7) {
		this.url7 = url7;
	}
	public String getUrl8() {
		return url8;
	}
	public void setUrl8(String url8) {
		this.url8 = url8;
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
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		//List<Record> rlist=new ArrayList<Record>();
		rlist=findallrecord(position.substring(0,3),type);
		/*if(rlist != null && rlist.size() >= 1){
			
			for (int i = 0; i < rlist.size(); i++){
				DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
				String today=format1.format(rlist.get(i).getDate());
				Date day=format1.parse(today) ;
				
				Record datee=new Record();
			    datee.setDate(day);
			    
				rlist.set(i, datee);;
				
			}
			
			
		}*/		
		
		return "success";

	
	
	}
	public List findallrecord(String jigouid,String type) 
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<Record> rlist=null;
		
		try {			
			String sql="select * from record where title='"+jigouid+"' and type='"+type+"' order by date desc";	
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
	

	