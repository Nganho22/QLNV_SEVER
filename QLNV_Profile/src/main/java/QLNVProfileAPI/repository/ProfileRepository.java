package QLNVProfileAPI.repository;
import QLNVProfileAPI.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface ProfileRepository extends JpaRepository <Profile, Integer>{
	
	@Query("SELECT p FROM Profile p WHERE p.tentaikhoan = :tenTaiKhoan AND p.matkhau = :matKhau AND p.tinhtrang = :tinhTrang")
	Profile findActiveProfile(@Param("tenTaiKhoan") String tenTaiKhoan, @Param("matKhau") String matKhau, @Param("tinhTrang") int tinhTrang);
	
	@Query("SELECT p FROM Profile p WHERE p.empid = :empid")
    Profile findProfileByID(@Param("empid") int empid);
}

