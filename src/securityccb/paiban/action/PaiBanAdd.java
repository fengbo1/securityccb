package securityccb.paiban.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.area.pojo.Area;
import securityccb.chu.pojo.Chu;
import securityccb.paiban.dao.PaiBanDAO;
import securityccb.paiban.pojo.PaiBan;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.DateTimeUtil;
import ccb.hibernate.HibernateSessionFactory;



public class PaiBanAdd {
	private static final Log log = LogFactory.getLog(PaiBanAdd.class);
	private String position;
	private String areaid;
	private String name1;
	private String name2;
	private String newnumber1;
	private String newnumber2;
	private String tel1;
	private String tel2;
	private Date begindate;
	private Date enddate;
	private String remark;
	private List<PaiBan> list;
	private String year;
	private List<String> listyear;



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
	
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}	


	public void setList(List<PaiBan> list) {
		this.list = list;
	}
	public List<PaiBan> getList() {
		return list;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	public Date getBegindate() {
		return begindate;
	}
	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getNewnumber1() {
		return newnumber1;
	}
	public void setNewnumber1(String newnumber1) {
		this.newnumber1 = newnumber1;
	}
	public String getNewnumber2() {
		return newnumber2;
	}
	public void setNewnumber2(String newnumber2) {
		this.newnumber2 = newnumber2;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public List<String> getListyear() {
		return listyear;
	}
	public void setListyear(List<String> listyear) {
		this.listyear = listyear;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		DateTimeUtil dtu = new DateTimeUtil();
		listyear = new ArrayList<String>();
		PaiBan pb=new PaiBan();
		if(newnumber1.equals("")){  //newnumber 穿过来前有字符，截取一下
			newnumber1="";
		}else{
			newnumber1=newnumber1.substring(2, newnumber1.length());
		}
		if(newnumber2.equals("")){
			newnumber2="";
		}else{
			newnumber2=newnumber2.substring(2, newnumber2.length());
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
	
		try {
		String sql="SELECT * from paiban where areaid = "+"'"+areaid+"' order by begindate desc";
		PaiBanDAO pbd=new PaiBanDAO();
		
		pb.setAreaid(areaid);
		pb.setBegindate(begindate);
		pb.setEnddate(enddate);
		
		pb.setNewnumber1(newnumber1);
		
		pb.setNewnumber2(newnumber2);
		pb.setTel1(tel1);
		pb.setTel2(tel2);
		pb.setRemark(remark);
		pb.setRemark2(name1);
		pb.setRemark3(name2);
		pbd.save(pb);
		
		Query query = session.createSQLQuery(sql).addEntity(PaiBan.class);		
		list = query.list();	
		listyear.add(String.valueOf(dtu.getThisYear()));
		listyear.add(String.valueOf(dtu.getThisYear()-1));
		listyear.add(String.valueOf(dtu.getThisYear()-2));
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
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
	public String findnewnumberbynameareaid(String name,String areaid) //通过机构ID查询机构全称
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<Area> list = null;
		try {
	        String sql="SELECT * from userinfo where mid(position,8,15) = "+"'"+areaid+"' and ";			
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
		return list.get(0).getAreaname();		
	}
	public String findareabyareaid(String areaid) //通过机构ID查询机构全称
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<Area> list = null;
		try {
	        String sql="SELECT * from area where areaid = "+"'"+areaid+"'";			
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
		return list.get(0).getArea();		
	}
	public List findarea(String chushiid) //
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
	public String findnamebynewnumber(String newnumber,Session session) //通过机构ID查询机构全称
    {
		Query query1;			
		
		String name="";
		try {

	        String sql="SELECT * from userinfo where newnumber = "+"'"+newnumber+"'";			
			System.out.println(sql);
			query1 = session.createSQLQuery(sql).addEntity(UserInfo.class);		
			List<UserInfo> list = query1.list();				
			if(list.isEmpty()){
				 name=null;				
			}else{
				name=list.get(0).getName();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return name;
	
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
