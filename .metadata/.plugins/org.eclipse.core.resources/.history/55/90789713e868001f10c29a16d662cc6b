package QLNVActivityAPI.controller;

import org.springframework.web.bind.annotation.RestController;

import QLNVActivityAPI.model.Activity;
import QLNVActivityAPI.repository.ActivityRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/apiActivity")
public class ActivityController{
	@Autowired
    private ActivityRepository repo;

    @GetMapping("/")
    public List<Activity> getAllActivity() {
		return repo.findAll();
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


}
