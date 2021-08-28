package org.saliam.smartrent.payment.presentation.message.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AuthorizePaymentEvent
{
  private String userId;

  private String subjectId;

  private String amount;

  private String replyTopic;
}
