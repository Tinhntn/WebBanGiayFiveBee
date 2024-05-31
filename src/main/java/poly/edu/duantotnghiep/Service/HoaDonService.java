package poly.edu.duantotnghiep.Service;


import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    List<HoaDon> getAllHoaDon();
    HoaDon taohoadon(HoaDon hd);
    List<HoaDon> getAllHoaDonChuaThanhToan();
    void delete(UUID id);

    void updatesoluonghuyhd(UUID id, ChiTietSanPham chiTietSanPham, ChiTietHoaDon chiTietHoaDon);

}
