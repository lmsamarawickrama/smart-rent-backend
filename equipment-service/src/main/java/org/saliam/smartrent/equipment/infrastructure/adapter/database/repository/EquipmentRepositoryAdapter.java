package org.saliam.smartrent.equipment.infrastructure.adapter.database.repository;

import org.saliam.smartrent.equipment.domain.entity.Equipment;
import org.saliam.smartrent.equipment.domain.entity.LocationPoint;
import org.saliam.smartrent.equipment.domain.port.out.EquipmentRepository;
import org.saliam.smartrent.equipment.infrastructure.adapter.database.document.EquipmentDocument;
import org.saliam.smartrent.equipment.infrastructure.adapter.database.mapper.EquipmentDocumentMapper;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EquipmentRepositoryAdapter implements EquipmentRepository
{
  private final EquipmentDocumentRepository equipmentDocumentRepository;

  private final EquipmentDocumentMapper equipmentDocumentMapper;

  public EquipmentRepositoryAdapter(
      EquipmentDocumentRepository equipmentDocumentRepository,
      EquipmentDocumentMapper equipmentDocumentMapper)
  {
    this.equipmentDocumentRepository = equipmentDocumentRepository;
    this.equipmentDocumentMapper = equipmentDocumentMapper;
  }

  @Override
  public Equipment save(Equipment equipment)
  {
    EquipmentDocument equipmentDocument = equipmentDocumentMapper.toEquipmentDocument(equipment);
    EquipmentDocument savedEquipmentDocument = equipmentDocumentRepository.save(equipmentDocument);
    return equipmentDocumentMapper.fromEquipmentDocument(savedEquipmentDocument);
  }

  @Override public Optional<Equipment> findById(String id)
  {
    Optional<EquipmentDocument> equipmentDocument = equipmentDocumentRepository.findById(id);
    return equipmentDocument.map(equipmentDocumentMapper::fromEquipmentDocument);
  }

  @Override public List<Equipment> getAll()
  {
    return equipmentDocumentRepository.findAll().stream().map(equipmentDocumentMapper::fromEquipmentDocument).collect(
        Collectors.toList());
  }

  @Override public List<Equipment> findByLocationNear(final LocationPoint locationPoint, final String distance)
  {
    GeoResults<EquipmentDocument> equipmentsNear = equipmentDocumentRepository.findByLocationNear(
        new Point(Double.parseDouble(locationPoint.getLatitude()), Double.parseDouble(locationPoint.getLongitude())),
        new Distance(Double.parseDouble(distance), Metrics.KILOMETERS));
    return equipmentsNear.getContent().stream().map(equipmentDocumentGeoResult -> equipmentDocumentMapper
        .fromEquipmentDocument(equipmentDocumentGeoResult.getContent())).collect(
        Collectors.toList());
  }
}
