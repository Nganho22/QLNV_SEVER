
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
        
        public List<PhongBan> getAllPhongBan() {
            String phongBanSql = "SELECT * FROM PhongBan";
            return jdbcTemplate.query(phongBanSql, (rs, rowNum) -> {
                PhongBan phongBan = new PhongBan();
                phongBan.setPhongID(rs.getString("PhongID"));
                phongBan.setTenPhong(rs.getString("TenPhong"));
                phongBan.setQuanLyID(rs.getInt("QuanLyID"));
                phongBan.setSoThanhVien(rs.getInt("SoThanhVien"));
                return phongBan;
            });
        }
        
        @SuppressWarnings("deprecation")
        public CheckInout getCurrentTimeSheetByEmpID(int empID) {
            String checkInoutSql = "SELECT * FROM Check_inout WHERE EmpID = ? AND Date_checkin = CURDATE()";
            List<CheckInout> results = jdbcTemplate.query(checkInoutSql, new Object[]{empID}, (rs, rowNum) -> {
                CheckInout checkInout = new CheckInout();
                checkInout.setStt(rs.getInt("STT"));
                checkInout.setEmpID(rs.getInt("EmpID"));
                checkInout.setDateCheckin(rs.getDate("Date_checkin"));
                checkInout.setTimeCheckin(rs.getTime("Time_checkin"));
                checkInout.setTimeCheckout(rs.getTime("Time_checkout"));
                checkInout.setOvertime(rs.getInt("Overtime"));
                checkInout.setLate(rs.getInt("Late"));
                checkInout.setWorkFromHome(rs.getInt("WorkFromHome"));
                checkInout.setNghi(rs.getInt("Nghi"));
                return checkInout;
            });
            return results.isEmpty() ? null : results.get(0);
        }
        
        @SuppressWarnings("deprecation")
        public int updateCheckInTime(int stt) {
            String updateSql = "UPDATE Check_inout " +
                               "SET Time_checkin = CURTIME(), " +
                               "Late = CASE WHEN CURTIME() > '08:00:00' THEN 1 ELSE 0 END " +
                               "WHERE STT = ?";

            int rowsUpdated = jdbcTemplate.update(updateSql, stt);
            return rowsUpdated > 0 ? 1 : 0;
        }

        
        
        
}


