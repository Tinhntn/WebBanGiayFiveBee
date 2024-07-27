package poly.edu.duantotnghiep.DAO;

import java.util.Date;
import java.util.UUID;

public interface ChiTieSanPhamCustom {
     UUID getId();
     UUID getIdSanPham();
     UUID getHang();
     UUID getSize();
     UUID getChatLieu();
     UUID getDanhMuc();
     UUID getMauSac();
     String getTenSanPham();
     String getTenHang();
     String getTenSize();
     String getTenDanhMuc();
     String getTenChatLieu();
     String getTenMauSac();
     String getTenKhuyenMai();
     Double getGiaNhap();
     Double getGiaBan();
     String getQR();
     String getHinhAnh();
     int getSoLuong();
     String getMoTa();
     Date getNgayTao();
     Date getNgaySua();
     int getTrangThai();
}
