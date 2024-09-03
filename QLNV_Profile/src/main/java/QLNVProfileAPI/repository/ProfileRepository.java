package QLNVProfileAPI.repository;
import QLNVProfileAPI.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface ProfileRepository extends JpaRepository <Profile, Integer>{
	
	@Query("SELECT p FROM Profile p WHERE p.TenTaiKhoan = :tenTaiKhoan AND p.MatKhau = :matKhau AND p.TinhTrang = :tinhTrang")
	Profile findActiveProfile(@Param("tenTaiKhoan") String tenTaiKhoan, @Param("matKhau") String matKhau, @Param("tinhTrang") int tinhTrang);
}

