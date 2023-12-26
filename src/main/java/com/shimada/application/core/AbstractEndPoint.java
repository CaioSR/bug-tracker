package com.shimada.application.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Abstract end point for handling requests
 * 
 * @param <E> - entity
 * @param <D> - dto
 * 
 * @author Caio Shimada
 */
public abstract class AbstractEndPoint<E extends BasicEntity, D extends BasicDto> {
	
	/**
	 * Returns the entity - dto transformer
	 * @return
	 */
	protected abstract AbstractDtoTransform<E, D> getTransform();
	
	/**
	 * Returns the entity storage
	 * @return
	 */
	protected abstract AbstractStorage<E> getStorage();
	
	/**
	 * Customize the dto before transforming into entity
	 * @param dto
	 */
	protected void customizeDto(D dto) {
		// empty by default
	}
	
	/**
	 * Customize the entity after transforming before saving
	 * @param entity
	 */
	protected void customizeEntity(E entity) {
		// empty by default
	}
	
	/**
	 * Saves the DTO into the database
	 * @param dto
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<D> save(@RequestBody D dto) {
		try {
			customizeDto(dto);
			
			E entity = getTransform().transformFrom(dto);
			
			customizeEntity(entity);
			
			getStorage().save(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Retrieves a object from the database by its Id
	 * @param id
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<D> find(@RequestBody Long id){
		try {
			E entity = getStorage().find(id);
			if (entity != null) {
				D dto = getTransform().transformTo(entity);
				
				return new ResponseEntity<D>(dto, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
