package org.saliam.smartrent.rent.presentation.rest.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartrent.rent.domain.entity.Rent;
import org.saliam.smartrent.rent.presentation.rest.dto.RentCreateDto;
import org.saliam.smartrent.rent.presentation.rest.dto.RentDto;

@Mapper
public interface RentMapper
{
  Rent rentCreateDtoToRent(RentCreateDto rentCreateDto);

  RentDto rentToRentDto(Rent rent);
}
