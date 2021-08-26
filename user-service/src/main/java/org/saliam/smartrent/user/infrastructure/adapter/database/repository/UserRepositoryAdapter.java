package org.saliam.smartrent.user.infrastructure.adapter.database.repository;

import org.saliam.smartrent.user.domain.entity.User;
import org.saliam.smartrent.user.domain.port.out.UserRepository;
import org.saliam.smartrent.user.infrastructure.adapter.database.entity.UserEntity;
import org.saliam.smartrent.user.infrastructure.adapter.database.mapper.UserEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepositoryAdapter implements UserRepository
{
  private final UserEntityRepository userEntityRepository;

  private final UserEntityMapper userEntityMapper;

  public UserRepositoryAdapter(
      final UserEntityRepository userEntityRepository,
      final UserEntityMapper userEntityMapper)
  {
    this.userEntityRepository = userEntityRepository;
    this.userEntityMapper = userEntityMapper;
  }

  @Override
  public Optional<User> findByUsername(String username)
  {
    Optional<UserEntity> userEntityByName = userEntityRepository.findByUsername(username);
    return userEntityByName.map(userEntityMapper::userEntityToUser);
  }

  @Override
  public User save(User user)
  {
    UserEntity userEntity = userEntityMapper.userToUserEntity(user);
    return userEntityMapper.userEntityToUser(userEntityRepository.save(userEntity));
  }

  @Override
  public boolean existsByUsername(String username)
  {
    return userEntityRepository.existsByUsername(username);
  }

  @Override
  public Optional<User> get(Long id)
  {
    Optional<UserEntity> userById = userEntityRepository.findById(id);
    return userById.map(userEntityMapper::userEntityToUser);
  }

  @Override
  public List<User> getAll()
  {
    List<UserEntity> userEntities = userEntityRepository.findAll();
    return userEntities.stream().map(userEntityMapper::userEntityToUser).collect(Collectors.toList());
  }

}
