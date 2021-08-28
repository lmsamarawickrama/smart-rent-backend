package org.saliam.smartrent.rent.presentation.rest;

import org.saliam.smartrent.rent.presentation.rest.dto.RentCreateDto;
import org.saliam.smartrent.rent.presentation.rest.dto.RentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RentApi
{
  @PostMapping
  ResponseEntity<RentDto> save(@RequestBody RentCreateDto rentCreateDto);

  @GetMapping(value = "/{id}")
  ResponseEntity<RentDto> get(@PathVariable(name = "id") String id);

  @GetMapping
  ResponseEntity<List<RentDto>> getAll();
}
