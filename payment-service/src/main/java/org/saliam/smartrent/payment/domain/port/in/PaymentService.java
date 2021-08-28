package org.saliam.smartrent.payment.domain.port.in;

public interface PaymentService
{
  void authorizePayment(String subjectId, String userId, String amount);
}
