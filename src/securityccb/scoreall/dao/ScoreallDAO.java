package securityccb.scoreall.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.scoreall.pojo.Scoreall;

/**
 	* A data access object (DAO) providing persistence and search support for Scoreall entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Scoreall
  * @author MyEclipse Persistence Tools 
 */

public class ScoreallDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ScoreallDAO.class);
		//property constants
	public static final String PNUMBER = "pnumber";
	public static final String A1 = "a1";
	public static final String A2 = "a2";
	public static final String A3 = "a3";
	public static final String A4 = "a4";
	public static final String A5 = "a5";
	public static final String A6 = "a6";
	public static final String A7 = "a7";
	public static final String A8 = "a8";
	public static final String A9 = "a9";
	public static final String A10 = "a10";
	public static final String A11 = "a11";
	public static final String A12 = "a12";
	public static final String A13 = "a13";
	public static final String A14 = "a14";
	public static final String A15 = "a15";
	public static final String A16 = "a16";
	public static final String A17 = "a17";
	public static final String A18 = "a18";
	public static final String A19 = "a19";
	public static final String A20 = "a20";
	public static final String A21 = "a21";
	public static final String A22 = "a22";
	public static final String A23 = "a23";
	public static final String A24 = "a24";
	public static final String A25 = "a25";
	public static final String A26 = "a26";
	public static final String A27 = "a27";
	public static final String A28 = "a28";
	public static final String A29 = "a29";
	public static final String A30 = "a30";
	public static final String A31 = "a31";
	public static final String A32 = "a32";
	public static final String A33 = "a33";
	public static final String A34 = "a34";
	public static final String A35 = "a35";
	public static final String A36 = "a36";
	public static final String A37 = "a37";
	public static final String A38 = "a38";
	public static final String A39 = "a39";



    
    public void save(Scoreall transientInstance) {
        log.debug("saving Scoreall instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Scoreall persistentInstance) {
        log.debug("deleting Scoreall instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Scoreall findById( java.lang.Integer id) {
        log.debug("getting Scoreall instance with id: " + id);
        try {
            Scoreall instance = (Scoreall) getSession()
                    .get("Scoreall", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Scoreall instance) {
        log.debug("finding Scoreall instance by example");
        try {
            List results = getSession()
                    .createCriteria("Scoreall")
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
      log.debug("finding Scoreall instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Scoreall as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPnumber(Object pnumber
	) {
		return findByProperty(PNUMBER, pnumber
		);
	}
	
	public List findByA1(Object a1
	) {
		return findByProperty(A1, a1
		);
	}
	
	public List findByA2(Object a2
	) {
		return findByProperty(A2, a2
		);
	}
	
	public List findByA3(Object a3
	) {
		return findByProperty(A3, a3
		);
	}
	
	public List findByA4(Object a4
	) {
		return findByProperty(A4, a4
		);
	}
	
	public List findByA5(Object a5
	) {
		return findByProperty(A5, a5
		);
	}
	
	public List findByA6(Object a6
	) {
		return findByProperty(A6, a6
		);
	}
	
	public List findByA7(Object a7
	) {
		return findByProperty(A7, a7
		);
	}
	
	public List findByA8(Object a8
	) {
		return findByProperty(A8, a8
		);
	}
	
	public List findByA9(Object a9
	) {
		return findByProperty(A9, a9
		);
	}
	
	public List findByA10(Object a10
	) {
		return findByProperty(A10, a10
		);
	}
	
	public List findByA11(Object a11
	) {
		return findByProperty(A11, a11
		);
	}
	
	public List findByA12(Object a12
	) {
		return findByProperty(A12, a12
		);
	}
	
	public List findByA13(Object a13
	) {
		return findByProperty(A13, a13
		);
	}
	
	public List findByA14(Object a14
	) {
		return findByProperty(A14, a14
		);
	}
	
	public List findByA15(Object a15
	) {
		return findByProperty(A15, a15
		);
	}
	
	public List findByA16(Object a16
	) {
		return findByProperty(A16, a16
		);
	}
	
	public List findByA17(Object a17
	) {
		return findByProperty(A17, a17
		);
	}
	
	public List findByA18(Object a18
	) {
		return findByProperty(A18, a18
		);
	}
	
	public List findByA19(Object a19
	) {
		return findByProperty(A19, a19
		);
	}
	
	public List findByA20(Object a20
	) {
		return findByProperty(A20, a20
		);
	}
	
	public List findByA21(Object a21
	) {
		return findByProperty(A21, a21
		);
	}
	
	public List findByA22(Object a22
	) {
		return findByProperty(A22, a22
		);
	}
	
	public List findByA23(Object a23
	) {
		return findByProperty(A23, a23
		);
	}
	
	public List findByA24(Object a24
	) {
		return findByProperty(A24, a24
		);
	}
	
	public List findByA25(Object a25
	) {
		return findByProperty(A25, a25
		);
	}
	
	public List findByA26(Object a26
	) {
		return findByProperty(A26, a26
		);
	}
	
	public List findByA27(Object a27
	) {
		return findByProperty(A27, a27
		);
	}
	
	public List findByA28(Object a28
	) {
		return findByProperty(A28, a28
		);
	}
	
	public List findByA29(Object a29
	) {
		return findByProperty(A29, a29
		);
	}
	
	public List findByA30(Object a30
	) {
		return findByProperty(A30, a30
		);
	}
	
	public List findByA31(Object a31
	) {
		return findByProperty(A31, a31
		);
	}
	
	public List findByA32(Object a32
	) {
		return findByProperty(A32, a32
		);
	}
	
	public List findByA33(Object a33
	) {
		return findByProperty(A33, a33
		);
	}
	
	public List findByA34(Object a34
	) {
		return findByProperty(A34, a34
		);
	}
	
	public List findByA35(Object a35
	) {
		return findByProperty(A35, a35
		);
	}
	
	public List findByA36(Object a36
	) {
		return findByProperty(A36, a36
		);
	}
	
	public List findByA37(Object a37
	) {
		return findByProperty(A37, a37
		);
	}
	
	public List findByA38(Object a38
	) {
		return findByProperty(A38, a38
		);
	}
	
	public List findByA39(Object a39
	) {
		return findByProperty(A39, a39
		);
	}
	

	public List findAll() {
		log.debug("finding all Scoreall instances");
		try {
			String queryString = "from Scoreall";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Scoreall merge(Scoreall detachedInstance) {
        log.debug("merging Scoreall instance");
        try {
            Scoreall result = (Scoreall) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Scoreall instance) {
        log.debug("attaching dirty Scoreall instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Scoreall instance) {
        log.debug("attaching clean Scoreall instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}