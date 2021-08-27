package org.saliam.smartrent.equipment.infrastructure.adapter.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.saliam.smartrent.equipment.domain.entity.Equipment;
import org.saliam.smartrent.equipment.domain.entity.LocationPoint;
import org.saliam.smartrent.equipment.infrastructure.adapter.database.document.EquipmentDocument;
import org.springframework.data.geo.Point;

@Mapper
public interface EquipmentDocumentMapper
{
  @Mappings({
      @Mapping(source = "equipment.location", target = "location", qualifiedByName = "locationPointToLocation"),
  })
  EquipmentDocument toEquipmentDocument(Equipment equipment);

  @Mappings({
      @Mapping(source = "equipmentDocument.location", target = "location", qualifiedByName = "pointToLocationPoint"),
  })
  Equipment fromEquipmentDocument(EquipmentDocument equipmentDocument);

  @Named("locationPointToLocation")
  static Point locationPointToLocation(LocationPoint locationPoint)
  {
    return new Point(Double.parseDouble(locationPoint.getLatitude()), Double.parseDouble(locationPoint.getLongitude()));
  }

  @Named("pointToLocationPoint")
  static LocationPoint pointToLocationPoint(Point point)
  {
    return new LocationPoint(String.valueOf(point.getX()), String.valueOf(point.getY()));
  }
}
