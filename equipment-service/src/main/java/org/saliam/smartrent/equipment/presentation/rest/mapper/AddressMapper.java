package org.saliam.smartrent.equipment.presentation.rest.mapper;

import org.mapstruct.Mapper;
import org.saliam.smartrent.equipment.domain.entity.Address;
import org.saliam.smartrent.equipment.presentation.rest.dto.AddressDto;

@Mapper
public interface AddressMapper
{
  AddressDto fromAddress(Address address);

  Address toAddress(AddressDto addressDto);
}
