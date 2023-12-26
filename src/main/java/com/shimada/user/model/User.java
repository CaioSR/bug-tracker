package com.shimada.user.model;

import com.shimada.application.core.model.BasicEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * An user of the system
 *
 * @author Caio Shimada
 */
@MappedSuperclass
public abstract class User extends BasicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user", nullable = false)
	private Long id;
	
	@Column(name = "cd_user", nullable = false)
	private Long code;
	
	@Column(name = "ds_name", nullable = false, length = 200)
	private String name;
	
	@Column(name = "ds_email", nullable = false, length = 200)
	private String email;
	
	@Column(name = "ds_password", nullable = false, length = 200)
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tp_type", nullable = false)
	private UserType type = UserType.REGULAR;

	/**
	 * Returns the id
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id
	 * @param the id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the code
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * Sets the code
	 * @param the code
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * Returns the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name
	 * @param the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email
	 * @param the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password
	 * @param the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the type
	 * @return the type
	 */
	public UserType getType() {
		return type;
	}

	/**
	 * Sets the type
	 * @param the type
	 */
	public void setType(UserType type) {
		this.type = type;
	}
	
}
