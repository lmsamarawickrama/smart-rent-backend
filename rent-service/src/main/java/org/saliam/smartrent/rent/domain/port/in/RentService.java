package org.saliam.smartrent.rent.domain.port.in;

import org.saliam.smartrent.rent.domain.entity.Rent;

import java.util.List;
import java.util.Optional;

public interface RentService
{
  Rent createRent(Rent rent);

  void approveRent(String id);

  void startRent(String id);

  void closeRent(String id);

  Optional<Rent> getById(String id);

  List<Rent> getAll();

  Optional<Rent> findByRentee(String renteeId);

}
