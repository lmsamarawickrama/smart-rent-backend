package org.saliam.smartrent.rent.domain.port.out;

public interface PaymentServiceProxy
{
  void authorizePayment(String userId, String rentId, String amount, String replyTopic);
}


