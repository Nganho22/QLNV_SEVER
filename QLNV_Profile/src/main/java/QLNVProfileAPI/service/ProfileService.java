
package QLNVProfileAPI.service;

import QLNVProfileAPI.model.Profile;
import QLNVProfileAPI.model.PhongBan;
import QLNVProfileAPI.model.CheckInout;
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
    
    public Profile findProfileByEmpID(int empID) {
        return profileRepository.findProfileByID(empID);
    } 

        @Autowired
        private JdbcTemplate jdbcTemplate;
        
        public String getTenPhongByPhongID(String phongID) {
            String phongBanSql = "SELECT tenphong FROM PhongBan WHERE phongid = ?";
            Map<String, Object> phongBan = jdbcTemplate.queryForMap(phongBanSql, phongID);
            return (String) phongBan.get("tenphong");
        }
        
       
        @SuppressWarnings("deprecation")
		public PhongBan getPhongBanByPhongID(String phongID) {
            String phongBanSql = "SELECT * FROM PhongBan WHERE phongid = ?";
            return jdbcTemplate.queryForObject(phongBanSql, new Object[]{phongID}, (rs, rowNum) -> {
                final PhongBan phongBan = new PhongBan();
                phongBan.setphongid(rs.getString("phongid"));
                phongBan.settenphong(rs.getString("tenphong"));
                phongBan.setquanlyid(rs.getInt("quanlyid"));
                phongBan.setsothanhvien(rs.getInt("sothanhvien"));
                return phongBan;
            });
        }
        
        public List<PhongBan> getAllPhongBan() {
            String phongBanSql = "SELECT * FROM PhongBan";
            return jdbcTemplate.query(phongBanSql, (rs, rowNum) -> {
                PhongBan phongBan = new PhongBan();
                phongBan.setphongid(rs.getString("phongid"));
                phongBan.settenphong(rs.getString("tenphong"));
                phongBan.setquanlyid(rs.getInt("quanlyid"));
                phongBan.setsothanhvien(rs.getInt("sothanhvien"));
                return phongBan;
            });
        }
        
        @SuppressWarnings("deprecation")
        public CheckInout getCurrentTimeSheetByEmpID(int empID) {
            String checkInoutSql = "SELECT * FROM Check_inout WHERE empid = ? AND date_checkin = CURDATE()";
            List<CheckInout> results = jdbcTemplate.query(checkInoutSql, new Object[]{empID}, (rs, rowNum) -> {
                CheckInout checkInout = new CheckInout();
                checkInout.setstt(rs.getInt("stt"));
                checkInout.setempid(rs.getInt("empid"));
                checkInout.setdatecheckin(rs.getDate("date_checkin"));
                checkInout.settimecheckin(rs.getTime("time_checkin"));
                checkInout.settimecheckout(rs.getTime("time_checkout"));
                checkInout.setovertime(rs.getInt("overtime"));
                checkInout.setlate(rs.getInt("late"));
                checkInout.setworkfromhome(rs.getInt("workfromhome"));
                checkInout.setnghi(rs.getInt("nghi"));
                return checkInout;
            });
            return results.isEmpty() ? null : results.get(0);
        }
        
        @SuppressWarnings("deprecation")
        public int updateCheckInTime(int stt) {
            String updateSql = "UPDATE check_inout " +
                               "SET time_checkin = CURTIME(), " +
                               "late = CASE WHEN CURTIME() > '08:00:00' THEN 1 ELSE 0 END " +
                               "WHERE stt = ?";

            int rowsUpdated = jdbcTemplate.update(updateSql, stt);
            return rowsUpdated > 0 ? 1 : 0;
        }

        
        
        
}


