package org.saliam.smartrent.payment;

import org.saliam.smartrent.payment.presentation.message.broker.PaymentBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(value = { PaymentBinder.class })
public class PaymentServiceApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(PaymentServiceApplication.class, args);
  }

}
