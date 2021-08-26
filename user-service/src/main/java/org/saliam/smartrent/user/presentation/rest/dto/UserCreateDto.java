package org.saliam.smartrent.user.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserCreateDto
{
  private String name;

  private String username;

  private String email;

  private String password;

  private List<String> groups;

  private boolean paymentVerified;
}
