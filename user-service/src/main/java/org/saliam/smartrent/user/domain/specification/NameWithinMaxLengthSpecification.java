package org.saliam.smartrent.user.domain.specification;

import org.saliam.smartrent.user.domain.entity.User;

public class NameWithinMaxLengthSpecification implements Specification<User>
{
  @Override
  public boolean IsSatisfiedBy(User subject)
  {
    return !subject.getUsername().isEmpty() && subject.getUsername().length() < 50;
  }
}
