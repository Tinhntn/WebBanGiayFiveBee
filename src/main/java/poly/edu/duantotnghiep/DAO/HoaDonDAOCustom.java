package poly.edu.duantotnghiep.DAO;

import java.util.Date;
import java.util.UUID;

public interface HoaDonDAOCustom {
    UUID getIdhoadon();
    String getMahoadon();
    String getTennhanvien();
    String getTenkhachhang();
    Date getNgaymua();
    Double getThanhtien();
    Double getGiatri();
    String getGhichu();
    Date getNgaytao();
    Date getNgaysua();
    Double getTongtien();
    Double getTongtiengiam();
    String getTrangthai();
    Double getTienkhachdua();
    String getTinhThanh();
    String getPhuongXa();
    String getQuanHuyen();
    String getTenNguoiNhan();
    String getEmailNguoiNhan();
    String getSdtNguoiNhan();
    Float getPhiShip();
    String getDonViGiao();
    String getTenNguoiGiao();
    String getSdtNguoiGiao();
    Integer getTrangThai();
        }
