package org.saliam.smartrent.user.domain.port.in;

import org.saliam.smartrent.user.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
  User save(User user);

  Optional<User> get(Long id);

  List<User> getAll();

  Optional<User> findByUsername(String username);

  boolean existsByUsername(String username);

  boolean isValidUser(String id);

}
