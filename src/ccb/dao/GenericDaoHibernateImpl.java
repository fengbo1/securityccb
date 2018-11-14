package ccb.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import ccb.hibernate.HibernateSessionFactory;

/**
 * 
 * 
 * 
 * 
 * 
 * @param <E>
 * @param <PK>
 */
public class GenericDaoHibernateImpl<E> implements GenericDao<E> {

	/**
	 * 实体类对象
	 */
	private Class<? extends E> entityClass;
	
	private static final Log log = LogFactory
			.getLog(GenericDaoHibernateImpl.class);

	/**
	 * 根据实体类对象构造DAO
	 * 
	 * @param entityClass
	 *            实体类对象
	 */
	public GenericDaoHibernateImpl(Class<? extends E> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * 根据实体类的类名构造DAO
	 * 
	 * @param entityClassName
	 *            实体类的类名
	 */
	@SuppressWarnings("unchecked")
	public GenericDaoHibernateImpl(String entityClassName) {
		try {
			this.entityClass = (Class<? extends E>) Class
					.forName(entityClassName);
		} catch (ClassNotFoundException e) {
			log.error("class for name " + entityClassName + "not found!", e);
		}
	}

	public Session getSession() {
		return HibernateSessionFactory.getSession();

	}

	public long countAll() {
		log.debug("countAll for class=" + entityClass.getName());
		try {
			String queryString = "select count(*) from "
					+ entityClass.getName();
			Query queryObject = getSession().createQuery(queryString);
			return (Long) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("countAll for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}
	public long countAll(String keyWordtb,String keyWord) {
		log.debug("countAll for class=" + entityClass.getName());
		try {
			String ktb;
			String kw;
			ktb = keyWordtb;
			kw = keyWord;
			String queryString = "select count(*) from "
					+ entityClass.getName() +" as cn where cn."+ktb+" like '%" + kw + "%'";
			Query queryObject = getSession().createQuery(queryString);
			return (Long) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("countAll for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}
	//以下是新添加部分
	public long countAll(String keyWordtb,String keyWord,String keyWordtb2,String keyWord2,String keyWordtb3,String keyWord3,String keyWordtb4,String keyWord4) {
		log.debug("countAll for class=" + entityClass.getName());
		try {
			String ktb;
			String kw;
			
			String ktb2;
			String kw2;
			
			String ktb3;
			String kw3;
			
			String ktb4;
			String kw4;
			
			ktb = keyWordtb;
			kw = keyWord;
			
			ktb2 = keyWordtb2;
			kw2 = keyWord2;
			
			ktb3 = keyWordtb3;
			kw3 = keyWord3;
			
			ktb4 = keyWordtb4;
			kw4 = keyWord4;
			//对keyword3进行循环拼接,达到对同一字段多关键字的查询目的////////////////////
			String qs="";
			if(!(kw3==null))
			{		
				String[] arr = kw3.split("\\、");
			
				for  (int i=0;i<arr.length;i++)
				{
					
					if (i==0)
					{
						 qs=ktb3+" like '%"+arr[i]+"%'";
					}
					if(i!=0)
					{
						 qs=qs+" or "+ktb3+" like '%"+arr[i]+"%'";
					}
					
				}	
			}
			if(kw3==null)
			{
				qs=ktb3+" like '%%'";
			}
			//判断kw中是否含有“、A”确定是否是工作计划页面查询，返回查询结果以month、week排序
			String[] brr = kw.split("\\、");
			kw=brr[0];			
			System.out.println("看看数组有多大"+brr.length);
			///////////////////////////////////////////
			String queryString = "select count(*) from "
					+ entityClass.getName() +" as cn where cn."+ktb+" like '%" + kw + "%' and "+ktb4+" like '%" + kw4 + "%' and "+ktb2+" like '%"+kw2+"%' and "+qs;
			if (brr.length>=2)
			{
				if (brr[1].equals("A"))
				{
					queryString=queryString+" order by month asc,week asc";
				}
			}
			
			System.out.println("queryString:"+queryString);
			
			
			Query queryObject = getSession().createQuery(queryString);
			return (Long) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("countAll for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}
	/////////////////
	public long countAll(String timetb,String beginDate,String endDate,String keyWordtb,String keyWord,String keyWordtb2,String keyWord2,String keyWordtb3,String keyWord3,String keyWordtb4,String keyWord4) {
		log.debug("countAll with date for class=" + entityClass.getName());
		try {
			String ktb;
			String kw;
			
			String ktb2;
			String kw2;
			
			String ktb3;
			String kw3;
			
			String ktb4;
			String kw4;
			
			String tm;
			String bd;
			String ed;
			ktb = keyWordtb;
			kw = keyWord;
			
			ktb2 = keyWordtb2;
			kw2 = keyWord2;
			
			ktb3 = keyWordtb3;
			kw3 = keyWord3;
			
			ktb4 = keyWordtb4;
			kw4 = keyWord4;
			
			tm = timetb;
			
			bd = beginDate;
			ed = endDate;
			//对keyword3进行循环拼接,达到对同一字段多关键字的查询目的////////////////////
			String qs="";
			if(!(kw3==null))
			{		
				String[] arr = kw3.split("\\、");
			
				for  (int i=0;i<arr.length;i++)
				{
					
					if (i==0)
					{
						 qs=ktb3+" like '%"+arr[i]+"%'";
					}
					if(i!=0)
					{
						 qs=qs+" or "+ktb3+" like '%"+arr[i]+"%'";
					}
					
				}	
			}
			if(kw3==null)
			{
				qs=ktb3+" like '%%'";
			}
			//判断kw中是否含有“、B C ”确定是否是工作日志页面查询，返回查询结果以time排序
			String[] brr = kw.split("\\、");
			if (brr[0].equals("null"))
					{
						kw="";
					}
			else{kw=brr[0];}			
			System.out.println("看看数组有多大"+brr.length);
					///////////////////////////////////////////
			String queryString = "select count(*) from "
					+ entityClass.getName()+ " as cn where cn."+tm+" >= :bd and cn."+tm+" <= :ed and cn."+ktb+" like '%" +kw+ "%' and cn."+ktb4+" like '%" +kw4+ "%' and cn."+ktb2+" like '%"+kw2+"%' and cn."+qs;
			
			if (brr.length>=2)
			{
				if (brr[1].equals("B"))
				{
					queryString=queryString+" order by time desc";
				}
				if (brr[1].equals("C"))
				{
					queryString=queryString+" order by cn.date asc";
				}
				if (brr[1].equals("D"))
				{
					queryString=queryString+" order by cn.begindate desc";
				}
			}
			
			
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setString("bd", bd);
			queryObject.setString("ed", ed);
			Long l = (Long) queryObject.uniqueResult();
			return l;
		} catch (RuntimeException re) {
			log.error("countAll for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}
	
	
	
	
	
	
	//以上是新添加部分
	public long countAll(String timetb,String beginDate,String endDate) {
		log.debug("countAll with date for class=" + entityClass.getName());
		try {
			String tm;
			String bd;
			String ed;
			tm = timetb;
			bd = beginDate;//+" 00:00:00";
			ed = endDate;//+" 23:59:59";
			String queryString = "select count(*) from "
					+ entityClass.getName()+ " as cn where cn."+tm+" >= :bd and cn."+tm+" <= :ed";
			System.out.println("有时间查询的语句："+queryString);
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setString("bd", bd);
			queryObject.setString("ed", ed);
			return (Long) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("countAll for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}
	public long countAll(String keyWordtb,String keyWord,String timetb,String beginDate,String endDate) {
		log.debug("countAll with date for class=" + entityClass.getName());
		try {
			String ktb;
			String kw;
			String tm;
			String bd;
			String ed;
			ktb = keyWordtb;
			kw = keyWord;
			tm = timetb;
			bd = beginDate+" 00:00:00";
			ed = endDate+" 23:59:59";
			String queryString = "select count(*) from "
					+ entityClass.getName()+ " as cn where cn."+tm+" >= :bd and cn."+tm+" <= :ed and cn."+ktb+" like '%" + kw + "%'";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setString("bd", bd);
			queryObject.setString("ed", ed);
			return (Long) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("countAll for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}
	public int countEntity(Map<String, ?> con) {
		log.debug("countEntity for class=" + entityClass.getName());
		try {
			Criteria crit = getSession().createCriteria(entityClass).add(
					Restrictions.allEq(con)).setProjection(
					Projections.rowCount());
			int count = new Integer(crit.uniqueResult().toString());
			return count;
		} catch (RuntimeException re) {
			log.error("countEntity for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param equalMap
	 * @param inMap
	 *            动态生成in .... 的条件查询语句
	 * @return
	 */
	public int countEntity(Map<String, ?> equalMap, Map<String, Object[]> inMap) {
		log.debug("findEntity for class=" + entityClass.getName());
		try {
			Criteria crit = getSession().createCriteria(entityClass).add(
					Restrictions.allEq(equalMap));
			for (Map.Entry<String, Object[]> in : inMap.entrySet()) {
				crit.add(Restrictions.in(in.getKey(), in.getValue()));
			}
			crit.setProjection(Projections.rowCount());
			int count = new Integer(crit.uniqueResult().toString());
			return count;
		} catch (RuntimeException re) {
			log.error("findEntity for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}

	public void deleteById(String id) {
		log.debug("delete for class=" + entityClass.getName());
		try {
			String hql = "delete from " + entityClass.getName() + " where id='"
					+ id + "'";
			getSession().createQuery(hql).executeUpdate();
			
		} catch (RuntimeException re) {
			log.error("delete for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}
	
	public void deleteByIds(List<String> idList) {
		log.debug("delete for class=" + entityClass.getName());
		try {
			String hql = "delete from " + entityClass.getName() + " where";
			for(String id:idList)
			{
				hql = hql+ " id='" + id + "' or";
			}
			hql = hql.substring(0, hql.length()-3);
			getSession().createQuery(hql).executeUpdate();
			
			
		} catch (RuntimeException re) {
			log.error("delete for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}
	
	public void deleteByIds(String timetb,String beginDate,String endDate) {
		log.debug("delete for class with date =" + entityClass.getName());
		try {
			String tm;
			String bd;
			String ed;
			tm = timetb;
			bd=beginDate+" 00:00:00";
			ed=endDate+" 23:59:59";
			String queryString = "delete from " + entityClass.getName() + " as cn where cn."+tm+" >= :bd and cn."+tm+" <= :ed";
			//Query queryObject = getSession().createQuery(queryString);
			//Query queryObject = getSession().createQuery(queryString).setString("bd", bd).setString("ed", ed).executeUpdate();
			//queryObject.setString("bd", bd);
			//queryObject.setString("ed", ed);
			getSession().createQuery(queryString).setString("bd", bd).setString("ed", ed).executeUpdate();
		} catch (RuntimeException re) {
			log.error(
					"deleteByIds for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}
	public void delete(E entity) {
		log.debug("delete for class=" + entityClass.getName());
		try {
			getSession().delete(entity);
		} catch (RuntimeException re) {
			log.error("delete for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		log.debug("findAll for class=" + entityClass.getName());
		try {
			String queryString = "from " + entityClass.getName();
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error(
					"findAll for class=" + entityClass.getName() + " failed!",
					re);
			re.printStackTrace();
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll(int firstResult, int maxResult) {
		log.debug("findAll for class=" + entityClass.getName());
		try {
			String queryString = "from " + entityClass.getName();
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setFirstResult(firstResult);
			queryObject.setMaxResults(maxResult);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error(
					"findAll for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<E> findAllDesc(String orderType,
			int firstResult, int maxResult) {
		log.debug("findAllDesc for class=" + entityClass.getName());
		try {
			String queryString = "from " + entityClass.getName() + " order by id desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setFirstResult(firstResult);
			queryObject.setMaxResults(maxResult);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error(
					"findAllDesc for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAllDesc(String orderType,
			int firstResult, int maxResult,String timetb,String beginDate,String endDate) {
		log.debug("findAllDescWithDate for class=" + entityClass.getName());
		try {
			String tm;
			String bd;
			String ed;
			tm = timetb;
			bd=beginDate;//+" 00:00:00";
			ed=endDate;//+" 23:59:59";
			String queryString = "from " + entityClass.getName() + " as cn where cn."+tm+" >= :bd and cn."+tm+" <= :ed order by id desc";
			System.out.println("有时间查询的语句："+queryString);
			System.out.println("有时间查询的语句bd,ed："+bd+"**"+ed);
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setString("bd", bd);
			queryObject.setString("ed", ed);
			queryObject.setFirstResult(firstResult);
			queryObject.setMaxResults(maxResult);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error(
					"findAllDescWithDate for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<E> findAllDesc(String orderType,int firstResult, int maxResult,String keyWordtb,String keyWord){
		log.debug("findAllDesc for class=" + entityClass.getName());
		try {
			String ktb;
			String kw;
			ktb = keyWordtb;
			kw = keyWord;
			String queryString = "from " + entityClass.getName() + " as cn where cn."+ktb+" like '%" + kw + "%' order by id desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setFirstResult(firstResult);
			queryObject.setMaxResults(maxResult);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error(
					"findAllDesc for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}
	//以下是新添加部分
	@SuppressWarnings("unchecked")
	public List<E> findAllDesc(String orderType,int firstResult, int maxResult,String keyWordtb,String keyWord,String keyWordtb2,String keyWord2,String keyWordtb3,String keyWord3,String keyWordtb4,String keyWord4){
		log.debug("findAllDesc for class=" + entityClass.getName());
		try {
			String ktb;
			String kw;
			
			String ktb2;
			String kw2;
			
			String ktb3;
			String kw3;
			
			String ktb4;
			String kw4;
			
			ktb = keyWordtb;
			kw = keyWord;
			
			ktb2 = keyWordtb2;
			kw2 = keyWord2;
			
			ktb3 = keyWordtb3;
			kw3 = keyWord3;
			
			ktb4 = keyWordtb4;
			kw4 = keyWord4;
			
			//对keyword3进行循环拼接,达到对同一字段多关键字的查询目的////////////////////
			String qs="";
			if(!(kw3==null))
			{		
				String[] arr = kw3.split("\\、");
			
				for  (int i=0;i<arr.length;i++)
				{
					
					if (i==0)
					{
						 qs=ktb3+" like '%"+arr[i]+"%'";
					}
					if(i!=0)
					{
						 qs=qs+" or "+ktb3+" like '%"+arr[i]+"%'";
					}
					
				}	
			}
			if(kw3==null)
			{
				qs=ktb3+" like '%%'";
			}
			//判断kw中是否含有“、A”确定是否是工作计划页面查询，返回查询结果以month、week排序
			String[] brr = kw.split("\\、");
			kw=brr[0];
			///////////////////////////////////////////
			
			String queryString = "from " + entityClass.getName() + " as cn where cn."+ktb+" like '%" + kw + "%'and "+ktb4+" like '%" + kw4 + "%'and "+ktb2+" like '%" + kw2 + "%'and "+qs+" order by id desc";
			if (brr.length>=2)
			{
				if (brr[1].equals("A"))
				{
					queryString=queryString.substring(0,queryString.length()-17)+" order by month asc,week asc";
				}
			}
			System.out.println("queryString:"+queryString);
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setFirstResult(firstResult);
			queryObject.setMaxResults(maxResult);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error(
					"findAllDesc for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}
	//////////////////////////////
	@SuppressWarnings("unchecked")
	public List<E> findAllDesc(String orderType,
			int firstResult, int maxResult,String timetb,String beginDate,String endDate,String keyWordtb,String keyWord,String keyWordtb2,String keyWord2,String keyWordtb3,String keyWord3,String keyWordtb4,String keyWord4) {
		log.debug("findAllDescWithDate for class=" + entityClass.getName());
		try {
			String ktb;
			String kw;
			
			String ktb2;
			String kw2;
			
			String ktb3;
			String kw3;
			
			String ktb4;
			String kw4;
			
			String tm;
			String bd;
			String ed;
			
			ktb2 = keyWordtb2;
			kw2 = keyWord2;
			
			ktb3 = keyWordtb3;
			kw3 = keyWord3;
			
			ktb4 = keyWordtb4;
			kw4 = keyWord4;
			
			ktb = keyWordtb;
			kw = keyWord;
			
			tm = timetb;
			bd=beginDate;
			ed=endDate;
			//对keyword3进行循环拼接,达到对同一字段多关键字的查询目的////////////////////
			String qs="";
			if(!(kw3==null))
			{		
				String[] arr = kw3.split("\\、");
			
				for  (int i=0;i<arr.length;i++)
				{
					
					if (i==0)
					{
						 qs=ktb3+" like '%"+arr[i]+"%'";
					}
					if(i!=0)
					{
						 qs=qs+" or "+ktb3+" like '%"+arr[i]+"%'";
					}
					
				}	
			}
			if(kw3==null)
			{
				qs=ktb3+" like '%%'";
			}
			//判断kw中是否含有“、B”确定是否是工作日志页面查询，返回查询结果以time排序
			String[] brr = kw.split("\\、");
			if (brr[0].equals("null"))
			{
				kw="";
			}
	         else{kw=brr[0];}				
			System.out.println("看看数组有多大"+brr.length);
			///////////////////////////////////////////
			String queryString = "from " + entityClass.getName() + " as cn where cn."+tm+" >= :bd and cn."+tm+" <= :ed and cn."+ktb+" like '%" + kw + "%'and "+ktb4+" like '%" + kw4 + "%'and "+ktb2+" like '%" + kw2 + "%'and "+qs+" order by id desc";
			
			if (brr.length>=2)
			{
				if (brr[1].equals("B"))
				{
					queryString=queryString.substring(0,queryString.length()-17)+" order by time desc";
				}
				if (brr[1].equals("C"))
				{
					queryString=queryString.substring(0,queryString.length()-17)+" order by date asc";
				}
				if (brr[1].equals("D"))
				{
					queryString=queryString.substring(0,queryString.length()-17)+" order by begindate desc";
				}
			}
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setString("bd", bd);
			queryObject.setString("ed", ed);
			queryObject.setFirstResult(firstResult);
			queryObject.setMaxResults(maxResult);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error(
					"findAllDescWithDate for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}

	//以上是新添加部分
	@SuppressWarnings("unchecked")
	public List<E> findAllDesc(String orderType,
			int firstResult, int maxResult,String keyWordtb,String keyWord,String timetb,String beginDate,String endDate) {
		log.debug("findAllDescWithDate for class=" + entityClass.getName());
		try {
			String ktb;
			String kw;
			String tm;
			String bd;
			String ed;
			ktb = keyWordtb;
			kw = keyWord;
			tm = timetb;
			bd=beginDate+" 00:00:00";
			ed=endDate+" 23:59:59";
			String queryString = "from " + entityClass.getName() + " as cn where cn."+tm+" >= :bd and cn."+tm+" <= :ed and cn."+ktb+" like '%" + kw + "%' order by id desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setString("bd", bd);
			queryObject.setString("ed", ed);
			queryObject.setFirstResult(firstResult);
			queryObject.setMaxResults(maxResult);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error(
					"findAllDescWithDate for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}
	/**带条件的排序查询*/
	@SuppressWarnings("unchecked")
	public List<E> findAllBy(int firstResult, int maxResult,String keyWordcol,int kwint,String timetb,String endDate){
		log.debug("findAllBy for class=" + entityClass.getName());
		try {
			
			String queryString = "from " + entityClass.getName() + " as cn where cn."+keyWordcol+"= :kwint order by cn."+keyWordcol+" desc";
			Query queryObject = getSession().createQuery(queryString);
		    queryObject.setLong("kwint", kwint);
			queryObject.setFirstResult(firstResult);
			queryObject.setMaxResults(maxResult);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error(
					"findAllBy for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<E> findEntity(Map<String, ?> equalMap, int firstResult,
			int maxResult) {
		log.debug("findEntity for class=" + entityClass.getName());
		try {
			Criteria crit = getSession().createCriteria(entityClass).add(
					Restrictions.allEq(equalMap));
			crit.setFirstResult(firstResult);
			crit.setMaxResults(maxResult);
			return crit.list();
		} catch (RuntimeException re) {
			log.error("findEntity for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<E> findEntity(Map<String, ?> equalMap) {
		log.debug("findEntity for class=" + entityClass.getName());
		try {
			Criteria crit = getSession().createCriteria(entityClass).add(
					Restrictions.allEq(equalMap));
			return crit.list();
		} catch (RuntimeException re) {
			log.error("findEntity for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param equalMap
	 * @param inMap
	 *            动态生成in .... 的条件查询语句
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findEntity(Map<String, ?> equalMap,
			Map<String, Object[]> inMap, int firstResult, int maxResult) {
		log.debug("findEntity for class=" + entityClass.getName());
		try {
			Criteria crit = getSession().createCriteria(entityClass).add(
					Restrictions.allEq(equalMap));
			for (Map.Entry<String, Object[]> in : inMap.entrySet()) {
				crit.add(Restrictions.in(in.getKey(), in.getValue()));
			}
			crit.setFirstResult(firstResult);
			crit.setMaxResults(maxResult);
			return crit.list();
		} catch (RuntimeException re) {
			log.error("findEntity for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param equalMap
	 * @param inMap
	 *            动态生成in .... 的条件查询语句
	 * @param orders
	 *            动态生成order by .....的排序条件
	 * @param orderType
	 *            排序的方式 该参数默认为asc 可能的取值为 asc 和 desc
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findEntity(Map<String, ?> equalMap,
			Map<String, Object[]> inMap, String[] orders, String orderType,
			int firstResult, int maxResult) {
		log.debug("findEntity for class=" + entityClass.getName());
		try {
			Criteria crit = getSession().createCriteria(entityClass).add(
					Restrictions.allEq(equalMap));
			for (Map.Entry<String, Object[]> in : inMap.entrySet()) {
				crit.add(Restrictions.in(in.getKey(), in.getValue()));
			}
			if (orderType == null || orderType.equals("asc")) {
				for (String order : orders) {
					crit.addOrder(Order.asc(order));
				}
			} else if (orderType.equals("desc")) {
				for (String order : orders) {
					crit.addOrder(Order.desc(order));
				}
			}
			crit.setFirstResult(firstResult);
			crit.setMaxResults(maxResult);
			return crit.list();
		} catch (RuntimeException re) {
			log.error("findEntity for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public E getById(String id) {
		log.debug("get for class=" + entityClass.getName());
		System.out.println("get for class!");

		try {
			return (E) getSession().createQuery(
					"from " + entityClass.getName() + " as clazz where id = '"
							+ id + "'").uniqueResult();
		} catch (RuntimeException re) {
			log
					.error("get for class=" + entityClass.getName()
							+ " failed!", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public E getForUpdate(String id) {
		log.debug("getForUpdate for class=" + entityClass.getName()
				+ "for update");
		try {
			return (E) getSession().createQuery(
					"from " + entityClass.getName() + " as clazz where id ='"
							+ id + "'").setLockMode("clazz", LockMode.UPGRADE)
					.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get for class=" + entityClass.getName()
					+ " for update failed!", re);
			throw re;
		}
	}

	public String save(E entity) {
		log.debug("save for class=" + entityClass.getName());
		try {
			return getSession().save(entity).toString();
		} catch (RuntimeException re) {
			log.error("save for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}

	public void update(E entity) {
		log.debug("update for class=" + entityClass.getName());
		try {
			//getSession().update(entity);
			getSession().merge(entity);
		} catch (RuntimeException re) {
			log.error("update for class=" + entityClass.getName() + " failed!",
					re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public void batchUpdate(Map<String, ?> equalMap, Map<String, ?> updateMap) {
		log.debug("batchUpdate for class=" + entityClass.getName());
		try {
			StringBuffer hql = new StringBuffer("update "
					+ entityClass.getName() + " set ");

			for (Iterator<?> iterator = updateMap.entrySet().iterator(); iterator
					.hasNext();) {
				Map.Entry<String, ?> entry = (Map.Entry<String, ?>) iterator
						.next();
				hql.append(entry.getKey());
				hql.append("=");
				hql.append("\"" + entry.getValue() + "\"");
				if (iterator.hasNext()) {
					hql.append(",");
				}
			}
			for (Iterator<?> iterator = equalMap.entrySet().iterator(); iterator
					.hasNext();) {
				Map.Entry<String, ?> entry = (Map.Entry<String, ?>) iterator
						.next();
				hql.append(entry.getKey());
				hql.append("=");
				hql.append("\"" + entry.getValue() + "\"");
				if (iterator.hasNext()) {
					hql.append(" and ");
				}
			}
			getSession().createQuery(hql.toString());
		} catch (RuntimeException re) {
			log.error("batchUpdate for class=" + entityClass.getName()
					+ " failed!", re);
			throw re;
		}
	}
}
