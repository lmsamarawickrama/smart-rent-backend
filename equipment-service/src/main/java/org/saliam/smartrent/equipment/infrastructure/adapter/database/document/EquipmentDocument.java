package org.saliam.smartrent.equipment.infrastructure.adapter.database.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import static org.springframework.data.mongodb.core.index.GeoSpatialIndexType.GEO_2DSPHERE;

@Getter @Setter
@Document(collection = "equipment")
public class EquipmentDocument
{
  @Id
  private String id;

  private String ownerId;

  private String name;

  private String description;

  private String amount;

  private AddressValueObject address;

  @GeoSpatialIndexed(type = GEO_2DSPHERE)
  private Point location;

}