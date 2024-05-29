package poly.edu.duantotnghiep.Service.Iml;

import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Repository.HoaDonRepository;
import poly.edu.duantotnghiep.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class HoaDonIml implements HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Override
    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.getAllHoaDon();
    }
}
