package org.saliam.smartrent.user.presentation.message;

import org.saliam.smartrent.user.application.UserApplicationService;
import org.saliam.smartrent.user.presentation.message.model.UserVerificationEvent;
import org.saliam.smartrent.user.presentation.message.model.VerifyUserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageHandler
{
  private final UserApplicationService userApplicationService;

  @Autowired
  public UserMessageHandler(UserApplicationService userApplicationService)
  {
    this.userApplicationService = userApplicationService;
  }

  public UserVerificationEvent isValidUser(final VerifyUserEvent verifyUserEvent)
  {
    boolean isValidUser = userApplicationService.isValidUser(verifyUserEvent.getUserId());
     return UserVerificationEvent
        .builder().name("User")
        .subjectId(verifyUserEvent.getSubjectId()).userId(
            verifyUserEvent.getUserId()).successful(isValidUser).build();

  }
}
