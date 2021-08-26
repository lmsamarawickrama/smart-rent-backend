package org.saliam.smartrent.user.domain.port.out;

import org.saliam.smartrent.user.domain.entity.User;

public interface IdentityProviderRepository
{
  void saveUser(User user);
}
