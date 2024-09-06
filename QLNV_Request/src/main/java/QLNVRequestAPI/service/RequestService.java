package QLNVRequestAPI.service;

import QLNVRequestAPI.model.Request;
import QLNVRequestAPI.repository.RequestRepository;
import QLNVRequestAPI.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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
    
}
