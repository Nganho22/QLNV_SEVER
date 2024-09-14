package QLNVActivityAPI.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import QLNVActivityAPI.model.Activity;
import QLNVActivityAPI.model.JoinActivity;
import QLNVActivityAPI.repository.JoinActivityRepository;
import QLNVActivityAPI.repository.ActivityRepository;
import QLNVActivityAPI.service.JoinActivityService;
import QLNVActivity.config.appConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/apiActivity")
public class ActivityController{
	 @Autowired
	    private MongoTemplate mongoTemplate;
	
	@Autowired
    private ActivityRepository repo;

	@Autowired
    private JoinActivityRepository join;
	
    @Autowired
    private JoinActivityService joinActivityService;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/activityAndProfile/{activityID}")
    public Map<String, Object> getActivityAndProfile(@PathVariable("activityID") int activityID) {
        Activity activity = repo.findByActivityID(activityID);

        List<JoinActivity> joinAcs = join.findByActivityID(activityID);

        List<Map<String, Object>> profiles = new ArrayList<>();

        for (JoinActivity joinActivity : joinAcs) {
            int empID = joinActivity.getEmployeeID();

            String profileServiceUrl = "http://localhost:9003/apiProfile/findByID/" + empID;
            Map<String, Object> profile = restTemplate.getForObject(profileServiceUrl, Map.class);

            profiles.add(profile);
        }

        Map<String, Object> combinedData = new HashMap<>();
        combinedData.put("activity", activity); 
        combinedData.put("profiles", profiles); 

        return combinedData;
    }






    @GetMapping("/")
    public List<Activity> getAllActivity() {
		return repo.findAll();
	}
    
    @GetMapping("/join/")
    public List<JoinActivity> getAllJoinActivity() {
		return join.findAll();
	}
    
    @GetMapping("/join/SearchByempID/{empid}")
    public ResponseEntity<List<Activity>> getAllJoinActivityByEmpID(@PathVariable("empid") int empid) {
        List<Activity> activities = joinActivityService.getActivitiesByEmployeeID(empid);
        return ResponseEntity.ok(activities);
    }
    @GetMapping("/join/countt")
    public ResponseEntity<Long> countJoinActivity(@RequestParam("activityID") int activityID,@RequestParam("empID") int empID) {
        long count = joinActivityService.countJoinActivityByActivityIDAndEmployeeID(activityID, empID);
        return ResponseEntity.ok(count);
    }
    
    @PostMapping("/join/create")
    public ResponseEntity<JoinActivity> createJoinActivity(@RequestParam int activityID, @RequestParam int employeeID) {
        long count = join.countByActivityIDAndEmployeeID(activityID, employeeID);
        
        if (count > 0) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        
       
        JoinActivity joinActivity = new JoinActivity(activityID, employeeID, LocalDate.now());

        JoinActivity savedJoinActivity = join.save(joinActivity);

        return new ResponseEntity<>(savedJoinActivity, HttpStatus.CREATED);
    }

    
    @GetMapping("/month/{month}")
    public List<Activity> getActivitiesByMonth(@PathVariable("month") int month) {
        List<Activity> allActivities = repo.findAll();
        
        // Filter activities by matching the month in any of the three date fields
        return allActivities.stream()
            .filter(activity -> 
                isMonthMatch(activity.getHanCuoiDangKy(), month) ||
                isMonthMatch(activity.getNgayBatDau(), month) ||
                isMonthMatch(activity.getNgayKetThuc(), month)
            )
            .collect(Collectors.toList());
    }

    private boolean isMonthMatch(LocalDate date, int month) {
        return date != null && date.getMonthValue() == month;
    }
    
    @GetMapping("/type/{Loai}")
    public List<Activity> getActivityByLoai(@PathVariable("Loai") int Loai) {
        System.out.println("Received Loai: " + Loai);
        return repo.findByLoai(Loai); 
    }
    
    
    @GetMapping("/searchCoBan")
    public List<Activity> searchActivitiesCoBan(@RequestParam("Ten") String searchTerm) {
    	int Loai = 1;
        if (searchTerm == null)
        {
        	 return repo.findByLoai(Loai); 
        }
        else {
	    	String escapedTerm = searchTerm.replaceAll("([\\W])", "\\\\$1");
	        String regex = "(?i).*" + escapedTerm + ".*";
	        System.out.println("Searching with regex: " + regex);
	        return repo.findByTenHoatDongRegex(regex,Loai);
        }
    }
    
    @GetMapping("/searchLienKet")
    public List<Activity> searchActivitiesLienKet(@RequestParam("Ten") String searchTerm) {
        int Loai = 2;
        if (searchTerm == null)
        {
        	 return repo.findByLoai(Loai); 
        }
        else {
        	 String escapedTerm = searchTerm.replaceAll("([\\W])", "\\\\$1");
             String regex = "(?i).*" + escapedTerm + ".*";
             System.out.println("Searching with regex: " + regex);
             return repo.findByTenHoatDongRegex(regex,Loai);

        }
       
    }
    @GetMapping("/countByMonth/{month}")
    public ResponseEntity<Long> countActivitiesByMonth(@PathVariable("month") int month) {
    	List<Activity> allActivities = repo.findAll();

        List<Activity> filteredActivities = allActivities.stream()
            .filter(activity -> 
                isMonthMatch(activity.getHanCuoiDangKy(), month) ||
                isMonthMatch(activity.getNgayBatDau(), month) ||
                isMonthMatch(activity.getNgayKetThuc(), month)
            )
            .collect(Collectors.toList());

        long count = filteredActivities.size();
        
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/countall")
    public ResponseEntity<Long> countActivities() {
    	long count = repo.count();
        
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/Activity/{ActivityID}")
    public Activity getActivityByID(@PathVariable("ActivityID") int ActivityID) {
        return repo.findByActivityID(ActivityID); 
    }


}
