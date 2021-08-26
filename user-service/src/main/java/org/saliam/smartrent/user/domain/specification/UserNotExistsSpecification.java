package org.saliam.smartrent.user.domain.specification;

import org.saliam.smartrent.user.domain.entity.User;
import org.saliam.smartrent.user.domain.port.out.UserRepository;

public class UserNotExistsSpecification implements Specification<User>
{
  private final UserRepository userRepository;

  public UserNotExistsSpecification(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  @Override
  public boolean IsSatisfiedBy(User subject)
  {
    return !userRepository.existsByUsername(subject.getUsername());
  }
}
