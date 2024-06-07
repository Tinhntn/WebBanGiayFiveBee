package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangRepository  extends JpaRepository<KhachHang, UUID> {
    @Query("SELECT kh.id FROM KhachHang kh WHERE kh.sdt = :sdt")
    UUID findIdKhachHangBySdt(@Param("sdt") String sdt);

    @Query(value = "select * from KhachHanng ", nativeQuery = true)
    List<KhachHang> getAllKH();
}
