package org.saliam.smartrent.rent.domain.service.saga;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface CreateRentSagaBinder
{
  String CREATE_RENT_SAGA_IN = "create-rent-saga-in";

  @Input(CREATE_RENT_SAGA_IN)
  MessageChannel createRentSagaIn();
}
