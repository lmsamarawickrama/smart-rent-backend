package org.saliam.smartrent.equipment.presentation.rest.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartrent.equipment.domain.entity.LocationPoint;
import org.saliam.smartrent.equipment.presentation.rest.dto.LocationPointDto;

@Mapper
public interface LocationPointMapper
{
  LocationPointDto fromLocationPoint(LocationPoint locationPoint);

  LocationPoint toLocationPoint(LocationPointDto locationPointDto);
}
