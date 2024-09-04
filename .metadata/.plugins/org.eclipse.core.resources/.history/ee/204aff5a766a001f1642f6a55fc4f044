
package QLNVProfileAPI.service;

import QLNVProfileAPI.model.Profile;
import QLNVProfileAPI.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(Integer id) {
        return profileRepository.findById(id);
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteProfile(Integer id) {
        profileRepository.deleteById(id);
    }
    
    public Profile getActiveProfile(String tenTaiKhoan, String matKhau, int tinhTrang) {
        return profileRepository.findActiveProfile(tenTaiKhoan, matKhau, tinhTrang);
    }
    

        @Autowired
        private JdbcTemplate jdbcTemplate;
        
        public String getTenPhongByPhongID(String phongID) {
            String phongBanSql = "SELECT TenPhong FROM PhongBan WHERE PhongID = ?";
            Map<String, Object> phongBan = jdbcTemplate.queryForMap(phongBanSql, phongID);
            return (String) phongBan.get("TenPhong");
        }
}


