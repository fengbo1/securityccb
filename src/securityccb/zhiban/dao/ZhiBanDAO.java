package securityccb.zhiban.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.zhiban.pojo.ZhiBan;

/**
 * A data access object (DAO) providing persistence and search support for
 * ZhiBan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .ZhiBan
 * @author MyEclipse Persistence Tools
 */

public class ZhiBanDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ZhiBanDAO.class);
	// property constants
	public static final String NEWNUMBER = "newnumber";
	public static final String AREAID = "areaid";
	public static final String COVER = "cover";
	public static final String COVERNEWNUMBER = "covernewnumber";
	public static final String REMARK = "remark";
	public static final String REMARK1 = "remark1";
	public static final String ZHIBAN = "zhiban";

	public void save(ZhiBan transientInstance) {
		log.debug("saving ZhiBan instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ZhiBan persistentInstance) {
		log.debug("deleting ZhiBan instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ZhiBan findById(java.lang.Integer id) {
		log.debug("getting ZhiBan instance with id: " + id);
		try {
			ZhiBan instance = (ZhiBan) getSession().get("ZhiBan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ZhiBan instance) {
		log.debug("finding ZhiBan instance by example");
		try {
			List results = getSession().createCriteria("ZhiBan").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ZhiBan instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ZhiBan as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNewnumber(Object newnumber) {
		return findByProperty(NEWNUMBER, newnumber);
	}

	public List findByAreaid(Object areaid) {
		return findByProperty(AREAID, areaid);
	}

	public List findByCover(Object cover) {
		return findByProperty(COVER, cover);
	}

	public List findByCovernewnumber(Object covernewnumber) {
		return findByProperty(COVERNEWNUMBER, covernewnumber);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByRemark1(Object remark1) {
		return findByProperty(REMARK1, remark1);
	}

	public List findByZhiban(Object zhiban) {
		return findByProperty(ZHIBAN, zhiban);
	}

	public List findAll() {
		log.debug("finding all ZhiBan instances");
		try {
			String queryString = "from ZhiBan";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ZhiBan merge(ZhiBan detachedInstance) {
		log.debug("merging ZhiBan instance");
		try {
			ZhiBan result = (ZhiBan) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ZhiBan instance) {
		log.debug("attaching dirty ZhiBan instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ZhiBan instance) {
		log.debug("attaching clean ZhiBan instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}