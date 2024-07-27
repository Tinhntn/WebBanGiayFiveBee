package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;

import java.util.List;

public interface HoaDonAdminService {

    List<HoaDonDAOCustom> getHoaDonOLChoxacnhan();
    List<HoaDonDAOCustom> getHoaDonOLChoLayHang();
    List<HoaDonDAOCustom> getHoaDonOLDangGiao();
    List<HoaDonDAOCustom> getHoaDonOlHoanThanh();
    List<HoaDonDAOCustom> getHoaDonOlDaHuy();


}
