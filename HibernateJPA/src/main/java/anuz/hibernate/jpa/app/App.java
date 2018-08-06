package anuz.hibernate.jpa.app;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import anuz.hibernate.jpa.dao.CustomerDAO;
import anuz.hibernate.jpa.dao.CustomerDAOImpl;
import anuz.hibernate.jpa.dao.OrderItemsDAO;
import anuz.hibernate.jpa.dao.OrderItemsDAOImpl;
import anuz.hibernate.jpa.dao.OrdersDAO;
import anuz.hibernate.jpa.dao.OrdersDAOImpl;
import anuz.hibernate.jpa.pojo.Address;
import anuz.hibernate.jpa.pojo.Customer;
import anuz.hibernate.jpa.pojo.OrderItemIdentifier;
import anuz.hibernate.jpa.pojo.OrderItems;
import anuz.hibernate.jpa.pojo.Orders;
import anuz.hibernate.jpa.util.HibernateUtil;

/**
 * Main Application
 *
 */
public class App {
	/*
	 * static reference to DAOs
	 */
	static CustomerDAO customerDAO = new CustomerDAOImpl();
	static OrdersDAO orderDAO = new OrdersDAOImpl();
	static OrderItemsDAO orderItemDAO = new OrderItemsDAOImpl();

	/**
	 * main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		create();

		read();

		update();

		delete();

		System.out.println(" ** DONE ** ");
		
		/**
		 * Closing Session
		 */
		HibernateUtil.openSession().close();
		System.exit(0);
	}

	/**
	 * Sample Create 
	 */
	private static void create() {
		/**
		 * Creating a new Customer
		 */

		Customer theCustomer = new Customer(1, "Anuj", "Shrestha", null, null);
		Address theAddress = new Address("McArthur", "Irving", "TX", "USA");
		theCustomer.setAddress(theAddress);

		/**
		 * Single order for the customer
		 */
		// List<Orders> orderList = new ArrayList<>();
		Orders theOrder = new Orders(1, Timestamp.valueOf(LocalDateTime.of(2018, 05, 21, 12, 34)),
				theCustomer.getCustID(), null);

		/**
		 * Adding items for the customer
		 */
		OrderItems theOrderItems1 = new OrderItems(new OrderItemIdentifier(theOrder.getOrderNumber(), 1), 10);
		OrderItems theOrderItems2 = new OrderItems(new OrderItemIdentifier(theOrder.getOrderNumber(), 2), 5);

		// List<OrderItems> orderItemsList = new ArrayList<>();
		// orderItemsList.add(theOrderItems1);
		/// orderItemsList.add(theOrderItems2);

		/**
		 * Writing info to DB
		 */
		customerDAO.createCustomer(theCustomer);
		orderDAO.createOrders(theOrder);
		orderItemDAO.createOrderItems(theOrderItems1);
		orderItemDAO.createOrderItems(theOrderItems2);
	}

	/**
	 * Sample read
	 */
	private static void read() {
		/**
		 * Retrieve from DB
		 */
		System.out.println("Getting Full Name of Customer");
		Customer rCustomer = customerDAO.getCustomer(1);
		System.out.println(rCustomer.getFirstName() + " " + rCustomer.getLastName());
		System.out.println(rCustomer.getAddress());
	}

	/**
	 * Sample Update
	 */
	private static void update() {
		/**
		 * Updating
		 */
		System.out.println("Updating Address of Customer");
		Customer rCustomer = customerDAO.getCustomer(1);
		Address uAddress = new Address("FargoDome", "Fargo", "ND", "USA");
		rCustomer.setAddress(uAddress);
		Customer uCustomer = customerDAO.updateCustomer(rCustomer);
		System.out.println(uCustomer.getFirstName() + " " + uCustomer.getLastName());
		System.out.println(uCustomer.getAddress());

	}

	/**
	 * Sample Delete
	 */
	private static void delete() {
		/**
		 * Deleting
		 */
		System.out.println("Deleting Order Items (#2)");

		OrderItems theOrderItem2 = orderItemDAO.getOrderItems(new OrderItemIdentifier(1, 2));
		boolean dResult = orderItemDAO.deleteOrderItems(theOrderItem2.getIdentifier());
		System.out.println(dResult);
	}
}
