package in.mindcraft.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Register {
	
	@Id
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "mobile_number")
	private long mobile_number;

	public Register() {
	}

	public Register(String name, long mobile_number) {
		this.name = name;
		this.mobile_number = mobile_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	
}
