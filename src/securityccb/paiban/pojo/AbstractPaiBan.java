package securityccb.paiban.pojo;
// default package

import java.util.Date;

/**
 * AbstractPaiBan entity provides the base persistence definition of the PaiBan
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPaiBan implements java.io.Serializable {

	// Fields

	private Integer id;
	private String areaid;
	private Date begindate;
	private Date enddate;
	private String newnumber1;
	private String tel1;
	private String remark1;
	private String newnumber2;
	private String tel2;
	private String remark2;
	private String remark;
	private String remark3;

	// Constructors

	/** default constructor */
	public AbstractPaiBan() {
	}

	/** full constructor */
	public AbstractPaiBan(String areaid, Date begindate, Date enddate,
			String newnumber1, String tel1, String remark1, String newnumber2,
			String tel2, String remark2, String remark, String remark3) {
		this.areaid = areaid;
		this.begindate = begindate;
		this.enddate = enddate;
		this.newnumber1 = newnumber1;
		this.tel1 = tel1;
		this.remark1 = remark1;
		this.newnumber2 = newnumber2;
		this.tel2 = tel2;
		this.remark2 = remark2;
		this.remark = remark;
		this.remark3 = remark3;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public Date getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getNewnumber1() {
		return this.newnumber1;
	}

	public void setNewnumber1(String newnumber1) {
		this.newnumber1 = newnumber1;
	}

	public String getTel1() {
		return this.tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getNewnumber2() {
		return this.newnumber2;
	}

	public void setNewnumber2(String newnumber2) {
		this.newnumber2 = newnumber2;
	}

	public String getTel2() {
		return this.tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

}