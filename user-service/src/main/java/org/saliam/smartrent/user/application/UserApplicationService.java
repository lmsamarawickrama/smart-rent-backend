package org.saliam.smartrent.user.application;

import org.saliam.smartrent.user.domain.entity.User;
import org.saliam.smartrent.user.domain.port.in.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserApplicationService
{
  private final UserService userService;

  @Autowired
  public UserApplicationService(UserService userService)
  {
    this.userService = userService;
  }

  @Transactional
  public User save(User user)
  {
    return userService.save(user);
  }

  public Optional<User> get(Long id)
  {
    return userService.get(id);
  }

  public List<User> getAll()
  {
    return userService.getAll();
  }
}
