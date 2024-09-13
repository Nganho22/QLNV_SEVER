package QLNVRequestAPI.controller;

import QLNVRequestAPI.model.*;
import QLNVRequestAPI.model.Request;
import QLNVRequestAPI.service.RequestService;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/apiRequest")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/")
    public List<Request> getAllRequests() {
    	return requestService.getAllRequests();
    }
    
    @GetMapping("/counts/{userId}")
    public Map<String, Integer> getRequestCountsByEmpID(@PathVariable int userId) {
        return requestService.getRequestCountsByEmpID(userId);
    }
    
    @GetMapping("/pending")
    public Page<Request> getPendingRequestsByEmpID(
            @RequestParam int empID,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return requestService.getPendingRequestsByEmpID(empID, pageable);
    }

    @GetMapping("/approved")
    public Page<Request> getApprovedRequestsByEmpID(
            @RequestParam int empID,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return requestService.getApprovedRequestsByEmpID(empID, pageable);
    }

    @GetMapping("/count/approved")
    public int countApprovedRequests(@RequestParam int empID) {
        return requestService.countApprovedRequests(empID);
    }

    @GetMapping("/count/pending")
    public int countPendingRequests(@RequestParam int empID) {
        return requestService.countPendingRequests(empID);
    }
    
    @GetMapping("/timesheets/{empID}")
    public List<Timesheet> getTimeSheetsByEmpID(@PathVariable int empID) {
        return requestService.getTimeSheetsByEmpID(empID);
    }
    
    @GetMapping("/timesheetsID/{timeSheetId}")
    public Timesheet getTimeSheetByID(@PathVariable int timeSheetId) {
        return requestService.getTimeSheetByID(timeSheetId);
    }

    @PostMapping("/createRequest")
    public ResponseEntity<String> createRequest(@RequestParam int empID,
                                                @RequestParam String nguoiGui,
                                                @RequestParam String loai,
                                                @RequestParam String tieuDe,
                                                @RequestParam Date ngayGui,
                                                @RequestParam Date ngayChon,
                                                @RequestParam String noiDung) {
    	boolean result = requestService.createRequest(empID, nguoiGui, loai, tieuDe, ngayGui, ngayChon, noiDung);
    	if (result) {
            return ResponseEntity.ok("Create request successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.SC_SERVER_ERROR).body("Failed to update profile.");
        }
    }
    
    @PostMapping("/createTimeSheetRequest")
    public ResponseEntity<String> createTimeSheetRequest(
            @RequestParam int empId,
            @RequestParam String nguoiGui,
            @RequestParam String loai,
            @RequestParam String tieuDe,
            @RequestParam Date ngayGui,
            @RequestParam String noiDung,
            @RequestParam Integer timeSheetID,
            @RequestParam String trangThai,
            @RequestParam Integer newUpThoiGianTimesheet) {

        boolean result = requestService.createTimeSheetRequest(empId, nguoiGui, loai, tieuDe, ngayGui, noiDung, timeSheetID, trangThai, newUpThoiGianTimesheet);

        if (result) {
            return ResponseEntity.ok("Create request successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.SC_SERVER_ERROR).body("Failed to create request.");
        }
    }
    
    @GetMapping("/getDetailRequest/{requestID}")
    public ResponseEntity<Request> getDetailRequest(@PathVariable Integer requestID) {
        Request request = requestService.getDetailRequest(requestID);
        if (request != null) {
            return ResponseEntity.ok(request);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/profileInfo/{userId}")
    public ResponseEntity<Map<String, Object>> getProfileInfo(@PathVariable int userId) {
        Map<String, Object> profileData = requestService.getEmpIDsAndPhongID(userId);
        return ResponseEntity.ok(profileData);
    }
    
    @GetMapping("/counts")
    public Map<String, Object> getRequestCountsByEmpIDs(@RequestParam List<Integer> empIDs) {
        return requestService.getRequestCountsByEmpIDs(empIDs);
    }
    
    @GetMapping("/by-emp-ids")
    public ResponseEntity<List<Request>> getRequestsByEmpIDs(@RequestParam List<Integer> empIDs) {
        List<Request> requests = requestService.getRequestsByEmpID_QL(empIDs);
        return ResponseEntity.ok(requests);
    }
    
    @GetMapping("/search")
    public List<Request> searchRequestsByEmpID_QL(
            @RequestParam List<Integer> empIDs,
            @RequestParam String searchTerm,
            @RequestParam int limit,
            @RequestParam int offset) {

        return requestService.searchRequestsByEmpID_QL(empIDs, searchTerm, limit, offset);
    }
    
    @GetMapping("/countSearchRequests")
    public int countSearchRequests(
        @RequestParam List<Integer> empIDs,
        @RequestParam String searchTerm
    ) {
        int total = requestService.countSearchRequestsByEmpID_QL(empIDs, searchTerm);
        return total;
    }
    
    @GetMapping("/filter")
    public ResponseEntity<List<Map<String, Object>>> filterRequestsByEmpID_QL(
            @RequestParam List<Integer> empIDs,
            @RequestParam String searchTerm,
            @RequestParam(required = false) List<String> types,
            @RequestParam(required = false) List<Integer> statuses,
            @RequestParam int limit,
            @RequestParam int offset) {

        List<Map<String, Object>> requests = requestService.filterRequestsByEmpID_QL(empIDs, searchTerm, types, statuses, limit, offset);
        return ResponseEntity.ok(requests);
    }
    
    @GetMapping("/countFilter")
    public int countFilteredRequests(
            @RequestParam List<Integer> empIDs,
            @RequestParam String searchTerm,
            @RequestParam List<String> types,
            @RequestParam List<Integer> statuses) {
        return requestService.countFilterRequestsByEmpID(empIDs, searchTerm, types, statuses);
    }

    @PutMapping("updateReq/{requestID}")
    public ResponseEntity<String> updateRequest(
            @PathVariable Integer requestID,
            @RequestParam Date ngayXuLy,
            @RequestParam int trangThai,
            @RequestParam String noiDung) {

        boolean updated = requestService.updateRequest(requestID, ngayXuLy, trangThai, noiDung);

        if (updated) {
            return ResponseEntity.ok("Request updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.SC_SERVER_ERROR).body("Request not found.");
        }
    }

    @PostMapping("/checkinout")
    public boolean insertCheckInOut(@RequestBody CheckInOut checkInOut) {
        return requestService.insertCheckInOut(checkInOut);
    }
    
    @PutMapping("/updateTimesheet/{timeSheetID}")
    public ResponseEntity<String> updateTimeSheet(@RequestBody Timesheet timeSheet) {
        boolean result = requestService.updateTimeSheet(timeSheet);
        if (result) {
            return ResponseEntity.ok("TimeSheet updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.SC_SERVER_ERROR).body("Failed to update TimeSheet.");
        }
    }
}
