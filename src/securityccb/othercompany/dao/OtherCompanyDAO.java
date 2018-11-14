package securityccb.othercompany.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.othercompany.pojo.OtherCompany;

/**
 	* A data access object (DAO) providing persistence and search support for OtherCompany entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .OtherCompany
  * @author MyEclipse Persistence Tools 
 */

public class OtherCompanyDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(OtherCompanyDAO.class);
		//property constants
	public static final String JIGOUID = "jigouid";
	public static final String COMPANY = "company";
	public static final String DEPARTMENT = "department";
	public static final String JOB = "job";
	public static final String NAME = "name";
	public static final String TEL = "tel";
	public static final String PHONE = "phone";
	public static final String REMARK = "remark";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";



    
    public void save(OtherCompany transientInstance) {
        log.debug("saving OtherCompany instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(OtherCompany persistentInstance) {
        log.debug("deleting OtherCompany instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public OtherCompany findById( java.lang.Integer id) {
        log.debug("getting OtherCompany instance with id: " + id);
        try {
            OtherCompany instance = (OtherCompany) getSession()
                    .get("OtherCompany", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(OtherCompany instance) {
        log.debug("finding OtherCompany instance by example");
        try {
            List results = getSession()
                    .createCriteria("OtherCompany")
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
      log.debug("finding OtherCompany instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from OtherCompany as model where model." 
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
	
	public List findByCompany(Object company
	) {
		return findByProperty(COMPANY, company
		);
	}
	
	public List findByDepartment(Object department
	) {
		return findByProperty(DEPARTMENT, department
		);
	}
	
	public List findByJob(Object job
	) {
		return findByProperty(JOB, job
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByTel(Object tel
	) {
		return findByProperty(TEL, tel
		);
	}
	
	public List findByPhone(Object phone
	) {
		return findByProperty(PHONE, phone
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
	

	public List findAll() {
		log.debug("finding all OtherCompany instances");
		try {
			String queryString = "from OtherCompany";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public OtherCompany merge(OtherCompany detachedInstance) {
        log.debug("merging OtherCompany instance");
        try {
            OtherCompany result = (OtherCompany) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(OtherCompany instance) {
        log.debug("attaching dirty OtherCompany instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(OtherCompany instance) {
        log.debug("attaching clean OtherCompany instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}