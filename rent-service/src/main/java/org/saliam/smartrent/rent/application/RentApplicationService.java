package org.saliam.smartrent.rent.application;

import org.saliam.smartrent.rent.domain.entity.Rent;
import org.saliam.smartrent.rent.domain.port.in.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class RentApplicationService
{
  private final RentService rentService;

  @Autowired
  public RentApplicationService(final RentService rentService)
  {
    this.rentService = rentService;
  }

  @Transactional
  public Rent save(Rent rent)
  {
    return rentService.createRent(rent);
  }

  public Optional<Rent> get(String id)
  {
    return rentService.getById(id);
  }

  public List<Rent> getAll()
  {
    return rentService.getAll();
  }
}
