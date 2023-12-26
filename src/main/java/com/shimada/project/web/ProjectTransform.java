package com.shimada.project.web;

import org.springframework.stereotype.Service;

import com.shimada.application.core.AbstractDtoTransform;
import com.shimada.project.model.ProjectDto;
import com.shimada.project.model.ProjectEntity;

/**
 * A transformer of entity to dto and vice-versa
 *
 * @author Caio Shimada
 */
@Service
public class ProjectTransform extends AbstractDtoTransform<ProjectEntity, ProjectDto> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void convertTo(ProjectDto dto, ProjectEntity entity) {
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void convertFrom(ProjectEntity entity, ProjectDto dto) {
		entity.setName(dto.getName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ProjectDto newDTO() {
		return new ProjectDto();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ProjectEntity newEntity() {
		return new ProjectEntity();
	}
	
}
