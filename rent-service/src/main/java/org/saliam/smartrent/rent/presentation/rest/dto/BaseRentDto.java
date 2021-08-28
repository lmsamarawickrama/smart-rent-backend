package org.saliam.smartrent.rent.presentation.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface BaseRentDto
{
  enum PaymentMode
  {
    @JsonProperty("CASH_ON_DELIVERY")
    CASH_ON_DELIVERY,
    @JsonProperty("CREDIT_CARD")
    CREDIT_CARD,
    @JsonProperty("BANK_DEPOSIT")
    BANK_DEPOSIT
  }

  enum RentStatus
  {
    @JsonProperty("PENDING")
    PENDING,
    @JsonProperty("APPROVED")
    APPROVED,
    @JsonProperty("STARTED")
    STARTED,
    @JsonProperty("CLOSED")
    CLOSED
  }
}
