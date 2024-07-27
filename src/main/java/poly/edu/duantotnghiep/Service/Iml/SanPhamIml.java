package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.SanPham;
import poly.edu.duantotnghiep.Repository.SanPhamRepository;
import poly.edu.duantotnghiep.Service.SanPhamService;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamIml implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getSanPhamALL() {
        return sanPhamRepository.getSanPhamALL();
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void deleteSanPham(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public void updateSanPham(SanPham sanPham, UUID id) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham getSanPhamById(UUID id) {
        return sanPhamRepository.getSanPhamById(id);
    }
}
