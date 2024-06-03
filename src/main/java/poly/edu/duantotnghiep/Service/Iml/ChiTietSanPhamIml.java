package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Repository.SanPhamChiTietRepository;
import poly.edu.duantotnghiep.Service.ChiTietSanPhamService;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamIml implements ChiTietSanPhamService {
    @Autowired
    SanPhamChiTietRepository sanPhamChiTietRepository;
    @Override
    public List<ChiTieSanPhamCustom> getAllCTSP() {
        return sanPhamChiTietRepository.getChiTietSanPhamDAO();
    }

    @Override
    public Page<ChiTieSanPhamCustom> phanTrang(int page, int size) {
        return sanPhamChiTietRepository.findAllChiTieSanPhamDAO(PageRequest.of(page,size));
    }
    @Override
    public ChiTietSanPham getChiTietSanPhamById(UUID idctsanpham) {
        return sanPhamChiTietRepository.getChiTietSanPhamById(idctsanpham);
    }
}
