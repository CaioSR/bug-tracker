package com.shimada.application.core.model;

/**
 * A basic DTO for front-end interaction
 *
 * @author Caio Shimada
 */
public abstract class BasicDto {
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
