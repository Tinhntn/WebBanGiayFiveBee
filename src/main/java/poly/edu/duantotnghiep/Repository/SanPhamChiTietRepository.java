package poly.edu.duantotnghiep.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.DAO.ChiTietSanPhamDAO;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<ChiTietSanPham, UUID> {

    @Query(value = "SELECT chitietsanpham.id, sanpham.tensanpham AS tensanpham, hang.tenhang AS tenhang, size.ten AS tensize, " +
            "danhmuc.ten AS tendanhmuc, chatlieu.ten AS tenchatlieu, mausac.ten AS tenmausac, chitietsanpham.gianhap, " +
            "chitietsanpham.giaban, chitietsanpham.qr AS qr, chitietsanpham.HinhAnh AS hinhanh, chitietsanpham.SoLuong, " +
            "chitietsanpham.MoTa, chitietsanpham.NgayTao, chitietsanpham.ngaysua, chitietsanpham.trangthai " +
            "FROM chitietsanpham " +
            "JOIN sanpham ON sanpham.id = chitietsanpham.idsanpham " +
            "JOIN hang ON hang.idhang = chitietsanpham.hang " +
            "JOIN size ON size.id = chitietsanpham.size " +
            "JOIN danhmuc ON danhmuc.id = chitietsanpham.danhmuc " +
            "JOIN chatlieu ON chatlieu.id = chitietsanpham.chatlieu " +
            "JOIN mausac ON mausac.id = chitietsanpham.mausac " +
            "WHERE chitietsanpham.trangthai = 1",
            nativeQuery = true)
    Page<ChiTieSanPhamCustom> findAllChiTieSanPhamDAO(Pageable pageable);


    @Query(value = "SELECT chitietsanpham.id, sanpham.tensanpham AS tensanpham, hang.tenhang AS tenhang, size.ten AS tensize, " +
            "danhmuc.ten AS tendanhmuc, chatlieu.ten AS tenchatlieu, mausac.ten AS tenmausac, chitietsanpham.gianhap, " +
            "chitietsanpham.giaban, chitietsanpham.qr AS qr, chitietsanpham.HinhAnh AS hinhanh, chitietsanpham.SoLuong, " +
            "chitietsanpham.MoTa, chitietsanpham.NgayTao, chitietsanpham.ngaysua, chitietsanpham.trangthai " +
            "FROM chitietsanpham " +
            "JOIN sanpham ON sanpham.id = chitietsanpham.idsanpham " +
            "JOIN hang ON hang.idhang = chitietsanpham.hang " +
            "JOIN size ON size.id = chitietsanpham.size " +
            "JOIN danhmuc ON danhmuc.id = chitietsanpham.danhmuc " +
            "JOIN chatlieu ON chatlieu.id = chitietsanpham.chatlieu " +
            "JOIN mausac ON mausac.id = chitietsanpham.mausac " +
            "WHERE chitietsanpham.trangthai = 1",
            nativeQuery = true)
    List<ChiTieSanPhamCustom> getChiTietSanPhamDAO();


    @Query(value = "SELECT * FROM chitietsanpham WHERE id = :id", nativeQuery = true)
    ChiTietSanPham getChiTietSanPhamById(@Param("id") UUID id);


    @Query(value = "SELECT chitietsanpham.id,chitietsanpham.idSanPham,chitietsanpham.hang,chitietsanpham.size,chitietsanpham.danhmuc,chitietsanpham.chatlieu,chitietsanpham.mausac," +
            " sanpham.tensanpham AS tensanpham, hang.tenhang AS tenhang, size.ten AS tensize, " +
            "danhmuc.ten AS tendanhmuc, chatlieu.ten AS tenchatlieu, mausac.ten AS tenmausac, chitietsanpham.gianhap, " +
            "chitietsanpham.giaban, chitietsanpham.qr AS qr, chitietsanpham.HinhAnh AS hinhanh, chitietsanpham.SoLuong, " +
            "chitietsanpham.MoTa, chitietsanpham.NgayTao, chitietsanpham.ngaysua, chitietsanpham.trangthai " +
            "FROM chitietsanpham " +
            "JOIN sanpham ON sanpham.id = chitietsanpham.idsanpham " +
            "JOIN hang ON hang.idhang = chitietsanpham.hang " +
            "JOIN size ON size.id = chitietsanpham.size " +
            "JOIN danhmuc ON danhmuc.id = chitietsanpham.danhmuc " +
            "JOIN chatlieu ON chatlieu.id = chitietsanpham.chatlieu " +
            "JOIN mausac ON mausac.id = chitietsanpham.mausac " +
            "WHERE chitietsanpham.id = :id",
            nativeQuery = true)
    ChiTieSanPhamCustom getChiTietSanPhamCTById(@Param("id") UUID id);



    // Bán hàng online
    @Query(value = "SELECT chitietsanpham.id, sanpham.tensanpham AS tensanpham, hang.tenhang AS tenhang, size.ten AS tensize, " +
            "danhmuc.ten AS tendanhmuc, chatlieu.ten AS tenchatlieu, mausac.ten AS tenmausac, chitietsanpham.gianhap, " +
            "chitietsanpham.giaban, chitietsanpham.qr AS qr, chitietsanpham.HinhAnh AS hinhanh, chitietsanpham.SoLuong, " +
            "chitietsanpham.MoTa, chitietsanpham.NgayTao, chitietsanpham.ngaysua, chitietsanpham.trangthai " +
            "FROM chitietsanpham " +
            "JOIN sanpham ON sanpham.id = chitietsanpham.idsanpham " +
            "JOIN hang ON hang.idhang = chitietsanpham.hang " +
            "JOIN size ON size.id = chitietsanpham.size " +
            "JOIN danhmuc ON danhmuc.id = chitietsanpham.danhmuc " +
            "JOIN chatlieu ON chatlieu.id = chitietsanpham.chatlieu " +
            "JOIN mausac ON mausac.id = chitietsanpham.mausac",
            nativeQuery = true)
    Page<ChiTieSanPhamCustom> findAllChiTietSanPhamCust(Pageable pageable);


    // Truy vấn để lấy sản phẩm bán chạy
    @Query(value = "SELECT chitietsanpham.id, sanpham.tensanpham AS tensanpham, hang.tenhang AS tenhang, size.ten AS tensize, " +
            "danhmuc.ten AS tendanhmuc, chatlieu.ten AS tenchatlieu, mausac.ten AS tenmausac, chitietsanpham.gianhap, " +
            "chitietsanpham.giaban, chitietsanpham.qr AS qr, chitietsanpham.HinhAnh AS hinhanh, chitietsanpham.SoLuong, " +
            "chitietsanpham.MoTa, chitietsanpham.NgayTao, chitietsanpham.ngaysua, chitietsanpham.trangthai " +
            "FROM chitietsanpham " +
            "JOIN sanpham ON sanpham.id = chitietsanpham.idsanpham " +
            "JOIN hang ON hang.idhang = chitietsanpham.hang " +
            "JOIN size ON size.id = chitietsanpham.size " +
            "JOIN danhmuc ON danhmuc.id = chitietsanpham.danhmuc " +
            "JOIN chatlieu ON chatlieu.id = chitietsanpham.chatlieu " +
            "JOIN mausac ON mausac.id = chitietsanpham.mausac " +
            "ORDER BY chitietsanpham.SoLuong DESC",
            nativeQuery = true)
    Page<ChiTieSanPhamCustom> findBestSellingProducts(Pageable pageable);



    //Lấy ra bằng màu sắc

    @Query(value = "SELECT chitietsanpham.id, \n" +
            "       sanpham.tensanpham AS tensanpham, \n" +
            "       hang.tenhang AS tenhang, \n" +
            "       size.ten AS tensize, \n" +
            "       danhmuc.ten AS tendanhmuc, \n" +
            "       chatlieu.ten AS tenchatlieu, \n" +
            "       mausac.ten AS tenmausac,\n" +
            "       chitietsanpham.gianhap, \n" +
            "       chitietsanpham.giaban, \n" +
            "       chitietsanpham.qr AS qr,\n" +
            "       chitietsanpham.HinhAnh AS hinhanh,\n" +
            "       chitietsanpham.SoLuong,\n" +
            "       chitietsanpham.MoTa,\n" +
            "       chitietsanpham.NgayTao,\n" +
            "       chitietsanpham.ngaysua,\n" +
            "       chitietsanpham.trangthai\n" +
            "FROM chitietsanpham\n" +
            "JOIN sanpham ON sanpham.id = chitietsanpham.idsanpham\n" +
            "JOIN hang ON hang.idhang = chitietsanpham.hang\n" +
            "JOIN size ON size.id = chitietsanpham.size\n" +
            "JOIN danhmuc ON danhmuc.id = chitietsanpham.danhmuc\n" +
            "JOIN chatlieu ON chatlieu.id = chitietsanpham.chatlieu\n" +
            "JOIN mausac ON mausac.id = chitietsanpham.mausac \n" +
            "WHERE chitietsanpham.id = :id AND chitietsanpham.mausac = :mausac", nativeQuery = true)
    ChiTieSanPhamCustom getChiTietSanPhamCTByIdAndMauSac(UUID id, UUID mausac);


    @Query(value = "SELECT ctsp.id AS id,\n" +
            "       sp.tensanpham AS tensanpham,\n" +
            "       h.tenhang AS tenhang,\n" +
            "       s.ten AS tensize,\n" +
            "       dm.ten AS tendanhmuc,\n" +
            "       cl.ten AS tenchatlieu,\n" +
            "       ms.ten AS tenmausac,\n" +
            "       ctsp.gianhap AS gianhap,\n" +
            "       ctsp.giaban AS giaban,\n" +
            "       ctsp.qr AS qr,\n" +
            "       ctsp.HinhAnh AS hinhanh,\n" +
            "       ctsp.SoLuong AS soLuong,\n" +
            "       ctsp.MoTa AS moTa,\n" +
            "       ctsp.NgayTao AS ngayTao,\n" +
            "       ctsp.ngaysua AS ngaysua,\n" +
            "       ctsp.trangthai AS trangthai\n" +
            "FROM chitietsanpham ctsp\n" +
            "JOIN sanpham sp ON sp.id = ctsp.idsanpham\n" +
            "JOIN hang h ON h.idhang = ctsp.hang\n" +
            "JOIN size s ON s.id = ctsp.size\n" +
            "JOIN danhmuc dm ON dm.id = ctsp.danhmuc\n" +
            "JOIN chatlieu cl ON cl.id = ctsp.chatlieu\n" +
            "JOIN mausac ms ON ms.id = ctsp.mausac\n" +
            "WHERE ctsp.idsanpham = ?", nativeQuery = true)
    List<ChiTieSanPhamCustom> getChiTietSanPhamByIdSanPham(@Param("idSanPham") UUID idSanPham);


//
//    @Query(value = "select chitietsanpham.id,sanpham.tensanpham as tensanpham, hang.tenhang as tenhang , size.ten as tensize, danhmuc.ten as tendanhmuc,chatlieu.ten as tenchatlieu,  mausac.ten as tenmausac,\n" +
//            "\tchitietsanpham.gianhap, chitietsanpham.giaban, chitietsanpham.qr as qr,chitietsanpham.HinhAnh as hinhanh,chitietsanpham.SoLuong,chitietsanpham.MoTa,ChiTietSanPham.NgayTao,\n" +
//            "\tchitietsanpham.ngaysua,chitietsanpham.trangthai\n" +
//            "from chitietsanpham\n" +
//            "join sanpham on sanpham.id = chitietsanpham.idsanpham\n" +
//            "join hang on hang.idhang =chitietsanpham.hang\n" +
//            "join size on size.id = chitietsanpham.size\n" +
//            "join danhmuc on danhmuc.id = chitietsanpham.danhmuc\n" +
//            "join chatlieu on chatlieu.id = chitietsanpham.chatlieu\n" +
//            "join mausac on mausac.id = chitietsanpham.mausac\n" +
//            "where SanPham.tenSanPham like'%ten%"
//            ,nativeQuery = true)
//    Page<ChiTieSanPhamCustom> searchByTen(@Param("tenSanPham") String tenSanPham, Pageable pageable);

//    @Query(value = "select chitietsanpham.id,sanpham.tensanpham as tensanpham, hang.tenhang as tenhang , size.ten as tensize, danhmuc.ten as tendanhmuc,chatlieu.ten as tenchatlieu,  mausac.ten as tenmausac,\n" +
//            "\tchitietsanpham.gianhap, chitietsanpham.giaban, chitietsanpham.qr as qr,chitietsanpham.HinhAnh as hinhanh,chitietsanpham.SoLuong,chitietsanpham.MoTa,ChiTietSanPham.NgayTao,\n" +
//            "\tchitietsanpham.ngaysua,chitietsanpham.trangthai\n" +
//            "from chitietsanpham\n" +
//            "join sanpham on sanpham.id = chitietsanpham.idsanpham\n" +
//            "join hang on hang.idhang =chitietsanpham.hang\n" +
//            "join size on size.id = chitietsanpham.size\n" +
//            "join danhmuc on danhmuc.id = chitietsanpham.danhmuc\n" +
//            "join chatlieu on chatlieu.id = chitietsanpham.chatlieu\n" +
//            "join mausac on mausac.id = chitietsanpham.mausac\n" +
//            "where SanPham.tenSanPham LIKE %:tenSanPham%"
//            ,nativeQuery = true)
//    List<ChiTieSanPhamCustom> searchByTenlist(@Param("tenSanPham") String tenSanPham);
}
