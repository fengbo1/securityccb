package securityccb.jigou.pojo;

public class JiGouBean {
	private Integer id;
    private String jigou;
    private String jigouid;
    private String quanxian;//主分中心
    private String shangji;//上级部门
    private String xiaji;//下级部门
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJigou() {
		return jigou;
	}
	public void setJigou(String jigou) {
		this.jigou = jigou;
	}
	public String getJigouid() {
		return jigouid;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	public String getQuanxian() {
		return quanxian;
	}
	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}
	public String getShangji() {
		return shangji;
	}
	public void setShangji(String shangji) {
		this.shangji = shangji;
	}
	public String getXiaji() {
		return xiaji;
	}
	public void setXiaji(String xiaji) {
		this.xiaji = xiaji;
	}
}
