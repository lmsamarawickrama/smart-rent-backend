package org.saliam.smartrent.payment.presentation.message.broker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PaymentBinder
{
  String PAYMENT_REQUESTS_IN = "payment-requests-in";
  String PAYMENT_RESPONSES_OUT = "payment-responses-out";
  String CREATE_RENT_SAGA_OUT = "create-rent-saga-out";

  @Input(PAYMENT_REQUESTS_IN)
  SubscribableChannel paymentRequestsIn();

  @Output(PAYMENT_RESPONSES_OUT)
  MessageChannel paymentResponsesOut();

  @Output(CREATE_RENT_SAGA_OUT)
  MessageChannel createRentSagaOut();
}
