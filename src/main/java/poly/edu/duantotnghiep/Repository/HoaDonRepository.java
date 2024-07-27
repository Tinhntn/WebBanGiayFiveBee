package poly.edu.duantotnghiep.Repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import poly.edu.duantotnghiep.DAO.HoaDonCustom;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.DAO.HoaDonLichSuCustom;
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

    @Query(value = "SELECT * From HoaDon\n" +
            "WHERE \n" +
            "    hoadon.id = :idhoadon;", nativeQuery = true)
    HoaDon getAllHoaDonByid(UUID idhoadon);

    @Query(value = "SELECT SUM(donGia) AS TongDonGia\n" +
            "FROM ChiTietHoaDon WHERE idhoadon = :idhoadon \n" +
            "GROUP BY idHoaDon;", nativeQuery = true)
           Float getTongTien(UUID idhoadon);

    @Query(value = "SELECT \n" +
            "    HoaDon.ID,\n" +
            "    HoaDon.maHoaDon, \n" +
            "    NhanVien.hoVaTen AS tenNhanVien,\n" +
            "    KhachHang.tenKhachHang,\n" +
            "    HoaDon.NgayTao,\n" +
            "    KhuyenMai.tenKhuyenMai,\n" +
            "    HoaDon.GhiChu,\n" +
            "    HoaDon.TongTien,\n" +
            "    HoaDon.TongTienGiam,\n" +
            "    HoaDon.thanhTien,\n" +
            "    HoaDon.TrangThai, \n" +
            "    HoaDon.loaihoadon, \n" +
            "    HoaDon.loaithanhtoan \n" +
            "FROM HoaDon\n" +
            " left JOIN NhanVien ON NhanVien.Id = HoaDon.idNhanVien\n" +
            " left JOIN KhachHang ON KhachHang.ID = HoaDon.idKhachHang\n" +
            " left JOIN KhuyenMai ON KhuyenMai.Id = HoaDon.idKhuyenMai\n"
            , nativeQuery = true)
    Page<HoaDonCustom> getAllHoaDonDaThanhToan(Pageable pageable);

    @Query(value = "select count(*) from hoadon where trangthai = :trangthai", nativeQuery = true)
    Long demSoLuongHoaDonTheoTrangThai(@Param("trangthai") int i);

    @Query(value = "SELECT\n" +
            "    HoaDon.ID,\n" +
            "    HoaDon.maHoaDon,\n" +
            "    NhanVien.hoVaTen AS tenNhanVien,\n" +
            "    KhachHang.tenKhachHang,\n" +
            "    HoaDon.NgayTao,\n" +
            "    KhuyenMai.tenKhuyenMai,\n" +
            "    HoaDon.GhiChu,\n" +
            "    HoaDon.TongTien,\n" +
            "    HoaDon.TongTienGiam,\n" +
            "    HoaDon.thanhTien,\n" +
            "    HoaDon.TrangThai,\n" +
            "    HoaDon.loaihoadon,\n" +
            "    HoaDon.loaithanhtoan\n" +
            "FROM HoaDon\n" +
            "\n" +
            "JOIN NhanVien ON NhanVien.Id = HoaDon.idNhanVien\n" +
            "JOIN KhachHang ON KhachHang.ID = HoaDon.idKhachHang\n" +
            "JOIN KhuyenMai ON KhuyenMai.Id = HoaDon.idKhuyenMai\n" +
            "where hoadon.id = :idhoadon", nativeQuery = true)
    HoaDonCustom getHoaDonByIdHoaDon(@Param("idhoadon") UUID idHoaDon);

    @Query(value = "SELECT\n" +
            "    HoaDon.ID,\n" +
            "    HoaDon.maHoaDon,\n" +
            "    KhachHang.tenKhachHang,\n" +
            "\tKhachHang.sdt as 'sdtkhachhang',\n" +
            "\tKhachHang.diaChi,\n" +
            "\tKhachHang.email,\n" +
            "\tHoaDon.tennguoigiao,\n" +
            "\tHoaDon.sdtnguoigiao,\n" +
            "\tHoaDon.trangthai,\n" +
            "    HoaDon.loaihoadon\n" +
            "FROM HoaDon\n" +
            "JOIN KhachHang ON KhachHang.ID = HoaDon.idKhachHang\n" +
            "where HoaDon.ID=:idhoadon",nativeQuery = true)
    HoaDonLichSuCustom getLichSuHoaDon(@Param("idhoadon") UUID idhoadon);

}
