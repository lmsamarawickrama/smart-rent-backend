package org.saliam.smartrent.rent.infrastructure.adapter.database.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartrent.rent.domain.entity.Rent;
import org.saliam.smartrent.rent.infrastructure.adapter.database.entity.RentEntity;

@Mapper
public interface RentEntityMapper
{
  RentEntity rentToRentEntity(Rent rent);

  Rent rentEntityToRent(RentEntity rentEntity);
}
