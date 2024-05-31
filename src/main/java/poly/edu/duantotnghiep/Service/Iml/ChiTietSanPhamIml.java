package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.Repository.SanPhamChiTietRepository;
import poly.edu.duantotnghiep.Service.ChiTietSanPhamService;

import java.util.List;
@Service
public class ChiTietSanPhamIml implements ChiTietSanPhamService {
    @Autowired
    SanPhamChiTietRepository sanPhamChiTietRepository;
    @Override
    public List<ChiTieSanPhamCustom> getAllCTSP() {
        return sanPhamChiTietRepository.getChiTietSanPhamDAO();
    }
}
