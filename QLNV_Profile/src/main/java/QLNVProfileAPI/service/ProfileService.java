
package QLNVProfileAPI.service;

import QLNVProfileAPI.model.Profile;
import QLNVProfileAPI.model.*;
import QLNVProfileAPI.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;





import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        
       
        @SuppressWarnings("deprecation")
		public PhongBan getPhongBanByPhongID(String phongID) {
            String phongBanSql = "SELECT * FROM PhongBan WHERE PhongID = ?";
            return jdbcTemplate.queryForObject(phongBanSql, new Object[]{phongID}, (rs, rowNum) -> {
                final PhongBan phongBan = new PhongBan();
                phongBan.setPhongID(rs.getString("PhongID"));
                phongBan.setTenPhong(rs.getString("TenPhong"));
                phongBan.setQuanLyID(rs.getInt("QuanLyID"));
                phongBan.setSoThanhVien(rs.getInt("SoThanhVien"));
                return phongBan;
            });
        }

        
        
        
}


