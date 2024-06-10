package poly.edu.duantotnghiep.Repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.Model.NhanVien;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien ,UUID > {
    @Query(value = "select * from nhanvien where email =:email and matkhau = :matkhau",nativeQuery = true)
    NhanVien findNhanVienByEmailAndMatKhau(@Param("email") String email,@Param("matkhau") String matKhau);
}
