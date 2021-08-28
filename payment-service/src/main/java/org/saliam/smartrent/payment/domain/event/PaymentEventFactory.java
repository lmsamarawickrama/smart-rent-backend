package org.saliam.smartrent.payment.domain.event;

public interface PaymentEventFactory
{
  AuthorizedPaymentEvent createAuthorizedPaymentEvent(String subjectId, String userId, String amount);

  UnAuthorizedPaymentEvent createUnAuthorizedPaymentEvent(String subjectId, String userId, String amount);
}
