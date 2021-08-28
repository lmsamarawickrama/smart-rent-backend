package org.saliam.smartrent.rent.domain.service.saga;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartrent.rent.domain.entity.Rent;
import org.saliam.smartrent.rent.domain.port.out.PaymentServiceProxy;
import org.saliam.smartrent.rent.domain.port.out.UserServiceProxy;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

public class CreateRentSaga
{
  private boolean userVerified;

  private boolean paymentVerified;

  private final Rent rent;

  private final UserServiceProxy userServiceProxy;

  private final PaymentServiceProxy paymentServiceProxy;

  public CreateRentSaga(Rent rent, UserServiceProxy userServiceProxy,
                        PaymentServiceProxy paymentServiceProxy)
  {
    this.rent = rent;
    this.userServiceProxy = userServiceProxy;
    this.paymentServiceProxy = paymentServiceProxy;
  }

  public void verifyUser()
  {
    userServiceProxy.verifyUser(rent.getRenteeId(), rent.getId(), "");
  }

  public void authorizePayment()
  {
    paymentServiceProxy.authorizePayment(rent.getRenteeId(), rent.getId(), "", "");
  }

  public boolean userAndPaymentVerified()
  {
    if (userVerified && paymentVerified)
    {
      return true;
    }
    try
    {
      Thread.sleep(3000);
    }
    catch (InterruptedException e)
    {
      throw new IllegalArgumentException(e);
    }
    return userVerified && paymentVerified;
  }

  @StreamListener(CreateRentSagaBinder.CREATE_RENT_SAGA_IN)
  public void onSagaResponse(@Payload CreateRentResponseEvent createRentResponseEvent)
  {
    if (createRentResponseEvent.getSubjectId().equals(rent.getId()))
    {
      switch (createRentResponseEvent.getName())
      {
        case "Payment":
          paymentVerified = true;
          break;

        case "User":
          userVerified = true;
          break;
      }
    }
  }

  @Getter @Setter
  private class CreateRentResponseEvent
  {
    private String userId;

    private String name;

    private String subjectId;

    private String reason;

    private boolean successful;
  }
}
