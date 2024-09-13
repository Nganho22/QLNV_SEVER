package QLNVActivityAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.List;

import QLNVActivityAPI.model.Activity;
import QLNVActivityAPI.model.JoinActivity;

public interface JoinActivityRepository extends MongoRepository<JoinActivity, String> {
	List<JoinActivity> findByEmployeeID(int employeeID); 
	List<JoinActivity> findByActivityID(int activityID); 
    long countByActivityIDAndEmployeeID(int activityID, int employeeID);

}
