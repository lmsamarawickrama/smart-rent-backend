package org.saliam.smartrent.user.presentation.message.broker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UserBinder
{
  String USER_REQUESTS_IN = "user-requests-in";
  String USER_RESPONSES_OUT = "user-responses-out";
  String CREATE_RENT_SAGA_OUT = "create-rent-saga-out";

  @Input(USER_REQUESTS_IN)
  SubscribableChannel userRequestsIn();

  @Output(USER_RESPONSES_OUT)
  MessageChannel userResponsesOut();

  @Output(CREATE_RENT_SAGA_OUT)
  MessageChannel createRentSagaOut();
}
