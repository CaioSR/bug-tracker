package com.shimada.ticket.model;

import com.shimada.util.defaultEntityDisplay.DefaultModelDisplayFormat;
import com.shimada.util.defaultEntityDisplay.DefaultModelDisplayProvider;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

/**
 * Entity of {@link Ticket}
 *
 * @author Caio Shimada
 */
@Entity
@Table(name = "ticket", indexes = { @Index(name = "idx_ticket_code", columnList = "cd_ticket", unique = true) })
@Access(AccessType.FIELD)
public class TicketEntity extends Ticket {

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
				return getTitle();
			}
			
		});
	}
	
}
