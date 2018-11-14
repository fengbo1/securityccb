package securityccb.paiban.action;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.area.pojo.Area;
import securityccb.chu.pojo.Chu;
import securityccb.userinfo.action.UserInfoAction;
import ccb.hibernate.HibernateSessionFactory;



public class PaiBanAction {
	private static final Log log = LogFactory.getLog(PaiBanAction.class);
	private String position;
	private String chushiid;
	private String chushiname;
	private String areaid;
	private String area;
	private String areaname;
	private String url;
	private List<PaiBanAction> pbalist;





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
	
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return position;
	}

	public String getChushiname() {
		return chushiname;
	}
	public void setChushiname(String chushiname) {
		this.chushiname = chushiname;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<PaiBanAction> getPbalist() {
		return pbalist;
	}
	public void setPbalist(List<PaiBanAction> pbalist) {
		this.pbalist = pbalist;
	}
	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}
	public String getChushiid() {
		return chushiid;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{

		List <Chu> chulist = null ;
		List <Area> arealist=null;
        pbalist=new ArrayList<PaiBanAction>();	
		
		
		chulist=findchushi(position); //查到属于本机构的所有处室 装入chuchushi
		
		if(chulist != null && chulist.size() >= 1){
			
			for (int i=0;i<chulist.size();i++){

				
				
				arealist=findarea(chulist.get(i).getChushiid());
				
				if(arealist != null && arealist.size() >= 1){
				
				for (int j=0;j<arealist.size();j++){
					
					PaiBanAction pba = new PaiBanAction();
					
					pba.setArea(arealist.get(j).getArea());
					pba.setAreaid(arealist.get(j).getAreaid());
					pba.setAreaname(arealist.get(j).getAreaname());
					pba.setChushiname(findchushiname(arealist.get(j).getChushiid()));
					pba.setChushiid(arealist.get(j).getChushiid());
					pba.setUrl(arealist.get(j).getUrl());
					pbalist.add(pba);					
					
				}	
				
				}
				
			}
			
		}
		return "success";

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
	public List findchushi(String position) //通过机构ID查询机构全称
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<Chu> list = null;
	    String jigouid=position.substring(0, 3);
	    String zhiwu=position.substring(9, 11);
		String chushiid=position.substring(3, 9);
		String sql=null;
		try {
	        if(zhiwu.equals("24")|zhiwu.equals("14")|zhiwu.equals("11")||zhiwu.equals("13")||zhiwu.equals("23")||zhiwu.equals("51")||zhiwu.equals("33")){
	        	 sql="SELECT * from chu where jigouid = "+"'"+jigouid+"'";
	        }
	        if(zhiwu.equals("52")||zhiwu.equals("53")){
	        	 sql="SELECT * from chu where chushiid = "+"'"+chushiid+"'";
	        }
			        
	        System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(Chu.class);		
			list = query.list();				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}		
		return list;		
	}
	public List findarea(String chushiid) //通过机构ID查询机构全称
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<Area> list = null;
		try {
	        String sql="SELECT * from area where chushiid = "+"'"+chushiid+"'";			
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(Area.class);		
			list = query.list();				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}		
		return list;		
	}
	public String findchushiname(String chushiid) //通过机构ID查询机构全称
    {
		Query query1;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		String chushiname="";
		try {

	        String sql="SELECT * from chu where chushiid = "+"'"+chushiid+"'";			
			System.out.println(sql);
			query1 = session.createSQLQuery(sql).addEntity(Chu.class);		
			List<Chu> list2 = query1.list();				
			
			if(list2 != null && list2.size() >= 1)
			{

			chushiname=list2.get(0).getChushi();
				
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return chushiname;
	
}
}
