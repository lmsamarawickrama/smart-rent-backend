package org.saliam.smartrent.payment.domain.service;

import org.saliam.smartrent.payment.domain.event.AuthorizedPaymentEvent;
import org.saliam.smartrent.payment.domain.event.PaymentEventFactory;
import org.saliam.smartrent.payment.domain.port.in.PaymentService;
import org.saliam.smartrent.payment.domain.port.out.PaymentEventProducer;

public class PaymentServiceImpl implements PaymentService
{

  private final PaymentEventFactory paymentEventFactory;

  private final PaymentEventProducer paymentEventProducer;

  public PaymentServiceImpl(PaymentEventFactory paymentEventFactory,
                            PaymentEventProducer paymentEventProducer)
  {
    this.paymentEventFactory = paymentEventFactory;
    this.paymentEventProducer = paymentEventProducer;
  }

  @Override
  public void authorizePayment(String subjectId, String userId, String amount)
  {
    AuthorizedPaymentEvent authorizedPaymentEvent = paymentEventFactory
        .createAuthorizedPaymentEvent(subjectId, userId, amount);
    paymentEventProducer.sendAuthorizedPaymentEvent(authorizedPaymentEvent);
  }
}
