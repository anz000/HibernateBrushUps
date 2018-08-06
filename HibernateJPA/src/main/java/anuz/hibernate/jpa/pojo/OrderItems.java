package anuz.hibernate.jpa.pojo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {

	@EmbeddedId
	private OrderItemIdentifier identifier;
	
	@Column
	private int quantity;
}
