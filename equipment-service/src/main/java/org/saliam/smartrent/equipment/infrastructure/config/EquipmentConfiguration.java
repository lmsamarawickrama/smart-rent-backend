package org.saliam.smartrent.equipment.infrastructure.config;

import org.mapstruct.factory.Mappers;
import org.saliam.smartrent.equipment.domain.port.in.EquipmentService;
import org.saliam.smartrent.equipment.domain.port.out.EquipmentRepository;
import org.saliam.smartrent.equipment.domain.service.EquipmentServiceImpl;
import org.saliam.smartrent.equipment.infrastructure.adapter.database.mapper.EquipmentDocumentMapper;
import org.saliam.smartrent.equipment.infrastructure.adapter.database.repository.EquipmentDocumentRepository;
import org.saliam.smartrent.equipment.infrastructure.adapter.database.repository.EquipmentRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EquipmentConfiguration
{
  @Bean(name = "org.saliam.smartrent.equipment.domain.port.out.EquipmentRepository")
  public EquipmentRepository getUserRepository(final EquipmentDocumentRepository equipmentDocumentRepository)
  {
    return new EquipmentRepositoryAdapter(equipmentDocumentRepository, Mappers.getMapper(
        EquipmentDocumentMapper.class));
  }

  @Bean(name = "org.saliam.smartrent.equipment.domain.port.in.EquipmentService")
  public EquipmentService getUserService(final EquipmentRepository equipmentRepository)
  {
    return new EquipmentServiceImpl(equipmentRepository);
  }
}
