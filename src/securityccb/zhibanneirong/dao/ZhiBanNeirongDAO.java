package securityccb.zhibanneirong.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.zhibanneirong.pojo.ZhiBanNeirong;

/**
 * A data access object (DAO) providing persistence and search support for
 * ZhiBanNeirong entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .ZhiBanNeirong
 * @author MyEclipse Persistence Tools
 */

public class ZhiBanNeirongDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ZhiBanNeirongDAO.class);
	// property constants
	public static final String AREAID = "areaid";
	public static final String ZHIBANNEIRONG = "zhibanneirong";

	public void save(ZhiBanNeirong transientInstance) {
		log.debug("saving ZhiBanNeirong instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ZhiBanNeirong persistentInstance) {
		log.debug("deleting ZhiBanNeirong instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ZhiBanNeirong findById(java.lang.Integer id) {
		log.debug("getting ZhiBanNeirong instance with id: " + id);
		try {
			ZhiBanNeirong instance = (ZhiBanNeirong) getSession().get(
					"ZhiBanNeirong", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ZhiBanNeirong instance) {
		log.debug("finding ZhiBanNeirong instance by example");
		try {
			List results = getSession().createCriteria("ZhiBanNeirong").add(
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
		log.debug("finding ZhiBanNeirong instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ZhiBanNeirong as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAreaid(Object areaid) {
		return findByProperty(AREAID, areaid);
	}

	public List findByZhibanneirong(Object zhibanneirong) {
		return findByProperty(ZHIBANNEIRONG, zhibanneirong);
	}

	public List findAll() {
		log.debug("finding all ZhiBanNeirong instances");
		try {
			String queryString = "from ZhiBanNeirong";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ZhiBanNeirong merge(ZhiBanNeirong detachedInstance) {
		log.debug("merging ZhiBanNeirong instance");
		try {
			ZhiBanNeirong result = (ZhiBanNeirong) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ZhiBanNeirong instance) {
		log.debug("attaching dirty ZhiBanNeirong instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ZhiBanNeirong instance) {
		log.debug("attaching clean ZhiBanNeirong instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}