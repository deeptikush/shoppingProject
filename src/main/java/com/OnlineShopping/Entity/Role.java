package com.OnlineShopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Data
@Table(name="role")

public class Role {
	
	@Id
	private String roleName;
	
	private String roleDescirption;
	

}
