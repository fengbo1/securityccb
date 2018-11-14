package securityccb.gzjh.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.gzjh.pojo.Gzjh;

/**
 	* A data access object (DAO) providing persistence and search support for Gzjh entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Gzjh
  * @author MyEclipse Persistence Tools 
 */

public class GzjhDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(GzjhDAO.class);
		//property constants
	public static final String JIGOUID = "jigouid";
	public static final String PTITLE = "ptitle";
	public static final String PFILE = "pfile";
	public static final String YEAR = "year";
	public static final String DATE = "date";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";



    
    public void save(Gzjh transientInstance) {
        log.debug("saving Gzjh instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Gzjh persistentInstance) {
        log.debug("deleting Gzjh instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Gzjh findById( java.lang.Integer id) {
        log.debug("getting Gzjh instance with id: " + id);
        try {
            Gzjh instance = (Gzjh) getSession()
                    .get("Gzjh", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Gzjh instance) {
        log.debug("finding Gzjh instance by example");
        try {
            List results = getSession()
                    .createCriteria("Gzjh")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Gzjh instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Gzjh as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByJigouid(Object jigouid
	) {
		return findByProperty(JIGOUID, jigouid
		);
	}
	
	public List findByPtitle(Object ptitle
	) {
		return findByProperty(PTITLE, ptitle
		);
	}
	
	public List findByPfile(Object pfile
	) {
		return findByProperty(PFILE, pfile
		);
	}
	
	public List findByYear(Object year
	) {
		return findByProperty(YEAR, year
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByRemark1(Object remark1
	) {
		return findByProperty(REMARK1, remark1
		);
	}
	
	public List findByRemark2(Object remark2
	) {
		return findByProperty(REMARK2, remark2
		);
	}
	

	public List findAll() {
		log.debug("finding all Gzjh instances");
		try {
			String queryString = "from Gzjh";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Gzjh merge(Gzjh detachedInstance) {
        log.debug("merging Gzjh instance");
        try {
            Gzjh result = (Gzjh) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Gzjh instance) {
        log.debug("attaching dirty Gzjh instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Gzjh instance) {
        log.debug("attaching clean Gzjh instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}