package org.saliam.smartrent.rent.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class RentDto implements BaseRentDto
{
  private String id;

  private String renteeId;

  private String equipmentId;

  private Date pickUpDate;

  private RentStatus status;

  private PaymentMode paymentMode;
}
