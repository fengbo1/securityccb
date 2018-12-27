package securityccb.area.action;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import securityccb.area.dao.AreaDAO;
import securityccb.area.pojo.Area;
import securityccb.chu.action.ChuAction;
import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;
import securityccb.jigou.dao.JiGouDAO;


import ccb.hibernate.HibernateSessionFactory;

public class AreaAction {
	private static final Log log = LogFactory.getLog(AreaAction.class);
	private String jigou;
	private String jigouid;
	private String chushi;
	private List<AreaAction> arealist;
	private String position;
	private String chushiid;
	private String area;
	private String url;
	private String areaid;
	private String areaname;
	/**
	* 获得默认的分页大小
	*/
	private int pageSize = 16;

	/**
	* 总页数
	*/
	private int totalPages = -1;

	/**
	* 当前页
	*/
	private int currentPage = -1;

	/**
	* 上一页
	*/
	private int previousPage = 1;

	/**
	* 下一页
	*/
	private int nextPage = 1;
	/**
	* 第一页
	*/
	private int firstPage = 1;
	/**
	* 最后一页
	*/
	private int lastPage = 1;
	/**
	* 总记录条数
	*/
	private long totalRows = -1;
	
	
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
	public void setJigou(String jigou) {
		this.jigou = jigou;
	}
	public String getJigou() {
		return jigou;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	public String getJigouid() {
		return jigouid;
	}
	public void setChushi(String chushi) {
		this.chushi = chushi;
	}
	public String getChushi() {
		return chushi;
	}


	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}
	public String getChushiid() {
		return chushiid;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getArea() {
		return area;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public List<AreaAction> getArealist() {
		return arealist;
	}
	public void setArealist(List<AreaAction> arealist) {
		this.arealist = arealist;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getAreaname() {
		return areaname;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
        JiGouDAO jgd=new JiGouDAO();
	    ChuDAO cd=new ChuDAO();
	    AreaDAO ad=new AreaDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String jigouid=position.substring(0, 3);
		
		List <Chu>chushiid=cd.findchushiidbyjigouid(jigouid);
		
				
		arealist=new ArrayList<AreaAction>();	
		
		ChuAction ca=new ChuAction();

		
		int k=0;
		if(chushiid != null && chushiid.size() >= 1){
			
			for (int i=0;i<chushiid.size();i++){
				
				List<Area>area=ad.findareaidbychushiid(chushiid.get(i).getChushiid());
				
				System.out.print("查询处室id为："+chushiid.get(i).getChushiid());
					if(area != null && area.size() >= 1){
						for (int j=0;j<area.size();j++){

							AreaAction areaaction = new AreaAction();	
							areaaction.setArea(area.get(j).getArea());
							areaaction.setAreaid(area.get(j).getAreaid());
							areaaction.setAreaname(area.get(j).getAreaname());
							areaaction.setUrl((area.get(j).getUrl()));

							areaaction.setChushi(chushiid.get(i).getChushi());
							areaaction.setJigou(jgd.findJigouNameByJigouid(jigouid));
							arealist.add(areaaction);
							k++;
						}
					}
			}
			
		}

		return "find_all_success";
	}
	
	


	/**
	 * 初始化页面属性<br>
	 * 必须在已获得totalRows值之后再调用该函数<br>
	 * 调用方式为：<br>
	 * 
	 * 给totalRows赋值<br>
	 * 调用initPageProperties(form)方法<br>
	 * 给list赋值<br>
	 * 调用initAttribute(request)方法<br>
	 * 
	 * 该方法在调用查询语句之前调用<br>
	 * pageSize为系统默认的分页的大小，如要更改pageSize，应在掉用setPageSize方法后再调用该方法<br>
	 * 
	 * 
	 */
	protected void initPageProperties() {

		if (totalRows == -1) {
			log.error("没有初始化totalRows参数！");
		}

		firstPage = 1;
		
		currentPage = currentPage<= 1 ? 1 : currentPage;

		totalPages = (totalRows % pageSize == 0) ? ((int) (totalRows / pageSize))
				: ((int) (totalRows / pageSize + 1));

		currentPage = currentPage >= totalPages ? totalPages : currentPage;

		previousPage = currentPage > 1 ? currentPage - 1 : 1;

		nextPage = currentPage < totalPages ? currentPage + 1 : totalPages;

		lastPage = totalPages;
	}

	
}
