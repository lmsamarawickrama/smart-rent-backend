package org.saliam.smartrent.payment.domain.event;

public interface PaymentEventFactory
{
  AuthorizedPaymentEvent createAuthorizedPaymentEvent(String userId, String amount);

  UnAuthorizedPaymentEvent createUnAuthorizedPaymentEvent(String userId, String amount);
}
