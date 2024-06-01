package poly.edu.duantotnghiep.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

}
