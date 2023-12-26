package com.shimada.project.dao;

import org.springframework.stereotype.Repository;

import com.shimada.application.core.AbstractStorage;
import com.shimada.project.model.ProjectEntity;

/**
 * Project storage
 *
 * @author Caio Shimada
 */
@Repository
public class ProjectStorage extends AbstractStorage<ProjectEntity> {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<ProjectEntity> getType() {
		return ProjectEntity.class;
	}

}
