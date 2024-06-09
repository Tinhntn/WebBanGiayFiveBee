package poly.edu.duantotnghiep.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.DAO.KhachHangCustom;
import poly.edu.duantotnghiep.infrastructures.Reponse.KhachHangReponse;
import poly.edu.duantotnghiep.Model.KhachHang;

import java.util.List;
import java.util.UUID;
@Repository
public interface KhachHangRepository  extends JpaRepository<KhachHang, UUID> {

    @Query(value = "SELECT maKhachHang, loaiKhachHang, tenKhachHang, diaChi, gioiTinh, email, sdt, ngaySinh, ngayThamGia, tichDiem, diemEXP, ngayTao, ngaySua, trangThai\n" +
            "FROM KhachHang", nativeQuery = true)
    Page<KhachHangCustom> getAllKhachHang(Pageable pageable);


    @Query("SELECT kh.id FROM KhachHang kh WHERE kh.sdt = :sdt")
    UUID findIdKhachHangBySdt(@Param("sdt") String sdt);

    @Query(value = "Select * from  khachhang where sdt = :sdt",nativeQuery = true)
    KhachHang findKhachHangBySdt(@Param("sdt")String sdt);
    @Query(value = "select * from KhachHang", nativeQuery = true)
    List<KhachHang> getAllKhachHanglist();
    @Query(value = "select  * from khachhang where email =:email and matkhau = :matkhau",nativeQuery = true)
    KhachHang findKhachHangByEmailAndMatkhau(@Param("email")String email,@Param("matkhau")String matkhau);
    boolean existsByEmail(String email);
    @Query(value = "SELECT MAX(makhachhang) FROM KhachHang")
    String getMaxMaKhachHang();
}
