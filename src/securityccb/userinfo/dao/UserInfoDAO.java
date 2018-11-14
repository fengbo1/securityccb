package securityccb.userinfo.dao;
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

import securityccb.chu.action.chuAdd;
import securityccb.chu.pojo.Chu;
import securityccb.plan.pojo.Plan;
import securityccb.userinfo.pojo.UserInfo;

/**
 	* A data access object (DAO) providing persistence and search support for UserInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserInfo
  * @author MyEclipse Persistence Tools 
 */

public class UserInfoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserInfoDAO.class);
		//property constants
	public static final String POSITION = "position";
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String QUANXIAN = "quanxian";
	public static final String REMARK1 = "remark1";
	public static final String ADDRESS = "address";
	public static final String TEL = "tel";
	public static final String NAMESOS = "namesos";
	public static final String TELSOS = "telsos";
	public static final String RELATION = "relation";



    
    public void save(UserInfo transientInstance) {
        log.debug("saving UserInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserInfo persistentInstance) {
        log.debug("deleting UserInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserInfo findById( java.lang.Integer id) {
        log.debug("getting UserInfo instance with id: " + id);
        try {
            UserInfo instance = (UserInfo) getSession()
                    .get("UserInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserInfo instance) {
        log.debug("finding UserInfo instance by example");
        try {
            List results = getSession()
                    .createCriteria("UserInfo")
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
      log.debug("finding UserInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserInfo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByRole(Object role
	) {
		return findByProperty(ROLE, role
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
	
	public List findByAddress(Object address
	) {
		return findByProperty(ADDRESS, address
		);
	}
	
	public List findByTel(Object tel
	) {
		return findByProperty(TEL, tel
		);
	}
	
	public List findByNamesos(Object namesos
	) {
		return findByProperty(NAMESOS, namesos
		);
	}
	
	public List findByTelsos(Object telsos
	) {
		return findByProperty(TELSOS, telsos
		);
	}
	
	public List findByRelation(Object relation
	) {
		return findByProperty(RELATION, relation
		);
	}
	

	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserInfo merge(UserInfo detachedInstance) {
        log.debug("merging UserInfo instance");
        try {
            UserInfo result = (UserInfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserInfo instance) {
        log.debug("attaching dirty UserInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserInfo instance) {
        log.debug("attaching clean UserInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public UserInfo findAllById(int id) {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo where id='"+id+"'";
			Query queryObject = getSession().createQuery(queryString);
			List list =  queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return (UserInfo) list.get(0);
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	//寻找安保部综合处长newnumber
	public UserInfo findZhChuz(){
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo where substr(position,1,5)='00000' and role='3'";
			Query queryObject = getSession().createQuery(queryString);
			List list =  queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return (UserInfo) list.get(0);
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}
	//根据发起人position前5位找到对应审批人列表
	public List<UserInfo> findByPostionAndRole(String position, String role) 
	{
		log.debug("finding UserInfo instance with position: " + position
				+ "and role=" + role);
		String queryString="";
		try {
			
			if(role.equals("2"))//不管正副主任，找出分管安保的那个
			{
				queryString = "from UserInfo  where substr(position,1,5)='"
					+ position.substring(0,5) +"' and quanxian='4' and role in('1','2')";
			}
			else
				queryString = "from UserInfo  where substr(position,1,5)='"
					+ position.substring(0,5) +"' and role='"+role+"'";
			
			
			Query queryObject = getSession().createQuery(queryString);
			List<UserInfo> list=queryObject.list();
			log.debug(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//寻找安保部部长newnumber
	public UserInfo findAnBaobz()
	{
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo where substr(position,1,5)='00000' and role='0'";
			Query queryObject = getSession().createQuery(queryString);
			List list =  queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return (UserInfo) list.get(0);
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}
	//查找机构中的安全管理岗。
	public String findAnQuan(String jigouid){
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo where substr(position,1,2)='"+jigouid.trim()+"' and role='5'";
			Query queryObject = getSession().createSQLQuery(queryString).addEntity(UserInfo.class);	
			List<UserInfo> list =  queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return list.get(0).getNewnumber();
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}
	//保存到USERinfo表中。
	public String mysave(UserInfo ui)
	{

		try {
			String queryString = "insert into userinfo(position,name,newnumber,password,role,quanxian,remark1,address,tel,namesos,telsos,relation) values('"
				+ui.getPosition()+"','"+ui.getName()+"','"+ui.getNewnumber()+"','"+ui.getPassword()+"'," +
						"'"+ui.getRole()+"','"+ui.getQuanxian()+"','"+ui.getRemark1()+"','"+ui.getAddress()+"'," +
								"'"+ui.getTel()+"','"+ui.getNamesos()+"','"+ui.getTelsos()+"','"+ui.getRelation()+"')";
			System.out.print("userinfo insert："+queryString);
			Query queryObject = getSession().createSQLQuery(queryString);
			queryObject.executeUpdate();	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}
		return "success";
	}
	public List findadressbychushiid(String chushiid) //根据处室ID查询本处室所有人员的address
	{
		Query query;

		List<UserInfo> ulist=null;
		try {			
			String sql="select * from userinfo where mid(position,3,6) = "+"'"+chushiid+"'";	
			System.out.println(sql);		
			query  = getSession().createSQLQuery(sql).addEntity(UserInfo.class);		
			ulist=query.list();	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
		}			
		
		return ulist;	
	
	}
	public List findadressbyjigouid(String jigouid) //根据机构ID查询机构所有人员的address
	{
		Query query;

		List<UserInfo> ulist=null;
		try {			
			String sql="select * from userinfo where mid(position,1,3) = "+"'"+jigouid+"'";	
			System.out.println(sql);		
			query  = getSession().createSQLQuery(sql).addEntity(UserInfo.class);		
			ulist=query.list();	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{			
			
		}		
		
		return ulist;		
	}
	public List findadressbynewnumber(String newnumber) //根据新一代号，查询address信息
	{
		Query query;

		List<UserInfo> ulist=null;
		
		try {
			
			String sql="select * from userinfo where newnumber = "+"'"+newnumber+"'";	
			System.out.println(sql);		
			query  = getSession().createSQLQuery(sql).addEntity(UserInfo.class);		
			ulist=query.list();	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			 
			 
		}			
		
		return ulist;	
	
}
	public int findmaxuserinfoid() //获取userinfo中最大的id
    {
		Query query;		
		List<UserInfo>  list;
		int newuserinfoid=0;
		try {

	        String hql="from UserInfo order by id desc";	     
						
			query=getSession().createQuery(hql);
			
	     	list = query.list();	
	     	
	     	int userinfoid=list.get(0).getId();
	     	
	     	chuAdd ca =new chuAdd();
							
			 newuserinfoid=userinfoid+1;
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{

		}
		
		return newuserinfoid;
		
	}
	
	public int findmaxuserinfoid(int i) //获取id
    {
		Query query;			
			
		List<UserInfo>  list;
		int newuserinfoid=0;
		try {

	        String hql="from UserInfo order by id desc";			        
									
			query=getSession().createQuery(hql);
			
	     	list = query.list();	
	     	
	     	int userinfoid=list.get(0).getId();    	
	     	
							
			 newuserinfoid=userinfoid+1+i;
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{

		}
		
		return newuserinfoid;
		
	}

	
}
