package QLNVRequestAPI.repository;

import QLNVRequestAPI.model.Request;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RequestRepository extends JpaRepository <Request, Integer> {
	
	@Query("SELECT COUNT(r) FROM Request r WHERE r.empid = :userId")
    int countTotalRequestsByEmpID(@Param("userId") int userId);

    @Query("SELECT COUNT(r) FROM Request r WHERE r.empid = :userId AND r.trangthai = 0")
    int countPendingRequestsByEmpID(@Param("userId") int userId);

    @Query("SELECT COUNT(r) FROM Request r WHERE r.empid = :userId AND r.trangthai != 0")
    int countApprovedRequestsByEmpID(@Param("userId") int userId);
    
    @Query("SELECT r FROM Request r WHERE r.empid = :empId AND r.trangthai = 0 ORDER BY r.ngaygui DESC")
    Page<Request> findPendingRequestsByEmpID(@Param("empId") int empId, Pageable pageable);

    @Query("SELECT r FROM Request r WHERE r.empid = :empId AND r.trangthai != 0 ORDER BY r.ngaygui DESC")
    Page<Request> findApprovedRequestsByEmpID(@Param("empId") int empId, Pageable pageable);

    @Query("SELECT COUNT(r) FROM Request r WHERE r.empid = :empId AND r.trangthai != 0")
    int countApprovedRequests(@Param("empId") int empId);

    @Query("SELECT COUNT(r) FROM Request r WHERE r.empid = :empId AND r.trangthai = 0")
    int countPendingRequests(@Param("empId") int empId);
}