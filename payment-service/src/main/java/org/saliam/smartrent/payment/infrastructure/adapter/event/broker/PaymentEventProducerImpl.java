package org.saliam.smartrent.payment.infrastructure.adapter.event.broker;

import org.saliam.smartrent.payment.domain.event.AuthorizedPaymentEvent;
import org.saliam.smartrent.payment.domain.event.UnAuthorizedPaymentEvent;
import org.saliam.smartrent.payment.domain.port.out.PaymentEventProducer;

public class PaymentEventProducerImpl implements PaymentEventProducer
{

  @Override public void sendAuthorizedPaymentEvent(AuthorizedPaymentEvent authorizedPaymentEvent)
  {

  }

  @Override public void sendAuthorizedPaymentEvent(UnAuthorizedPaymentEvent unAuthorizedPaymentEvent)
  {

  }
}
