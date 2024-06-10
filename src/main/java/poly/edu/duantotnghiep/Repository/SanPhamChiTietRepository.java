package poly.edu.duantotnghiep.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.DAO.ChiTietSanPhamDAO;
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



    // Bán hàng online
    @Query(value = "SELECT ctsp.Id as id,\n" +
            "       sp.tensanpham as tensanpham,\n" +
            "       h.tenhang as tenhang,\n" +
            "       s.ten as tensize,\n" +
            "       dm.ten as tendanhmuc,\n" +
            "       cl.ten as tenchatlieu,\n" +
            "       ms.ten as tenmausac,\n" +
            "       ctsp.idKhuyenMai as tenkhuyenmai,\n" +
            "       ctsp.gianhap as gianhap,\n" +
            "       ctsp.giaban as giaban,\n" +
            "       ctsp.qr as qr,\n" +
            "       ctsp.hinhanh as hinhanh,\n" +
            "       ctsp.soluong as soluong,\n" +
            "       ctsp.mota as mota,\n" +
            "       ctsp.ngaytao as ngaytao,\n" +
            "       ctsp.ngaysua as ngaysua,\n" +
            "       ctsp.trangthai as trangthai\n" +
            "FROM ChiTietSanPham ctsp\n" +
            "JOIN sanpham sp ON sp.id = ctsp.idSanPham\n" +
            "JOIN hang h ON h.idHang = ctsp.hang\n" +
            "JOIN size s ON s.id = ctsp.Size\n" +
            "JOIN danhmuc dm ON dm.id = ctsp.DanhMuc\n" +
            "JOIN chatlieu cl ON cl.id = ctsp.ChatLieu\n" +
            "JOIN mausac ms ON ms.id = ctsp.MauSac;\n",
            nativeQuery = true)
    Page<ChiTieSanPhamCustom> findAllChiTietSanPhamCust(Pageable pageable);

    // Truy vấn để lấy sản phẩm bán chạy
    @Query(value = "SELECT ctsp.Id as id, sp.tensanpham as tensanpham, h.tenhang as tenhang, s.ten as tensize, " +
            "dm.ten as tendanhmuc, cl.ten as tenchatlieu, ms.ten as tenmausac, ctsp.idKhuyenMai as tenkhuyenmai, " +
            "ctsp.gianhap as gianhap, ctsp.giaban as giaban, ctsp.qr as qr, ctsp.hinhanh as hinhanh, " +
            "ctsp.soluong as soluong, ctsp.mota as mota, ctsp.ngaytao as ngaytao, ctsp.ngaysua as ngaysua, " +
            "ctsp.trangthai as trangthai " +
            "FROM ChiTietSanPham ctsp " +
            "JOIN sanpham sp ON sp.id = ctsp.idSanPham " +
            "JOIN hang h ON h.idHang = ctsp.hang " +
            "JOIN size s ON s.id = ctsp.Size " +
            "JOIN danhmuc dm ON dm.id = ctsp.DanhMuc " +
            "JOIN chatlieu cl ON cl.id = ctsp.ChatLieu " +
            "JOIN mausac ms ON ms.id = ctsp.MauSac " +
            "ORDER BY ctsp.soluong DESC", // Giả định sản phẩm bán chạy được xác định bởi số lượng
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


}
