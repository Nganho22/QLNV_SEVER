package QLNVProfileAPI.controller;

import QLNVProfileAPI.model.Profile;

import QLNVProfileAPI.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/getActiveProfile")
    public Profile getActiveProfile(@RequestParam String tenTaiKhoan,
                                    @RequestParam String matKhau) {
        Profile profile = profileService.getActiveProfile(tenTaiKhoan, matKhau, 1);
        
        if (profile != null && profile.getPhongID() != null) {
        	profile.setTenPhong(profileService.getTenPhongByPhongID(profile.getPhongID()));
        }
        return profile;
    }
}
