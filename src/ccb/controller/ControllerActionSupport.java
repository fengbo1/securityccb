package ccb.controller;
import java.util.List;

import ccb.util.IsNull;
import ccb.util.MessageException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * 
 * @author miracle
 * 
 * 2012-9-5
 * 
 * @param <E>
 * 		实体类别
 * 
 * @param <PK>
 * 		实体的ID类别
 */
public class ControllerActionSupport<E> extends ActionSupport implements ControllerAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1046751037184976151L;
	
	/**
	 * 操作的类型
	 */
	String type;
	
	/**
	 * 跳转控制参数
	 */
	private String forward;
	private static final Log log = LogFactory.getLog(ControllerActionSupport.class);
	/**
	 * 关键字的数据库表字段
	 */
	protected String keyWordtb;
	
	protected String keyWordtb2;
	
	
	protected String keyWordtb3;
	
	protected String keyWordtb4;
	/**
	 * 关键字
	 */
	protected String keyWord;
	
	protected String keyWord2;
	
	protected String keyWord3;
	
	protected String keyWord4;
	
	/**
	* 工作日志页面用来判断年份使用
	*/
	protected String year;
	
	protected String year_paiban;
	/**
	 *int型的关键字
	 **/
	protected int kwint;
	/**
	 * 传入的ID列表
	 */
	List<String> idList;
	/**
	 * 表名
	 */
	protected String timetb;
	/**
	* 起始时间
	*/
	protected String beginDate;
	/**
	* 结束时间
	*/
	protected String endDate;
/**
* 获得默认的分页大小
*/

	/* 测试分页，先使用三页 一分页*/
	//protected int pageSize = 3;
    
	protected int pageSize = 15;

/**
* 总页数
*/
protected int totalPages = -1;

/**
* 当前页
*/
protected int currentPage = -1;

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
protected long totalRows = -1;

