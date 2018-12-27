package securityccb.operate.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.khps.pojo.Khps;
import securityccb.operate.pojo.Operate;

/**
 	* A data access object (DAO) providing persistence and search support for Operate entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Operate
  * @author MyEclipse Persistence Tools 
 */

public class OperateDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(OperateDAO.class);
		//property constants
	public static final String JIGOUID = "jigouid";
	public static final String PNUMBER = "pnumber";
	public static final String OTIME = "otime";
	public static final String ODATE = "odate";
	public static final String VIEWERNUM = "viewernum";
	public static final String VIEWERNAME = "viewername";
	public static final String VIEWOPTION = "viewoption";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";
	public static final String SCORE = "score";



    
    public void save(Operate transientInstance) {
        log.debug("saving Operate instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Operate persistentInstance) {
        log.debug("deleting Operate instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Operate findById( java.lang.Integer id) {
        log.debug("getting Operate instance with id: " + id);
        try {
            Operate instance = (Operate) getSession()
                    .get("Operate", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Operate instance) {
        log.debug("finding Operate instance by example");
        try {
            List results = getSession()
                    .createCriteria("Operate")
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
      log.debug("finding Operate instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Operate as model where model." 
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
	
	public List findByPnumber(Object pnumber
	) {
		return findByProperty(PNUMBER, pnumber
		);
	}
	
	public List findByOtime(Object otime
	) {
		return findByProperty(OTIME, otime
		);
	}
	
	public List findByOdate(Object odate
	) {
		return findByProperty(ODATE, odate
		);
	}
	
	public List findByViewernum(Object viewernum
	) {
		return findByProperty(VIEWERNUM, viewernum
		);
	}
	
	public List findByViewername(Object viewername
	) {
		return findByProperty(VIEWERNAME, viewername
		);
	}
	
	public List findByViewoption(Object viewoption
	) {
		return findByProperty(VIEWOPTION, viewoption
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
	
	public List findByScore(Object score
	) {
		return findByProperty(SCORE, score
		);
	}
	

	public List findAll() {
		log.debug("finding all Operate instances");
		try {
			String queryString = "from Operate";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Operate merge(Operate detachedInstance) {
        log.debug("merging Operate instance");
        try {
            Operate result = (Operate) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Operate instance) {
        log.debug("attaching dirty Operate instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Operate instance) {
        log.debug("attaching clean Operate instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List<Khps> findAllByViewernum(String num ) {
		log.debug("finding all Operate instances");
		try {
			String queryString = "select * from khps where pnumber in(select pnumber from operate where viewernum='"+num+"' ) order by id desc";
			List<Khps> list= getSession().createSQLQuery(queryString).addEntity(Khps.class).list();
			 return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public List<Khps> findAllByjigouid(String position ) {//本机构考核事项
		log.debug("finding all Operate instances");
		try {
			String queryString = "select * from khps where jigouid='"+position.substring(0,3)+"' order by id desc";
			List<Khps> list= getSession().createSQLQuery(queryString).addEntity(Khps.class).list();
			 return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public Operate findByJgPnOtOd(String pnumber,String otime,String odate) {
		log.debug("finding all Operate instances");
		try {
			String queryString = "from Operate where pnumber='"+pnumber+"' and otime='"+otime+"' and odate='"+odate+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List<Operate> list = queryObject.list();
			 if(list.isEmpty())
			 {
				 Operate op = new Operate();
				 op.setPnumber(pnumber);
				 op.setOtime(otime);
				 op.setOdate(odate);
				 return op;
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
}