package securityccb.area.pojo;
// default package

/**
 * AbstractArea entity provides the base persistence definition of the Area
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractArea implements java.io.Serializable {

	// Fields

	private Integer id;
	private String chushiid;
	private String areaid;
	private String area;
	private String url;
	private String areaname;

	// Constructors

	/** default constructor */
	public AbstractArea() {
	}

	/** full constructor */
	public AbstractArea(String chushiid, String areaid, String area,
			String url, String areaname) {
		this.chushiid = chushiid;
		this.areaid = areaid;
		this.area = area;
		this.url = url;
		this.areaname = areaname;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChushiid() {
		return this.chushiid;
	}

	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}

	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAreaname() {
		return this.areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

}