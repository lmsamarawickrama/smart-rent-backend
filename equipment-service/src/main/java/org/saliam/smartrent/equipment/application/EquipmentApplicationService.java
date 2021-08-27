package org.saliam.smartrent.equipment.application;

import org.saliam.smartrent.equipment.domain.entity.Equipment;
import org.saliam.smartrent.equipment.domain.entity.LocationPoint;
import org.saliam.smartrent.equipment.domain.port.in.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class EquipmentApplicationService
{
  private final EquipmentService equipmentService;

  @Autowired
  public EquipmentApplicationService(final EquipmentService equipmentService)
  {
    this.equipmentService = equipmentService;
  }

  @Transactional
  public Equipment save(Equipment equipment)
  {
    return equipmentService.save(equipment);
  }

  public Optional<Equipment> get(String id)
  {
    return equipmentService.findById(id);
  }

  public List<Equipment> getAll()
  {
    return equipmentService.getAll();
  }


  public List<Equipment> findByLocationNear(LocationPoint locationPoint, String distance)
  {
    return equipmentService.findByLocationNear(locationPoint, distance);
  }
}
