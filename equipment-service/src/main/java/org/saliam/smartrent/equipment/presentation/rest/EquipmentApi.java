package org.saliam.smartrent.equipment.presentation.rest;

import org.saliam.smartrent.equipment.domain.entity.Equipment;
import org.saliam.smartrent.equipment.presentation.rest.dto.EquipmentCreateDto;
import org.saliam.smartrent.equipment.presentation.rest.dto.EquipmentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EquipmentApi
{
  @PostMapping
  ResponseEntity<EquipmentDto> save(@RequestBody EquipmentCreateDto equipmentCreateDto);

  @GetMapping(value = "/{id}")
  ResponseEntity<EquipmentDto> get(@PathVariable(name = "id") String id);

  @GetMapping
  ResponseEntity<List<EquipmentDto>> getAll();

  @GetMapping(value = "/findByLocationNear")
  List<Equipment> findByLocationNear(@RequestParam String longitude, @RequestParam String latitude,
                                     @RequestParam String distance);
}
