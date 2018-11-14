package securityccb.record.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.record.pojo.Record;

/**
 	* A data access object (DAO) providing persistence and search support for Record entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Record
  * @author MyEclipse Persistence Tools 
 */

public class RecordDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(RecordDAO.class);
		//property constants
	public static final String JIGOUID = "jigouid";
	public static final String SYSSUM = "syssum";
	public static final String TYPE = "type";
	public static final String TITLE = "title";
	public static final String CONTENT1 = "content1";
	public static final String CONTENT2 = "content2";
	public static final String PEOPLE = "people";
	public static final String REMARK = "remark";
	public static final String URL1 = "url1";
	public static final String URL2 = "url2";
	public static final String URL3 = "url3";
	public static final String URL4 = "url4";
	public static final String URL5 = "url5";
	public static final String URL6 = "url6";
	public static final String URL7 = "url7";
	public static final String URL8 = "url8";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";
	public static final String REMARK4 = "remark4";



    
    public void save(Record transientInstance) {
        log.debug("saving Record instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Record persistentInstance) {
        log.debug("deleting Record instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Record findById( java.lang.Integer id) {
        log.debug("getting Record instance with id: " + id);
        try {
            Record instance = (Record) getSession()
                    .get("Record", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Record instance) {
        log.debug("finding Record instance by example");
        try {
            List results = getSession()
                    .createCriteria("Record")
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
      log.debug("finding Record instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Record as model where model." 
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
	
	public List findBySyssum(Object syssum
	) {
		return findByProperty(SYSSUM, syssum
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
	
	public List findByContent1(Object content1
	) {
		return findByProperty(CONTENT1, content1
		);
	}
	
	public List findByContent2(Object content2
	) {
		return findByProperty(CONTENT2, content2
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
	
	public List findByUrl1(Object url1
	) {
		return findByProperty(URL1, url1
		);
	}
	
	public List findByUrl2(Object url2
	) {
		return findByProperty(URL2, url2
		);
	}
	
	public List findByUrl3(Object url3
	) {
		return findByProperty(URL3, url3
		);
	}
	
	public List findByUrl4(Object url4
	) {
		return findByProperty(URL4, url4
		);
	}
	
	public List findByUrl5(Object url5
	) {
		return findByProperty(URL5, url5
		);
	}
	
	public List findByUrl6(Object url6
	) {
		return findByProperty(URL6, url6
		);
	}
	
	public List findByUrl7(Object url7
	) {
		return findByProperty(URL7, url7
		);
	}
	
	public List findByUrl8(Object url8
	) {
		return findByProperty(URL8, url8
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
	

	public List findAll() {
		log.debug("finding all Record instances");
		try {
			String queryString = "from Record";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Record merge(Record detachedInstance) {
        log.debug("merging Record instance");
        try {
            Record result = (Record) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Record instance) {
        log.debug("attaching dirty Record instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Record instance) {
        log.debug("attaching clean Record instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public Record findAllById(String id) {
		log.debug("finding all Record instances");
		try {
			String queryString = "from Record where id='"+id+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<Record> list = queryObject.list();
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
    
    public List findAllByJiGouYearItem(String jg,String year,String item) {
		log.debug("finding all Record instances");
		try {
			String queryString = "from Record as r where r.jigouid='"+jg+"' and MID(r.date,1,4)='"+year+"' and r.type='"+item+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}