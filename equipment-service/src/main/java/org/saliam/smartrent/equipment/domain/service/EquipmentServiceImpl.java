package org.saliam.smartrent.equipment.domain.service;

import org.saliam.smartrent.equipment.domain.entity.Equipment;
import org.saliam.smartrent.equipment.domain.entity.LocationPoint;
import org.saliam.smartrent.equipment.domain.port.in.EquipmentService;
import org.saliam.smartrent.equipment.domain.port.out.EquipmentRepository;

import java.util.List;
import java.util.Optional;

public class EquipmentServiceImpl implements EquipmentService
{
  private final EquipmentRepository equipmentRepository;

  public EquipmentServiceImpl(final EquipmentRepository equipmentRepository)
  {
    this.equipmentRepository = equipmentRepository;
  }

  @Override
  public Equipment save(Equipment equipment)
  {
    return equipmentRepository.save(equipment);
  }

  @Override
  public Optional<Equipment> findById(String id)
  {
    return equipmentRepository.findById(id);
  }

  @Override
  public List<Equipment> getAll()
  {
    return equipmentRepository.getAll();
  }

  @Override
  public List<Equipment> findByLocationNear(LocationPoint locationPoint, String distance)
  {
    return equipmentRepository.findByLocationNear(locationPoint, distance);
  }
}
