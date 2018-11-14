package securityccb.zhiban.pojo;
// default package

import java.sql.Time;
import java.util.Date;

/**
 * AbstractZhiBan entity provides the base persistence definition of the ZhiBan
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractZhiBan implements java.io.Serializable {

	// Fields

	private Integer id;
	private String newnumber;
	private String areaid;
	private Date date;
	private Time time;
	private String cover;
	private String covernewnumber;
	private String remark;
	private String remark1;
	private String zhiban;

	// Constructors

	/** default constructor */
	public AbstractZhiBan() {
	}

	/** full constructor */
	public AbstractZhiBan(String newnumber, String areaid, Date date,
			Time time, String cover, String covernewnumber, String remark,
			String remark1, String zhiban) {
		this.newnumber = newnumber;
		this.areaid = areaid;
		this.date = date;
		this.time = time;
		this.cover = cover;
		this.covernewnumber = covernewnumber;
		this.remark = remark;
		this.remark1 = remark1;
		this.zhiban = zhiban;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNewnumber() {
		return this.newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getCovernewnumber() {
		return this.covernewnumber;
	}

	public void setCovernewnumber(String covernewnumber) {
		this.covernewnumber = covernewnumber;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getZhiban() {
		return this.zhiban;
	}

	public void setZhiban(String zhiban) {
		this.zhiban = zhiban;
	}

}