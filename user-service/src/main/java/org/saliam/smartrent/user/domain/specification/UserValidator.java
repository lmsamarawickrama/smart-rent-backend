package org.saliam.smartrent.user.domain.specification;

import org.saliam.smartrent.user.domain.entity.User;

import java.util.Iterator;
import java.util.List;

public class UserValidator implements Validator<User>
{

  private final List<Specification<User>> rules;

  public UserValidator(
      final List<Specification<User>> rules)
  {
    this.rules = rules;
  }

  @Override public boolean isValid(User entity)
  {
    return !brokenRules(entity).hasNext();
  }

  @Override
  public Iterator<Specification<User>> brokenRules(User entity)
  {
    return rules.stream().filter(rule -> !rule.IsSatisfiedBy(entity)).iterator();
  }
}
