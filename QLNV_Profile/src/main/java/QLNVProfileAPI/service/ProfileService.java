
package QLNVProfileAPI.service;

import QLNVProfileAPI.model.Profile;
import QLNVProfileAPI.model.PhongBan;
import QLNVProfileAPI.model.CheckInout;
import QLNVProfileAPI.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.DataAccessException;



import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
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
        
        public int getCountNghiID(int empID) {
            String phongBanSql = "SELECT COUNT(nghi) as total_nghi FROM Check_inout WHERE empid = ? AND nghi = 1";
            
            try {
               
                Map<String, Object> phongBan = jdbcTemplate.queryForMap(phongBanSql, empID);
                
                
                if (phongBan.get("total_nghi") != null) {
                    return ((Number) phongBan.get("total_nghi")).intValue(); // Safe casting to int
                } else {
                    return 0; 
                }
            } catch (EmptyResultDataAccessException e) {
                return 0; 
            }
        }
        
        public int getCountLateID(int empID) {
            String phongBanSql = "SELECT COUNT(late) as total_late FROM Check_inout WHERE empid = ? AND late = 1";
            
            try {
               
                Map<String, Object> phongBan = jdbcTemplate.queryForMap(phongBanSql, empID);
                
                
                if (phongBan.get("total_late") != null) {
                    return ((Number) phongBan.get("total_late")).intValue();
                } else {
                    return 0; 
                }
            } catch (EmptyResultDataAccessException e) {
                return 0;
            }
        }
       
        public List<Map<String, Object>> getTotalPointsByMonth(int nguoinhan) {
            String sql = "SELECT MONTH(date) AS month, SUM(point) AS total_points " +
                         "FROM Felicitation " +
                         "WHERE nguoinhan = ? " +
                         "GROUP BY MONTH(date) " +
                         "ORDER BY MONTH(date)";

            return jdbcTemplate.queryForList(sql, nguoinhan);
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
        public List<CheckInout> getListTimeSheetsByEmpID(int empID) {
            String checkInoutSql = "SELECT * FROM Check_inout WHERE empid = ?";
            
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

            // Trả về danh sách kết quả
            return results;
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
        
        public List<Profile> getProfilesByPhongIDAndHoteen(int empid, String hoten, int limit, int offset) {
            return profileRepository.findProfilesByPhongIDAndHoteen(empid, hoten, limit, offset);
        }
        
        public boolean updateProfile(int empID, String gioiTinh, String cccd, String sdt, String stk, String diaChi, String image, String newPass) {
            try {
                if (newPass != null && !newPass.isEmpty()) {
                    profileRepository.updateProfileWithPassword(empID, gioiTinh, cccd, sdt, stk, diaChi, image, newPass);
                } else {
                    profileRepository.updateProfileWithoutPassword(empID, gioiTinh, cccd, sdt, stk, diaChi, image);
                }
                return true;
            } catch (Exception e) {
                
                return false;
            }
        }
        
        public int countProfilesBySearch(int empID, String hoTen) {
            return profileRepository.countProfilesBySearch(empID, hoTen);
        }

        public int countProfilesInSamePhongBan(int empID) {
            return profileRepository.countProfilesInSamePhongBan(empID);
        }
        

        public List<Map<String, Object>> getPhongBanStatistics(int empID) {
            Optional<String> optionalPhongId = profileRepository.findPhongIdByEmpId(empID);
            
            if (!optionalPhongId.isPresent()) {
                return new ArrayList<>();
            }

            String phongID = optionalPhongId.get();
            
            // Lấy danh sách nhân viên cùng phòng ban
            List<Profile> employees = profileRepository.findByPhongid(phongID);
            
            // Ánh xạ kết quả thành dạng Map
            List<Map<String, Object>> result = new ArrayList<>();
            for (Profile employee : employees) {
                Map<String, Object> employeeData = new HashMap<>();
                employeeData.put("empid", employee.getempid());
                employeeData.put("hoten", employee.gethoten());
                result.add(employeeData);
            }
            
            return result;
        }

        public List<Map<String, Object>> getPhongBanCheckinout(int empID) {
            return profileRepository.getPhongBanCheckinout(empID);
        }
        
        
}



