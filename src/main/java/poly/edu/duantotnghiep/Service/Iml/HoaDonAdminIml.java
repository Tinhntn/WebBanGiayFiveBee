package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Repository.HoaDonAdminRepository;
import poly.edu.duantotnghiep.Service.HoaDonAdminService;

import java.util.List;

@Service
public class HoaDonAdminIml implements HoaDonAdminService {

    @Autowired
    HoaDonAdminRepository hoaDonAdminRepository;

    @Override
    public List<HoaDonDAOCustom> getHoaDonOLChoxacnhan() {
        return hoaDonAdminRepository.getHoaDonOLChoxacnhan();
    }

    @Override
    public List<HoaDonDAOCustom> getHoaDonOLChoLayHang() {
        return hoaDonAdminRepository.getHoaDonOLChoLayHang();
    }

    @Override
    public List<HoaDonDAOCustom> getHoaDonOLDangGiao() {
        return hoaDonAdminRepository.getHoaDonOLDangGiao();
    }

    @Override
    public List<HoaDonDAOCustom> getHoaDonOlHoanThanh() {
        return hoaDonAdminRepository.getHoaDonOLHoanThanh();
    }

    @Override
    public List<HoaDonDAOCustom> getHoaDonOlDaHuy() {
        return hoaDonAdminRepository.getHoaDonOLDaHuy();
    }
}
