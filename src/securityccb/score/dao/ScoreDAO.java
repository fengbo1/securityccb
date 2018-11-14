package securityccb.score.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import ccb.hibernate.HibernateSessionFactory;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.kpxm.dao.KpxmDAO;
import securityccb.kpxm.pojo.Kpxm;
import securityccb.score.pojo.Score;
import securityccb.util.KhpsUtil;

/**
 	* A data access object (DAO) providing persistence and search support for Score entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Score
  * @author MyEclipse Persistence Tools 
 */

public class ScoreDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ScoreDAO.class);
		//property constants
	public static final String YEAR = "year";
	public static final String PNUMBER = "pnumber";
	public static final String SUB = "sub";
	public static final String NEWNUMBER = "newnumber";
	public static final String JIGOUID = "jigouid";
	public static final String ITEM = "item";
	public static final String NUM = "num";
	public static final String INDX = "indx";
	public static final String SCORE = "score";
	public static final String SCORETEMP = "scoretemp";
	public static final String IFABB = "ifabb";
	public static final String IFXZ = "ifxz";
	public static final String STDSCORE = "stdscore";
	public static final String YUANSCORE = "yuanscore";
	public static final String XZREASON = "xzreason";
	public static final String REMARK = "remark";
	public static final String REMARKTEMP = "remarktemp";



    
    public void save(Score transientInstance) {
        log.debug("saving Score instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Score persistentInstance) {
        log.debug("deleting Score instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Score findById( java.lang.Integer id) {
        log.debug("getting Score instance with id: " + id);
        try {
            Score instance = (Score) getSession()
                    .get("Score", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Score instance) {
        log.debug("finding Score instance by example");
        try {
            List results = getSession()
                    .createCriteria("Score")
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
      log.debug("finding Score instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Score as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByYear(Object year
	) {
		return findByProperty(YEAR, year
		);
	}
	
	public List findByPnumber(Object pnumber
	) {
		return findByProperty(PNUMBER, pnumber
		);
	}
	
	public List findBySub(Object sub
	) {
		return findByProperty(SUB, sub
		);
	}
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByJigouid(Object jigouid
	) {
		return findByProperty(JIGOUID, jigouid
		);
	}
	
	public List findByItem(Object item
	) {
		return findByProperty(ITEM, item
		);
	}
	
	public List findByNum(Object num
	) {
		return findByProperty(NUM, num
		);
	}
	
	public List findByIndx(Object indx
	) {
		return findByProperty(INDX, indx
		);
	}
	
	public List findByScore(Object score
	) {
		return findByProperty(SCORE, score
		);
	}
	
	public List findByScoretemp(Object scoretemp
	) {
		return findByProperty(SCORETEMP, scoretemp
		);
	}
	
	public List findByIfabb(Object ifabb
	) {
		return findByProperty(IFABB, ifabb
		);
	}
	
	public List findByIfxz(Object ifxz
	) {
		return findByProperty(IFXZ, ifxz
		);
	}
	
	public List findByStdscore(Object stdscore
	) {
		return findByProperty(STDSCORE, stdscore
		);
	}
	
	public List findByYuanscore(Object yuanscore
	) {
		return findByProperty(YUANSCORE, yuanscore
		);
	}
	
	public List findByXzreason(Object xzreason
	) {
		return findByProperty(XZREASON, xzreason
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	
	public List findByRemarktemp(Object remarktemp
	) {
		return findByProperty(REMARKTEMP, remarktemp
		);
	}
	

	public List findAll() {
		log.debug("finding all Score instances");
		try {
			String queryString = "from Score";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Score merge(Score detachedInstance) {
        log.debug("merging Score instance");
        try {
            Score result = (Score) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Score instance) {
        log.debug("attaching dirty Score instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Score instance) {
        log.debug("attaching clean Score instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public Score findAllById(int id) {
    	log.debug("finding all Score instances");
    	try {
    		String queryString = "from Score where id='"+id+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List<Score> list = queryObject.list();
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
    public double findSumByYearAndJigou(String jg,String year,String key) {
    	log.debug("finding all Score instances");
    	try {
    		double result = 0.0;
    		String queryString = "select sum("+key+") from score where jigouid='"+jg+"' and year='"+year+"' and item!='ypfj'";
             Object obj = getSession().createSQLQuery(queryString).uniqueResult();
             queryString = "select sum("+key+") from score where jigouid='"+jg+"' and year='"+year+"' and item='ypfj'";
             Object obj2 = getSession().createSQLQuery(queryString).uniqueResult();
             queryString = "select sum(stdscore) from score where jigouid='"+jg+"' and year='"+year+"' and indx<36 and ifxz=1";
             Object obj3 = getSession().createSQLQuery(queryString).uniqueResult();
             queryString = "select sum(yuanscore) from score where jigouid='"+jg+"' and year='"+year+"' and indx<36";
             Object obj4 = getSession().createSQLQuery(queryString).uniqueResult();
             if(obj==null)
             {
            	 result= 0.0;
             }
             else
             {
            	 result = KhpsUtil.DoubleTo1(Double.valueOf(obj.toString()));
            	 result = result+Double.valueOf(obj4.toString())-Double.valueOf(obj3.toString());
            	 result = result<0?0:result;
            	 if(obj2!=null)
            	 {
            		 double temp = Double.valueOf(obj2.toString());
            		 if(temp>0)
            		 {
            			 result=result>60?59:result;
            		 }
            	 }
             }
             return result;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public double findSumByPnumber(String pnumber,String key) {
    	log.debug("finding all Score instances");
    	try {
    		double result = 0.0;
    		String queryString = "select sum("+key+") from score where pnumber='"+pnumber+"' and item!='ypfj'";
             Object obj = getSession().createSQLQuery(queryString).uniqueResult();
             queryString = "select sum("+key+") from score where pnumber='"+pnumber+"' and item='ypfj'";
             Object obj2 = getSession().createSQLQuery(queryString).uniqueResult();
             queryString = "select sum(stdscore) from score where pnumber='"+pnumber+"' and indx<36 and ifxz=1";//选择的分
             Object obj3 = getSession().createSQLQuery(queryString).uniqueResult();
             queryString = "select sum(yuanscore) from score where pnumber='"+pnumber+"' and indx<36";//85分
             Object obj4 = getSession().createSQLQuery(queryString).uniqueResult();
             if(obj==null)
             {
            	 result= 0.0;
             }
             else
             {
            	 result = KhpsUtil.DoubleTo1(Double.valueOf(obj.toString()));
            	 result = result+Double.valueOf(obj4.toString())-Double.valueOf(obj3.toString());
            	 result = result<0?0:result;
            	 if(obj2!=null)
            	 {
            		 double temp = Double.valueOf(obj2.toString());
            		 if(temp>0)
            		 {
            			 result=result>60?59:result;
            		 }
            	 }
             }
             return result;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public double findSumTempByPnumber1(String pnumber) {
    	log.debug("finding all Score instances");
    	try {
    		double result = 0.0;
    		String queryString = "select sum(scoretemp) from score where pnumber='"+pnumber+"' and item!='ypfj'";
             Object obj = getSession().createSQLQuery(queryString).uniqueResult();
             queryString = "select sum(scoretemp) from score where pnumber='"+pnumber+"' and item='ypfj'";
             Object obj2 = getSession().createSQLQuery(queryString).uniqueResult();
             if(obj==null)
             {
            	 result= 0.0;
             }
             else
             {
            	 result = KhpsUtil.DoubleTo1(Double.valueOf(obj.toString()));
            	 if(obj2!=null)
            	 {
            		 double temp = Double.valueOf(obj2.toString());
            		 if(temp>0)
            		 {
            			 result=result>60?59:result;
            		 }
            	 }
             }
             return result;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllByPnumber(String pnumber) {
    	log.debug("finding all Score instances");
    	try {
    		String queryString = "from Score where pnumber='"+pnumber+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllByJgAndYear(String jg,String year) {
    	log.debug("finding all Score instances");
    	try {
    		String queryString = "from Score where jigouid='"+jg+"' and year='"+year+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllByPnumberAndItem(String pnumber,String item) {
    	log.debug("finding all Score instances");
    	try {
    		String queryString = "from Score where pnumber='"+pnumber+"' and item='"+item+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllByJgidAndYearAndItem(String jigouid,String year,String item) {
    	log.debug("finding all Score instances");
    	try {
    		String queryString = "from Score where jigouid='"+jigouid+"' and year='"+year+"' and item='"+item+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllByJgAndYearAndItem(String jg,String year,String item) {
    	log.debug("finding all Score instances");
    	try {
    		String queryString = "from Score where jigouid='"+jg+"' and year='"+year+"' and item='"+item+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public String updateTempToScore(String pnumber,String year,String jigouid)
    {
    	String sql = "";
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		if(pnumber.equals("kong")||pnumber.equals(""))
    		{
    			sql = "update score set score=scoretemp,remark=remarktemp where year='"+year+"' and jigouid='"+jigouid+"'";	
    		}
    		else
    		{
    			sql = "update score set score=scoretemp,remark=remarktemp where pnumber='"+pnumber+"'";
    		}
    		session.createSQLQuery(sql).executeUpdate();
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	}finally{
    		trans.commit();
    		session.flush();
    		session.clear();
    		session.close();
    	}
        
    	return "success";
    }
    public String updateScoreToTemp(String pnumber,String year,String jigouid)
    {
    	String sql = "";
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		if(pnumber.equals("kong")||pnumber.equals(""))
    		{
    			sql = "update score set scoretemp=score,remarktemp=remark where year='"+year+"' and jigouid='"+jigouid+"'";
    		}
    		else
    		{
    			sql = "update score set scoretemp=score,remarktemp=remark where pnumber='"+pnumber+"'";
    		}
    		session.createSQLQuery(sql).executeUpdate();
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	}finally{
    		trans.commit();
    		session.flush();
    		session.clear();
    		session.close();
    	}
        
    	return "success";
    }

    /**
     * 初始化单个机构评分
     * @param session
     * @param year
     * @param season
     * @return
     */
    public String initRateByJigou(Session session,String year,String jigou)
    {
    	ScoreDAO sdao = new ScoreDAO();
    	KpxmDAO kdao = new KpxmDAO();
    	List<Kpxm> listk = kdao.findAllOrder();
    	for(int j=0;j<listk.size();j++)
    	{
    		Kpxm k = listk.get(j);
    		Score score = new Score();
    		score.setYear(year);
    		score.setPnumber("");
    		score.setJigouid(jigou);
    		score.setItem(k.getKhxm());
    		score.setNum(k.getNum());
    		score.setIndx(j+1);
    		score.setScore(0.0);
    		score.setRemark("");
    		score.setRemarktemp("");
    		score.setSub("");
    		score.setNewnumber("");
    		score.setIfxz(0);
    		score.setIfabb(0);
    		score.setYuanscore(0.0);
    		score.setStdscore(0.0);
    		score.setXzreason("");
    		sdao.merge(score);
    	}
    	return "";
    }
}