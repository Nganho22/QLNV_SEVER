package QLNVProfileAPI.controller;

import QLNVProfileAPI.model.PhongBan;
import QLNVProfileAPI.model.*;

import QLNVProfileAPI.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiProfile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;


    @GetMapping("/")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
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
}
