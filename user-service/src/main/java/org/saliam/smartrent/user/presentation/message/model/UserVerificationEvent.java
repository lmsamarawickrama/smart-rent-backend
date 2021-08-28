package org.saliam.smartrent.user.presentation.message.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter @SuperBuilder
public abstract class UserVerificationEvent
{
  private String userId;
}
