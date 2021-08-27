package org.saliam.smartrent.equipment.presentation.rest.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartrent.equipment.domain.entity.Equipment;
import org.saliam.smartrent.equipment.presentation.rest.dto.EquipmentCreateDto;
import org.saliam.smartrent.equipment.presentation.rest.dto.EquipmentDto;

@Mapper(uses = { AddressMapper.class, LocationPointMapper.class })
public interface EquipmentMapper
{
  Equipment equipmentCreateDtoToEquipment(EquipmentCreateDto equipmentCreateDto);

  EquipmentDto equipmentToEquipmentDto(Equipment equipment);
}
