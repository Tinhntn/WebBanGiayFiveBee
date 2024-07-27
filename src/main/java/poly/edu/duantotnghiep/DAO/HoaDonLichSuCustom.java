package poly.edu.duantotnghiep.DAO;

import java.util.UUID;

public interface HoaDonLichSuCustom {
    UUID getId();
    String getMaHoaDon();
    String getTenKhachHang();
    String getSdtKhachHang();
    String getDiaChi();
    String getEmail();
    String getTenNguoiGiao();
    String getSdtNguoiGiao();
    int getTrangThai();
    int getLoaiHoaDon();
}

