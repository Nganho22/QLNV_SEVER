package QLNVRequestAPI.repository;

import QLNVRequestAPI.model.Request;
import jakarta.transaction.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface RequestRepository extends JpaRepository <Request, Integer>, RequestRepositoryCustom {
	
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
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Request (empid, nguoigui, loai, tieude, ngaygui, ngaychon, noidung) " +
            "VALUES (:empid, :nguoigui, :loai, :tieude, :ngaygui, :ngaychon, :noidung)", nativeQuery = true)
    void createRequest(@Param("empid") int empid,
                      @Param("nguoigui") String nguoigui,
                      @Param("loai") String loai,
                      @Param("tieude") String tieude,
                      @Param("ngaygui") Date ngaygui,
                      @Param("ngaychon") Date ngaychon,
                      @Param("noidung") String noidung);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Request (empid, nguoigui, loai, tieude, ngaygui, noidung, time_sheetid, up_tinhtrang_timesheet, up_thoigian_timesheet) " +
                   "VALUES (:empId, :nguoiGui, :loai, :tieuDe, :ngayGui, :noiDung, :timeSheetID, :trangThai, :newUpThoiGianTimesheet)", 
           nativeQuery = true)
    void createTimeSheetRequest(
            @Param("empId") int empId,
            @Param("nguoiGui") String nguoiGui,
            @Param("loai") String loai,
            @Param("tieuDe") String tieuDe,
            @Param("ngayGui") java.sql.Date ngayGui,
            @Param("noiDung") String noiDung,
            @Param("timeSheetID") Integer timeSheetID,
            @Param("trangThai") String trangThai,
            @Param("newUpThoiGianTimesheet") Integer newUpThoiGianTimesheet);

	//Map<String, Object> getRequestCountsByEmpIDs(List<Integer> empIDs);
    
	
}

