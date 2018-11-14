package securityccb.zhibanneirong.action;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import securityccb.area.pojo.Area;
import securityccb.chu.pojo.Chu;
import securityccb.zhibanneirong.pojo.ZhiBanNeirong;


import ccb.hibernate.HibernateSessionFactory;

public class ZhiBanNeirongAddFind {
	private static final Log log = LogFactory.getLog(ZhiBanNeirongAddFind.class);
	private List<Chu> chushilist;
	private String jigouid;
	private String chushiid;
	private String chushi;




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

	public void setChushi(String chushi) {
		this.chushi = chushi;
	}
	public String getChushi() {
		return chushi;
	}
	
	public String getChushiid() {
		return chushiid;
	}
	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	public String getJigouid() {
		return jigouid;
	}
	public void setChushilist(List<Chu> chushilist) {
		this.chushilist = chushilist;
	}
	public List<Chu> getChushilist() {
		return chushilist;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{

		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
				
		
		chushilist=(findchushiidbyjigouid(jigouid));
	
									
			
		return "success";
	}
	
	
		public List<Chu> findchushiidbyjigouid(String jigouid) //通过机构ID查询所辖处室id
	    {
			Query query ;			
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();		
			List<Chu> chulist = null;
			try {

		        String sql="SELECT * from chu where jigouid = "+"'"+jigouid+"'";			
				System.out.println(sql);
				query  = session.createSQLQuery(sql).addEntity(Chu.class);		
				chulist = query.list();						
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				trans.commit();
				session.flush();
				session.clear();
				session.close();
			}
				
		return chulist;
		
	}
		public List<Area> findareaidbychushiid(String chushiid) //通过处室ID查询所辖责任区id
	    {
			Query query ;			
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();		
			List<Area> arealist = null;
			try {

		        String sql="SELECT * from area where chushiid = "+"'"+chushiid+"'";			
				System.out.println(sql);
				query  = session.createSQLQuery(sql).addEntity(Area.class);		
				arealist = query.list();						
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				trans.commit();
				session.flush();
				session.clear();
				session.close();
			}
				
		return arealist;
		
	}
		public List<ZhiBanNeirong> findzhibanneirongbyareaid(String areaid) 
		{
			Query query ;			
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();		
			List<ZhiBanNeirong> zbnrlist = null;
			try {

		        String sql="SELECT * from zhibanneirong where areaid = "+"'"+areaid+"'";			
				System.out.println(sql);
				query  = session.createSQLQuery(sql).addEntity(ZhiBanNeirong.class);		
				zbnrlist = query.list();						
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				trans.commit();
				session.flush();
				session.clear();
				session.close();
			}
				
		return zbnrlist;
		
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
		
		currentPage = currentPage <= 1 ? 1 : currentPage;

		totalPages = (totalRows % pageSize == 0) ? ((int) (totalRows / pageSize))
				: ((int) (totalRows / pageSize + 1));

		currentPage = currentPage >= totalPages ? totalPages : currentPage;

		previousPage = currentPage > 1 ? currentPage - 1 : 1;

		nextPage = currentPage < totalPages ? currentPage + 1 : totalPages;

		lastPage = totalPages;
	}

	
}
