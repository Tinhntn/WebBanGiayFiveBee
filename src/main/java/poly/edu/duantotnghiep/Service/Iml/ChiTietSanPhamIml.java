package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.DAO.ChiTietSanPhamDAO;
import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Repository.ChiTietHoaDonRepository;
import poly.edu.duantotnghiep.Repository.SanPhamChiTietRepository;
import poly.edu.duantotnghiep.Service.ChiTietSanPhamService;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamIml implements ChiTietSanPhamService {
    @Autowired
    SanPhamChiTietRepository sanPhamChiTietRepository;
    @Autowired
    ChiTietHoaDonRepository chiTietHoaDonRepository;
    @Override
    public List<ChiTieSanPhamCustom> getAllCTSP() {
        return sanPhamChiTietRepository.getChiTietSanPhamDAO();
    }

    @Override
    public Page<ChiTieSanPhamCustom> phanTrang(int page, int size) {
        return sanPhamChiTietRepository.findAllChiTieSanPhamDAO(PageRequest.of(page,size));
    }

    @Override
    public void updateChiTietSanPhamSuaCTHD(UUID id, int soLuong) {
        int soLuongHDCT = chiTietHoaDonRepository.getSoLuongById(id);
        UUID idCTSP = chiTietHoaDonRepository.findIdCTSPByIDCTHD(id);
        ChiTietSanPham chiTietSanPham = sanPhamChiTietRepository.findById(idCTSP).orElseThrow(()->new RuntimeException("Không tìm thấy"));
        int soLuongCTSP = chiTietSanPham.getSoluong();
        int tongKho = soLuongCTSP+soLuongHDCT;
        int soLuongCapNhat = tongKho- soLuong;
        if(soLuongCapNhat<=0){
            chiTietSanPham.setTrangthai(0);
        }else {
            chiTietSanPham.setTrangthai(1);
        }
        chiTietSanPham.setSoluong(soLuongCapNhat);
        sanPhamChiTietRepository.save(chiTietSanPham);
    }
    @Override
    public ChiTietSanPham getChiTietSanPhamById(UUID idctsanpham) {
        return sanPhamChiTietRepository.getChiTietSanPhamById(idctsanpham);
    }

    @Override
    public ChiTieSanPhamCustom getChiTietCustomSanPhamById(UUID idctsp) {
        return sanPhamChiTietRepository.getChiTietSanPhamCTById(idctsp);
    }

    @Override
    public ChiTietSanPham updateSLSP(ChiTietSanPham chiTietSanPham) {
        return sanPhamChiTietRepository.save(chiTietSanPham);
    }
//    public Page<ChiTieSanPhamCustom> searchByTen(String tenSanPham, Pageable pageable) {
//        return sanPhamChiTietRepository.searchByTen(tenSanPham, pageable);
//    }

    @Override
    public Page<ChiTieSanPhamCustom> findAllChiTietSanPhamCust(int page, int size) {
        return sanPhamChiTietRepository.findAllChiTietSanPhamCust(PageRequest.of(page,size));
    }

    @Override
    public Page<ChiTieSanPhamCustom> findBestSellingProducts(int page, int size) {
        return sanPhamChiTietRepository.findBestSellingProducts(PageRequest.of(page,size));
    }

    @Override
    public ChiTieSanPhamCustom getChiTietSanPhamCTByIdAndMauSac(UUID id, UUID mausac) {
        return sanPhamChiTietRepository.getChiTietSanPhamCTByIdAndMauSac(id, mausac);
    }


}
