package securityccb.userinfo.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.userinfo.pojo.Fankui;

/**
 	* A data access object (DAO) providing persistence and search support for Fankui entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Fankui
  * @author MyEclipse Persistence Tools 
 */

public class FankuiDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(FankuiDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String TIME = "time";
	public static final String NEWNUMBER = "newnumber";
	public static final String JIGOU = "jigou";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String FUJIAN = "fujian";



    
    public void save(Fankui transientInstance) {
        log.debug("saving Fankui instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Fankui persistentInstance) {
        log.debug("deleting Fankui instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Fankui findById( java.lang.Integer id) {
        log.debug("getting Fankui instance with id: " + id);
        try {
            Fankui instance = (Fankui) getSession()
                    .get("Fankui", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Fankui instance) {
        log.debug("finding Fankui instance by example");
        try {
            List results = getSession()
                    .createCriteria("Fankui")
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
      log.debug("finding Fankui instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Fankui as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByTime(Object time
	) {
		return findByProperty(TIME, time
		);
	}
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByJigou(Object jigou
	) {
		return findByProperty(JIGOU, jigou
		);
	}
	
	public List findByTitle(Object title
	) {
		return findByProperty(TITLE, title
		);
	}
	
	public List findByContent(Object content
	) {
		return findByProperty(CONTENT, content
		);
	}
	
	public List findByFujian(Object fujian
	) {
		return findByProperty(FUJIAN, fujian
		);
	}
	

	public List findAll() {
		log.debug("finding all Fankui instances");
		try {
			String queryString = "from Fankui";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Fankui merge(Fankui detachedInstance) {
        log.debug("merging Fankui instance");
        try {
            Fankui result = (Fankui) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Fankui instance) {
        log.debug("attaching dirty Fankui instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Fankui instance) {
        log.debug("attaching clean Fankui instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}