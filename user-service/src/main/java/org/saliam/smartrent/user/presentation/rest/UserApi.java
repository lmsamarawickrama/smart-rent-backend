package org.saliam.smartrent.user.presentation.rest;

import org.saliam.smartrent.user.presentation.rest.dto.UserCreateDto;
import org.saliam.smartrent.user.presentation.rest.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserApi
{
  @PostMapping
  ResponseEntity<UserDto> save(@RequestBody UserCreateDto userCreateDto);

  @GetMapping(value = "/{id}")
  ResponseEntity<UserDto> get(@PathVariable(name = "id") Long id);

  @GetMapping
  ResponseEntity<List<UserDto>> getAll();
}
