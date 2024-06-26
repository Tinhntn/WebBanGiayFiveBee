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


    @Query(value = "select * from hoadon where trangthai = 0",nativeQuery = true)
    List<HoaDon> findHoaDonByTrangThai();

        @Query(value = "SELECT hoadon.id as idhoadon,hoadon.mahoadon, nhanvien.hovaten AS tennhanvien, khachhang.tenkhachhang\n" +
                ",hoadon.ngaymua,hoadon.thanhtien,khuyenmai.giatri,hoadon.GhiChu,hoadon.ngaytao,hoadon.ngaysua\n" +
                ",hoadon.tongtien,hoadon.tongtiengiam,hoadon.trangthai,hoadon.tienkhachdua\n" +
                "FROM hoadon\n" +
                "JOIN nhanvien ON hoadon.idnhanvien = nhanvien.id\n" +
                "join khachhang on hoadon.idKhachHang = khachhang.id\n" +
                "join khuyenmai on hoadon.idKhuyenMai = khuyenmai.id\n",nativeQuery = true
                )
        List<HoaDonDAOCustom> getHoaDonDAO();

        @Query(value = "SELECT hoadon.id as idhoadon,hoadon.mahoadon, nhanvien.hovaten AS tennhanvien, khachhang.tenkhachhang\n" +
                ",hoadon.ngaymua,hoadon.thanhtien,khuyenmai.giatri,hoadon.GhiChu,hoadon.ngaytao,hoadon.ngaysua\n" +
                ",hoadon.tongtien,hoadon.tongtiengiam,hoadon.trangthai,hoadon.tienkhachdua\n" +
                "FROM hoadon\n" +
                "JOIN nhanvien ON hoadon.idnhanvien = nhanvien.id\n" +
                "join khachhang on hoadon.idKhachHang = khachhang.id\n" +
                "join khuyenmai on hoadon.idKhuyenMai = khuyenmai.id\n"+
                "WHERE \n" +
                "    hoadon.id = :idhoadon;", nativeQuery = true)
          HoaDonDAOCustom getTenTPHD(UUID idhoadon);

    @Query(value = "SELECT SUM(donGia) AS TongDonGia\n" +
            "FROM ChiTietHoaDon WHERE idhoadon = :idhoadon \n" +
            "GROUP BY idHoaDon;", nativeQuery = true)
           Float getTongTien(UUID idhoadon);


}
