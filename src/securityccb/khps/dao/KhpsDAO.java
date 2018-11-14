package securityccb.khps.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.jigou.pojo.JiGou;
import securityccb.khps.pojo.Khps;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;

/**
 	* A data access object (DAO) providing persistence and search support for Khps entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Khps
  * @author MyEclipse Persistence Tools 
 */

public class KhpsDAO extends BaseHibernateDAO  {
	private static final Logger log = LoggerFactory.getLogger(KhpsDAO.class);
		
	public static final String JIGOUID = "jigouid";
	public static final String PNUMBER = "pnumber";
	public static final String ITEM = "item";
	public static final String DATE = "date";
	public static final String JINDU = "jindu";
	public static final String STATUS = "status";
	public static final String PREUNDER = "preunder";
	public static final String THISUNDER = "thisunder";
	public static final String INITIATOR = "initiator";
	public static final String NAME = "name";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";
	public static final String SCORE = "score";



    
    public void save(Khps transientInstance) {
        log.debug("saving Khps instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Khps persistentInstance) {
        log.debug("deleting Khps instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Khps findById( java.lang.Integer id) {
        log.debug("getting Khps instance with id: " + id);
        try {
            Khps instance = (Khps) getSession()
                    .get("Khps", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Khps instance) {
        log.debug("finding Khps instance by example");
        try {
            List results = getSession()
                    .createCriteria("Khps")
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
      log.debug("finding Khps instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Khps as model where model." 
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
	
	public List findByItem(Object item
	) {
		return findByProperty(ITEM, item
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByJindu(Object jindu
	) {
		return findByProperty(JINDU, jindu
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	
	public List findByPreunder(Object preunder
	) {
		return findByProperty(PREUNDER, preunder
		);
	}
	
	public List findByThisunder(Object thisunder
	) {
		return findByProperty(THISUNDER, thisunder
		);
	}
	
	public List findByInitiator(Object initiator
	) {
		return findByProperty(INITIATOR, initiator
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
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
		log.debug("finding all Khps instances");
		try {
			String queryString = "from Khps";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Khps merge(Khps detachedInstance) {
        log.debug("merging Khps instance");
        try {
            Khps result = (Khps) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Khps instance) {
        log.debug("attaching dirty Khps instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Khps instance) {
        log.debug("attaching clean Khps instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    //本人代处理审批
    public List<Khps> findUndoByThisunder(String newnumber) {
		log.debug("finding all Khps instances");
		try {
					
			String queryString = "select * from khps where status not in('4') and thisunder='"+newnumber+"'";
			List<Khps> list = getSession().createSQLQuery(queryString).addEntity(Khps.class).list();
			 return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    //总行安保处长待处理审批
    public List<Khps> findUndoByZhcz(String newnumber) {
		log.debug("finding all Khps instances");
		try {
					
			String queryString = "select * from khps where status not in('4') and thisunder='"+newnumber+"' " +
					"and ((item='2' and jindu<='7') or (item='1' and jindu<='5'))";
			List<Khps> list = getSession().createSQLQuery(queryString).addEntity(Khps.class).list();
			 return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public Khps findAllByPnumber(String pnum) {
		log.debug("finding all Khps instances");
		try {
			String queryString = "from Khps where pnumber='"+pnum+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List<Khps> list = queryObject.list();
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
			throw re;}
		}
	//查询未开始的list
    public  List<JiGou>  findwaitlist() {
		
		try {
			 String queryString = "select * from jigou  where jigouid not in(select jigouid from " +
			 		"khps )  and jigouid!='000'";
	        
			 List<JiGou> list = getSession().createSQLQuery(queryString).addEntity(JiGou.class).list();
			 
				 return list;
			 
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
}
    //查询所有流转中的list
    public  List<Khps>  findlzlist() {
		log.debug("finding all Khps instances");
		try {
			 String queryString = "from Khps where status ='1' and ((item='2' and jindu <'8')) or (item='1' and jindu <'6'))";
	         Query queryObject = getSession().createQuery(queryString);
			 List<Khps> list = queryObject.list();
			 return list;
			 
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
}
		//查询所有流转到安保部处长名下待推送刘总的list
	    public  List<Khps>  findUnflist() {
			log.debug("finding all Khps instances");
			try {
				 String queryString = "from Khps where status ='1' and ((item='2' and jindu in('8')) or (item='1' and jindu in('6')))";
		         Query queryObject = getSession().createQuery(queryString);
				 List<Khps> list = queryObject.list();
				 return list;
				 
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
	}
	    //查询所有已经推送刘总待刘总审批
	    public  List<Khps>  findwaitsplist() {
			log.debug("finding all Khps instances");
			try {
				 String queryString = "from Khps where status ='1' and ((item='2' and jindu in('9')) or (item='1' and jindu in('7')))";
		         Query queryObject = getSession().createQuery(queryString);
				 List<Khps> list = queryObject.list();
				 return list;
				 
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
	}
	
	    
	  //查询所有到已完成审批的list
	    public  List<Khps>  findflist() {
			log.debug("finding all Khps instances");
			try {
				 String queryString = "from Khps where status ='4'";
		         Query queryObject = getSession().createQuery(queryString);
		         List<Khps> list = queryObject.list();
				 
		         return list;
				 
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
	}
	    public Khps findByJgidAndYear(String jigouid,String year) {
			log.debug("finding all Khps instances");
			try {
				String queryString = "from Khps where jigouid='"+jigouid+"' and remark3='"+year+"'";
		         Query queryObject = getSession().createQuery(queryString);
				 List list = queryObject.list();
				 if(list.isEmpty())
				 {
					 return null;
				 }
				 else
				 {
					 return (Khps) list.get(0);
				 }
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}  
}