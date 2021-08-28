package org.saliam.smartrent.user.domain.service;

import org.saliam.smartrent.user.domain.entity.User;
import org.saliam.smartrent.user.domain.port.in.UserService;
import org.saliam.smartrent.user.domain.port.out.IdentityProviderRepository;
import org.saliam.smartrent.user.domain.port.out.UserRepository;
import org.saliam.smartrent.user.domain.specification.UserValidator;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService
{
  private final UserRepository userRepository;

  private final IdentityProviderRepository identityProviderRepository;

  private final UserValidator userValidator;

  public UserServiceImpl(final UserRepository userRepository,
                         final IdentityProviderRepository identityProviderRepository,
                         final UserValidator userValidator)
  {
    this.userRepository = userRepository;
    this.identityProviderRepository = identityProviderRepository;
    this.userValidator = userValidator;
  }

  @Override
  public Optional<User> findByUsername(String username)
  {
    return userRepository.findByUsername(username);
  }

  @Override
  public User save(User user)
  {
    if (userValidator.isValid(user))
    {
      User savedUser = userRepository.save(user);
      // This assumes all the exceptions thrown during persisting user to idp are Runtime
      // since it rollback the operation of persisting user to local database
      identityProviderRepository.saveUser(user);
      user.setId(savedUser.getId());
      return user;
    }
    throw new IllegalArgumentException(
        "User " + user.getUsername() + "is not Valid due to " + userValidator.brokenRules(user).next().getClass()
            .toString());

  }

  @Override
  public Optional<User> get(Long id)
  {
    return userRepository.get(id);
  }

  @Override
  public List<User> getAll()
  {
    return userRepository.getAll();
  }

  @Override
  public boolean existsByUsername(String username)
  {
    return userRepository.existsByUsername(username);
  }

  public boolean isValidUser(String id)
  {
    return userRepository.get(Long.valueOf(id)).isPresent();
  }
}
