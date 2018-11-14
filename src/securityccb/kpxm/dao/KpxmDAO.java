package securityccb.kpxm.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.kpxm.pojo.Kpxm;

/**
 	* A data access object (DAO) providing persistence and search support for Kpxm entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Kpxm
  * @author MyEclipse Persistence Tools 
 */

public class KpxmDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(KpxmDAO.class);
		//property constants
	public static final String KHXM = "khxm";
	public static final String XM = "xm";
	public static final String NUM = "num";
	public static final String STDSCORE = "stdscore";
	public static final String KHNR = "khnr";
	public static final String PFBZ = "pfbz";
	public static final String PFQD = "pfqd";
	public static final String REMARK = "remark";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";



    
    public void save(Kpxm transientInstance) {
        log.debug("saving Kpxm instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Kpxm persistentInstance) {
        log.debug("deleting Kpxm instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Kpxm findById( java.lang.Integer id) {
        log.debug("getting Kpxm instance with id: " + id);
        try {
            Kpxm instance = (Kpxm) getSession()
                    .get("Kpxm", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Kpxm instance) {
        log.debug("finding Kpxm instance by example");
        try {
            List results = getSession()
                    .createCriteria("Kpxm")
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
      log.debug("finding Kpxm instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Kpxm as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByKhxm(Object khxm
	) {
		return findByProperty(KHXM, khxm
		);
	}
	
	public List findByXm(Object xm
	) {
		return findByProperty(XM, xm
		);
	}
	
	public List findByNum(Object num
	) {
		return findByProperty(NUM, num
		);
	}
	
	public List findByStdscore(Object stdscore
	) {
		return findByProperty(STDSCORE, stdscore
		);
	}
	
	public List findByKhnr(Object khnr
	) {
		return findByProperty(KHNR, khnr
		);
	}
	
	public List findByPfbz(Object pfbz
	) {
		return findByProperty(PFBZ, pfbz
		);
	}
	
	public List findByPfqd(Object pfqd
	) {
		return findByProperty(PFQD, pfqd
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
		log.debug("finding all Kpxm instances");
		try {
			String queryString = "from Kpxm";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Kpxm merge(Kpxm detachedInstance) {
        log.debug("merging Kpxm instance");
        try {
            Kpxm result = (Kpxm) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Kpxm instance) {
        log.debug("attaching dirty Kpxm instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Kpxm instance) {
        log.debug("attaching clean Kpxm instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    
    
	public List findAllOrder() {
		log.debug("finding all Kpxm instances");
		try {
			String queryString = "from Kpxm order by xm,num";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public Kpxm findByItemAndNum(String item,int num) {
		log.debug("finding all Kpxm instances");
		try {
			String queryString = "from Kpxm where khxm='"+item+"' and num='"+num+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return new Kpxm();
			 }
			 else
			 {
				 return (Kpxm) list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}