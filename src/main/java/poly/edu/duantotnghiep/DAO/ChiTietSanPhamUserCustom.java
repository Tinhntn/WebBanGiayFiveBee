package poly.edu.duantotnghiep.DAO;

import java.util.Date;
import java.util.UUID;

public interface ChiTietSanPhamUserCustom {
    UUID getSanPhamId();
    String getMaSanPham();
    String getTenSanPham();
    Date getSanPhamNgayTao();
    Date getSanPhamNgaySua();
    int getSanPhamTrangThai();
    UUID getChiTietSanPhamId();
    UUID getIdSanPham();
    UUID getHang();
    UUID getSize();
    UUID getDanhMuc();
    UUID getChatLieu();
    UUID getMauSac();
    UUID getIdKhuyenMai();
    Double getGiaNhap();
    Double getGiaBan();
    int getQR();
    String getHinhAnh();
    int getSoLuong();
    Date getChiTietSanPhamNgayTao();
    Date getChiTietSanPhamNgaySua();
    int getChiTietSanPhamTrangThai();
}

