package org.saliam.smartrent.payment.infrastructure.adapter.event;

import org.saliam.smartrent.payment.domain.event.AuthorizedPaymentEvent;
import org.saliam.smartrent.payment.domain.event.PaymentEventFactory;
import org.saliam.smartrent.payment.domain.event.UnAuthorizedPaymentEvent;

public class PaymentEventFactoryImpl implements PaymentEventFactory
{

  @Override
  public AuthorizedPaymentEvent createAuthorizedPaymentEvent(String userId, String amount)
  {
    return AuthorizedPaymentEvent.builder().userId(userId).amount(amount).transactionId("23")
        .build();
  }

  @Override
  public UnAuthorizedPaymentEvent createUnAuthorizedPaymentEvent(String userId,
                                                                 String amount)
  {
    return UnAuthorizedPaymentEvent.builder().userId(userId).amount(amount)
        .reason("In sufficient credit")
        .build();
  }
}