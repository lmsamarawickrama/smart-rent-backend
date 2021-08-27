package org.saliam.smartrent.equipment.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EquipmentCreateDto
{
  private String name;

  private String description;

  private String amount;

  private AddressDto address;

  private boolean rented;

  private LocationPointDto location;

}
