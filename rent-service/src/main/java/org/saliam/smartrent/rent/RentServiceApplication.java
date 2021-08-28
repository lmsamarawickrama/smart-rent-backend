package org.saliam.smartrent.rent;

import org.saliam.smartrent.rent.domain.service.saga.CreateRentSagaBinder;
import org.saliam.smartrent.rent.infrastructure.adapter.proxy.ServiceBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(value = { ServiceBinder.class })
public class RentServiceApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(RentServiceApplication.class, args);
  }

}
