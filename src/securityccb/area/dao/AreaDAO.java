package securityccb.area.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import ccb.hibernate.HibernateSessionFactory;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.area.pojo.Area;

/**
 * A data access object (DAO) providing persistence and search support for Area
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see .Area
 * @author MyEclipse Persistence Tools
 */

public class AreaDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AreaDAO.class);
	// property constants
	public static final String CHUSHIID = "chushiid";
	public static final String AREAID = "areaid";
	public static final String AREA = "area";
	public static final String URL = "url";
	public static final String AREANAME = "areaname";

	public void save(Area transientInstance) {
		log.debug("saving Area instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Area persistentInstance) {
		log.debug("deleting Area instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Area findById(java.lang.Integer id) {
		log.debug("getting Area instance with id: " + id);
		try {
			Area instance = (Area) getSession().get("Area", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Area instance) {
		log.debug("finding Area instance by example");
		try {
			List results = getSession().createCriteria("Area").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Area instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Area as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByChushiid(Object chushiid) {
		return findByProperty(CHUSHIID, chushiid);
	}

	public List findByAreaid(Object areaid) {
		return findByProperty(AREAID, areaid);
	}

	public List findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByAreaname(Object areaname) {
		return findByProperty(AREANAME, areaname);
	}

	public List findAll() {
		log.debug("finding all Area instances");
		try {
			String queryString = "from Area";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Area merge(Area detachedInstance) {
		log.debug("merging Area instance");
		try {
			Area result = (Area) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Area instance) {
		log.debug("attaching dirty Area instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Area instance) {
		log.debug("attaching clean Area instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public List<Area> findareaidbychushiid(String chushiid) //查询处室ID下全部责任区
    {
		Query query ;		
		List<Area> arealist = null;
		try {

	        String sql="SELECT * from area where chushiid = "+"'"+chushiid+"'";			
			System.out.println(sql);
			query  = getSession().createSQLQuery(sql).addEntity(Area.class);		
			arealist = query.list();						
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{

		}
			
	return arealist;
	
    }
	public String findmaxareaid() //获取area最大id
    {
		Query query;			
		String newareaid="";
		String hql="from Area order by areaid desc";		
		query=getSession().createQuery(hql);
		List<Area>  list = query.list();	
     	if(list.isEmpty())
     	{
     		newareaid = "000001";
     	}
     	else
     	{
     		newareaid=list.get(0).getAreaid();	
     	} 
		return newareaid;
	}
	public static String addOne(String testStr){
	    String[] strs = testStr.split("[^0-9]");//根据不是数字的字符拆分字符串
	    String numStr = strs[strs.length-1];//取出最后一组数字
	    if(numStr != null && numStr.length()>0){//如果最后一组没有数字(也就是不以数字结尾)，抛NumberFormatException异常
	        int n = numStr.length();//取出字符串的长度
	        int num = Integer.parseInt(numStr)+1;//将该数字加一
	        String added = String.valueOf(num);
	        n = Math.min(n, added.length());
	        //拼接字符串
	        return testStr.subSequence(0, testStr.length()-n)+added;
	    }else{
	        throw new NumberFormatException();
	    }
	}
	public String FindAreaUrl(String areaid) 
	{
		Query query;
		String url="";	

		try {			
		
			String sql="select * from area where areaid = "+"'"+areaid+"'";	
			System.out.println(sql);
			query =getSession().createSQLQuery(sql).addEntity(Area.class);	;
			List <Area>arealist = query.list();	
            url=arealist.get(0).getUrl();
            if(!url.equals("")){
    			url=url.substring(url.indexOf("upload_area")+12, url.indexOf("\" width"));

            }
			
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		
		return url;	
	}
}