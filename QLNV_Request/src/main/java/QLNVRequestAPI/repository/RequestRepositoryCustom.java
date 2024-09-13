package QLNVRequestAPI.repository;

import QLNVRequestAPI.model.Request;

import java.util.List;
import java.util.Map;

public interface RequestRepositoryCustom {
	Map<String, Object> getRequestCountsByEmpIDs(List<Integer> empIDs);

    List<Request> getRequestsByEmpID_QL(List<Integer> empIDs);
}
