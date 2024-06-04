package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;
import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Repository.ChiTietHoaDonRepository;
import poly.edu.duantotnghiep.Service.ChiTietHoaDonService;

import java.util.List;
import java.util.UUID;

@Service

public class ChiTietHoaDonIml implements ChiTietHoaDonService {

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;

    @Override
    public List<ChiTietHoaDonCustom> findByHoaDonId(UUID idhoadon) {
        return chiTietHoaDonRepository.findByHoaDonId(idhoadon);
    }
    @Override
    public Integer getSoLuongById(UUID id) {
        return chiTietHoaDonRepository.getSoLuongById(id);
    }

    @Override
    public ChiTietHoaDon addCTHD(ChiTietHoaDon cthd) {
        return chiTietHoaDonRepository.save(cthd);
    }


}
