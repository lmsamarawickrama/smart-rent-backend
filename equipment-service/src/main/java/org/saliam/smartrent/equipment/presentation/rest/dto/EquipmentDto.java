package org.saliam.smartrent.equipment.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartrent.equipment.domain.entity.LocationPoint;

@Getter @Setter
public class EquipmentDto
{
  private String id;

  private String ownerId;

  private String name;

  private String description;

  private String amount;

  private AddressDto address;

  private LocationPoint location;
}
