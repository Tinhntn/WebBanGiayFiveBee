package poly.edu.duantotnghiep.Service;


import org.springframework.stereotype.Service;
<<<<<<< HEAD
import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
=======
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
>>>>>>> 251681b45cf1ae81cf7964a04672666a8f57dc33
import poly.edu.duantotnghiep.Model.HoaDon;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {
<<<<<<< HEAD
    List<HoaDon> getAllHoaDon();
    HoaDon taohoadon(HoaDon hd);
    List<HoaDon> getAllHoaDonChuaThanhToan();
    void delete(UUID id);

    void updatesoluonghuyhd(UUID id, ChiTietSanPham chiTietSanPham, ChiTietHoaDon chiTietHoaDon);

=======
    List<HoaDonDAOCustom> getAllHoaDon();
>>>>>>> 251681b45cf1ae81cf7964a04672666a8f57dc33
}
