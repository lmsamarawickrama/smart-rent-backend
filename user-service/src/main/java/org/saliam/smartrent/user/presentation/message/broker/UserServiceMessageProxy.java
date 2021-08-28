package org.saliam.smartrent.user.presentation.message.broker;

import lombok.RequiredArgsConstructor;
import org.saliam.smartrent.user.presentation.message.UserMessageHandler;
import org.saliam.smartrent.user.presentation.message.model.UserVerificationEvent;
import org.saliam.smartrent.user.presentation.message.model.VerifyUserEvent;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceMessageProxy
{
  private final UserBinder userBinder;

  private final UserMessageHandler userMessageHandler;

  public void producer(Object message)
  {
    userBinder.userResponsesOut().send(MessageBuilder.withPayload(message).build());
  }

  @StreamListener(UserBinder.USER_REQUESTS_IN)
  public void onVerifyUserRequest(@Payload VerifyUserEvent verifyUserEvent)
  {
    UserVerificationEvent userVerificationEvent = userMessageHandler.isValidUser(verifyUserEvent);
    userBinder.createRentSagaOut().send(
        MessageBuilder.withPayload(userVerificationEvent).setHeader("partitionKey", verifyUserEvent.getSubjectId())
            .build());
  }

}
