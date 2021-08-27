package org.saliam.smartrent.equipment.domain.port.out;

import org.saliam.smartrent.equipment.domain.entity.Equipment;
import org.saliam.smartrent.equipment.domain.entity.LocationPoint;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository
{
  Equipment save(Equipment equipment);

  Optional<Equipment> findById(String id);

  List<Equipment> getAll();

  List<Equipment> findByLocationNear(LocationPoint locationPoint, String distance);
}
