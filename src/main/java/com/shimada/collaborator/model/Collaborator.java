package com.shimada.collaborator.model;

import com.shimada.application.core.BasicEntity;
import com.shimada.project.model.ProjectEntity;
import com.shimada.user.model.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

/**
 * Defines the collaborators within projects
 *
 * @author Caio Shimada
 */
@MappedSuperclass
public abstract class Collaborator extends BasicEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_collaborator", nullable = false)
	private Long id;
	
	@Column(name = "cd_collaborator", nullable = false)
	private Long code;

	@JoinColumn(name = "user_id_user", nullable = false, foreignKey = @ForeignKey(name = "fk_collaborator_user"))
	@ManyToOne(targetEntity = UserEntity.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private UserEntity user;
	
	@JoinColumn(name = "project_id_project", nullable = false, foreignKey = @ForeignKey(name = "fk_collaborator_project"))
	@ManyToOne(targetEntity = ProjectEntity.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private ProjectEntity project;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tp_role", nullable = false)
	private CollaboratorRole role;

	/**
	 * Returns the id
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id
	 * @param the id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the code
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}
	
	/**
	 * Sets the code
	 * @param the code
	 */
	public void setCode(Long code) {
		this.code = code;
	}
	
	/**
	 * Returns the user
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}

	/**
	 * Sets the user
	 * @param the user
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}

	/**
	 * Returns the project
	 * @return the project
	 */
	public ProjectEntity getProject() {
		return project;
	}

	/**
	 * Sets the project
	 * @param the project
	 */
	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	/**
	 * Returns the role
	 * @return the role
	 */
	public CollaboratorRole getRole() {
		return role;
	}

	/**
	 * Sets the role
	 * @param the role
	 */
	public void setRole(CollaboratorRole role) {
		this.role = role;
	}
	
}
