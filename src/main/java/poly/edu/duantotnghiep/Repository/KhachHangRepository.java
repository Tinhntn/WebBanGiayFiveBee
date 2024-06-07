package poly.edu.duantotnghiep.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.edu.duantotnghiep.DAO.KhachHangCustom;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangRepository  extends JpaRepository<KhachHang, UUID> {

    @Query(value = "SELECT maKhachHang, loaiKhachHang, tenKhachHang, diaChi, gioiTinh, email, sdt, ngaySinh, ngayThamGia, tichDiem, diemEXP, ngayTao, ngaySua, trangThai\n" +
            "FROM KhachHang", nativeQuery = true)
    Page<KhachHangCustom> getAllKhachHang(Pageable pageable);


    @Query("SELECT kh.id FROM KhachHang kh WHERE kh.sdt = :sdt")
    UUID findIdKhachHangBySdt(@Param("sdt") String sdt);


    @Query(value = "select * from KhachHanng ", nativeQuery = true)
    List<KhachHang> getAllKH();

    @Query(value = "select * from KhachHang", nativeQuery = true)
    List<KhachHang> getAllKhachHanglist();

}