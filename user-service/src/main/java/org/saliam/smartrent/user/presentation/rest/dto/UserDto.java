package org.saliam.smartrent.user.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserDto
{
  private Long id;

  private String name;

  private String username;

  private String email;

  private List<String> groups;

  private boolean paymentVerified;
}
