package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Model.HoaDon;

import java.util.List;
import java.util.UUID;

public interface HoaDonUserRepository  extends JpaRepository<HoaDon, UUID> {
    @Query(value = "SELECT hoadon.id AS idhoadon, hoadon.mahoadon AS mahoadon, khachhang.tenkhachhang,\n" +
            "    hoadon.ngaymua, hoadon.thanhtien,  hoadon.GhiChu, hoadon.ngaytao, hoadon.ngaysua,\n" +
            "    hoadon.tongtien, hoadon.tongtiengiam, hoadon.trangthai, hoadon.tienkhachdua\n" +
            "FROM hoadon\n" +
            "\n" +
            "JOIN khachhang ON hoadon.idKhachHang = khachhang.id\n" +
            "\n" +
            "WHERE hoadon.trangThai = 2\n" +
            "AND hoadon.idKhachHang = :idKhachHang;"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getHoaDonChoxacnhan(UUID idKhachHang);

    @Query(value = "SELECT hoadon.id AS idhoadon, hoadon.mahoadon AS mahoadon, khachhang.tenkhachhang,\n" +
            "    hoadon.ngaymua, hoadon.thanhtien,  hoadon.GhiChu, hoadon.ngaytao, hoadon.ngaysua,\n" +
            "    hoadon.tongtien, hoadon.tongtiengiam, hoadon.trangthai, hoadon.tienkhachdua\n" +
            "FROM hoadon\n" +
            "\n" +
            "JOIN khachhang ON hoadon.idKhachHang = khachhang.id\n" +
            "\n" +
            "WHERE hoadon.trangThai = 3\n" +
            "AND hoadon.idKhachHang = :idKhachHang;"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getHoaDoncholayhang(UUID idKhachHang);

    @Query(value = "SELECT hoadon.id AS idhoadon, hoadon.mahoadon AS mahoadon, khachhang.tenkhachhang,\n" +
            "    hoadon.ngaymua, hoadon.thanhtien,  hoadon.GhiChu, hoadon.ngaytao, hoadon.ngaysua,\n" +
            "    hoadon.tongtien, hoadon.tongtiengiam, hoadon.trangthai, hoadon.tienkhachdua\n" +
            "FROM hoadon\n" +
            "\n" +
            "JOIN khachhang ON hoadon.idKhachHang = khachhang.id\n" +
            "\n" +
            "WHERE hoadon.trangThai = 4\n" +
            "AND hoadon.idKhachHang = :idKhachHang;"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getHoaDonDangGiao(UUID idKhachHang);

    @Query(value = "SELECT hoadon.id AS idhoadon, hoadon.mahoadon AS mahoadon, khachhang.tenkhachhang,\n" +
            "    hoadon.ngaymua, hoadon.thanhtien,  hoadon.GhiChu, hoadon.ngaytao, hoadon.ngaysua,\n" +
            "    hoadon.tongtien, hoadon.tongtiengiam, hoadon.trangthai, hoadon.tienkhachdua\n" +
            "FROM hoadon\n" +
            "\n" +
            "JOIN khachhang ON hoadon.idKhachHang = khachhang.id\n" +
            "\n" +
            "WHERE hoadon.trangThai = 5\n" +
            "AND hoadon.idKhachHang = :idKhachHang;"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getHoaDonDaGiao(UUID idKhachHang);

    @Query(value = "SELECT hoadon.id AS idhoadon, hoadon.mahoadon AS mahoadon, khachhang.tenkhachhang,\n" +
            "    hoadon.ngaymua, hoadon.thanhtien,  hoadon.GhiChu, hoadon.ngaytao, hoadon.ngaysua,\n" +
            "    hoadon.tongtien, hoadon.tongtiengiam, hoadon.trangthai, hoadon.tienkhachdua\n" +
            "FROM hoadon\n" +
            "\n" +
            "JOIN khachhang ON hoadon.idKhachHang = khachhang.id\n" +
            "\n" +
            "WHERE hoadon.trangThai = 6\n" +
            "AND hoadon.idKhachHang = :idKhachHang;"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getHoaDonDaHuy(UUID idKhachHang);

    @Query(value = "SELECT hoadon.id AS idhoadon, hoadon.mahoadon AS mahoadon, khachhang.tenkhachhang,\n" +
            "    hoadon.ngaymua, hoadon.thanhtien,  hoadon.GhiChu, hoadon.ngaytao, hoadon.ngaysua,\n" +
            "    hoadon.tongtien, hoadon.tongtiengiam, hoadon.trangthai, hoadon.tienkhachdua\n" +
            "FROM hoadon\n" +
            "\n" +
            "JOIN khachhang ON hoadon.idKhachHang = khachhang.id\n" +
            "\n" +
            "WHERE \n" +
            " hoadon.idKhachHang = :idKhachHang;"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getAll(UUID idKhachHang);
}
