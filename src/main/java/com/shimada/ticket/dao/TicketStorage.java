package com.shimada.ticket.dao;

import org.springframework.stereotype.Repository;

import com.shimada.application.core.dao.AbstractStorage;
import com.shimada.ticket.model.TicketEntity;

/**
 * Ticket storage
 *
 * @author Caio Shimada
 */
@Repository
public class TicketStorage extends AbstractStorage<TicketEntity> {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<TicketEntity> getType() {
		return TicketEntity.class;
	}

}
