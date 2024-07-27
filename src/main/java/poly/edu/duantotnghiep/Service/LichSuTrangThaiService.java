package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.Model.LichSuTrangThai;

import java.util.List;
import java.util.UUID;

public interface LichSuTrangThaiService {
    void addLichSu(UUID idhoadon, String ghichu);
    List<LichSuTrangThai> getAllbyIdHoaDon(UUID idhoadon);
    void huyDon(UUID idhoadon,String ghichu);
    void DoiTrangThai(UUID idHoaDon, String ghiChu,int trangthai);
}
