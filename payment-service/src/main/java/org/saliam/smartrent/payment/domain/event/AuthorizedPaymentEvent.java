package org.saliam.smartrent.payment.domain.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class AuthorizedPaymentEvent
{
  private String subjectId;

  private String transactionId;

  private String userId;

  private String amount;



}
