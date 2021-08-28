package org.saliam.smartrent.payment.presentation.message;

import org.saliam.smartrent.payment.application.PaymentApplicationService;
import org.saliam.smartrent.payment.presentation.message.model.AuthorizePaymentEvent;
import org.saliam.smartrent.payment.presentation.message.model.PaymentAuthorizationEvent;
import org.saliam.smartrent.payment.presentation.message.model.PaymentAuthorizationFailedEvent;
import org.saliam.smartrent.payment.presentation.message.model.PaymentAuthorizationPassedEvent;
import org.springframework.stereotype.Service;

@Service
public class PaymentMessageHandler
{
  private final PaymentApplicationService paymentApplicationService;

  public PaymentMessageHandler(
      PaymentApplicationService paymentApplicationService)
  {
    this.paymentApplicationService = paymentApplicationService;
  }

  public PaymentAuthorizationEvent authorizePayment(final AuthorizePaymentEvent authorizePaymentEvent)
  {
    boolean authorizePayment = paymentApplicationService.authorizePayment(authorizePaymentEvent.getUserId(),
        authorizePaymentEvent.getAmount());
    final PaymentAuthorizationEvent paymentAuthorizationEvent;
    if (authorizePayment)
    {
      paymentAuthorizationEvent = PaymentAuthorizationPassedEvent.builder()
          .subjectId(authorizePaymentEvent.getSubjectId()).userId(
              authorizePaymentEvent.getUserId()).build();
    }
    else
    {
      paymentAuthorizationEvent = PaymentAuthorizationFailedEvent.builder()
          .subjectId(authorizePaymentEvent.getSubjectId()).userId(
              authorizePaymentEvent.getUserId()).reason("User does not have enough credit").build();
    }
    return paymentAuthorizationEvent;

  }
}
