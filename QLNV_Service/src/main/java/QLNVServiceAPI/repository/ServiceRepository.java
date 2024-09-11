package QLNVServiceAPI.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.List;

import QLNVServiceAPI.model.Service;
public interface ServiceRepository extends MongoRepository<Service, String> {

}
