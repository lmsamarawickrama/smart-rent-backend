package org.saliam.smartrent.user.infrastructure.config;

import com.okta.sdk.client.Client;
import org.mapstruct.factory.Mappers;
import org.saliam.smartrent.user.domain.entity.User;
import org.saliam.smartrent.user.domain.port.in.UserService;
import org.saliam.smartrent.user.domain.port.out.IdentityProviderRepository;
import org.saliam.smartrent.user.domain.port.out.UserRepository;
import org.saliam.smartrent.user.domain.service.UserServiceImpl;
import org.saliam.smartrent.user.domain.specification.MandatoryAttributesNotEmpty;
import org.saliam.smartrent.user.domain.specification.NameWithinMaxLengthSpecification;
import org.saliam.smartrent.user.domain.specification.Specification;
import org.saliam.smartrent.user.domain.specification.UserNotExistsSpecification;
import org.saliam.smartrent.user.domain.specification.UserValidator;
import org.saliam.smartrent.user.infrastructure.adapter.database.mapper.UserEntityMapper;
import org.saliam.smartrent.user.infrastructure.adapter.database.repository.UserEntityRepository;
import org.saliam.smartrent.user.infrastructure.adapter.database.repository.UserRepositoryAdapter;
import org.saliam.smartrent.user.infrastructure.adapter.identityprovider.OktaIdentityProviderClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class UserConfiguration
{
  @Bean(name = "org.saliam.smartrent.user.domain.port.out.UserRepository")
  public UserRepository getUserRepository(final UserEntityRepository userEntityRepository)
  {
    return new UserRepositoryAdapter(userEntityRepository, Mappers.getMapper(UserEntityMapper.class));
  }

  @Bean(name = "org.saliam.smartrent.user.domain.port.in.UserService")
  public UserService getUserService(final UserRepository userRepository, final UserValidator userValidator,
                                    final IdentityProviderRepository identityProviderRepository)
  {
    return new UserServiceImpl(userRepository, identityProviderRepository, userValidator);
  }

  @Bean(name = "org.saliam.smartrent.user.domain.specification.UserValidator")
  public UserValidator getUserValidator(List<Specification<User>> rules)
  {
    return new UserValidator(rules);
  }

  @Bean(name = "org.saliam.smartrent.user.domain.specification.MandatoryAttributesNotEmpty")
  public Specification<User> getMandatoryAttributesNotEmpty()
  {
    return new MandatoryAttributesNotEmpty();
  }

  @Bean(name = "org.saliam.smartrent.user.domain.specification.NameWithinMaxLengthSpecification")
  public Specification<User> getNameWithinMaxLengthSpecification()
  {
    return new NameWithinMaxLengthSpecification();
  }

  @Bean(name = "org.saliam.smartrent.user.domain.specification.UserNotExistsSpecification")
  public Specification<User> getUserNotExistsSpecification(final UserRepository userRepository)
  {
    return new UserNotExistsSpecification(userRepository);
  }

  @Bean(name = "org.saliam.smartrent.user.domain.port.out.IdentityProviderRepository")
  public IdentityProviderRepository getIdentityProviderRepository(Client client, @Value("#{${okta.user.groups}}") Map<String,String> groupNameToId)
  {
    return new OktaIdentityProviderClient(client, groupNameToId);
  }
}
