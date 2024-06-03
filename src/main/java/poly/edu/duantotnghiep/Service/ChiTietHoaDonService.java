package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;

import java.util.List;
import java.util.UUID;

public interface ChiTietHoaDonService {

//    List<ChiTietHoaDon> getAll();
    List<ChiTietHoaDonCustom> findByHoaDonId(UUID idhoadon);
    Integer getSoLuongById(UUID id);

}
