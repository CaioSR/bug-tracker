package com.shimada.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shimada.application.Application;
import com.shimada.application.core.AbstractDtoTransform;
import com.shimada.application.core.AbstractEndPoint;
import com.shimada.application.core.AbstractStorage;
import com.shimada.project.dao.ProjectStorage;
import com.shimada.project.model.ProjectDto;
import com.shimada.project.model.ProjectEntity;
import com.shimada.project.web.ProjectTransform;

/**
 * EndPoint for {@link ProjectEntity}
 *
 * @author Caio Shimada
 */
@RestController
@RequestMapping(ProjectEndPoint.ENDPOINT)
public class ProjectEndPoint extends AbstractEndPoint<ProjectEntity, ProjectDto>{
	
	public static final String ENDPOINT = "/project";
	
	@GetMapping(value = "/teste")
	public String find(){
		return "hello";
	}
	
	private ProjectTransform transform;
	private ProjectStorage storage;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected AbstractDtoTransform<ProjectEntity, ProjectDto> getTransform() {
		if (transform == null) {
			transform = Application.getInstance(ProjectTransform.class);
		}
		return transform;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected AbstractStorage<ProjectEntity> getStorage() {
		if (storage == null) {
			storage = Application.getInstance(ProjectStorage.class);
		}
		return storage;
	}

}
