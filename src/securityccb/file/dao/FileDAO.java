package securityccb.file.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.file.pojo.File;

/**
 	* A data access object (DAO) providing persistence and search support for File entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .File
  * @author MyEclipse Persistence Tools 
 */

public class FileDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(FileDAO.class);
		//property constants
	public static final String JIGOUID = "jigouid";
	public static final String TYPE = "type";
	public static final String TITLE = "title";
	public static final String URL = "url";
	public static final String URL1 = "url1";



    
    public void save(File transientInstance) {
        log.debug("saving File instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(File persistentInstance) {
        log.debug("deleting File instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public File findById( java.lang.Integer id) {
        log.debug("getting File instance with id: " + id);
        try {
            File instance = (File) getSession()
                    .get("File", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(File instance) {
        log.debug("finding File instance by example");
        try {
            List results = getSession()
                    .createCriteria("File")
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
      log.debug("finding File instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from File as model where model." 
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
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByTitle(Object title
	) {
		return findByProperty(TITLE, title
		);
	}
	
	public List findByUrl(Object url
	) {
		return findByProperty(URL, url
		);
	}
	
	public List findByUrl1(Object url1
	) {
		return findByProperty(URL1, url1
		);
	}
	

	public List findAll() {
		log.debug("finding all File instances");
		try {
			String queryString = "from File";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public File merge(File detachedInstance) {
        log.debug("merging File instance");
        try {
            File result = (File) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(File instance) {
        log.debug("attaching dirty File instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(File instance) {
        log.debug("attaching clean File instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}