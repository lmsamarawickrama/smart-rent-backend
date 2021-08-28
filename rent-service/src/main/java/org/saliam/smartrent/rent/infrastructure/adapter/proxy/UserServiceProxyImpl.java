package org.saliam.smartrent.rent.infrastructure.adapter.proxy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.saliam.smartrent.rent.domain.port.out.UserServiceProxy;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceProxyImpl implements UserServiceProxy
{
  private final ServiceBinder serviceBinder;

  @Override
  public void verifyUser(String userId, String rentId, String replyTopic)
  {
    VerifyUserEvent verifyUserEvent = new VerifyUserEvent();
    verifyUserEvent.setUserId(userId);
    verifyUserEvent.setSubjectId(rentId);
    verifyUserEvent.setReplyTopic(replyTopic);
    serviceBinder.userRequestsOut().send(MessageBuilder.withPayload(verifyUserEvent).build());
  }

  @Getter @Setter
  private static class VerifyUserEvent
  {
    private String userId;

    private String subjectId;

    private String replyTopic;
  }
}
