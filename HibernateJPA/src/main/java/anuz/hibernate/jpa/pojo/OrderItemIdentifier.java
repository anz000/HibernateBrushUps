package anuz.hibernate.jpa.pojo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemIdentifier implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * The two class variables forms the composite primary key for the OrderItems Entity 
	 */
	
	// this is the foreign key
	private int orderNumber;
	
	// this is the foreign key
	private int itemNumber;
	
	
}
