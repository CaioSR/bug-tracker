package com.shimada.project.model;

import com.shimada.application.core.model.BasicEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * The project a ticket refers to
 *
 * @author Caio Shimada
 */
@MappedSuperclass
public abstract class Project extends BasicEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_project", nullable = false)
	private Long id;
	
	@Column(name = "cd_project", nullable = false)
	private Long code;
	
	@Column(name = "ds_name", nullable = false, length = 200)
	private String name;

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

}
