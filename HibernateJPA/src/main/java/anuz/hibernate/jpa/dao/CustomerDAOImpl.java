/**
 * 
 */
package anuz.hibernate.jpa.dao;

import static anuz.hibernate.jpa.util.HibernateUtil.openSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import anuz.hibernate.jpa.pojo.Customer;

/**
 * @author anz
 *
 */
public class CustomerDAOImpl implements CustomerDAO {

	/* (non-Javadoc)
	 * @see trng.imcs.dao.CustomerDAO#getCustomer(int)
	 */
	@Override
	public Customer getCustomer(int id) {
		Session session = null;
		try {
			session = openSession();
			Customer cust = (Customer) session.get(Customer.class, id);
			return cust;
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see trng.imcs.dao.CustomerDAO#createCustomer(trng.imcs.pojo.Customer)
	 */
	@Override
	public Customer createCustomer(Customer cust) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(cust);
			session.getTransaction().commit();
			return cust;
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			//session.close();
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see trng.imcs.dao.CustomerDAO#updateCustomer(trng.imcs.pojo.Customer)
	 */
	@Override
	public Customer updateCustomer(Customer cust) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			session.update(cust);
			transaction.commit();
			return cust;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see trng.imcs.dao.CustomerDAO#deleteCustomer(int)
	 */
	@Override
	public boolean deleteCustomer(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			Customer cust = (Customer) session.get(Customer.class, id);
			if (cust != null)
				session.delete(cust);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

}
