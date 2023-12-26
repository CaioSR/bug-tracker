package com.shimada.application.core;

/**
 * A base abstract transformer from entity to dto and vice-versa
 *
 * @author Caio Shimada
 */
public abstract class AbstractDtoTransform<E extends BasicEntity, D extends BasicDto> {

	/**
	 * Converts the values from entity to dto
	 * @param dto
	 * @param entity
	 */
	protected abstract void convertTo(D dto, E entity);
	
	/**
	 * Converts the values from dto to entity
	 * @param entity
	 * @param dto
	 */
	protected abstract void convertFrom(E entity, D dto);
	
	/**
	 * Instantiates a new dto
	 * @return
	 */
	protected abstract D newDTO();
	
	/**
	 * Instantiates a new entity
	 * @return
	 */
	protected abstract E newEntity();
	
	/**
	 * Basic process to transform a dto to entity
	 * @param entity
	 * @return
	 */
	public D transformTo(E entity) {
		D dto = newDTO();
		dto.setId(entity.getId());
		convertTo(dto, entity);
		return dto;
	}
	
	/**
	 * Basic process to transform an entity to dto
	 * @param dto
	 * @return
	 */
	public E transformFrom(D dto) {
		E entity = newEntity();
		convertFrom(entity, dto);
		return entity;
	}
	
}
