package org.saliam.smartrent.rent.presentation.rest.controller;

import org.mapstruct.factory.Mappers;
import org.saliam.smartrent.rent.application.RentApplicationService;
import org.saliam.smartrent.rent.domain.entity.Rent;
import org.saliam.smartrent.rent.presentation.rest.RentApi;
import org.saliam.smartrent.rent.presentation.rest.dto.RentCreateDto;
import org.saliam.smartrent.rent.presentation.rest.dto.RentDto;
import org.saliam.smartrent.rent.presentation.rest.mapper.RentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/smartrent/api/rent")
public class RentController implements RentApi
{
  private RentApplicationService rentApplicationService;

  private RentMapper rentMapper = Mappers.getMapper(RentMapper.class);

  @Autowired
  public void setRentApplicationService(RentApplicationService rentApplicationService)
  {
    this.rentApplicationService = rentApplicationService;
  }

  @Override
  public ResponseEntity<RentDto> save(RentCreateDto rentCreateDto)
  {
    Rent rent = rentMapper.rentCreateDtoToRent(rentCreateDto);
    RentDto rentDto = rentMapper.rentToRentDto(rentApplicationService.save(rent));
    return ResponseEntity.ok(rentDto);
  }

  @Override
  public ResponseEntity<RentDto> get(String id)
  {
    final Optional<Rent> rentById = rentApplicationService.get(id);
    return rentById.map(rent -> ResponseEntity.ok(rentMapper.rentToRentDto(rent)))
        .orElse(ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<List<RentDto>> getAll()
  {
    final List<Rent> rents = rentApplicationService.getAll();
    List<RentDto> rentDtoS = rents.stream().map(rentMapper::rentToRentDto).collect(Collectors.toList());
    return ResponseEntity.ok(rentDtoS);
  }
}
