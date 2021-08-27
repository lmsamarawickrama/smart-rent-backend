package org.saliam.smartrent.equipment.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class LocationPoint
{
  private String latitude;

  private String longitude;
}
