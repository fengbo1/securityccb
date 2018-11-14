package securityccb.zhibanneirong.pojo;
// default package

/**
 * AbstractZhiBanNeirong entity provides the base persistence definition of the
 * ZhiBanNeirong entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractZhiBanNeirong implements java.io.Serializable {

	// Fields

	private Integer id;
	private String areaid;
	private String zhibanneirong;

	// Constructors

	/** default constructor */
	public AbstractZhiBanNeirong() {
	}

	/** full constructor */
	public AbstractZhiBanNeirong(String areaid, String zhibanneirong) {
		this.areaid = areaid;
		this.zhibanneirong = zhibanneirong;
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

	public String getZhibanneirong() {
		return this.zhibanneirong;
	}

	public void setZhibanneirong(String zhibanneirong) {
		this.zhibanneirong = zhibanneirong;
	}

}