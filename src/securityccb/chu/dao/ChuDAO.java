package securityccb.chu.dao;
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

import securityccb.chu.pojo.Chu;

/**
 	* A data access object (DAO) providing persistence and search support for Chu entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Chu
  * @author MyEclipse Persistence Tools 
 */

public class ChuDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ChuDAO.class);
		//property constants
	public static final String JIGOUID = "jigouid";
	public static final String CHUSHI = "chushi";
	public static final String CHUSHIID = "chushiid";



    
    public void save(Chu transientInstance) {
        log.debug("saving Chu instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Chu persistentInstance) {
        log.debug("deleting Chu instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Chu findById( java.lang.Integer id) {
        log.debug("getting Chu instance with id: " + id);
        try {
            Chu instance = (Chu) getSession()
                    .get("Chu", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public Chu findZHById(String jigouid) {
        log.debug("getting ZHChu instance with id: " + jigouid);
        try {
            String queryString = "from Chu  where jigouid='" 
            						+ jigouid + "' and substr(chushiid,6,6)='1'";
            Query queryObject = getSession().createQuery(queryString);
   		    Chu chu=(Chu)queryObject.list().get(0);
   		 return chu;
         } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
         }
    }
    public List findByExample(Chu instance) {
        log.debug("finding Chu instance by example");
        try {
            List results = getSession()
                    .createCriteria("Chu")
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
      log.debug("finding Chu instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Chu as model where model." 
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
	
	public List findByChushi(Object chushi
	) {
		return findByProperty(CHUSHI, chushi
		);
	}
	
	public List findByChushiid(Object chushiid
	) {
		return findByProperty(CHUSHIID, chushiid
		);
	}
	

	public List findAll() {
		log.debug("finding all Chu instances");
		try {
			String queryString = "from Chu";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Chu merge(Chu detachedInstance) {
        log.debug("merging Chu instance");
        try {
            Chu result = (Chu) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Chu instance) {
        log.debug("attaching dirty Chu instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Chu instance) {
        log.debug("attaching clean Chu instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public String findChuidByJigouAndChushi(String jigouid,String chushi) {
		log.debug("finding all Chu instances");
		try {
			String queryString = "from Chu where jigouid = '"+jigouid+"' and chushi='"+chushi+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List<Chu> list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				return list.get(0).getChushiid(); 
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public Chu findByJigouAndChushi(String jgid,String chushi) {
		log.debug("finding all Chu instances");
		try {
			String queryString = "from Chu where jigouid = '"+jgid+"' and chushi='"+chushi+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List<Chu> list = queryObject.list();
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
	public String  findchushinamebychushiid(String chushiid) //通过处室ID查询处室名字
    {		       
		List<Chu> clist=null;
		String chushi = null;
		try {
	        String sql="SELECT * from chu where chushiid = "+"'"+chushiid+"'";			
			System.out.println(sql);
			Query query = getSession().createSQLQuery(sql).addEntity(Chu.class);		
			clist = query.list();
			if(!clist.isEmpty())
			{
				chushi=clist.get(0).getChushi();
			}
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{			
		}			
		return chushi;		
	}	
	public List<Chu> findchushinamebyjigouid(String jigouid) //通过机构ID查询机构所辖处室
    {
					
		List<Chu> clist=null;
		try {

	        String sql="SELECT * from chu where jigouid = "+"'"+jigouid+"'";			
			System.out.println(sql);
			Query query = getSession().createSQLQuery(sql).addEntity(Chu.class);		
			clist = query.list();	
			 			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return clist;
		
	}
	public List<Chu> findchushiidbyjigouid(String jigouid) //查询机构ID下全部处室
    {
		Query query ;			
		
		List<Chu> chulist = null;
		try {

	        String sql="SELECT * from chu where jigouid = "+"'"+jigouid+"'";			
			System.out.println(sql);
			query  = getSession().createSQLQuery(sql).addEntity(Chu.class);		
			chulist = query.list();						
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
			
	return chulist;
	
}
	public List findchulist(String jigouid,Session session)
	{
		Query query;
		List<Chu> list=null;		
		
		try {
			    String sql="SELECT * from chu where jigouid = "+"'"+jigouid+"'";			
				System.out.println(sql);
				query = session.createSQLQuery(sql).addEntity(Chu.class);		
				 list = query.list();	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public String findmaxchushiid() //获取处室的最大的id再加一
    {
		Query query;			
		String newchushiid="";
		try {
	        String hql="from Chu order by chushiid desc";		
			System.out.println(hql);
			query=getSession().createQuery(hql);
			List<Chu>  list = query.list();	
	     	if(list.isEmpty())
	     	{
	     		newchushiid = "101";
	     	}
	     	else
	     	{
	     		newchushiid = list.get(0).getChushiid().substring(0,3);
	     	}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
		return newchushiid;
	}


	public int findmaxid() //获取下一条数据的id
    {
		Query query;		
		int newchushiid=0;
		List<Chu>  list;
		
		try {

	        String hql="from Chu order by id desc";	
			query=getSession().createQuery(hql);			
	     	list = query.list();		     	
	     	int id=list.get(0).getId();							
			newchushiid=id+1;					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}return newchushiid;
		
	}
}