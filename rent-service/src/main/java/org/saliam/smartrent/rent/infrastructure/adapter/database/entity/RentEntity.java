package org.saliam.smartrent.rent.infrastructure.adapter.database.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.saliam.smartrent.rent.domain.entity.PaymentMode;
import org.saliam.smartrent.rent.domain.entity.RentStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "rent", uniqueConstraints = { @UniqueConstraint(columnNames = "equipmentId") })
@Getter @Setter
public class RentEntity
{
  @Id
  private String id;

  private String renteeId;

  private String equipmentId;

  private Date pickUpDate;

  @Enumerated(EnumType.STRING)
  private RentStatus status;

  @Enumerated(EnumType.STRING)
  private PaymentMode paymentMode;

  @Version
  private Integer version;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "last_updated")
  private LocalDateTime lastUpdated;

  @PrePersist
  private void ensureId()
  {
    this.setId(UUID.randomUUID().toString());
  }
}