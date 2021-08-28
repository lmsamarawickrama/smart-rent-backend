package org.saliam.smartrent.payment.presentation.message.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter @SuperBuilder
public class PaymentAuthorizationPassedEvent extends PaymentAuthorizationEvent
{
  private String subjectId;
}
