package org.saliam.smartrent.user.presentation.rest.controller;

import org.mapstruct.factory.Mappers;
import org.saliam.smartrent.user.application.UserApplicationService;
import org.saliam.smartrent.user.domain.entity.User;
import org.saliam.smartrent.user.presentation.message.broker.UserServiceMessageProxy;
import org.saliam.smartrent.user.presentation.message.model.VerifyUserEvent;
import org.saliam.smartrent.user.presentation.rest.UserApi;
import org.saliam.smartrent.user.presentation.rest.dto.UserCreateDto;
import org.saliam.smartrent.user.presentation.rest.dto.UserDto;
import org.saliam.smartrent.user.presentation.rest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/smartrent/api/user")
public class UserController implements UserApi
{
  private UserApplicationService userApplicationService;

  @Autowired
  private UserServiceMessageProxy userServiceMessageProxy;

  @Autowired
  public void setUserService(UserApplicationService userApplicationService)
  {
    this.userApplicationService = userApplicationService;
  }

  @Override
  public ResponseEntity<UserDto> save(UserCreateDto userCreateDto)
  {
    final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    User user = userMapper.userCreateDtoToUser(userCreateDto);
    UserDto savedUser = userMapper.userToUserDto(userApplicationService.save(user));
    return ResponseEntity.ok(savedUser);
  }

  @Override
  public ResponseEntity<UserDto> get(Long id)
  {
    VerifyUserEvent response_topic = new VerifyUserEvent("1", "4", "response topic");
    userServiceMessageProxy.producerPayment(response_topic);
    final Optional<User> userById = userApplicationService.get(id);
    final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    return userById.map(user -> ResponseEntity.ok(userMapper.userToUserDto(user)))
        .orElse(ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<List<UserDto>> getAll()
  {
    final List<User> users = userApplicationService.getAll();
    final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    List<UserDto> userDtoS = users.stream().map(userMapper::userToUserDto).collect(Collectors.toList());
    return ResponseEntity.ok(userDtoS);
  }
}
