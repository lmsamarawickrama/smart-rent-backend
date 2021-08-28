package org.saliam.smartrent.payment.presentation.message;

import org.saliam.smartrent.payment.application.PaymentApplicationService;
import org.saliam.smartrent.payment.presentation.message.model.AuthorizePaymentEvent;
import org.saliam.smartrent.payment.presentation.message.model.PaymentAuthorizationEvent;
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
    return  PaymentAuthorizationEvent
        .builder().name("Payment")
        .subjectId(authorizePaymentEvent.getSubjectId()).userId(
            authorizePaymentEvent.getUserId()).successful(authorizePayment).build();
  }
}
