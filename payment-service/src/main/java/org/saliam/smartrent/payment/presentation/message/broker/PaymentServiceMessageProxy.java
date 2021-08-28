package org.saliam.smartrent.payment.presentation.message.broker;

import lombok.RequiredArgsConstructor;
import org.saliam.smartrent.payment.presentation.message.PaymentMessageHandler;
import org.saliam.smartrent.payment.presentation.message.model.AuthorizePaymentEvent;
import org.saliam.smartrent.payment.presentation.message.model.PaymentAuthorizationEvent;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentServiceMessageProxy
{
  private final PaymentBinder paymentBinder;

  private final PaymentMessageHandler paymentMessageHandler;

  public void producer(Object message)
  {
    paymentBinder.paymentResponsesOut().send(MessageBuilder.withPayload(message).build());
  }

  @StreamListener(PaymentBinder.PAYMENT_REQUESTS_IN)
  public void onVerifyUserRequest(@Payload AuthorizePaymentEvent authorizePaymentEvent)
  {
    PaymentAuthorizationEvent paymentAuthorizationEvent = paymentMessageHandler.authorizePayment(authorizePaymentEvent);
    paymentBinder.createRentSagaOut().send(
        MessageBuilder.withPayload(paymentAuthorizationEvent)
            .setHeader("partitionKey", authorizePaymentEvent.getSubjectId())
            .build());
  }

}
