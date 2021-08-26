package org.saliam.smartrent.user.domain.port.out;

import org.saliam.smartrent.user.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository
{
  Optional<User> findByUsername(String username);

  User save(User user);

  boolean existsByUsername(String username);

  Optional<User> get(Long id);

  List<User> getAll();
}
