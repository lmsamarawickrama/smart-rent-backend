package org.saliam.smartrent.rent.infrastructure.adapter.database.repository;

import org.saliam.smartrent.rent.domain.entity.Rent;
import org.saliam.smartrent.rent.domain.entity.RentStatus;
import org.saliam.smartrent.rent.domain.port.out.RentRepository;
import org.saliam.smartrent.rent.infrastructure.adapter.database.entity.RentEntity;
import org.saliam.smartrent.rent.infrastructure.adapter.database.mapper.RentEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RentRepositoryAdapter implements RentRepository
{
  private final RentEntityRepository rentEntityRepository;

  private final RentEntityMapper rentEntityMapper;

  public RentRepositoryAdapter(
      final RentEntityRepository rentEntityRepository,
      final RentEntityMapper rentEntityMapper)
  {
    this.rentEntityRepository = rentEntityRepository;
    this.rentEntityMapper = rentEntityMapper;
  }

  @Override
  public Rent createRent(Rent rent)
  {
    RentEntity rentEntity = rentEntityMapper.rentToRentEntity(rent);
    RentEntity savedRentEntity = rentEntityRepository.save(rentEntity);
    return rentEntityMapper.rentEntityToRent(savedRentEntity);
  }

  @Override
  public void approveRent(String id)
  {
    Optional<RentEntity> rentEntityById = rentEntityRepository.findById(id);
    rentEntityById.ifPresent(rentEntity -> rentEntity.setStatus(RentStatus.APPROVED));
  }

  @Override public void startRent(String id)
  {
    Optional<RentEntity> rentEntityById = rentEntityRepository.findById(id);
    rentEntityById.ifPresent(rentEntity -> rentEntity.setStatus(RentStatus.STARTED));
  }

  @Override public void closeRent(String id)
  {
    Optional<RentEntity> rentEntityById = rentEntityRepository.findById(id);
    rentEntityById.ifPresent(rentEntity -> rentEntity.setStatus(RentStatus.CLOSED));
  }

  @Override public Optional<Rent> getById(String id)
  {
    Optional<RentEntity> rentEntityById = rentEntityRepository.findById(id);
    return rentEntityById.map(rentEntityMapper::rentEntityToRent);
  }

  @Override
  public List<Rent> getAll()
  {
    List<RentEntity> rentEntities = rentEntityRepository.findAll();
    return rentEntities.stream().map(rentEntityMapper::rentEntityToRent).collect(Collectors.toList());
  }

  @Override public Optional<Rent> findByRentee(String renteeId)
  {
    Optional<RentEntity> rentEntityById = rentEntityRepository.findRentEntityByRenteeId(renteeId);
    return rentEntityById.map(rentEntityMapper::rentEntityToRent);
  }
}
