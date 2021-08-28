package org.saliam.smartrent.rent.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class RentCreateDto implements BaseRentDto
{
  private String renteeId;

  private String equipmentId;

  private Date pickUpDate;

  private PaymentMode paymentMode;

}
