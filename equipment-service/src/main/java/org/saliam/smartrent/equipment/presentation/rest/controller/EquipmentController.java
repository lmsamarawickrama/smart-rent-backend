package org.saliam.smartrent.equipment.presentation.rest.controller;

import org.mapstruct.factory.Mappers;
import org.saliam.smartrent.equipment.application.EquipmentApplicationService;
import org.saliam.smartrent.equipment.domain.entity.Equipment;
import org.saliam.smartrent.equipment.domain.entity.LocationPoint;
import org.saliam.smartrent.equipment.presentation.rest.EquipmentApi;
import org.saliam.smartrent.equipment.presentation.rest.dto.EquipmentCreateDto;
import org.saliam.smartrent.equipment.presentation.rest.dto.EquipmentDto;
import org.saliam.smartrent.equipment.presentation.rest.mapper.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/smartrent/api/equipment")
public class EquipmentController implements EquipmentApi
{
  private EquipmentApplicationService equipmentApplicationService;

  private EquipmentMapper equipmentMapper = Mappers.getMapper(EquipmentMapper.class);

  @Autowired
  public void setEquipmentApplicationService(EquipmentApplicationService equipmentApplicationService)
  {
    this.equipmentApplicationService = equipmentApplicationService;
  }

  @Override
  public ResponseEntity<EquipmentDto> save(EquipmentCreateDto equipmentCreateDto)
  {
    Equipment equipment = equipmentMapper.equipmentCreateDtoToEquipment(equipmentCreateDto);
    EquipmentDto saveEquipment = equipmentMapper.equipmentToEquipmentDto(
        equipmentApplicationService.save(equipment));
    return ResponseEntity.ok(saveEquipment);
  }

  @Override
  public ResponseEntity<EquipmentDto> get(String id)
  {
    final Optional<Equipment> equipmentById = equipmentApplicationService.get(id);
    return equipmentById.map(equipment -> ResponseEntity.ok(equipmentMapper.equipmentToEquipmentDto(equipment)))
        .orElse(ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<List<EquipmentDto>> getAll()
  {
    final List<Equipment> equipments = equipmentApplicationService.getAll();
    List<EquipmentDto> equipmentDtoS = equipments.stream()
        .map(equipmentMapper::equipmentToEquipmentDto).collect(Collectors.toList());
    return ResponseEntity.ok(equipmentDtoS);
  }

  @Override
  public List<Equipment> findByLocationNear(String longitude, String latitude,
                                            String distance)
  {
    return equipmentApplicationService.findByLocationNear(new LocationPoint(latitude, longitude), distance);
  }
}
