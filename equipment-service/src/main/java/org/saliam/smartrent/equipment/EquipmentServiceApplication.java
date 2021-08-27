package org.saliam.smartrent.equipment;

import org.saliam.smartrent.equipment.infrastructure.adapter.database.repository.EquipmentDocumentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = EquipmentDocumentRepository.class)
public class EquipmentServiceApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(EquipmentServiceApplication.class, args);
  }

}
