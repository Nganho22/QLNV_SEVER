package QLNVdbsAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import QLNVdbsAPI.model.Database;
import java.util.Optional;
import java.util.List;

public interface DatabaseRepository extends MongoRepository<Database, String> {
    List<Database> findByServiceID(int ServiceID); // This should match the property name in your Database class
}