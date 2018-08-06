package anuz.hibernate.jpa.pojo;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

	/**
	 * This class variables will be part of the Customer Table, 
	 * but can be represented with different Object for better OOP design
	 */
	private String street;
	private String city;
	private String state;
	private String country;
}
