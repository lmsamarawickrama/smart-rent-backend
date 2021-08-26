package org.saliam.smartrent.user.infrastructure.adapter.database.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartrent.user.domain.entity.User;
import org.saliam.smartrent.user.infrastructure.adapter.database.entity.UserEntity;

@Mapper
public interface UserEntityMapper
{
  UserEntity userToUserEntity(User user);

  User userEntityToUser(UserEntity userEntity);
}
