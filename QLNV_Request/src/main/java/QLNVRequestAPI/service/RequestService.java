package QLNVRequestAPI.service;

import QLNVRequestAPI.model.Request;
import QLNVRequestAPI.model.Timesheet;
import QLNVRequestAPI.repository.RequestRepository;
import QLNVRequestAPI.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    
}
