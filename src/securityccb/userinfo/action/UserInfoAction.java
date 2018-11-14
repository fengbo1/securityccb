package securityccb.userinfo.action;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import securityccb.jigou.action.JigouAction;
import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.userinfo.pojo.UserInfoBean;
import securityccb.util.Util;

import securityccb.area.pojo.Area;
import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;


import ccb.hibernate.HibernateSessionFactory;

public class UserInfoAction {
	private static final Log log = LogFactory.getLog(UserInfoAction.class);
	private String jigouid;
	private List<UserInfoBean> mylist;
	private String position;
	private String chushiid;
	private String name;
	private String newnumber;
	private String zhiwu;
	private List<Chu> chulist;
	private int pageSize = 16;
	private int totalPages = -1;
	private int currentPage = -1;
	private int previousPage = 1;
	private int nextPage = 1;
	private int firstPage = 1;
	private int lastPage = 1;
	private long totalRows = -1;
	public String getJigouid() {
		return jigouid;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	public List<UserInfoBean> getMylist() {
		return mylist;
	}
	public void setMylist(List<UserInfoBean> mylist) {
		this.mylist = mylist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getZhiwu() {
		return zhiwu;
	}
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getChushiid() {
		return chushiid;
	}
	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}
	public List<Chu> getChulist() {
		return chulist;
	}
	public void setChulist(List<Chu> chulist) {
		this.chulist = chulist;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		String jglike = Util.jglike;
        ChuDAO cd=new ChuDAO();
        JiGouDAO jgdao = new JiGouDAO();
		List <securityccb.userinfo.pojo.UserInfo> list = null ;
		Query query;
		String hql = "";
		if(position!=null&&position.length()>3)
		{
			jglike = position.substring(0, 3)+jglike.substring(3, 11);
		}
		
		if(chushiid!=null&&chushiid.length()==6)
		{
			jglike = jglike.substring(0, 3)+chushiid+jglike.substring(9, 11);
		}
		if(zhiwu!=null&&zhiwu.length()==2)
		{
			jglike = jglike.substring(0, 9)+zhiwu;
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		mylist=new ArrayList<UserInfoBean>();	
		try {
			jigouid=position.substring(0, 3);
			hql="from UserInfo where position like "+"'"+jglike+"'";
			if(name!=null)
			{
				hql+=" and name like '%"+name+"%'";
			}
			if(newnumber!=null)
			{
				hql+=" and newnumber like '%"+newnumber+"%'";
			}
			hql+=" order by position";
			System.out.println("user:"+hql);
			query = session.createQuery(hql);				
			list = query.list();			
			chulist=findchulist(jigouid,session);
			for (int i=0;i<list.size();i++){
				UserInfo ui = list.get(i);
				UserInfoBean uib = new UserInfoBean();
				String pos = ui.getPosition();
				String zw = pos.substring(9, 11);
				uib.setPosition(pos);
				uib.setZw_jigou(jgdao.findjigoubyjigouid(pos.substring(0, 3)));
				uib.setZw_chu(cd.findchushinamebychushiid(pos.substring(3, 9)));
				uib.setZw_role(Util.rolequanxianToString(zw));
				uib.setName(ui.getName());
				uib.setNewnumber(ui.getNewnumber());
				uib.setPassword(ui.getPassword());
				uib.setAddress(ui.getAddress());
				uib.setTel(ui.getTel());
				uib.setNamesos(ui.getNamesos());
				uib.setTelsos(ui.getTelsos());
				uib.setRelation(ui.getRelation());
				if(zw.startsWith("1")||zw.startsWith("2"))
				{
					uib.setZw_chu("领导");
				}
				mylist.add(uib);
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

		

		return "success";
	}
	

	public List<Chu> findchulist(String jigouid,Session session) //通过机构ID查询机构所有
    {
		Query query;		
		List <Chu>chulist=null;
		try {
	        String sql="SELECT * from chu where jigouid = "+"'"+jigouid+"'";			
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(Chu.class);		
			chulist = query.list();				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}		
		return chulist;		
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