/**
* 列表数据
*/
protected List<E> list;

	
	public ControllerActionSupport(){
		super();
	}
	@Override
	public String execute()
			throws Exception {
		// TODO Auto-generated method stub
		/**
		 *强制转换，以获得操作的类型
		 */
		type = getType();
		keyWord4 = getKeyWord4();		
		keyWord = getKeyWord();		
		keyWordtb = getKeyWordtb();
		
		year=getYear();
		timetb = getTimetb();
		beginDate = getBeginDate();		
		endDate = getEndDate();
		if (year!=null&&!year.equals("null")&&beginDate!=null&&endDate!=null)
		{				
			if(beginDate.equals("")&&endDate.equals("")&&(!year.equals("B")))
			{
				beginDate=year+"-00-00";			
				endDate=year+"-99-99";
				
			}
			keyWord=keyWord+"、B";
			
		}
		if (year_paiban!=null&&!year_paiban.equals("null")&&beginDate!=null&&endDate!=null)
		{				
			if(beginDate.equals("")&&endDate.equals("")&&(!year_paiban.equals("B")))
			{
				beginDate=year_paiban+"-00-00";			
				endDate=year_paiban+"-99-99";
				
			}
			keyWord=keyWord+"、D";
			
		}
		//System.out.println("beginDate:"+beginDate);
		//System.out.println("endDate:"+endDate);
		
		if(beginDate!=null&&endDate!=null)
		{
		
			if (beginDate.equals("")&&(!endDate.equals("")))
			{
				beginDate="0000-00-00";
			}
			if (endDate.equals("")&&(!beginDate.equals("")))
			{
				endDate="9999-99-99";
			}		
			
			if(beginDate.equals("")&&endDate.equals(""))
			{
					beginDate="0000-00-00";			
					endDate="9999-99-99";				
			}
		
		}
		
		
		
		
		
		
		
		//以下是新添加部分
		keyWord2 = getKeyWord2();
		
		
		keyWordtb2 = getKeyWordtb2();
		
		keyWord3 = getKeyWord3();
		keyWordtb3 = getKeyWordtb3();
		
		keyWord4 = getKeyWord4();
		keyWordtb4 = getKeyWordtb4();
		/*根据type字段是否含“9”判断是否是链接传来的参数，是否需要对汉字进行转换.
		20150507日对server.xml文件定义了编码格式，暂不需要对超链接的汉字进行解码。*/
		if ((type.indexOf("9")!=-1))
		{   
			String[] arr = type.split("9");
			type=arr[0];
			
			if(keyWord!=null&&((keyWord.indexOf("、B")==-1)&&(keyWord.indexOf("、D")==-1)&&(keyWord.indexOf("、A")==-1))){
				keyWord=new String(keyWord.getBytes("iso-8859-1"),"utf-8");
			}
			if(keyWord2!=null){
				keyWord2=new String(keyWord2.getBytes("iso-8859-1"),"utf-8");
			}
			if(keyWord3!=null){
				keyWord3=new String(keyWord3.getBytes("iso-8859-1"),"utf-8");
			}
			if(keyWord4!=null){
				keyWord4=new String(keyWord4.getBytes("iso-8859-1"),"utf-8");
			}
			
			if(keyWordtb!=null){
				keyWordtb=new String(keyWordtb.getBytes("iso-8859-1"),"utf-8");
			}
			if(keyWordtb2!=null){
				keyWordtb2=new String(keyWordtb2.getBytes("iso-8859-1"),"utf-8");
			}
			if(keyWordtb3!=null){
				keyWordtb3=new String(keyWordtb3.getBytes("iso-8859-1"),"utf-8");
			}
			if(keyWordtb4!=null){
				keyWordtb4=new String(keyWordtb4.getBytes("iso-8859-1"),"utf-8");
			}			
		}
		
		
		//keyWord3=new String(keyWord3.getBytes("iso-8859-1"),"utf-8");
		//以上是新添加部分		
		kwint=getKwint();
		idList = getIdList();
		
		
		
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		session.setAttribute("keyWord",null);
		session.setAttribute("keyWordtb",null);
		
		session.setAttribute("keyWord2",null);
		session.setAttribute("keyWordtb2",null);
		
		session.setAttribute("keyWord3",null);
		session.setAttribute("keyWordtb3",null);
		
		session.setAttribute("keyWord4",null);
		session.setAttribute("keyWordtb4",null);
		
		session.setAttribute("timetb",null);
		session.setAttribute("beginDate",null);
		session.setAttribute("endDate",null);
		
		
		
		session.setAttribute("keyWord",keyWord);
		session.setAttribute("keyWordtb",keyWordtb);
				
		session.setAttribute("keyWord2",keyWord2);
		session.setAttribute("keyWordtb2",keyWordtb2);
		
		session.setAttribute("keyWord3",keyWord3);
		session.setAttribute("keyWordtb3",keyWordtb3);
		
		session.setAttribute("keyWord4",keyWord4);
		session.setAttribute("keyWordtb4",keyWordtb4);
		
		session.setAttribute("timetb",timetb);
		session.setAttribute("beginDate",beginDate);
		session.setAttribute("endDate",endDate);
		/*System.out.println("在java中写入session中的值：");
		System.out.println("keyWord的值："+keyWord);
		System.out.println("keyWord2的值："+keyWord2);
		System.out.println("keyWord3的值："+keyWord3);
		System.out.println("keyWord4的值："+keyWord4);
		System.out.println("立即提取keyWord的值："+request.getSession().getAttribute("keyWord"));
		System.out.println("立即提取keyWord2的值："+request.getSession().getAttribute("keyWord2"));
		System.out.println("立即提取keyWord3的值："+request.getSession().getAttribute("keyWord3"));
		System.out.println("立即提取keyWord4的值："+request.getSession().getAttribute("keyWord4"));*/
	
		
        /*
		String s1= (String) request.getSession().getAttribute("keyWordtb");
        String ss1= (String) request.getSession().getAttribute("keyWord");
		
		System.out.println("session值："+s1+"_"+ss1);	
		
		String s2= (String) request.getSession().getAttribute("keyWordtb2");
        String ss2= (String) request.getSession().getAttribute("keyWord2");
		
		System.out.println("session值2："+s2+"_"+ss2);	
		*/
		
		
		
		
		
	
		
		//System.out.println("started!");
		if (type == null) {
			throw new MessageException("对不起，操作类型不能为空！");
		}else if (ADD.equals(type)) {
			forward = add();
		}else if (DETAIL.equals(type)) {
			forward = detail();
		}else if (DEL.equals(type)) {
				forward = delete();
		}else if(DELBYTIME.equals(type)){
				forward = delete(timetb,beginDate,endDate);
		}else if (UPDATE.equals(type)) {
			forward = update();
		}else if(TO_UPDATE.equals(type)){
			forward =to_update();
		}else if(FIND_ALL.equals(type)){
			forward =findAll();
		}else if(FIND_ALL_DESC.equals(type))
			/*{
			if(beginDate==null&&endDate==null
					&&keyWord==null&&keyWord2==null&&keyWord3==null)
			{
				forward = findAllDesc();
			}
			else if(keyWord==null)
			{
				forward = findAllDesc(timetb,beginDate,endDate);
			}
			//else if(beginDate.isEmpty()&&endDate.isEmpty())
			else if(beginDate==null&&endDate==null&&keyWord2==null&&keyWord3==null)
			{
				forward = findAllDesc(keyWordtb,keyWord);
			}
			else if(beginDate==null&&endDate==null)
			{
				forward = findAllDesc(keyWordtb,keyWord,keyWordtb2,keyWord2,keyWordtb3,keyWord3);
			}
			else
			{
				forward = findAllDesc(keyWordtb,keyWord,timetb,beginDate,endDate);
			}	
		}*/
		
		{
			//查询所有
			if(beginDate==null&&endDate==null&&keyWord==null&&keyWord2==null&&keyWord3==null&&keyWord4==null)
			{
				forward = findAllDesc();
			}
			
			
			//带有时间的查询
			else if(beginDate!=null||endDate!=null)
			{
				if(keyWord==null){keyWord="";}
				if(keyWord2==null)
				{
					keyWord2="";
					
				}
				if(keyWord3==null){keyWord3="";}
				if(keyWord4==null){keyWord4="";}
				
				if(keyWordtb==null){keyWordtb="id";}
				if(keyWordtb2==null){keyWordtb2="id";}
				if(keyWordtb3==null){keyWordtb3="id";}
				if(keyWordtb4==null){keyWordtb4="id";}
				
				
				forward = findAllDesc(timetb,beginDate,endDate,keyWordtb,keyWord,keyWordtb2,keyWord2,keyWordtb3,keyWord3,keyWordtb4,keyWord4);
			}
			//没有时间的查询
			else if(beginDate==null&&endDate==null)
			{	
				if(keyWord==null){keyWord="";}
				if(keyWord2==null){keyWord2="";}
				if(keyWord3==null){keyWord3="";}
				if(keyWord4==null){keyWord4="";}
				
				if(keyWordtb==null){keyWordtb="id";}
				if(keyWordtb2==null){keyWordtb2="id";}
				if(keyWordtb3==null){keyWordtb3="id";}
				if(keyWordtb4==null){keyWordtb4="id";}
				forward = findAllDesc(keyWordtb,keyWord,keyWordtb2,keyWord2,keyWordtb3,keyWord3,keyWordtb4,keyWord4);							
			}
		}
		
		
		
		
		
		
		
		else if(FIND_ALL_BY.equals(type))
		{
			forward=findAllBy(keyWordtb,kwint,timetb,endDate);
		}
		else {
			throw new MessageException("对不起，不存在该操作类型！ type=" + type);
		}

		return forward;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getKeyWordtb() {
		return keyWordtb;
	}
	public void setKeyWordtb(String keyWordtb) {
		this.keyWordtb = keyWordtb;
	}
	//以下是新添加部分

	
	
	
	
	
	
	public String getKeyWordtb2() {
		return keyWordtb2;
	}
	public void setKeyWordtb2(String keyWordtb2) {
		this.keyWordtb2 = keyWordtb2;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getYear_paiban() {
		return year_paiban;
	}
	public void setYear_paiban(String yearPaiban) {
		year_paiban = yearPaiban;
	}
	public String getKeyWordtb3() {
		return keyWordtb3;
	}
	public void setKeyWordtb3(String keyWordtb3) {
		this.keyWordtb3 = keyWordtb3;
	}
	public String getKeyWordtb4() {
		return keyWordtb4;
	}
	public void setKeyWordtb4(String keyWordtb4) {
		this.keyWordtb4 = keyWordtb4;
	}
	public String getKeyWord2() {
		return keyWord2;
	}
	public void setKeyWord2(String keyWord2) {
		this.keyWord2 = keyWord2;
	}
	public String getKeyWord3() {
		return keyWord3;
	}
	public void setKeyWord3(String keyWord3) {
		this.keyWord3 = keyWord3;
	}
	public String getKeyWord4() {
		return keyWord4;
	}
	public void setKeyWord4(String keyWord4) {
		this.keyWord4 = keyWord4;
	}
	//以上是新添加部分
	
	public List<String> getIdList() {
		return idList;
	}
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public int getKwint() {
		return kwint;
	}
	public void setKwint(int kwint) {
		this.kwint = kwint;
	}
	public String getTimetb() {
		return timetb;
	}
	public void setTimetb(String timetb) {
		this.timetb = timetb;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
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
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public String add() throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	public String delete() throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	public String delete(List<String> idList) throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	public String delete(String timetb,String beginDate,String endDate){
		// TODO Auto-generated method stub
		return null;
	}
	public String detail() throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 *准备更新记录	 
	 */
	public String to_update() throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 查找所有
	 */
	public String findAll() {
		return null;
	}
	/*
	 * 逆序查找所有
	 */
	public String findAllDesc() {
		return null;
	}
	/*
	 * 根据时间逆序查找所有
	 */
	public String findAllDesc(String timetb,String beginDate,String endDate) {
		return null;
	}
	/*
	 * 根据关键字段的关键字逆序查找所有
	 */
	public String findAllDesc(String keyWordtb,String keyWord){
		return null;
	}
	/*
	 * 根据时间和关键字段的关键字逆序查找所有
	 */
	public String findAllDesc(String keyWordtb,String keyWord,String timetb,String beginDate,String endDate) {
		return null;
	}
	//以下是新添加部分
	public String findAllDesc(String keyWordtb,String keyWord,String keyWordtb2,String keyWord2,String keyWordtb3,String keyWord3,String keyWordtb4,String keyWord4) {
		return null;
	}
	public String findAllDesc(String timetb,String beginDate,String endDate,String keyWordtb,String keyWord,String keyWordtb2,String keyWord2,String keyWordtb3,String keyWord3,String keyWordtb4,String keyWord4) {
		return null;
	}

	//以上是新添加部分
	/*
	 *根据关键字查询后按日期逆序排序 
	 */
	public String findAllBy(String keyWordtb,int kwint,String timetb,String endDate) {
		return null;
	}
	/*
	 * 更新记录
	 */
	public String update() throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	protected boolean isNull(Object property){
		return IsNull.isNull(property);
	}
	
}
