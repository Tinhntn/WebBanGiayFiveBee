package poly.edu.duantotnghiep.Service;


import org.springframework.data.domain.Page;
import poly.edu.duantotnghiep.DAO.HoaDonCustom;
import poly.edu.duantotnghiep.DAO.HoaDonLichSuCustom;
import poly.edu.duantotnghiep.Model.ChiTietHoaDon;

import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;

import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {

    List<HoaDon> getAllHoaDoncho();
    HoaDon getAllHoaDonById(UUID id);
    HoaDon taohoadon(HoaDon hd);
    List<HoaDon> getAllHoaDonChuaThanhToan();
    void delete(UUID id);
    void updateSoLuongCTSanPhamByHoaDonId(UUID id);
    List<HoaDonDAOCustom> getAllHoaDon();
    HoaDonDAOCustom getAllTenTPD(UUID idHD);
    Page<HoaDonCustom> getAllHoaDonDaThanhToan(int page, int size);

    void updateHoaDon(HoaDon hd,UUID id);
    HoaDon tao(HoaDon hoaDon);
    ChiTietHoaDon findbyid(UUID id);
    HoaDon detailHD(UUID id);
    Float hienthiTongTienHD(UUID id);

    long hoadonchuathanhtoan();
    long hoadondathanhtoan();
    long hoadondangiao();
    long hoadondagiao();
    long hoadondahuy();

    HoaDonCustom getHoaDonByIdHoaDon(UUID id);
    HoaDonLichSuCustom getLichSu(UUID id);
    void HuyDon(UUID idhoadon);
}
