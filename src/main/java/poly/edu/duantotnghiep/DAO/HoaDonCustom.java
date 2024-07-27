package poly.edu.duantotnghiep.DAO;

import java.util.Date;
import java.util.UUID;

public interface HoaDonCustom {
    UUID getId();

    String getTenNhanVien();

    String getTenKhachHang();

    String getMaHoaDon();

    Date getNgayTao();

    String getTenKhuyenMai();

    String getGhiChu();

    Double getTongTien();

    Double getTongTienGiam();

    Double getThanhTien();

    int getTrangThai();

    int getLoaiHoaDon();

    int getLoaiThanhToan();
}
