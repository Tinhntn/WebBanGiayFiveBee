package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.edu.duantotnghiep.DAO.ChiTietGioHangCustom;
import poly.edu.duantotnghiep.DAO.SizeCustom;
import poly.edu.duantotnghiep.Model.GioHangChiTiet;
import poly.edu.duantotnghiep.Model.SanPham;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {
    @Query(value = "SELECT\n" +
            " gh.maGioHang,\n" +
            "    gh.idNhanVien,\n" +
            "    gh.idKhachHang,\n" +
            "    gh.idKhuyenMai,\n" +
            "    ghct.idGioHangChiTiet,\n" +
            "    ghct.idGioHang,\n" +
            "    ghct.idChiTietSanPham,\n" +
            "    ghct.soLuong,\n" +
            "    ghct.donGia,\n" +
            "    ghct.tongTien,\n" +
            "    ghct.donGiaKhiGiam,\n" +
            "    ghct.ngayTao,\n" +
            "    ghct.ngaySua,\n" +
            "    ghct.trangThai,\n" +
            "    csp.Id AS idChiTietSanPham,\n" +
            "    csp.idSanPham,\n" +
            "    csp.hang,\n" +
            "    csp.Size,\n" +
            "    csp.DanhMuc,\n" +
            "    csp.ChatLieu,\n" +
            "    csp.MauSac,\n" +
            "    csp.idKhuyenMai,\n" +
            "    csp.giaNhap,\n" +
            "    csp.giaBan,\n" +
            "    csp.QR,\n" +
            "    csp.HinhAnh,\n" +
            "    csp.SoLuong AS SoLuongSanPham,\n" +
            "    csp.MoTa,\n" +
            "    csp.NgayTao AS NgayTaoSanPham,\n" +
            "    csp.NgaySua AS NgaySuaSanPham,\n" +
            "    csp.TrangThai AS TrangThaiSanPham,\n" +
            "\t sp.Id AS idSanPham,\n" +
            "    sp.maSanPham,\n" +
            "    sp.tenSanPham\n" +
            "FROM\n" +
            "    GioHangChiTiet ghct\n" +
            "INNER JOIN\n" +
            "    ChiTietSanPham csp ON ghct.idChiTietSanPham = csp.Id\n" +
            "INNER JOIN\n" +
            "    GioHang gh ON ghct.idGioHang = gh.idGioHang\n" +
            "INNER JOIN\n" +
            "    SanPham sp ON csp.idSanPham = sp.Id\n" +
            "\tWHERE\n" +
            "    ghct.idGioHang = :idGioHang;", nativeQuery = true)
            List<ChiTietGioHangCustom> getGioHang(UUID idGioHang);

    @Query(value = "select * from GioHangChiTiet where idGioHangChiTiet = :idGioHangChiTiet", nativeQuery = true)
    GioHangChiTiet getGioHangChiTietByIdgiohangchitiet(UUID idGioHangChiTiet);




    @Query(value = "SELECT SUM(tongTien) AS TotalTongTien\n" +
            "    FROM GioHangChiTiet\n" +
            "    WHERE trangThai = 2\n" +
            "    AND idGioHang = :idGioHang", nativeQuery = true)
      Float getTongTien(UUID idGioHang);

//    @Query(value = "SELECT * FROM GioHangChiTiet " +
//            "WHERE trangThai = 2 " +
//            "AND idGioHang = :idGioHang", nativeQuery = true)

//    @Query(value = "SELECT\n" +
//            " gh.maGioHang,\n" +
//            "    gh.idNhanVien,\n" +
//            "    gh.idKhachHang,\n" +
//            "    gh.idKhuyenMai,\n" +
//            "    ghct.idGioHangChiTiet,\n" +
//            "    ghct.idGioHang,\n" +
//            "    ghct.idChiTietSanPham,\n" +
//            "    ghct.soLuong,\n" +
//            "    ghct.donGia,\n" +
//            "    ghct.tongTien,\n" +
//            "    ghct.donGiaKhiGiam,\n" +
//            "    ghct.ngayTao,\n" +
//            "    ghct.ngaySua,\n" +
//            "    ghct.trangThai,\n" +
//            "    csp.Id AS idChiTietSanPham,\n" +
//            "    csp.idSanPham,\n" +
//            "    csp.hang,\n" +
//            "    csp.Size,\n" +
//            "    csp.DanhMuc,\n" +
//            "    csp.ChatLieu,\n" +
//            "    csp.MauSac,\n" +
//            "    csp.idKhuyenMai,\n" +
//            "    csp.giaNhap,\n" +
//            "    csp.giaBan,\n" +
//            "    csp.QR,\n" +
//            "    csp.HinhAnh,\n" +
//            "    csp.SoLuong AS SoLuongSanPham,\n" +
//            "    csp.MoTa,\n" +
//            "    csp.NgayTao AS NgayTaoSanPham,\n" +
//            "    csp.NgaySua AS NgaySuaSanPham,\n" +
//            "    csp.TrangThai AS TrangThaiSanPham,\n" +
//            "\t sp.Id AS idSanPham,\n" +
//            "    sp.maSanPham,\n" +
//            "    sp.tenSanPham\n" +
//            "FROM\n" +
//            "    GioHangChiTiet ghct\n" +
//            "INNER JOIN\n" +
//            "    ChiTietSanPham csp ON ghct.idChiTietSanPham = csp.Id\n" +
//            "INNER JOIN\n" +
//            "    GioHang gh ON ghct.idGioHang = gh.idGioHang\n" +
//            "INNER JOIN\n" +
//            "    SanPham sp ON csp.idSanPham = sp.Id\n" +
//            "WHERE ghct.trangThai = 2 " +
//            " AND   ghct.idGioHang = :idGioHang;", nativeQuery = true)
//    List<ChiTietGioHangCustom> getAllBanHang(UUID idGioHang);

    @Query(value = "SELECT\n" +
            "    gh.maGioHang,\n" +
            "    gh.idNhanVien,\n" +
            "    gh.idKhachHang,\n" +
            "    gh.idKhuyenMai,\n" +
            "    ghct.idGioHangChiTiet,\n" +
            "    ghct.idGioHang,\n" +
            "    ghct.idChiTietSanPham,\n" +
            "    ghct.soLuong,\n" +
            "    ghct.donGia,\n" +
            "    ghct.tongTien,\n" +
            "    ghct.donGiaKhiGiam,\n" +
            "    ghct.ngayTao,\n" +
            "    ghct.ngaySua,\n" +
            "    ghct.trangThai,\n" +
            "    csp.Id AS idChiTietSanPham,\n" +
            "    csp.idSanPham,\n" +
            "    csp.hang,\n" +
            "    hang.tenhang AS tenHang,\n" +  // Lấy tên hàng từ bảng hang
            "    csp.Size,\n" +
            "    size.ten AS tenSize,\n" +  // Lấy tên size từ bảng size
            "    csp.DanhMuc,\n" +
            "    danhmuc.ten AS tenDanhMuc,\n" +  // Lấy tên danh mục từ bảng danhmuc
            "    csp.ChatLieu,\n" +
            "    chatlieu.ten AS tenChatLieu,\n" +  // Lấy tên chất liệu từ bảng chatlieu
            "    csp.MauSac,\n" +
            "    mausac.ten AS tenMauSac,\n" +  // Lấy tên màu sắc từ bảng mausac
            "    csp.idKhuyenMai,\n" +
            "    csp.giaNhap,\n" +
            "    csp.giaBan,\n" +
            "    csp.QR,\n" +
            "    csp.HinhAnh,\n" +
            "    csp.SoLuong AS SoLuongSanPham,\n" +
            "    csp.MoTa,\n" +
            "    csp.NgayTao AS NgayTaoSanPham,\n" +
            "    csp.NgaySua AS NgaySuaSanPham,\n" +
            "    csp.TrangThai AS TrangThaiSanPham,\n" +
            "    sp.Id AS idSanPham,\n" +
            "    sp.maSanPham,\n" +
            "    sp.tenSanPham\n" +
            "FROM\n" +
            "    GioHangChiTiet ghct\n" +
            "INNER JOIN\n" +
            "    ChiTietSanPham csp ON ghct.idChiTietSanPham = csp.Id\n" +
            "INNER JOIN\n" +
            "    GioHang gh ON ghct.idGioHang = gh.idGioHang\n" +
            "INNER JOIN\n" +
            "    SanPham sp ON csp.idSanPham = sp.Id\n" +
            "LEFT JOIN\n" +
            "    size ON csp.Size = size.id\n" +
            "LEFT JOIN\n" +
            "    mausac ON csp.MauSac = mausac.id\n" +
            "LEFT JOIN\n" +
            "    chatlieu ON csp.ChatLieu = chatlieu.id\n" +  // Thêm join với bảng chatlieu để lấy tên chất liệu
            "LEFT JOIN\n" +
            "    danhmuc ON csp.DanhMuc = danhmuc.id\n" +  // Thêm join với bảng danhmuc để lấy tên danh mục
            "LEFT JOIN\n" +
            "    hang ON csp.hang = hang.idhang\n" +  // Thêm join với bảng hang để lấy tên hàng
            "WHERE ghct.trangThai = 2 " +
            "AND ghct.idGioHang = :idGioHang", nativeQuery = true)
    List<ChiTietGioHangCustom> getAllBanHang(UUID idGioHang);


}
