package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;

import java.util.List;
import java.util.UUID;

public interface HoaDonUserService {
    List<HoaDonDAOCustom> getHoaDonChoXacNhan(UUID idKhachHang);
    List<HoaDonDAOCustom> getHoaDonCholayHang(UUID idKhachHang);
    List<HoaDonDAOCustom> getHoaDonDangGiao(UUID idKhachHang);
    List<HoaDonDAOCustom> getHoaDonDaGiao(UUID idKhachHang);
    List<HoaDonDAOCustom> getHoaDonDaHuy(UUID idKhachHang);
    List<HoaDonDAOCustom> getAll(UUID idKhachHang);
}
