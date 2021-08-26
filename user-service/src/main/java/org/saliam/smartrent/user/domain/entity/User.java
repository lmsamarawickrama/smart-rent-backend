package org.saliam.smartrent.user.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class User
{
  private Long id;

  private String name;

  private String username;

  private String email;

  private String password;

  private List<String> groups;

  private boolean paymentVerified;
}
