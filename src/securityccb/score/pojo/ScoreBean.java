package securityccb.score.pojo;

public class ScoreBean {

	private int id;//score表中的id
	private int indx;//序号1-39
	private int indx0;
	private int xuhao;//大项的序号
	private String item;
	private String itemc;
	private String cont;
	private String std;
	private String rmk;
	private String qudao;
	private int qudaoe;//english
	private int ifxz;//如果是考核项
	private int ifpinfen;//大项能不能点进去评分，1及以能点进去评分
	private String xzreason;//选择的理由
	private double score;
	private double stdscore;
	private int rowsp;//合并单元格的参数
	private int beijing;//表格背景2:1:0
	private int beijing2;//表格背景2:1:red
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIndx() {
		return indx;
	}
	public void setIndx(int indx) {
		this.indx = indx;
	}
	public int getIndx0() {
		return indx0;
	}
	public void setIndx0(int indx0) {
		this.indx0 = indx0;
	}
	public int getXuhao() {
		return xuhao;
	}
	public void setXuhao(int xuhao) {
		this.xuhao = xuhao;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getItemc() {
		return itemc;
	}
	public void setItemc(String itemc) {
		this.itemc = itemc;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getQudao() {
		return qudao;
	}
	public void setQudao(String qudao) {
		this.qudao = qudao;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getRowsp() {
		return rowsp;
	}
	public void setRowsp(int rowsp) {
		this.rowsp = rowsp;
	}
	public double getStdscore() {
		return stdscore;
	}
	public void setStdscore(double stdscore) {
		this.stdscore = stdscore;
	}
	
	public int getQudaoe() {
		return qudaoe;
	}
	public void setQudaoe(int qudaoe) {
		this.qudaoe = qudaoe;
	}
	public int getBeijing() {
		return beijing;
	}
	public void setBeijing(int beijing) {
		this.beijing = beijing;
	}
	public int getBeijing2() {
		return beijing2;
	}
	public void setBeijing2(int beijing2) {
		this.beijing2 = beijing2;
	}
	public int getIfxz() {
		return ifxz;
	}
	public void setIfxz(int ifxz) {
		this.ifxz = ifxz;
	}
	public String getXzreason() {
		return xzreason;
	}
	public void setXzreason(String xzreason) {
		this.xzreason = xzreason;
	}
	public int getIfpinfen() {
		return ifpinfen;
	}
	public void setIfpinfen(int ifpinfen) {
		this.ifpinfen = ifpinfen;
	}
	
	public ScoreBean(int id, int indx, int indx0, int xuhao, String item,
			String itemc, String cont, String std, String rmk, String qudao,
			int qudaoe, int ifxz, int ifpinfen, String xzreason, double score,
			double stdscore, int rowsp, int beijing, int beijing2) {
		super();
		this.id = id;
		this.indx = indx;
		this.indx0 = indx0;
		this.xuhao = xuhao;
		this.item = item;
		this.itemc = itemc;
		this.cont = cont;
		this.std = std;
		this.rmk = rmk;
		this.qudao = qudao;
		this.qudaoe = qudaoe;
		this.ifxz = ifxz;
		this.ifpinfen = ifpinfen;
		this.xzreason = xzreason;
		this.score = score;
		this.stdscore = stdscore;
		this.rowsp = rowsp;
		this.beijing = beijing;
		this.beijing2 = beijing2;
	}
	public ScoreBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
