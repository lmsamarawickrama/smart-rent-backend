package org.saliam.smartrent.rent.domain.service;

import org.saliam.smartrent.rent.domain.entity.Rent;
import org.saliam.smartrent.rent.domain.entity.RentStatus;
import org.saliam.smartrent.rent.domain.port.in.RentService;
import org.saliam.smartrent.rent.domain.port.out.RentRepository;

import java.util.List;
import java.util.Optional;

public class RentServiceImpl implements RentService
{
  private final RentRepository rentRepository;

  public RentServiceImpl(final RentRepository rentRepository)
  {
    this.rentRepository = rentRepository;
  }

  @Override
  public Rent createRent(Rent rent)
  {
    rent.setStatus(RentStatus.PENDING);
    return rentRepository.createRent(rent);
  }

  @Override
  public void approveRent(String id)
  {
    rentRepository.approveRent(id);
  }

  @Override
  public void startRent(String id)
  {
    rentRepository.startRent(id);
  }

  @Override
  public void closeRent(String id)
  {
    rentRepository.closeRent(id);
  }

  @Override
  public Optional<Rent> getById(String id)
  {
    return rentRepository.getById(id);
  }

  @Override
  public List<Rent> getAll()
  {
    return rentRepository.getAll();
  }

  @Override
  public Optional<Rent> findByRentee(String renteeId)
  {
    return rentRepository.findByRentee(renteeId);
  }
}
