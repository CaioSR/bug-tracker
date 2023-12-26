package com.shimada.project.model;

import com.shimada.util.defaultEntityDisplay.DefaultModelDisplayFormat;
import com.shimada.util.defaultEntityDisplay.DefaultModelDisplayProvider;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

/**
 * Entity of {@link Project}
 *
 * @author Caio Shimada
 */
@Entity
@Table(name = "project", indexes = { @Index(name = "idx_project_code", columnList = "cd_project", unique = true) })
@Access(AccessType.FIELD)
public class ProjectEntity extends Project {

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
				return getName();
			}

		});
	}
	
}
