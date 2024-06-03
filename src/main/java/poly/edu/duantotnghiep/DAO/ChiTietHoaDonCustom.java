package poly.edu.duantotnghiep.DAO;

import java.util.Date;
import java.util.UUID;


public interface ChiTietHoaDonCustom {
    UUID getId();
    UUID getIdchitietsanpham();
    String getMaHoaDon();
    String getTenSanPham();
    int getSoluong();
    double getDongia();
    String getSize();
    String getHang();
    String getDanhMuc();
    String getMauSac();
    String getChatLieu();
    Date getNgayban();
    Date getNgaytao();
    Date getNgaysua();
    String getTrangthai();

}
