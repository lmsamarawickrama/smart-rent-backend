package org.saliam.smartrent.rent.domain.service.saga;

import org.saliam.smartrent.rent.domain.entity.Rent;
import org.saliam.smartrent.rent.domain.port.out.PaymentServiceProxy;
import org.saliam.smartrent.rent.domain.port.out.RentRepository;
import org.saliam.smartrent.rent.domain.port.out.UserServiceProxy;

public class CreateRentSagaManager
{
  private final UserServiceProxy userServiceProxy;

  private final PaymentServiceProxy paymentServiceProxy;

  private final RentRepository rentRepository;

  public CreateRentSagaManager(UserServiceProxy userServiceProxy,
                               PaymentServiceProxy paymentServiceProxy,
                               RentRepository rentRepository)
  {
    this.userServiceProxy = userServiceProxy;
    this.paymentServiceProxy = paymentServiceProxy;
    this.rentRepository = rentRepository;
  }

  public void createSaga(Rent rent)
  {
    CreateRentSaga createRentSaga = new CreateRentSaga(rent, userServiceProxy, paymentServiceProxy);
    createRentSaga.verifyUser();
    createRentSaga.authorizePayment();
    if (createRentSaga.userAndPaymentVerified())
    {
      rentRepository.approveRent(rent.getId());
    }
    else
    {
      rentRepository.closeRent(rent.getId());
    }
  }
}
