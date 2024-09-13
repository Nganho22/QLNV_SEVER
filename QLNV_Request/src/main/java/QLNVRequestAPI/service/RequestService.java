package QLNVRequestAPI.service;

import QLNVRequestAPI.model.Request;
import QLNVRequestAPI.model.Timesheet;
import QLNVRequestAPI.model.Profile;

import QLNVRequestAPI.repository.RequestRepository;
import QLNVRequestAPI.model.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;


@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;
    
    public List<Request> getAllRequests(){
    	return requestRepository.findAll();
    }

    public Map<String, Integer> getRequestCountsByEmpID(int userId) {
        int totalRequests = requestRepository.countTotalRequestsByEmpID(userId);
        int pendingRequests = requestRepository.countPendingRequestsByEmpID(userId);
        int approvedRequests = requestRepository.countApprovedRequestsByEmpID(userId);

        Map<String, Integer> requestCounts = new HashMap<>();
        requestCounts.put("total", totalRequests);
        requestCounts.put("pending", pendingRequests);
        requestCounts.put("approved", approvedRequests);

        return requestCounts;
    }
    
    public Page<Request> getPendingRequestsByEmpID(int empId, Pageable pageable) {
        return requestRepository.findPendingRequestsByEmpID(empId, pageable);
    }

    public Page<Request> getApprovedRequestsByEmpID(int empId, Pageable pageable) {
        return requestRepository.findApprovedRequestsByEmpID(empId, pageable);
    }

    public int countApprovedRequests(int empId) {
        return requestRepository.countApprovedRequests(empId);
    }

    public int countPendingRequests(int empId) {
        return requestRepository.countPendingRequests(empId);
    }
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
    public List<Timesheet> getTimeSheetsByEmpID(int empID) {
        String sql = "SELECT * FROM Time_sheet WHERE empid = ? AND trangthai = 'Chưa hoàn thành'";

        List<Timesheet> results = jdbcTemplate.query(sql, new Object[]{empID}, (rs, rowNum) -> {
            Timesheet timesheet = new Timesheet();
            timesheet.settimesheetid(rs.getInt("time_sheetid"));
            timesheet.setprojectid(rs.getInt("projectid"));
            timesheet.setempid(rs.getInt("empid"));
            timesheet.settenduan(rs.getString("tenduan"));
            timesheet.setnguoigui(rs.getString("nguoigui"));
            timesheet.setPhongBan(rs.getString("phongban"));
            timesheet.setTrangThai(rs.getString("trangthai"));
            timesheet.setsogiothuchien(rs.getInt("sogiothuchien"));
            timesheet.setngaygiao(rs.getDate("ngaygiao"));
            timesheet.sethanchot(rs.getDate("hanchot"));
            timesheet.setdiemthuong(rs.getInt("diemthuong"));
            timesheet.settre(rs.getInt("tre"));
            timesheet.setnoidung(rs.getString("noidung"));
            return timesheet;
        });
        return results;
    }
    
    @SuppressWarnings("deprecation")
    public Timesheet getTimeSheetByID(int timeSheetId) {
        String sql = "SELECT * FROM Time_sheet WHERE time_sheetid = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{timeSheetId}, (rs, rowNum) -> {
            Timesheet timesheet = new Timesheet();
            timesheet.settimesheetid(rs.getInt("time_sheetid"));
            timesheet.setprojectid(rs.getInt("projectid"));
            timesheet.setempid(rs.getInt("empid"));
            timesheet.settenduan(rs.getString("tenduan"));
            timesheet.setnguoigui(rs.getString("nguoigui"));
            timesheet.setPhongBan(rs.getString("phongban"));
            timesheet.setTrangThai(rs.getString("trangthai"));
            timesheet.setsogiothuchien(rs.getInt("sogiothuchien"));
            timesheet.setngaygiao(rs.getDate("ngaygiao"));
            timesheet.sethanchot(rs.getDate("hanchot"));
            timesheet.setdiemthuong(rs.getInt("diemthuong"));
            timesheet.settre(rs.getInt("tre"));
            timesheet.setnoidung(rs.getString("noidung"));
            return timesheet;
        });
    }

    public boolean createRequest(int empId, String nguoiGui, String loai, String tieuDe, Date ngayGui, Date ngayChon, String noiDung) {
    	try {
    		requestRepository.createRequest(empId, nguoiGui, loai, tieuDe, ngayGui, ngayChon, noiDung); 
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    public boolean createTimeSheetRequest(int empId, String nguoiGui, String loai, String tieuDe, java.sql.Date ngayGui, String noiDung, Integer timeSheetID, String trangThai, Integer newUpThoiGianTimesheet) {
        try {
            requestRepository.createTimeSheetRequest(empId, nguoiGui, loai, tieuDe, ngayGui, noiDung, timeSheetID, trangThai, newUpThoiGianTimesheet);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Request getDetailRequest(Integer requestID) {
        Optional<Request> request = requestRepository.findById(requestID);
        return request.orElse(null);
    }

    @SuppressWarnings("deprecation")
    public Map<String, Object> getEmpIDsAndPhongID(int userId) {
        String sql = "SELECT p1.phongid, p2.empid " +
                     "FROM Profile p1 " +
                     "LEFT JOIN Profile p2 ON p1.phongid = p2.phongid " +
                     "WHERE p1.empid = ?";

        return jdbcTemplate.query(sql, new Object[]{userId}, rs -> {
            Map<String, Object> resultMap = new HashMap<>();
            List<Integer> empIDs = new ArrayList<>();
            String phongID = null;

            while (rs.next()) {
                if (phongID == null) {
                    phongID = rs.getString("phongid");
                }
                empIDs.add(rs.getInt("empid"));
            }

            resultMap.put("phongID", phongID);
            resultMap.put("empIDs", empIDs);
            return resultMap;
        });
    }

    public Map<String, Object> getRequestCountsByEmpIDs(List<Integer> empIDs) {
        return requestRepository.getRequestCountsByEmpIDs(empIDs);
    }
    
    public List<Request> getRequestsByEmpID_QL(List<Integer> empIDs) {
        return requestRepository.getRequestsByEmpID_QL(empIDs);
    }
    
    public List<Request> searchRequestsByEmpID_QL(List<Integer> empIDs, String searchTerm, int limit, int offset) {
        return requestRepository.searchRequestsByEmpID_QL(empIDs, searchTerm, limit, offset);
    }

	public int countSearchRequestsByEmpID_QL(List<Integer> empIDs, String searchTerm) {
		return requestRepository.countSearchRequestsByEmpID_QL(empIDs, searchTerm);
	}

	public List<Map<String, Object>> filterRequestsByEmpID_QL(List<Integer> empIDs, String searchTerm, List<String> types, List<Integer> statuses, int limit, int offset) {
        if (empIDs.isEmpty()) {
            return Collections.emptyList();
        }
        return requestRepository.filterRequestsByEmpID_QL(empIDs, searchTerm, types, statuses, limit, offset);
    }

	public int countFilterRequestsByEmpID(List<Integer> empIDs, String searchTerm, List<String> types, List<Integer> statuses) {
        return requestRepository.countFilterRequestsByEmpID(empIDs, searchTerm, types, statuses);
    }
	
	public boolean updateRequest(Integer requestID, Date ngayXuLy, int trangThai, String noiDung) {
        try {
            Optional<Request> optionalRequest = requestRepository.findById(requestID);
            if (optionalRequest.isPresent()) {
                Request request = optionalRequest.get();
                request.setngayxuly(ngayXuLy);
                request.settrangthai(trangThai);
                request.setphanhoi(noiDung);
                requestRepository.save(request);
                return true;
            } else {
                return false; // Request not found
            }
        } catch (Exception e) {
            // Log exception if needed
            return false;
        }
    }

	public boolean insertCheckInOut(CheckInOut checkInOut) {
        String sql = "INSERT INTO Check_inout (empid, date_checkin, workfromhome, nghi) VALUES (?,?,?,?)";
        try {
            jdbcTemplate.update(sql, checkInOut.getempid(), checkInOut.getdatecheckin(), 
                                checkInOut.getworkfromhome(), checkInOut.getnghi());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

	public boolean updateTimeSheet(Timesheet timeSheet) {
        String sql = "UPDATE Time_sheet SET trangthai = ?, sogiothuchien = ?, tre = ? WHERE time_sheetid = ?";
        try {
            jdbcTemplate.update(sql, 
                timeSheet.getTrangThai(), 
                timeSheet.getsogiothuchien(), 
                timeSheet.gettre(), 
                timeSheet.gettimesheetid());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
