package org.saliam.smartrent.payment.infrastructure.config;

import org.saliam.smartrent.payment.domain.event.PaymentEventFactory;
import org.saliam.smartrent.payment.domain.port.in.PaymentService;
import org.saliam.smartrent.payment.domain.port.out.PaymentEventProducer;
import org.saliam.smartrent.payment.domain.service.PaymentServiceImpl;
import org.saliam.smartrent.payment.infrastructure.adapter.event.PaymentEventFactoryImpl;
import org.saliam.smartrent.payment.infrastructure.adapter.event.broker.PaymentEventProducerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfiguration
{
  @Bean
  public PaymentService getPaymentService(PaymentEventFactory paymentEventFactory,
                                          PaymentEventProducer paymentEventProducer)
  {
    return new PaymentServiceImpl(paymentEventFactory, paymentEventProducer);
  }

  @Bean
  public PaymentEventFactory getPaymentEventFactory()
  {
    return new PaymentEventFactoryImpl();
  }

  @Bean
  public PaymentEventProducer getPaymentEventProducer()
  {
    return new PaymentEventProducerImpl();
  }
}
