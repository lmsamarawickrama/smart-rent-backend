package org.saliam.smartrent.user.presentation.message;

import org.saliam.smartrent.user.application.UserApplicationService;
import org.saliam.smartrent.user.presentation.message.model.UserVerificationEvent;
import org.saliam.smartrent.user.presentation.message.model.UserVerificationFailedEvent;
import org.saliam.smartrent.user.presentation.message.model.UserVerificationPassedEvent;
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
    final UserVerificationEvent userVerificationEvent;
    if (isValidUser)
    {
      userVerificationEvent = UserVerificationPassedEvent.builder()
          .subjectId(verifyUserEvent.getSubjectId()).userId(
              verifyUserEvent.getUserId()).build();
    }
    else
    {
      userVerificationEvent = UserVerificationFailedEvent.builder()
          .subjectId(verifyUserEvent.getSubjectId()).userId(
              verifyUserEvent.getUserId()).reason("User does not exists").build();
    }
    return userVerificationEvent;

  }
}
