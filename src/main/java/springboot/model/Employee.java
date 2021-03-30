package springboot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public Employee( String name, String email) {
		super();
		
		this.name = name;
		this.email = email;
		
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	//@NotBlank(message = "Name is mandatory")
	@Size(min=3,max=10,message="name is not valid")
	@Column(name="name")
	private String name;
	@NotBlank(message = "email is mandatory")
	@Column(name="email")
	private String email;
	
	@Column(name="phoneNo")
	private long phoneNo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
