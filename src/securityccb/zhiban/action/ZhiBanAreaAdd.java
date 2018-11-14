package securityccb.zhiban.action;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import securityccb.paiban.pojo.PaiBan;
import securityccb.userinfo.action.UserInfoAction;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.zhiban.dao.ZhiBanDAO;
import securityccb.zhiban.pojo.ZhiBan;
import securityccb.zhibanneirong.pojo.ZhiBanNeirong;
import ccb.hibernate.HibernateSessionFactory;



public class ZhiBanAreaAdd {
	private static final Log log = LogFactory.getLog(ZhiBanAreaAdd.class);
	private String newnumber1;
	private String newnumber2;
	private String newnumber;
	private String name1;
	private String name2;
	private String name;
	private String cover;
	private String areaid;
	private String covername;
	private String remark;
	private String ifcover;
	private String covernewnumber;
	private String position;
	private List<ZhiBanAction> pbalist;



	

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
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getCover() {
		return cover;
	}
	public void setCovername(String covername) {
		this.covername = covername;
	}
	public String getCovername() {
		return covername;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	public void setIfcover(String ifcover) {
		this.ifcover = ifcover;
	}
	public String getIfcover() {
		return ifcover;
	}
	public void setCovernewnumber(String covernewnumber) {
		this.covernewnumber = covernewnumber;
	}
	public String getCovernewnumber() {
		return covernewnumber;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public List<ZhiBanAction> getPbalist() {
		return pbalist;
	}
	public void setPbalist(List<ZhiBanAction> pbalist) {
		this.pbalist = pbalist;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{

		ZhiBan zb=new ZhiBan();		
		ZhiBanDAO zbo=new ZhiBanDAO();		

		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
		String today=dateFormat.format(now);
		Date day=dateFormat.parse(today);
		
		java.util.Date nowdate= new java.util.Date ();
		java.sql.Time nowtime=new java.sql.Time(nowdate.getTime());
		
	
		
        if (ifcover== null ||ifcover.length() <= 0){
        	zb.setAreaid(areaid);
    		zb.setCover("0");
    		zb.setCovernewnumber("");
    		zb.setDate(day);
    		zb.setTime(nowtime);
    		zb.setNewnumber(newnumber);
        	zb.setRemark(remark);
        	zb.setZhiban("1");
			
		}else if (ifcover.equals("on")){
			zb.setAreaid(areaid);
    		zb.setCover("1");
    		zb.setCovernewnumber(covernewnumber);
    		zb.setDate(day);
    		zb.setTime(nowtime);
    		zb.setNewnumber(newnumber);
    		zb.setRemark(remark);		
    		zb.setZhiban("1");
		}
            zbo.save(zb);
		
            List <Chu> chulist = null ;
    		List <Area> arealist=null;
            pbalist=new ArrayList<ZhiBanAction>();	
    		
    		
            if(position.substring(10,11).equals("1")){
    			String jigou=position.substring(0, 3);
    	 		chulist=findchushi(jigou); //查到属于本机构的所有处室 装入chuchushi
    		}else{
    			String chushiid=position.substring(3, 9);
    	 		chulist=findchushibychushiid(chushiid); //查到属于本处室chuchushi
    		}
    		
    		if(chulist != null && chulist.size() >= 1){
    			
    			for (int i=0;i<chulist.size();i++){

    				
    				
    				arealist=findarea(chulist.get(i).getChushiid());
    				
    				if(arealist != null && arealist.size() >= 1){
    				
    				for (int j=0;j<arealist.size();j++){
    					
    					ZhiBanAction pba = new ZhiBanAction();
    					
    					pba.setArea(arealist.get(j).getArea());
    					pba.setAreaid(arealist.get(j).getAreaid());
    					pba.setAreaname(arealist.get(j).getAreaname());
    					pba.setChushiname(findchushiname(arealist.get(j).getChushiid()));
    					
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
	public List findzhibanneirong(String areaid) //通过机构ID查询机构全称
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<ZhiBanNeirong> list = null;
		try {
	        String sql="SELECT * from zhibanneirong where areaid = "+"'"+areaid+"'";			
			
			query = session.createSQLQuery(sql).addEntity(ZhiBanNeirong.class);		
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
	public List findarealistbyareaid(String areaid) //通过机构ID查询机构全称
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<Area> list = null;
		try {
	        String sql="SELECT * from area where areaid = "+"'"+areaid+"'";			
			
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
	public List findzhibanbydateandareaid(String areaid,String date) //通过机构ID查询机构全称
    {
		Query query1;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		List<PaiBan> list2=null;
		try {

	        String sql=  "SELECT * from paiban where areaid='"+areaid+"' and (begindate<='"+date+"' and enddate>='"+date+"')";
			
			query1 = session.createSQLQuery(sql).addEntity(PaiBan.class);		
			list2 = query1.list();				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return list2;
	
}
	public String findnamebynewnumber(String newnumber) //通过新一代编号查找姓名
    {
		Query query1;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		List<UserInfo> list2=null;
		String name="";
		try {

	        String sql=  "SELECT * from userinfo where  newnumber='"+newnumber+"'";
			
			query1 = session.createSQLQuery(sql).addEntity(UserInfo.class);		
			list2 = query1.list();				
			if(list2 != null && list2.size() >= 1){
				 name=list2.get(0).getName();
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
		
		return name;
	
}
	
	public List findchushi(String jigouid) //通过机构ID查询机构全称
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<Chu> list = null;
		try {
	        String sql="SELECT * from chu where jigouid = "+"'"+jigouid+"'";			
			
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
	public List findchushibychushiid(String chushiid) //通过处室ID查询处室信息
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<Chu> list = null;
		try {
	        String sql="SELECT * from chu where chushiid = "+"'"+chushiid+"'";			
		
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
}
