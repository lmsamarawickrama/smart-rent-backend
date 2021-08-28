package org.saliam.smartrent.payment.domain.port.out;

import org.saliam.smartrent.payment.domain.event.AuthorizedPaymentEvent;
import org.saliam.smartrent.payment.domain.event.UnAuthorizedPaymentEvent;

public interface PaymentEventProducer
{
  void sendAuthorizedPaymentEvent(AuthorizedPaymentEvent authorizedPaymentEvent);

  void sendAuthorizedPaymentEvent(UnAuthorizedPaymentEvent unAuthorizedPaymentEvent);
}
