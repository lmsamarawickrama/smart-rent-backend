package org.saliam.smartrent.payment.domain.port.in;

public interface PaymentService
{
  boolean authorizePayment(String userId, String amount);
}
