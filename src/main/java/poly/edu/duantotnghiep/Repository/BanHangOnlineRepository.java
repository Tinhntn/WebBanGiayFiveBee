package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.DAO.ChiTietSanPhamUserCustom;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.Size;

import java.util.List;
import java.util.UUID;

@Repository
public interface BanHangOnlineRepository extends JpaRepository<ChiTietSanPham, UUID> {



    @Query(value = "select idSanPham from ChiTietSanPham where Id = ?", nativeQuery = true)
    UUID getIdSPById(UUID id);




    @Query(value = "WITH RankedChiTietSanPham AS (\n" +
            "    SELECT \n" +
            "        ctsp.*,\n" +
            "        ROW_NUMBER() OVER (PARTITION BY ctsp.idSanPham, ctsp.hang, ctsp.DanhMuc, ctsp.ChatLieu ORDER BY ctsp.NgayTao) AS rn\n" +
            "    FROM \n" +
            "        [dbo].[ChiTietSanPham] ctsp\n" +
            "    WHERE \n" +
            "        ctsp.TrangThai = 1\n" +
            ")\n" +
            "SELECT \n" +
            "    sp.Id AS SanPhamId,\n" +
            "    sp.maSanPham,\n" +
            "    sp.tenSanPham,\n" +
            "    sp.NgayTao AS SanPhamNgayTao,\n" +
            "    sp.NgaySua AS SanPhamNgaySua,\n" +
            "    sp.TrangThai AS SanPhamTrangThai,\n" +
            "    ctsp.Id AS ChiTietSanPhamId,\n" +
            "    ctsp.idSanPham,\n" +
            "    ctsp.hang,\n" +
            "    ctsp.Size,\n" +
            "    ctsp.DanhMuc,\n" +
            "    ctsp.ChatLieu,\n" +
            "    ctsp.MauSac,\n" +
            "    ctsp.idKhuyenMai,\n" +
            "    ctsp.giaNhap,\n" +
            "    ctsp.giaBan,\n" +
            "    ctsp.QR,\n" +
            "    ctsp.HinhAnh,\n" +
            "    ctsp.SoLuong,\n" +
            "    ctsp.NgayTao AS ChiTietSanPhamNgayTao,\n" +
            "    ctsp.NgaySua AS ChiTietSanPhamNgaySua,\n" +
            "    ctsp.TrangThai AS ChiTietSanPhamTrangThai\n" +
            "FROM \n" +
            "    [dbo].[SanPham] sp\n" +
            "INNER JOIN \n" +
            "    RankedChiTietSanPham ctsp ON sp.Id = ctsp.idSanPham\n" +
            "WHERE \n" +
            "    ctsp.rn = 1\n" +
            "    AND sp.TrangThai = 1;", nativeQuery = true)
    List<ChiTietSanPhamUserCustom> getAllSP();


    @Query(value = "SELECT \n" +
            "    chitietsanpham.id, \n" +
            "    sanpham.tensanpham AS tensanpham, \n" +
            "    hang.tenhang AS tenhang, \n" +
            "    size.ten AS tensize, \n" +
            "    danhmuc.ten AS tendanhmuc, \n" +
            "    chatlieu.ten AS tenchatlieu, \n" +
            "    mausac.ten AS tenmausac, \n" +
            "    chitietsanpham.gianhap, \n" +
            "    chitietsanpham.giaban, \n" +
            "    chitietsanpham.qr AS qr, \n" +
            "    chitietsanpham.HinhAnh AS hinhanh, \n" +
            "    chitietsanpham.SoLuong, \n" +
            "    chitietsanpham.MoTa, \n" +
            "    chitietsanpham.NgayTao, \n" +
            "    chitietsanpham.ngaysua, \n" +
            "    chitietsanpham.trangthai \n" +
            "FROM \n" +
            "    chitietsanpham \n" +
            "    JOIN sanpham ON sanpham.id = chitietsanpham.idsanpham \n" +
            "    JOIN hang ON hang.idhang = chitietsanpham.hang \n" +
            "    JOIN size ON size.id = chitietsanpham.size \n" +
            "    JOIN danhmuc ON danhmuc.id = chitietsanpham.danhmuc \n" +
            "    JOIN chatlieu ON chatlieu.id = chitietsanpham.chatlieu \n" +
            "    JOIN mausac ON mausac.id = chitietsanpham.mausac \n" +
            "WHERE\n" +
            "    chitietsanpham.idSanPham = :idSanPham AND\n" +
            "    chitietsanpham.MauSac = :idMauSac AND\n" +
            "    chitietsanpham.ChatLieu = :idChatLieu AND\n" +
            "    chitietsanpham.hang = :idHang AND\n" +
            "    chitietsanpham.Size = :idSize AND\n" +
            "    chitietsanpham.DanhMuc = :idDanhMuc AND\n" +
            "    chitietsanpham.trangthai = 1;", nativeQuery = true)
      ChiTieSanPhamCustom timkiemCTSP(
            @Param("idSanPham") UUID idSanPham,
            @Param("idMauSac") UUID idMauSac,
            @Param("idChatLieu") UUID idChatLieu,
            @Param("idHang") UUID idHang,
            @Param("idSize") UUID idSize,
            @Param("idDanhMuc") UUID idDanhMuc);


}
