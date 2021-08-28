package org.saliam.smartrent.rent.infrastructure.adapter.proxy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.saliam.smartrent.rent.domain.port.out.PaymentServiceProxy;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentServiceProxyImpl implements PaymentServiceProxy
{
  private final ServiceBinder serviceBinder;

  @Override
  public void authorizePayment(String userId, String rentId, String amount, String replyTopic)
  {
    final AuthorizePaymentEvent authorizePaymentEvent = new AuthorizePaymentEvent();
    authorizePaymentEvent.setUserId(userId);
    authorizePaymentEvent.setSubjectId(rentId);
    authorizePaymentEvent.setAmount(amount);
    authorizePaymentEvent.setReplyTopic(replyTopic);
    serviceBinder.paymentRequestsOut().send(MessageBuilder.withPayload(authorizePaymentEvent).build());

  }

  @Getter @Setter
  private static class AuthorizePaymentEvent
  {
    private String userId;

    private String subjectId;

    private String amount;

    private String replyTopic;
  }
}
