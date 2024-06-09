package poly.edu.duantotnghiep.Service;


import poly.edu.duantotnghiep.Model.ChiTietHoaDon;

import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;

import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {

    List<HoaDon> getAllHoaDoncho();
    HoaDon taohoadon(HoaDon hd);
    List<HoaDon> getAllHoaDonChuaThanhToan();
    void delete(UUID id);
    void updateSoLuongCTSanPhamByHoaDonId(UUID id);
    List<HoaDonDAOCustom> getAllHoaDon();
    HoaDonDAOCustom getAllTenTPD(UUID idHD);

    void updateHoaDon(HoaDon hd,UUID id);

    ChiTietHoaDon findbyid(UUID id);
    HoaDon detailHD(UUID id);

}
