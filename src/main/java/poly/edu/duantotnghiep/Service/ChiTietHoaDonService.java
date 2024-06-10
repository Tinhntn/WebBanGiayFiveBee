package poly.edu.duantotnghiep.Service;

import org.springframework.data.domain.Page;
import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;

import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;

import java.util.List;
import java.util.UUID;

public interface ChiTietHoaDonService {

//    List<ChiTietHoaDon> getAll();
    List<ChiTietHoaDonCustom> findByHoaDonId(UUID idhoadon);
    void updateSoLuongHoaDonChiTietById(UUID id, int soLuong);
    Integer getSoLuongById(UUID id);
    ChiTietHoaDon addCTHD(ChiTietHoaDon cthd);
    ChiTietHoaDon findById(UUID id);

    List<ChiTietHoaDon> getKtraTrungCTSP(UUID idChiTietSanPham,UUID idHoaDon);

}
