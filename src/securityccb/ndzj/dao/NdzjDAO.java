package securityccb.ndzj.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.ndzj.pojo.Ndzj;

/**
 	* A data access object (DAO) providing persistence and search support for Ndzj entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Ndzj
  * @author MyEclipse Persistence Tools 
 */

public class NdzjDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(NdzjDAO.class);
		//property constants
	public static final String JIGOUID = "jigouid";
	public static final String RTITLE = "rtitle";
	public static final String RFILE = "rfile";
	public static final String YEAR = "year";
	public static final String DATE = "date";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";



    
    public void save(Ndzj transientInstance) {
        log.debug("saving Ndzj instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Ndzj persistentInstance) {
        log.debug("deleting Ndzj instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Ndzj findById( java.lang.Integer id) {
        log.debug("getting Ndzj instance with id: " + id);
        try {
            Ndzj instance = (Ndzj) getSession()
                    .get("Ndzj", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Ndzj instance) {
        log.debug("finding Ndzj instance by example");
        try {
            List results = getSession()
                    .createCriteria("Ndzj")
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
      log.debug("finding Ndzj instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Ndzj as model where model." 
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
	
	public List findByRtitle(Object rtitle
	) {
		return findByProperty(RTITLE, rtitle
		);
	}
	
	public List findByRfile(Object rfile
	) {
		return findByProperty(RFILE, rfile
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
		log.debug("finding all Ndzj instances");
		try {
			String queryString = "from Ndzj";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Ndzj merge(Ndzj detachedInstance) {
        log.debug("merging Ndzj instance");
        try {
            Ndzj result = (Ndzj) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Ndzj instance) {
        log.debug("attaching dirty Ndzj instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Ndzj instance) {
        log.debug("attaching clean Ndzj instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}