package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.DAO.ChiTietGioHangCustom;
import poly.edu.duantotnghiep.Model.GioHangChiTiet;
import poly.edu.duantotnghiep.Repository.GioHangChiTietRepository;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {
    List<ChiTietGioHangCustom> getAllGioHang(UUID idGioHang);
    GioHangChiTiet getGHCTByID(UUID idGioHangChiTiet);
    GioHangChiTiet updatesl(GioHangChiTiet gioHangChiTiet);
    void xoaGHCT(UUID idGioHangChiTiet);
    Float getTongTien(UUID idGioHang);
    GioHangChiTiet addGGHCT(GioHangChiTiet gioHangChiTiet);
    List<ChiTietGioHangCustom> getAllBanHang(UUID idGioHang);
}
