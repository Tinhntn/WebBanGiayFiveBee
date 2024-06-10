package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;
import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;


import java.util.List;
import java.util.UUID;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, UUID> {


    List<ChiTietHoaDon> findByIdhoadon(UUID hoaDonId);

//    @Query(value = "SELECT cthd.id AS id, cthd.idchitietsanpham AS idChiTietSanPham, hd.mahoadon AS maHoaDon, sp.tensanpham AS tenSanPham, cthd.soluong, cthd.dongia, cthd.ngayban, cthd.ngaytao, cthd.ngaysua, cthd.trangthai\n" +
//            "FROM ChiTietHoaDon cthd\n" +
//            "JOIN HoaDon hd ON cthd.idhoadon = hd.id\n" +
//            "JOIN ChiTietSanPham ctsp ON cthd.idchitietsanpham = ctsp.id\n" +
//            "JOIN SanPham sp ON ctsp.idsanpham = sp.id\n" +
//            "WHERE hd.id = :idhoadon\n", nativeQuery = true)
//    List<ChiTietHoaDonCustom> findByHoaDonId(@Param("idhoadon") UUID idhoadon);

    @Query(value = "SELECT cthd.id AS id, cthd.idchitietsanpham AS idChiTietSanPham ,\n" +
            "    hd.mahoadon AS maHoaDon, \n" +
            "    sp.tensanpham AS tenSanPham, \n" +
            "    cl.ten AS chatlieu, \n" +
            "    s.ten AS size, \n" +
            "    dm.ten AS danhmuc, \n" +
            "    ms.ten AS MauSac, \n" +
            "    h.tenHang AS hang, \n" +
            "    cthd.soluong, \n" +
            "    cthd.dongia, \n" +
            "    cthd.trangthai \n" +
            "FROM \n" +
            "    ChiTietHoaDon cthd \n" +
            "    JOIN HoaDon hd ON cthd.idhoadon = hd.id \n" +
            "    JOIN ChiTietSanPham ctsp ON cthd.idchitietsanpham = ctsp.id \n" +
            "    JOIN SanPham sp ON ctsp.idsanpham = sp.id \n" +
            "    JOIN ChatLieu cl ON ctsp.ChatLieu = cl.id\n" +
            "    JOIN Size s ON ctsp.Size = s.id \n" +
            "    JOIN DanhMuc dm ON ctsp.DanhMuc = dm.id \n" +
            "    JOIN MauSac ms ON ctsp.MauSac = ms.id \n" +
            "    JOIN Hang h ON ctsp.hang = h.idHang \n" +
            "WHERE \n" +
            "    hd.id = :idhoadon;", nativeQuery = true)
    List<ChiTietHoaDonCustom> findByHoaDonId( UUID idhoadon);

    @Query("SELECT c.idhoadon FROM ChiTietHoaDon c WHERE c.id = :chiTietId")
    UUID findHoaDonIdByChiTietId(UUID chiTietId);

    @Query("SELECT cthd.soluong FROM ChiTietHoaDon cthd WHERE cthd.id = :id")
    Integer getSoLuongById(@Param("id") UUID id);

    @Query(value = "SELECT * FROM ChiTietHoaDon " +
            "WHERE ChiTietHoaDon.idChiTietSanPham = :idChiTietSanPham " +
            "AND ChiTietHoaDon.idHoaDon = :idHoaDon", nativeQuery = true)
    List<ChiTietHoaDon> ktraAddctsplencthd(@Param("idChiTietSanPham") UUID idChiTietSanPham,
                                           @Param("idHoaDon") UUID idHoaDon);


}
