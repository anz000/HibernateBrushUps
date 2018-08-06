/**
 * 
 */
package anuz.hibernate.jpa.dao;

import static anuz.hibernate.jpa.util.HibernateUtil.openSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import anuz.hibernate.jpa.pojo.OrderItemIdentifier;
import anuz.hibernate.jpa.pojo.OrderItems;

/**
 * @author anz
 *
 */
public class OrderItemsDAOImpl implements OrderItemsDAO {

	/* (non-Javadoc)
	 * @see trng.imcs.dao.OrderItemsDAO#getOrderItems(int)
	 */
	@Override
	public OrderItems getOrderItems(OrderItemIdentifier id) {
		Session session = null;
		try {
			session = openSession();
			OrderItems orderItem = (OrderItems) session.get(OrderItems.class, id);
			return orderItem;
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see trng.imcs.dao.OrderItemsDAO#createOrderItems(trng.imcs.pojo.OrderItems)
	 */
	@Override
	public OrderItems createOrderItems(OrderItems orderItem) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(orderItem);
			session.getTransaction().commit();
			return orderItem;
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			//session.close();
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see trng.imcs.dao.OrderItemsDAO#updateOrderItems(trng.imcs.pojo.OrderItems)
	 */
	@Override
	public OrderItems updateOrderItems(OrderItems orderItem) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			session.update(orderItem);
			transaction.commit();
			return orderItem;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see trng.imcs.dao.OrderItemsDAO#deleteOrderItems(int)
	 */
	@Override
	public boolean deleteOrderItems(OrderItemIdentifier id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			OrderItems orderItem = (OrderItems) session.get(OrderItems.class, id);
			if (orderItem != null)
				session.delete(orderItem);
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
