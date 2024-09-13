package QLNVRequestAPI.repository;

import QLNVRequestAPI.model.Request;

import java.util.List;
import java.util.Map;

public interface RequestRepositoryCustom {
	Map<String, Object> getRequestCountsByEmpIDs(List<Integer> empIDs);
	
    List<Request> getRequestsByEmpID_QL(List<Integer> empIDs);

	List<Request> searchRequestsByEmpID_QL(List<Integer> empIDs, String searchTerm, int limit, int offset);
	
	int countSearchRequestsByEmpID_QL(List<Integer> empIDs, String searchTerm);
	
    List<Map<String, Object>> filterRequestsByEmpID_QL(List<Integer> empIDs, String searchTerm, List<String> types, List<Integer> statuses, int limit, int offset);

    int countFilterRequestsByEmpID(List<Integer> empIDs, String searchTerm, List<String> types, List<Integer> statuses);

}
