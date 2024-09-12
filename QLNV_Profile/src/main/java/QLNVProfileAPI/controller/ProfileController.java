package QLNVProfileAPI.controller;

import QLNVProfileAPI.model.PhongBan;
import QLNVProfileAPI.model.*;

import QLNVProfileAPI.service.ProfileService;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.dao.EmptyResultDataAccessException;

@RestController
@RequestMapping("/apiProfile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;


    @GetMapping("/")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }
    
    @GetMapping("/findByID/{empID}")
    public Profile getActiveByID(@PathVariable("empID") int empID) {
        Profile profile = profileService.findProfileByEmpID(empID);
        
        if (profile != null && profile.getphongid() != null) {
        	profile.settenphong(profileService.getTenPhongByPhongID(profile.getphongid()));
        }
        return profile;
    }
    
    @GetMapping("/PhongBan/{phongID}")
    public PhongBan getPhongBanByID(@PathVariable("phongID") String phongID) {
        return profileService.getPhongBanByPhongID(phongID);
    }
    
    @GetMapping("/PhongBan/")
    public List<PhongBan> getAllPhongBan() {
        return profileService.getAllPhongBan();
    }
    
    @GetMapping("/CurrentTimesheet/{empID}")
    public CheckInout getCurrentTimesheet(@PathVariable("empID") int empID) {
        return profileService.getCurrentTimeSheetByEmpID(empID);
    }
    
    @GetMapping("/CountNghiByID/{empID}")
    public ResponseEntity<Integer> getCountNghiByID(@PathVariable("empID") int empID) {
        try {
            int count = profileService.getCountNghiID(empID);
            return ResponseEntity.ok(count); // Return the count if found
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.ok(0); // If no result, return 0
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(0); // Handle any unexpected errors
        }
    }
    
    @GetMapping("/CountLateByID/{empID}")
    public ResponseEntity<Integer> getCountLateByID(@PathVariable("empID") int empID) {
        try {
            int count = profileService.getCountLateID(empID);
            return ResponseEntity.ok(count); // Return the count if found
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.ok(0); // If no result, return 0
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(0); // Handle any unexpected errors
        }
    }
    @GetMapping("/totalPointsByMonth/{empID}")
    public ResponseEntity<List<Map<String, Object>>> getTotalPointsByMonth(@PathVariable("empID") int empID) {
        List<Map<String, Object>> data = profileService.getTotalPointsByMonth(empID);
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/GetTimesheetsByID/{empID}")
    public List<CheckInout> getTimesheetsByID(@PathVariable("empID") int empID) {
        return profileService.getListTimeSheetsByEmpID(empID);
    }
    
    @PutMapping("/UpdateCheckin/{stt}")
    public int updateCheckInTime(@PathVariable("stt") int stt) {
        return profileService.updateCheckInTime(stt);
    }
    
    @GetMapping("/getActiveProfile")
    public Profile getActiveProfile(@RequestParam String tenTaiKhoan,
                                    @RequestParam String matKhau) {
        Profile profile = profileService.getActiveProfile(tenTaiKhoan, matKhau, 1);
        
        if (profile != null && profile.getphongid() != null) {
        	profile.settenphong(profileService.getTenPhongByPhongID(profile.getphongid()));
        }
        return profile;
    }
    
    @GetMapping("/getProfileNVByQL")
    public List<Profile> getProfiles(
            @RequestParam int empid, 
            @RequestParam String hoten, 
            @RequestParam int limit, 
            @RequestParam int offset) {
        return profileService.getProfilesByPhongIDAndHoteen(empid, hoten, limit, offset);
    }
    
    @PutMapping("/updateProfile")
    public ResponseEntity<String> updateProfile(
            @RequestParam int empID, 
            @RequestParam String gioiTinh, 
            @RequestParam String cccd, 
            @RequestParam String sdt, 
            @RequestParam String stk, 
            @RequestParam String diaChi, 
            @RequestParam String image, 
            @RequestParam(required = false) String newPass) {
        
        boolean isUpdated = profileService.updateProfile(empID, gioiTinh, cccd, sdt, stk, diaChi, image, newPass);
        
        if (isUpdated) {
            return ResponseEntity.ok("Profile updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.SC_SERVER_ERROR).body("Failed to update profile.");
        }
    }
    
    @GetMapping("/countProfilesInSamePhongBan")
    public ResponseEntity<Integer> countProfilesInSamePhongBan(
            @RequestParam int empID, 
            @RequestParam String hoTen) {
        
        int count = profileService.countProfilesInSamePhongBan(empID, hoTen);
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/countProfilesInSamePhongBan2")
    public ResponseEntity<Integer> countProfilesInSamePhongBan2(
            @RequestParam int empID) {
        
        int count = profileService.countProfilesInSamePhongBan2(empID);
        return ResponseEntity.ok(count);
    }
    
    
}
