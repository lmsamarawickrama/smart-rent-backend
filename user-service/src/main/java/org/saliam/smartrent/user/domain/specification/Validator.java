package org.saliam.smartrent.user.domain.specification;

import java.util.Iterator;

public interface Validator<T>
{
  boolean isValid(T entity);

  Iterator<Specification<T>> brokenRules(T entity);
}
