package org.saliam.smartrent.user.presentation.message.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class UserVerificationEvent
{
  private String userId;

  private String name;

  private String subjectId;

  private String reason;

  private boolean successful;
}
