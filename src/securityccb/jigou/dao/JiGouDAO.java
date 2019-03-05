package securityccb.jigou.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.chu.pojo.Chu;
import securityccb.jigou.pojo.JiGou;

/**
 	* A data access object (DAO) providing persistence and search support for JiGou entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .JiGou
  * @author MyEclipse Persistence Tools 
 */

public class JiGouDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(JiGouDAO.class);
		//property constants
	public static final String JIGOU = "jigou";
	public static final String JIGOUID = "jigouid";
	public static final String QUANXIAN = "quanxian";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";
	public static final String REMARK4 = "remark4";
	public static final String REMARK5 = "remark5";



    
    public void save(JiGou transientInstance) {
        log.debug("saving JiGou instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(JiGou persistentInstance) {
        log.debug("deleting JiGou instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public JiGou findById( java.lang.Integer id) {
        log.debug("getting JiGou instance with id: " + id);
        try {
            JiGou instance = (JiGou) getSession()
                    .get("JiGou", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(JiGou instance) {
        log.debug("finding JiGou instance by example");
        try {
            List results = getSession()
                    .createCriteria("JiGou")
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
      log.debug("finding JiGou instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from JiGou as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByJigou(Object jigou
	) {
		return findByProperty(JIGOU, jigou
		);
	}
	
	public List findByJigouid(Object jigouid
	) {
		return findByProperty(JIGOUID, jigouid
		);
	}
	
	public List findByQuanxian(Object quanxian
	) {
		return findByProperty(QUANXIAN, quanxian
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
	
	public List findByRemark4(Object remark4
	) {
		return findByProperty(REMARK4, remark4
		);
	}
	
	public List findByRemark5(Object remark5
	) {
		return findByProperty(REMARK5, remark5
		);
	}
	

	public List findAll() {
		log.debug("finding all JiGou instances");
		try {
			String queryString = "from JiGou";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public JiGou merge(JiGou detachedInstance) {
        log.debug("merging JiGou instance");
        try {
            JiGou result = (JiGou) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(JiGou instance) {
        log.debug("attaching dirty JiGou instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(JiGou instance) {
        log.debug("attaching clean JiGou instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public String findSubByJigou(String jg) {
		log.debug("finding all JiGou instances");
		try {
			String queryString = "from JiGou where jigouid='"+jg+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List<JiGou> list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				return list.get(0).getQuanxian(); 
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAllPinfenJigou() {
		log.debug("finding all JiGou instances");
		try {
			String queryString = "from JiGou as jg where jg.jigouid!='00'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findByJigouid(String jgid) {
		log.debug("finding all JiGou instances");
		try {
			String queryString = "from JiGou where jigouid='"+jgid+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public String findJigouidByChuid(String chushiid) {////通过处室ID查询机构ID
		log.debug("finding all JiGou instances");
		try {
			String queryString = "from Chu where chushiid = '"+chushiid+"'";		
	         Query queryObject = getSession().createQuery(queryString);
			 List<Chu> list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				return list.get(0).getJigouid(); 
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public String findJigouNameByJigouid(String jigouid) {
		log.debug("finding all JiGou instances");
		try {
			String queryString = "from JiGou where jigouid = '"+jigouid+"'";		
	         Query queryObject = getSession().createQuery(queryString);
			 List<JiGou> list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				return list.get(0).getJigou(); 
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public JiGou findJigouByJigouname(String jigouname) {
		log.debug("finding all JiGou instances");
		try {
			String queryString = "from JiGou where jigou = '"+jigouname+"'";		
	         Query queryObject = getSession().createQuery(queryString);
			 List<JiGou> list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				return list.get(0); 
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public JiGou findJigouByJigouid(String jigouid) {
		log.debug("finding all JiGou instances");
		try {
			String queryString = "from JiGou where jigouid = '"+jigouid+"'";		
	         Query queryObject = getSession().createQuery(queryString);
			 List<JiGou> list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				return list.get(0); 
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public JiGou findJigouByJigouidNullNew(String jigouid) {
		log.debug("finding all JiGou instances");
		try {
			String queryString = "from JiGou where jigouid = '"+jigouid+"'";		
	         Query queryObject = getSession().createQuery(queryString);
			 List<JiGou> list = queryObject.list();
			 if(list.isEmpty())
			 {
				 JiGou jg = new JiGou();
				 jg.setJigouid(jigouid);
				 return jg;
			 }
			 else
			 {
				return list.get(0); 
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public String findMaxJigou() {
		log.debug("finding all JiGou instances");
		try {
			int max = 1;
			String sql = "SELECT max(jigouid) from jigou";		
	         Object obj = getSession().createSQLQuery(sql).uniqueResult();
	         if(obj!=null)
	         {
	        	 max = Integer.valueOf(obj.toString());
	        	 max+=1;
	         }
	         if(max<100)
	         {
	        	 return "0"+max;
	         }
	         else if(max<10)
	         {
	        	return "00"+max; 
	         }
	         else
	         {
	        	 return String.valueOf(max);
	         }
	         
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}