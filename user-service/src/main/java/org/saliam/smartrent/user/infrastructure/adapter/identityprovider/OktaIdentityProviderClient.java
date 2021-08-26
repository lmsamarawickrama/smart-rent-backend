package org.saliam.smartrent.user.infrastructure.adapter.identityprovider;

import com.okta.sdk.client.Client;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.sdk.resource.user.UserProfile;
import org.saliam.smartrent.user.domain.entity.User;
import org.saliam.smartrent.user.domain.port.out.IdentityProviderRepository;

import java.util.Map;
import java.util.stream.Collectors;

public class OktaIdentityProviderClient implements IdentityProviderRepository
{
  private final Client client;

  private final Map<String, String> groupNameToId;

  public OktaIdentityProviderClient(Client client, Map<String, String> groupNameToId)
  {
    this.client = client;
    this.groupNameToId = groupNameToId;
  }

  @Override
  public void saveUser(User user)
  {
    UserBuilder.instance().setEmail(user.getEmail())
        .setLogin(user.getUsername()).setFirstName(user.getName()).setLastName(user.getName())
        .setPassword(user.getPassword().toCharArray()).setActive(true)
        .setGroups(user.getGroups().stream().map(groupNameToId::get).collect(Collectors.toSet()))
        .buildAndCreate(client);

  }
}
