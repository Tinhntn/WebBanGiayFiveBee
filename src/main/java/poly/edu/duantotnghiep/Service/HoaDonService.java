package poly.edu.duantotnghiep.Service;


import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Model.HoaDon;

import java.util.List;

public interface HoaDonService {
    List<HoaDonDAOCustom> getAllHoaDon();
}
