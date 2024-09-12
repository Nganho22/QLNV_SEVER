package QLNVProfileAPI.repository;
import QLNVProfileAPI.model.Profile;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface ProfileRepository extends JpaRepository <Profile, Integer>{
	
	@Query("SELECT p FROM Profile p WHERE p.tentaikhoan = :tenTaiKhoan AND p.matkhau = :matKhau AND p.tinhtrang = :tinhTrang")
	Profile findActiveProfile(@Param("tenTaiKhoan") String tenTaiKhoan, @Param("matKhau") String matKhau, @Param("tinhTrang") int tinhTrang);
	
	@Query("SELECT p FROM Profile p WHERE p.empid = :empid")
    Profile findProfileByID(@Param("empid") int empid);
	
	@Query(value = "SELECT *" +
            "FROM Profile " +
            "WHERE phongid = (SELECT phongid FROM Profile WHERE empid = :empid) " +
            "AND hoten LIKE %:hoten% AND empid <> :empid " +
            "LIMIT :limit OFFSET :offset", 
    nativeQuery = true)
	List<Profile> findProfilesByPhongIDAndHoteen(@Param("empid") int empid, 
                                           @Param("hoten") String hoten, 
                                           @Param("limit") int limit, 
                                           @Param("offset") int offset);
	
	@Modifying
    @Transactional
    @Query("UPDATE Profile p SET p.gioitinh = :gioitinh, p.cccd = :cccd, p.sodienthoai = :sdt, p.stk = :stk, p.diachi = :diachi, p.image = :image, p.matkhau = :newPass WHERE p.empid = :empID")
    void updateProfileWithPassword(@Param("empID") int empID,
                                   @Param("gioitinh") String gioitinh,
                                   @Param("cccd") String cccd,
                                   @Param("sdt") String sdt,
                                   @Param("stk") String stk,
                                   @Param("diachi") String diachi,
                                   @Param("image") String image,
                                   @Param("newPass") String newPass);

    // Update profile without password
    @Modifying
    @Transactional
    @Query("UPDATE Profile p SET p.gioitinh = :gioitinh, p.cccd = :cccd, p.sodienthoai = :sdt, p.stk = :stk, p.diachi = :diachi, p.image = :image WHERE p.empid = :empID")
    void updateProfileWithoutPassword(@Param("empID") int empID,
                                      @Param("gioitinh") String gioitinh,
                                      @Param("cccd") String cccd,
                                      @Param("sdt") String sdt,
                                      @Param("stk") String stk,
                                      @Param("diachi") String diachi,
                                      @Param("image") String image);


    @Query(value = "SELECT COUNT(p.empid) as total " +
            "FROM Profile p " +
            "WHERE p.phongid = (" +
            "    SELECT sub.phongid " +
            "    FROM Profile sub " +
            "    WHERE sub.empid = :empid) " +
            "AND p.hoten LIKE %:hoten% AND p.empid <> :empid")
    int countProfilesBySearch(@Param("empid") int empid, @Param("hoten") String hoten);
    
    @Query(value = "SELECT COUNT(p.empid) as total " +
            "FROM Profile p " +
            "WHERE p.phongid = (" +
            "    SELECT sub.phongid " +
            "    FROM Profile sub " +
            "    WHERE sub.empid = :empid) " +
            "AND p.empid <> :empid")
    int countProfilesInSamePhongBan(@Param("empid") int empid);

}

