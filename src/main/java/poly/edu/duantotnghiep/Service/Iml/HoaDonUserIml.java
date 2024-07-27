package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Repository.HoaDonUserRepository;
import poly.edu.duantotnghiep.Service.HoaDonUserService;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonUserIml implements HoaDonUserService {
    @Autowired
    HoaDonUserRepository hoaDonUserRepository;
    @Override
    public List<HoaDonDAOCustom> getHoaDonChoXacNhan(UUID idKhachHang) {
        return hoaDonUserRepository.getHoaDonChoxacnhan(idKhachHang);
    }

    @Override
    public List<HoaDonDAOCustom> getHoaDonCholayHang(UUID idKhachHang) {
        return hoaDonUserRepository.getHoaDoncholayhang(idKhachHang);
    }

    @Override
    public List<HoaDonDAOCustom> getHoaDonDangGiao(UUID idKhachHang) {
        return hoaDonUserRepository.getHoaDonDangGiao(idKhachHang);
    }
    @Override
    public List<HoaDonDAOCustom> getHoaDonDaGiao(UUID idKhachHang) {
        return hoaDonUserRepository.getHoaDonDaGiao(idKhachHang);
    }

    @Override
    public List<HoaDonDAOCustom> getHoaDonDaHuy(UUID idKhachHang) {
        return hoaDonUserRepository.getHoaDonDaHuy(idKhachHang);
    }

    @Override
    public List<HoaDonDAOCustom> getAll(UUID idKhachHang) {
        return hoaDonUserRepository.getAll(idKhachHang);
    }
}
