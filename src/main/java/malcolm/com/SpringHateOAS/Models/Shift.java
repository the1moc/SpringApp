package malcolm.com.SpringHateOAS.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class Shift extends ResourceSupport {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "day")
	private String day;
	
	@Column(name = "time")
	private String time;
	
	protected Shift() { };
	
	public Shift(int shiftid, String firstName, String lastName, String day, String time) {
		this.id = shiftid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.day= day;
		this.time = time;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getDay() {
		return this.day;
	}
	
	public String getTime() {
		return this.time;
	}
}
