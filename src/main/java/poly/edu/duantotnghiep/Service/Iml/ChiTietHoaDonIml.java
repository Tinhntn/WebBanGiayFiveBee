package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;
import poly.edu.duantotnghiep.DAO.ChiTietSanPhamDAO;
import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Repository.ChiTietHoaDonRepository;
import poly.edu.duantotnghiep.Repository.HoaDonRepository;
import poly.edu.duantotnghiep.Service.ChiTietHoaDonService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class ChiTietHoaDonIml implements ChiTietHoaDonService {

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Override
    public List<ChiTietHoaDonCustom> findByHoaDonId(UUID idhoadon) {
        return chiTietHoaDonRepository.findByHoaDonId(idhoadon);
    }
    @Override
    public void updateSoLuongHoaDonChiTietById(UUID id, int soLuong) {


        ChiTietHoaDon chiTietHoaDon = chiTietHoaDonRepository.findById(id).orElseThrow(()->new RuntimeException("Không tìm thấy hoadonchitiet"));
        UUID idHoaDon = chiTietHoaDon.getIdhoadon();
        HoaDon hoaDon = hoaDonRepository.findById(idHoaDon).orElseThrow(()->new RuntimeException("KHong tim thấy hoadon"));
        Float tongtienmoi = soLuong*chiTietHoaDon.getDongia();
        hoaDon.setTongtien(tongtienmoi);
        hoaDonRepository.save(hoaDon);
        chiTietHoaDon.setSoluong(soLuong);
        chiTietHoaDonRepository.save(chiTietHoaDon);
    }



}
