package org.saliam.smartrent.rent.domain.port.out;

public interface UserServiceProxy
{
  void verifyUser(String userId, String rentId, String replyTopic);
}
