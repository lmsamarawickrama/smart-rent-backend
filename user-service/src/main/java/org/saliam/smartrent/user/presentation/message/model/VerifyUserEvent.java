package org.saliam.smartrent.user.presentation.message.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class VerifyUserEvent
{
  private String userId;

  private String subjectId;

  private String replyTopic;
}
