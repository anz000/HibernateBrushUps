/**
 * 
 */
package anuz.hibernate.jpa.dao;

import static anuz.hibernate.jpa.util.HibernateUtil.openSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import anuz.hibernate.jpa.pojo.Orders;

/**
 * @author anz
 *
 */
public class OrdersDAOImpl implements OrdersDAO {

	/* (non-Javadoc)
	 * @see trng.imcs.dao.OrdersDAO#getOrders(int)
	 */
	@Override
	public Orders getOrders(int id) {
		Session session = null;
		try {
			session = openSession();
			Orders orders = (Orders) session.get(Orders.class, id);
			return orders;
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see trng.imcs.dao.OrdersDAO#createOrders(trng.imcs.pojo.Orders)
	 */
	@Override
	public Orders createOrders(Orders orders) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(orders);
			session.getTransaction().commit();
			return orders;
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			//session.close();
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see trng.imcs.dao.OrdersDAO#updateOrders(trng.imcs.pojo.Orders)
	 */
	@Override
	public Orders updateOrders(Orders orders) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			session.update(orders);
			transaction.commit();
			return orders;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see trng.imcs.dao.OrdersDAO#deleteOrders(int)
	 */
	@Override
	public boolean deleteOrders(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			Orders orders = (Orders) session.get(Orders.class, id);
			if (orders != null)
				session.delete(orders);
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
