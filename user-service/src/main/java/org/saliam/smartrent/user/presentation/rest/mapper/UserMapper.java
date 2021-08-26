package org.saliam.smartrent.user.presentation.rest.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartrent.user.domain.entity.User;
import org.saliam.smartrent.user.presentation.rest.dto.UserCreateDto;
import org.saliam.smartrent.user.presentation.rest.dto.UserDto;

@Mapper
public interface UserMapper
{
  User userCreateDtoToUser(UserCreateDto user);

  UserDto userToUserDto(User user);
}
