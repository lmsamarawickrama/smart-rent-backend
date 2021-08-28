package org.saliam.smartrent.rent.infrastructure.adapter.database.repository;

import org.saliam.smartrent.rent.infrastructure.adapter.database.entity.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentEntityRepository extends JpaRepository<RentEntity, String>, JpaSpecificationExecutor<RentEntity>
{
  Optional<RentEntity> findRentEntityByRenteeId(String renteeId);

}
