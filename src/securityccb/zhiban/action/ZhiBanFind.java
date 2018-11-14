package securityccb.zhiban.action;


import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import securityccb.paiban.pojo.PaiBan;

import securityccb.userinfo.pojo.UserInfo;

import securityccb.zhiban.pojo.ZhiBan;
import securityccb.zhiban.pojo.ZhiBanC;

import ccb.hibernate.HibernateSessionFactory;



public class ZhiBanFind {
	private static final Log log = LogFactory.getLog(ZhiBanFind.class);
	
	private String btime;
	private String etime;
	private String newnumber1;
	private String newnumber2;

	private String name1;
	private String name2;
	
	private String newnumberjihua1;
	private String newnumberjihua2;

	private String namejihua1;
	private String namejihua2;
	
	private Date date1;
	private Date date2;
	
	private Date date;
	
	private Time time1;
	private Time time2;
	
	private String areaid;
	private String covername1;
	private String covername2;
	private String remark1;
	private String remark2;
	private String ifcover1;
	private String ifcover2;
	private String covernewnumber;
	
	private String zhiban1;
	private String zhiban2;
	
	private List<ZhiBanC> zlist;

	
	



	

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
	
	
	
	
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
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



	public void setCovernewnumber(String covernewnumber) {
		this.covernewnumber = covernewnumber;
	}
	public String getCovernewnumber() {
		return covernewnumber;
	}
	public String getNewnumberjihua1() {
		return newnumberjihua1;
	}
	public void setNewnumberjihua1(String newnumberjihua1) {
		this.newnumberjihua1 = newnumberjihua1;
	}
	public String getNewnumberjihua2() {
		return newnumberjihua2;
	}
	public void setNewnumberjihua2(String newnumberjihua2) {
		this.newnumberjihua2 = newnumberjihua2;
	}
	public String getNamejihua1() {
		return namejihua1;
	}
	public void setNamejihua1(String namejihua1) {
		this.namejihua1 = namejihua1;
	}
	public String getNamejihua2() {
		return namejihua2;
	}
	public void setNamejihua2(String namejihua2) {
		this.namejihua2 = namejihua2;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public Date getDate1() {
		return date1;
	}
	public Date getDate2() {
		return date2;
	}
	public Time getTime1() {
		return time1;
	}
	public void setTime1(Time time1) {
		this.time1 = time1;
	}
	public Time getTime2() {
		return time2;
	}
	public void setTime2(Time time2) {
		this.time2 = time2;
	}
	public String getIfcover1() {
		return ifcover1;
	}
	public void setIfcover1(String ifcover1) {
		this.ifcover1 = ifcover1;
	}
	public String getIfcover2() {
		return ifcover2;
	}
	public void setIfcover2(String ifcover2) {
		this.ifcover2 = ifcover2;
	}
	public String getZhiban1() {
		return zhiban1;
	}
	public void setZhiban1(String zhiban1) {
		this.zhiban1 = zhiban1;
	}
	public String getZhiban2() {
		return zhiban2;
	}
	public void setZhiban2(String zhiban2) {
		this.zhiban2 = zhiban2;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setZlist(List<ZhiBanC> zlist) {
		this.zlist = zlist;
	}
	public List<ZhiBanC> getZlist() {
		return zlist;
	}
	public String getCovername1() {
		return covername1;
	}
	public void setCovername1(String covername1) {
		this.covername1 = covername1;
	}
	public String getCovername2() {
		return covername2;
	}
	public void setCovername2(String covername2) {
		this.covername2 = covername2;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{

		
		List<ZhiBan> zblist=null;
		List<PaiBan> pblist=null;

		zlist=new ArrayList<ZhiBanC>();
		
		List <Date> datelist=new ArrayList<Date>();
		datelist=findzhibandate(areaid,btime,etime);
		
		if(datelist != null && datelist.size() >= 1)
		{
			for (int j=0;j<datelist.size();j++){
				
				zblist=findallzhiban(areaid,datelist.get(j));
			
				pblist=findpaibanbydateandareaid(areaid,datelist.get(j));
				
				ZhiBanC zbf=new ZhiBanC();		
				
					
					if(zblist.size()==2){	
						// 第一条 有代班   有值班 
						if(zblist.get(0).getCover().equals("1")&&zblist.get(0).getZhiban().equals("1")){				
																
							zbf.setIfcover1("是");					
							zbf.setName1(findnamebynewnumber(zblist.get(0).getNewnumber()));
							zbf.setTime1(zblist.get(0).getTime());
							zbf.setZhiban1("已完成值班");
							zbf.setRemark1(zblist.get(0).getRemark());
							zbf.setDate(datelist.get(j));
							zbf.setCovername1(findnamebynewnumber(zblist.get(0).getCovernewnumber()));
							
						}	
						// 第一条 无代班   有值班 
						if(zblist.get(0).getCover().equals("0")&&zblist.get(0).getZhiban().equals("1")){				
							
							zbf.setIfcover1("否");					
							zbf.setName1(findnamebynewnumber(zblist.get(0).getNewnumber()));
							zbf.setTime1(zblist.get(0).getTime());
							zbf.setZhiban1("已完成值班");
							zbf.setRemark1(zblist.get(0).getRemark());
							zbf.setDate(datelist.get(j));
						}	
						// 第一条 无代班   无值班 
						if(zblist.get(0).getCover().equals("0")&&zblist.get(0).getZhiban().equals("0")){				
							
							zbf.setIfcover1("否");					
							zbf.setName1("");
							zbf.setTime1(null);
							zbf.setZhiban1("未完成值班");
							zbf.setRemark1(zblist.get(0).getRemark());
							zbf.setDate(datelist.get(j));
						}	
						// 第2条 有代班   有值班 
						if(zblist.get(1).getCover().equals("1")&&zblist.get(1).getZhiban().equals("1")){				
																
							zbf.setIfcover2("是");					
							zbf.setName2(findnamebynewnumber(zblist.get(1).getNewnumber()));
							zbf.setTime2(zblist.get(1).getTime());
							zbf.setZhiban2("已完成值班");
							zbf.setRemark2(zblist.get(1).getRemark());
							zbf.setDate(datelist.get(j));
							zbf.setCovername2(findnamebynewnumber(zblist.get(1).getCovernewnumber()));

						}	
						// 第2条 无代班   有值班 
						if(zblist.get(1).getCover().equals("0")&&zblist.get(1).getZhiban().equals("1")){				
							
							zbf.setIfcover2("否");					
							zbf.setName2(findnamebynewnumber(zblist.get(1).getNewnumber()));
							zbf.setTime2(zblist.get(1).getTime());
							zbf.setZhiban2("已完成值班");
							zbf.setRemark2(zblist.get(1).getRemark());
							zbf.setDate(datelist.get(j));
						
						}	
						// 第2条 无代班   无值班 
						if(zblist.get(1).getCover().equals("0")&&zblist.get(1).getZhiban().equals("0")){				
							
							zbf.setIfcover2("否");					
							zbf.setName2("");
							zbf.setTime2(null);
							zbf.setZhiban2("未完成值班");
							zbf.setRemark1(zblist.get(1).getRemark());
							zbf.setDate(datelist.get(j));
							
						}						
			     	}
					if(zblist.size()==1){	
						// 1条 有代班   有值班 
                            if(zblist.get(0).getCover().equals("1")&&zblist.get(0).getZhiban().equals("1")){				
							
                            	zbf.setIfcover1("是");					
    							zbf.setName1(findnamebynewnumber(zblist.get(0).getNewnumber()));
    							zbf.setTime1(zblist.get(0).getTime());
    							zbf.setZhiban1("已完成值班");
    							zbf.setRemark1(zblist.get(0).getRemark());
    							zbf.setIfcover2(null);					
    							zbf.setName2(null);
    							zbf.setTime2(null);
    							zbf.setZhiban2(null);
    							zbf.setRemark1(null);
    							zbf.setDate(datelist.get(j));
    							zbf.setCovername1(findnamebynewnumber(zblist.get(0).getCovernewnumber()));

    

						}		
                         // 1条 无代班   有值班 
                            if(zblist.get(0).getCover().equals("0")&&zblist.get(0).getZhiban().equals("1")){				
							
                            	zbf.setIfcover1("否");					
    							zbf.setName1(findnamebynewnumber(zblist.get(0).getNewnumber()));
    							zbf.setTime1(zblist.get(0).getTime());
    							zbf.setZhiban1("已完成值班");
    							zbf.setRemark1(zblist.get(0).getRemark());
    							zbf.setIfcover2(null);					
    							zbf.setName2(null);
    							zbf.setTime2(null);
    							zbf.setZhiban2(null);
    							zbf.setRemark1(null);
    							zbf.setDate(datelist.get(j));
    							
						}		
			     	}
					if(pblist.size()>0)
					{
						zbf.setNamejihua1(findnamebynewnumber(pblist.get(0).getNewnumber1().replace("\r","").replace("\n","")));
						zbf.setNamejihua2(findnamebynewnumber(pblist.get(0).getNewnumber2().replace("\r","").replace("\n","")));
					}
					
					zlist.add(zbf);
					
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
	public List findallzhiban(String areaid,Date date) //通过机构ID查询机构全称
    {
		Query query;			
 		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<ZhiBan> list = null;
		try {
	     //   String sql="SELECT * from zhiban where areaid = "+"'"+areaid+"'and (begindate<='"+date+"' and dateenddate>='"+date+"')";	
	        String sql="SELECT * from zhiban where areaid = "+"'"+areaid+"'and date='"+date+"'";		

			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(ZhiBan.class);		
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
	public List findpaibanbydateandareaid(String areaid,Date date) //通过机构ID查询机构全称
    {
		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<PaiBan> list = null;
		try {
	        String sql="SELECT * from PaiBan where areaid = "+"'"+areaid+"' and (begindate<='"+date+"' and enddate>='"+date+"')";			
			
			query = session.createSQLQuery(sql).addEntity(PaiBan.class);		
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
	public List findzhibandate(String areaid,String btime,String etime) //通过新一代编号查找姓名
    {
		Query query1;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();	
		
		List <Date> list2=new ArrayList<Date>();

		String name="";
		try {
			String sql=  "SELECT DISTINCT date from zhiban where  areaid='"+areaid+"'";
			
			if(btime!=null&&!btime.equals(""))
			{
				sql+=" and date>='"+btime+"'";
			}
			if(etime!=null&&!etime.equals(""))
			{
				sql+=" and date<='"+etime+"'";
			}
			sql+=" order by date desc";
	        System.out.println(sql);
			query1 = session.createSQLQuery(sql);	
			//query1 = session.createSQLQuery(sql).addEntity(Object.class);		
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
	
}
