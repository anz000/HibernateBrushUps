package anuz.hibernate.jpa.dao;

import anuz.hibernate.jpa.pojo.Customer;

/**
 * DAO interface for Customer
 * @author anz
 *
 */
public interface CustomerDAO {

	/**
	 * Fetch the Customer from Database with given id
	 * @param id
	 * @return
	 */
	Customer getCustomer(int id);

	/**
	 * Create the given employee in DB
	 * @param emp
	 * @return
	 */
	Customer createCustomer(Customer emp);

	/**
	 * Update the employee with new credentials
	 * @param emp
	 * @return
	 */
	Customer updateCustomer(Customer emp);

	/**
	 * delete the employee with the given id
	 * @param id
	 * @return
	 */
	boolean deleteCustomer(int id);

}
