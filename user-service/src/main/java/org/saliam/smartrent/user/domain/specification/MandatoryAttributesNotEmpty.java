package org.saliam.smartrent.user.domain.specification;

import org.apache.commons.lang3.StringUtils;
import org.saliam.smartrent.user.domain.entity.User;

public class MandatoryAttributesNotEmpty implements Specification<User>
{
  @Override
  public boolean IsSatisfiedBy(User subject)
  {
    return StringUtils.isNoneBlank(subject.getUsername()) && StringUtils.isNoneBlank(subject.getPassword())
        && StringUtils.isNoneBlank(subject.getEmail());
  }
}
