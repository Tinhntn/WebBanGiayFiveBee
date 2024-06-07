package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.Model.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    KhachHang getKhachHangByID(UUID id);
    UUID findIdKhachHangBySdt(String sdt);
    List<KhachHang> getALlKH();
}
