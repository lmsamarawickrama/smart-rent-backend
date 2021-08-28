package org.saliam.smartrent.payment.presentation.message.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class PaymentAuthorizationEvent
{
  private String name;

  private String userId;

  private String subjectId;

  private String reason;

  private boolean successful;
}
