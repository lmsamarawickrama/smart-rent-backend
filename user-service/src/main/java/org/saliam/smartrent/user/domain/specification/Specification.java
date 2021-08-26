package org.saliam.smartrent.user.domain.specification;

public interface Specification<T>
{
  boolean IsSatisfiedBy(T subject);
}
