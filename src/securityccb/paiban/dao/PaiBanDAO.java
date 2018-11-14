package securityccb.paiban.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import securityccb.paiban.pojo.PaiBan;

/**
 * A data access object (DAO) providing persistence and search support for
 * PaiBan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .PaiBan
 * @author MyEclipse Persistence Tools
 */

public class PaiBanDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PaiBanDAO.class);
	// property constants
	public static final String AREAID = "areaid";
	public static final String NEWNUMBER1 = "newnumber1";
	public static final String TEL1 = "tel1";
	public static final String REMARK1 = "remark1";
	public static final String NEWNUMBER2 = "newnumber2";
	public static final String TEL2 = "tel2";
	public static final String REMARK2 = "remark2";
	public static final String REMARK = "remark";
	public static final String REMARK3 = "remark3";

	public void save(PaiBan transientInstance) {
		log.debug("saving PaiBan instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PaiBan persistentInstance) {
		log.debug("deleting PaiBan instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PaiBan findById(java.lang.Integer id) {
		log.debug("getting PaiBan instance with id: " + id);
		try {
			PaiBan instance = (PaiBan) getSession().get("PaiBan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PaiBan instance) {
		log.debug("finding PaiBan instance by example");
		try {
			List results = getSession().createCriteria("PaiBan").add(
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
		log.debug("finding PaiBan instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PaiBan as model where model."
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

	public List findByNewnumber1(Object newnumber1) {
		return findByProperty(NEWNUMBER1, newnumber1);
	}

	public List findByTel1(Object tel1) {
		return findByProperty(TEL1, tel1);
	}

	public List findByRemark1(Object remark1) {
		return findByProperty(REMARK1, remark1);
	}

	public List findByNewnumber2(Object newnumber2) {
		return findByProperty(NEWNUMBER2, newnumber2);
	}

	public List findByTel2(Object tel2) {
		return findByProperty(TEL2, tel2);
	}

	public List findByRemark2(Object remark2) {
		return findByProperty(REMARK2, remark2);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByRemark3(Object remark3) {
		return findByProperty(REMARK3, remark3);
	}

	public List findAll() {
		log.debug("finding all PaiBan instances");
		try {
			String queryString = "from PaiBan";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PaiBan merge(PaiBan detachedInstance) {
		log.debug("merging PaiBan instance");
		try {
			PaiBan result = (PaiBan) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PaiBan instance) {
		log.debug("attaching dirty PaiBan instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PaiBan instance) {
		log.debug("attaching clean PaiBan instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}