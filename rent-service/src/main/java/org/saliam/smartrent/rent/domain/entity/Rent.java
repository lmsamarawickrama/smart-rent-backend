package org.saliam.smartrent.rent.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Rent
{
  private String id;

  private String renteeId;

  private String equipmentId;

  private Date pickUpDate;

  private RentStatus status;

  private PaymentMode paymentMode;
}
