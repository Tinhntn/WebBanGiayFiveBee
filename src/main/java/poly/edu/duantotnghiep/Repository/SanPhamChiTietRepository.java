package poly.edu.duantotnghiep.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<ChiTietSanPham, UUID> {

    @Query(value = "select chitietsanpham.id,sanpham.tensanpham as tensanpham, hang.tenhang as tenhang , size.ten as tensize, danhmuc.ten as tendanhmuc,chatlieu.ten as tenchatlieu,  mausac.ten as tenmausac,\n" +
            "\tchitietsanpham.gianhap, chitietsanpham.giaban, chitietsanpham.qr as qr,chitietsanpham.HinhAnh as hinhanh,chitietsanpham.SoLuong,chitietsanpham.MoTa,ChiTietSanPham.NgayTao,\n" +
            "\tchitietsanpham.ngaysua,chitietsanpham.trangthai\n" +
            "from chitietsanpham\n" +
            "join sanpham on sanpham.id = chitietsanpham.idsanpham\n" +
            "join hang on hang.idhang =chitietsanpham.hang\n" +
            "join size on size.id = chitietsanpham.size\n" +
            "join danhmuc on danhmuc.id = chitietsanpham.danhmuc\n" +
            "join chatlieu on chatlieu.id = chitietsanpham.chatlieu\n" +
            "join mausac on mausac.id = chitietsanpham.mausac\n"
           ,nativeQuery = true)
    Page<ChiTieSanPhamCustom> findAllChiTieSanPhamDAO(Pageable pageable);
    @Query(value = "select * from chitietsanpham",nativeQuery = true)
    List<ChiTietSanPham> getALlChiTietSanPham();
    @Query(value = "select chitietsanpham.id,sanpham.tensanpham as tensanpham, hang.tenhang as tenhang , size.ten as tensize, danhmuc.ten as tendanhmuc,chatlieu.ten as tenchatlieu,  mausac.ten as tenmausac,\n" +
            "\tchitietsanpham.gianhap, chitietsanpham.giaban, chitietsanpham.qr as qr,chitietsanpham.HinhAnh as hinhanh,chitietsanpham.SoLuong,chitietsanpham.MoTa,ChiTietSanPham.NgayTao,\n" +
            "\tchitietsanpham.ngaysua,chitietsanpham.trangthai\n" +
            "from chitietsanpham\n" +
            "join sanpham on sanpham.id = chitietsanpham.idsanpham\n" +
            "join hang on hang.idhang =chitietsanpham.hang\n" +
            "join size on size.id = chitietsanpham.size\n" +
            "join danhmuc on danhmuc.id = chitietsanpham.danhmuc\n" +
            "join chatlieu on chatlieu.id = chitietsanpham.chatlieu\n" +
            "join mausac on mausac.id = chitietsanpham.mausac\n"
           ,nativeQuery = true)
    List<ChiTieSanPhamCustom> getChiTietSanPhamDAO();

    @Query(value = "select * from ChiTietSanPham ctsp where ctsp.Id = ?", nativeQuery = true)
    ChiTietSanPham getChiTietSanPhamById(UUID id);

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
            "JOIN mausac ON mausac.id = chitietsanpham.mausac where chitietsanpham.id=:id", nativeQuery = true)
          ChiTieSanPhamCustom getChiTietSanPhamCTById(UUID id);

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
