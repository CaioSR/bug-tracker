package com.shimada.collaborator.dao;

import org.springframework.stereotype.Repository;

import com.shimada.application.core.AbstractStorage;
import com.shimada.collaborator.model.CollaboratorEntity;

/**
 * Collaborator storage
 *
 * @author Caio Shimada
 */
@Repository
public class CollaboratorStorage extends AbstractStorage<CollaboratorEntity> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<CollaboratorEntity> getType() {
		return CollaboratorEntity.class;
	}

}
