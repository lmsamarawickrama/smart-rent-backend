package org.saliam.smartrent.payment.application;

import org.saliam.smartrent.payment.domain.port.in.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentApplicationService
{
  private final PaymentService paymentService;

  public PaymentApplicationService(PaymentService paymentService)
  {
    this.paymentService = paymentService;
  }

  public boolean authorizePayment(String userId, String amount)
  {
    return paymentService.authorizePayment(userId, amount);
  }

}
