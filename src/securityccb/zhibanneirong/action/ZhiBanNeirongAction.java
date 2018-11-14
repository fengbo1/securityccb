package securityccb.zhibanneirong.action;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import securityccb.area.pojo.Area;
import securityccb.chu.action.ChuAction;
import securityccb.chu.pojo.Chu;
import securityccb.zhibanneirong.pojo.ZhiBanNeirong;


import ccb.hibernate.HibernateSessionFactory;

public class ZhiBanNeirongAction {
	private static final Log log = LogFactory.getLog(ZhiBanNeirongAction.class);
	private List<ZhiBanNeirongAction> zbnrlist;
	private String position;
	private String areaid;
	private String areaname;
	private String zhibanneirong;
	private String chushi;
	private Integer id;
	private int rowsp1;//合并单元格的参数
	private int rowsp2;//合并单元格的参数



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
	


	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getAreaid() {
		return areaid;
	}

	public void setZhibanneirong(String zhibanneirong) {
		this.zhibanneirong = zhibanneirong;
	}
	public String getZhibanneirong() {
		return zhibanneirong;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setZbnrlist(List<ZhiBanNeirongAction> zbnrlist) {
		this.zbnrlist = zbnrlist;
	}
	public List<ZhiBanNeirongAction> getZbnrlist() {
		return zbnrlist;
	}
	public void setChushi(String chushi) {
		this.chushi = chushi;
	}
	public String getChushi() {
		return chushi;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public int getRowsp1() {
		return rowsp1;
	}
	public void setRowsp1(int rowsp1) {
		this.rowsp1 = rowsp1;
	}
	public int getRowsp2() {
		return rowsp2;
	}
	public void setRowsp2(int rowsp2) {
		this.rowsp2 = rowsp2;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{

	    String jigouid=position.substring(0, 3);
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
	
		List <Chu> chushiid=findchushiidbyjigouid(jigouid);
		
				
		zbnrlist=new ArrayList<ZhiBanNeirongAction>();	
//		int m1=0;//发现新item时的i位置
//		int m2=0;//发现新item时的i位置
//		int rows2 = 1;
//		String temp1 = "";
//		String temp2 = "";
//		int k=0;
		if(chushiid != null && chushiid.size() >= 1){
			
			for (int i=0;i<chushiid.size();i++){
				
				List<Area> area=findareaidbychushiid(chushiid.get(i).getChushiid());
					int rows1 = 0;
					if(area != null && area.size() >= 1){
						for (int j=0;j<area.size();j++){
							List<ZhiBanNeirong> zbnr=findzhibanneirongbyareaid(area.get(j).getAreaid());
							rows1+=zbnr.size();
						}
						for (int j=0;j<area.size();j++){
							
							List<ZhiBanNeirong> zbnr=findzhibanneirongbyareaid(area.get(j).getAreaid());
							if(zbnr != null && zbnr.size() >= 1){
								for (int l=0;l<zbnr.size();l++){
									int zbnrsize = zbnr.size();
									ZhiBanNeirongAction abnraction = new ZhiBanNeirongAction();	
									abnraction.setZhibanneirong(zbnr.get(l).getZhibanneirong());
									abnraction.setAreaid(area.get(j).getAreaid());
									abnraction.setAreaname(area.get(j).getAreaname());
									abnraction.setChushi(chushiid.get(i).getChushi());
									abnraction.setId(zbnr.get(l).getId());
									abnraction.setRowsp1(1);
									if(l==0)
									{
										if(j==0)
										{
											abnraction.setRowsp1(rows1);
										}
										else
										{
											abnraction.setRowsp1(0);
										}
										abnraction.setRowsp2(zbnrsize);
									}
									else
									{
										abnraction.setRowsp1(0);
										abnraction.setRowsp2(0);
									}
									
									zbnrlist.add(abnraction);
//									if(temp1.equals(abnraction.getChushi()))
//									{
//										rows1+=1;
//										zbnrlist.get(i).setRowsp1(0);
//									}
//									else
//									{
//										zbnrlist.get(m1).setRowsp1(rows1);
//										m1=i;
//										rows1=1;
//									}
//									if(temp2.equals(abnraction.getAreaname()))
//									{
//										rows2+=1;
//										zbnrlist.get(i).setRowsp2(0);
//									}
//									else
//									{
//										zbnrlist.get(m2).setRowsp2(rows2);
//										m2=i;
//										rows2=1;
//									}
//									temp1 = abnraction.getChushi();
//									temp2 = abnraction.getAreaname();
								}
							}
						}
					}
			}
		}

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
