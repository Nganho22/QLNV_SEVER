package QLNVActivityAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.List;
import QLNVActivityAPI.model.Activity;

public interface ActivityRepository extends MongoRepository<Activity, String>  {
	List<Activity> findByLoai(int Loai); 
	Activity findByActivityID(int ActivityID); 
	 @Query("{ 'tenHoatDong': { $regex: ?0, $options: 'i' }, 'loai': ?1  }")
	  List<Activity> findByTenHoatDongRegex(String regex,int Loai);
	  List<Activity> findAllByActivityIDIn(List<Integer> activityIDs);

	 
}
