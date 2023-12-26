package com.shimada.collaborator.model;


import com.shimada.util.defaultEntityDisplay.DefaultModelDisplayFormat;
import com.shimada.util.defaultEntityDisplay.DefaultModelDisplayProvider;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

/**
 * Entity of {@link Collaborator}
 *
 * @author Caio Shimada
 */
@Entity
@Table(name = "collaborator", indexes = { @Index(name = "idx_collaborator_code", columnList = "cd_collaborator", unique = true) })
@Access(AccessType.FIELD)
public class CollaboratorEntity extends Collaborator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return DefaultModelDisplayFormat.getDefaultEntityDisplay(new DefaultModelDisplayProvider() {
			
			public Long getFirstParam() {
				return getCode();
			}
			
			
			public String getSecondParam() {
				return getUser().getName();
			}
			
		});
	}
	
}
