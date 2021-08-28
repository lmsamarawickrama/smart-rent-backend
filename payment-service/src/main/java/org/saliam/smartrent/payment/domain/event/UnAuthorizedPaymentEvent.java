package org.saliam.smartrent.payment.domain.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class UnAuthorizedPaymentEvent
{
  private String subjectId;

  private String userId;

  private String amount;

  private String reason;
}
