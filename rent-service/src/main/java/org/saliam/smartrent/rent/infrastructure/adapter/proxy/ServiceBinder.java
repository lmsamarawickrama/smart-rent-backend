package org.saliam.smartrent.rent.infrastructure.adapter.proxy;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface ServiceBinder
{
  String PAYMENT_REQUESTS_OUT = "payment-requests-out";

  String USER_REQUESTS_OUT = "user-requests-out";

  @Output(PAYMENT_REQUESTS_OUT)
  SubscribableChannel paymentRequestsOut();

  @Output(USER_REQUESTS_OUT)
  SubscribableChannel userRequestsOut();
}
