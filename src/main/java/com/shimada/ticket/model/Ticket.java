package com.shimada.ticket.model;

import java.util.Date;

import com.shimada.application.core.model.BasicEntity;
import com.shimada.collaborator.model.CollaboratorEntity;
import com.shimada.project.model.ProjectEntity;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * A Ticket
 *
 * @author Caio Shimada
 */
@MappedSuperclass
public abstract class Ticket extends BasicEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_ticket", nullable = false)
	private Long id;
	
	@Column(name = "cd_ticket", nullable = false)
	private Long code;
	
	// @NotNull
	@Column(name = "ds_title", nullable = false, length = 200)
	private String title;
	
	@Column(name = "ds_description", nullable = true, length = 2000)
	private String description;
	
	@JoinColumn(name = "author_id_collaborator", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_collaborator"))
	@ManyToOne(targetEntity = CollaboratorEntity.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private CollaboratorEntity author;
	
	@JoinColumn(name = "project_id_project", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_project"))
	@ManyToOne(targetEntity = ProjectEntity.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private ProjectEntity project;
	
	@Column(name = "tp_priority", nullable = true)
	private TicketPriority priority;
	
	@Column(name = "tp_type", nullable = true)
	private TicketType type;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tp_status", nullable = false)
	private Status status = Status.Open;
	
	// @NotNull
	@Temporal(value = TemporalType.DATE)
	@Column(name = "dt_created_at", nullable = false)
	private Date createdAt;
	
//	@JoinColumn(name = "attachment_id_attachment", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_attachment"))
//	@OneToMany(targetEntity = AttachmentEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = AttachmentEntity.TICKET, orphanRemoval = true)
//	private List<AttachmentEntity> attachments = new ArrayList<>();
//	
//	@JoinColumn(name = "comment_id_comment", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_comment"))
//	@OneToMany(targetEntity = CommentEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = CommentEntity.TICKET, orphanRemoval = true)
//	private List<CommentEntity> comments = new ArrayList<>();

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
	 * Returns the title
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title
	 * @param the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description
	 * @param the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the author
	 * @return the author
	 */
	public CollaboratorEntity getAuthor() {
		return author;
	}

	/**
	 * Sets the author
	 * @param the author
	 */
	public void setAuthor(CollaboratorEntity author) {
		this.author = author;
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
	 * Returns the priority
	 * @return the priority
	 */
	public TicketPriority getPriority() {
		return priority;
	}

	/**
	 * Sets the priority
	 * @param the priority
	 */
	public void setPriority(TicketPriority priority) {
		this.priority = priority;
	}

	/**
	 * Returns the type
	 * @return the type
	 */
	public TicketType getType() {
		return type;
	}

	/**
	 * Sets the type
	 * @param the type
	 */
	public void setType(TicketType type) {
		this.type = type;
	}

	/**
	 * Returns the status
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Sets the status
	 * @param the status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Returns the createdAt
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the createdAt
	 * @param the createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

//	/**
//	 * Returns the attachments
//	 * @return the attachments
//	 */
//	public List<AttachmentEntity> getAttachments() {
//		return attachments;
//	}
//
//	/**
//	 * Sets the attachments
//	 * @param the attachments
//	 */
//	public void setAttachments(List<AttachmentEntity> attachments) {
//		this.attachments = attachments;
//	}
//
//	/**
//	 * Returns the comments
//	 * @return the comments
//	 */
//	public List<CommentEntity> getComments() {
//		return comments;
//	}
//
//	/**
//	 * Sets the comments
//	 * @param the comments
//	 */
//	public void setComments(List<CommentEntity> comments) {
//		this.comments = comments;
//	}

}
