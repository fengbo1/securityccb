package securityccb.jgxq.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.jgxq.pojo.Jgxq;

/**
 	* A data access object (DAO) providing persistence and search support for Jgxq entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Jgxq
  * @author MyEclipse Persistence Tools 
 */

public class JgxqDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(JgxqDAO.class);
		//property constants
	public static final String JIGOUID = "jigouid";
	public static final String JIGOUDESC = "jigoudesc";
	public static final String RECORD_DATE = "recordDate";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";



    
    public void save(Jgxq transientInstance) {
        log.debug("saving Jgxq instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Jgxq persistentInstance) {
        log.debug("deleting Jgxq instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Jgxq findById( java.lang.Integer id) {
        log.debug("getting Jgxq instance with id: " + id);
        try {
            Jgxq instance = (Jgxq) getSession()
                    .get("Jgxq", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Jgxq instance) {
        log.debug("finding Jgxq instance by example");
        try {
            List results = getSession()
                    .createCriteria("Jgxq")
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
      log.debug("finding Jgxq instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Jgxq as model where model." 
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
	
	public List findByJigoudesc(Object jigoudesc
	) {
		return findByProperty(JIGOUDESC, jigoudesc
		);
	}
	
	public List findByRecordDate(Object recordDate
	) {
		return findByProperty(RECORD_DATE, recordDate
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
		log.debug("finding all Jgxq instances");
		try {
			String queryString = "from Jgxq";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Jgxq merge(Jgxq detachedInstance) {
        log.debug("merging Jgxq instance");
        try {
            Jgxq result = (Jgxq) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Jgxq instance) {
        log.debug("attaching dirty Jgxq instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Jgxq instance) {
        log.debug("attaching clean Jgxq instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}