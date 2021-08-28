package org.saliam.smartrent.rent.infrastructure.config;

import org.mapstruct.factory.Mappers;
import org.saliam.smartrent.rent.domain.port.in.RentService;
import org.saliam.smartrent.rent.domain.port.out.RentRepository;
import org.saliam.smartrent.rent.domain.service.RentServiceImpl;
import org.saliam.smartrent.rent.infrastructure.adapter.database.mapper.RentEntityMapper;
import org.saliam.smartrent.rent.infrastructure.adapter.database.repository.RentEntityRepository;
import org.saliam.smartrent.rent.infrastructure.adapter.database.repository.RentRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RentConfiguration
{
  @Bean(name = "org.saliam.smartrent.rent.domain.port.out.RentRepository")
  public RentRepository getRentRepository(final RentEntityRepository rentEntityRepository)
  {
    return new RentRepositoryAdapter(rentEntityRepository, Mappers.getMapper(RentEntityMapper.class));
  }

  @Bean(name = "org.saliam.smartrent.rent.domain.port.in.RentService")
  public RentService getRentService(final RentRepository rentRepository)
  {
    return new RentServiceImpl(rentRepository);
  }
}
