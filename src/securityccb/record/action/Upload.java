package securityccb.record.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import securityccb.record.dao.RecordDAO;
import securityccb.record.pojo.Record;

import com.opensymphony.xwork2.ActionSupport;


public class Upload extends ActionSupport{
	

	private int id;
	private Date date;	
	private String type;
	private String content;
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
	

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

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
	public void   add(Date date,String type,String title,String content1,String content2,String people,String remark,String url1,String url2,String url3,String url4,String url5,String url6,String url7,String url8) throws Exception{
		
		Record record=new Record();
		RecordDAO dao=new RecordDAO();		
		//Date date = new Date();
		
		int index=0;
		
		//备注1、2、3为空
	    String remark1="";
	    String remark2="";
	    String remark3="";
	   
		
		
	    record.setTitle(title);
		record.setRemark(remark1);
		record.setRemark(remark2);
		record.setRemark(remark3);		
		record.setDate(date);	
		record.setType(type);
		record.setContent1(content1);//超长分段存入，需调整
		record.setContent2(content2);
		record.setPeople(people);
		record.setRemark(remark);
		record.setUrl1(url1);
		record.setUrl2(url2);
		record.setUrl3(url3);
		record.setUrl4(url4);
		record.setUrl5(url5);
		record.setUrl6(url6);
		record.setUrl7(url7);
		record.setUrl8(url8);
		record.setUrl1(url1);
		dao.save(record);
	}
	private String SimpleDateFormat(Date date) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}