package org.saliam.smartrent.user.presentation.message.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter @SuperBuilder
public class UserVerificationPassedEvent extends UserVerificationEvent
{
  private String subjectId;
}
