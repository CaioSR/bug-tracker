package com.shimada.user.dao;

import org.springframework.stereotype.Repository;

import com.shimada.application.core.AbstractStorage;
import com.shimada.user.model.UserEntity;

/**
 * User storage
 *
 * @author Caio Shimada
 */
@Repository
public class UserStorage extends AbstractStorage<UserEntity> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<UserEntity> getType() {
		return UserEntity.class;
	}

}
