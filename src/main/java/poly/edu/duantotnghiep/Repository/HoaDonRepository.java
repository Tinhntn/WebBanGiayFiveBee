package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Model.HoaDon;

import java.util.List;
import java.util.UUID;
@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query(value = "select * from hoadon",nativeQuery = true)
    List<HoaDon> getAllHoaDon();
    @Query(value = "SELECT hoadon.id as idhoadon,hoadon.mahoadon, nhanvien.hovaten AS tennhanvien, khachhang.tenkhachhang\n" +
            ",hoadon.ngaymua,hoadon.thanhtien,khuyenmai.giatri,hoadon.GhiChu,hoadon.ngaytao,hoadon.ngaysua\n" +
            ",hoadon.tongtien,hoadon.tongtiengiam,hoadon.trangthai,hoadon.tienkhachdua\n" +
            "FROM hoadon\n" +
            "JOIN nhanvien ON hoadon.idnhanvien = nhanvien.id\n" +
            "join khachhang on hoadon.idKhachHang = khachhang.id\n" +
            "join khuyenmai on hoadon.idKhuyenMai = khuyenmai.id\n",nativeQuery = true
            )
    List<HoaDonDAOCustom> getHoaDonDAO();


}
