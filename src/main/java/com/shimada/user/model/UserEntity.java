package com.shimada.user.model;

import com.shimada.util.defaultEntityDisplay.DefaultModelDisplayFormat;
import com.shimada.util.defaultEntityDisplay.DefaultModelDisplayProvider;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

/**
 * Entity of {@link User}
 *
 * @author Caio Shimada
 */
@Entity
@Table(name = "user", indexes = { @Index(name = "idx_user_code", columnList = "cd_user", unique = true) })
@Access(AccessType.FIELD)
public class UserEntity extends User {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return DefaultModelDisplayFormat.getDefaultEntityDisplay(new DefaultModelDisplayProvider(){

			public Long getFirstParam() {
				return getCode();
			}

			public String getSecondParam() {
				return getName();
			}
			
		});
	}
	
}
