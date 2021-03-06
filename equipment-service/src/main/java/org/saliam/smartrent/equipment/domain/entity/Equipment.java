package org.saliam.smartrent.equipment.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Equipment
{
  private String id;

  private String ownerId;

  private String name;

  private String description;

  private String amount;

  private Address address;

  private LocationPoint location;

}
