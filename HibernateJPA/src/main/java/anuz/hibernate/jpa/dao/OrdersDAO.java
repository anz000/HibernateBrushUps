package anuz.hibernate.jpa.dao;

import anuz.hibernate.jpa.pojo.Orders;

/**
 * Order DAO Interface
 * @author anz
 *
 */
public interface OrdersDAO {

	/**
	 * Get the order by Order Id
	 * @param id
	 * @return
	 */
	Orders getOrders(int id);

	/**
	 * Create the given order
	 * @param order
	 * @return
	 */
	Orders createOrders(Orders order);

	/**
	 * Update the order with new informations
	 * @param order
	 * @return
	 */
	Orders updateOrders(Orders order);

	/**
	 * Delete the order by id
	 * @param id
	 * @return
	 */
	boolean deleteOrders(int id);

}
