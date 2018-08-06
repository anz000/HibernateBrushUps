package anuz.hibernate.jpa.pojo;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue
	private int custID;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Embedded
	private Address address;
	
	@OneToMany
	@JoinColumn(name="custID")
	private List<Orders> orderList;
	
	
}
