package poly.edu.duantotnghiep.DAO;

import java.util.Date;
import java.util.UUID;

public interface KhachHangCustom {

    UUID getId();
    String getMaKhachHang();
    String getLoaiKhachHang();
    String getTenKhachHang();
    String getDiaChi();
    String getGioiTinh();
    String getEmail();
    String getSdt();
    Date getNgaySinh();
    Date getNgayThamGia();
    int getTichDiem();
    int getDiemExp();
    Date getNgayTao();
    Date getNgaySua();
    int getTrangThai();

}
