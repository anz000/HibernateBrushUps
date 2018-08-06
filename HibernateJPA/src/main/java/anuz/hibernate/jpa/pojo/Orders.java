package anuz.hibernate.jpa.pojo;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	
	@Id
	private int orderNumber;
	
	@Column
	private Timestamp timeStamp;
	
	// this is the foreign key
	private int custID;
	
	@OneToMany
	@JoinColumn(name="orderNumber")
	private List<OrderItems> items;

}
