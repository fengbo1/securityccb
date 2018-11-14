package securityccb.plan.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.plan.pojo.Plan;

/**
 	* A data access object (DAO) providing persistence and search support for Plan entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Plan
  * @author MyEclipse Persistence Tools 
 */

public class PlanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(PlanDAO.class);
		//property constants
	public static final String JIGOUID = "jigouid";
	public static final String YEAR = "year";
	public static final String WEEK = "week";
	public static final String MONTH = "month";
	public static final String CONTENT = "content";
	public static final String RESULT = "result";
	public static final String PEOPLE = "people";
	public static final String REMARK = "remark";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";



    
    public void save(Plan transientInstance) {
        log.debug("saving Plan instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Plan persistentInstance) {
        log.debug("deleting Plan instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Plan findById( java.lang.Integer id) {
        log.debug("getting Plan instance with id: " + id);
        try {
            Plan instance = (Plan) getSession()
                    .get("Plan", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Plan instance) {
        log.debug("finding Plan instance by example");
        try {
            List results = getSession()
                    .createCriteria("Plan")
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
      log.debug("finding Plan instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Plan as model where model." 
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
	
	public List findByYear(Object year
	) {
		return findByProperty(YEAR, year
		);
	}
	
	public List findByWeek(Object week
	) {
		return findByProperty(WEEK, week
		);
	}
	
	public List findByMonth(Object month
	) {
		return findByProperty(MONTH, month
		);
	}
	
	public List findByContent(Object content
	) {
		return findByProperty(CONTENT, content
		);
	}
	
	public List findByResult(Object result
	) {
		return findByProperty(RESULT, result
		);
	}
	
	public List findByPeople(Object people
	) {
		return findByProperty(PEOPLE, people
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
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
	
	public List findByRemark3(Object remark3
	) {
		return findByProperty(REMARK3, remark3
		);
	}
	

	public List findAll() {
		log.debug("finding all Plan instances");
		try {
			String queryString = "from Plan";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Plan merge(Plan detachedInstance) {
        log.debug("merging Plan instance");
        try {
            Plan result = (Plan) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Plan instance) {
        log.debug("attaching dirty Plan instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Plan instance) {
        log.debug("attaching clean Plan instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}