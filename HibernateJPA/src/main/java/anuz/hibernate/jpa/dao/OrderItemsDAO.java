package anuz.hibernate.jpa.dao;

import anuz.hibernate.jpa.pojo.OrderItemIdentifier;
import anuz.hibernate.jpa.pojo.OrderItems;

/**
 * This is the OrderItemsDAO Interface
 * @author anz
 *
 */
public interface OrderItemsDAO {

	/**
	 * Get the items in the order by the identifier
	 * @param id
	 * @return
	 */
	OrderItems getOrderItems(OrderItemIdentifier id);

	/**
	 * Create the items with quantity for the order
	 * @param orderItems
	 * @return
	 */
	OrderItems createOrderItems(OrderItems orderItems);

	/**
	 * Update the items in the basket with new information
	 * @param orderItems
	 * @return
	 */
	OrderItems updateOrderItems(OrderItems orderItems);

	/**
	 * Remove the item from the basket
	 * @param id
	 * @return
	 */
	boolean deleteOrderItems(OrderItemIdentifier id);

}
