package org.saliam.smartrent.equipment.infrastructure.adapter.database.repository;

import org.saliam.smartrent.equipment.infrastructure.adapter.database.document.EquipmentDocument;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDocumentRepository
    extends MongoRepository<EquipmentDocument, String>
{
  GeoResults<EquipmentDocument> findByLocationNear(Point p, Distance d);
}
