package poly.edu.duantotnghiep.DAO;

import java.util.UUID;

public interface ChiTietGioHangCustom {
    UUID getIdNhanVien();
    UUID getIdKhachHang();
    UUID getIdKhuyenMai();
    UUID getIdGioHang();
    UUID getIdGioHangChiTiet();
    UUID getIdChiTietSanPham();
    int getSoLuong();
    Float getDonGia();
    Float getTongTien();
    Float getDonGiaKhiGiam();
    String getTenSanPham();
    String getHinhAnh();
    int getTrangThai();
    String getTenHang();
    String getTenSize();
    String getTenChatLieu();
    String getTenDanhMuc();
    String getTenMauSac();




}
