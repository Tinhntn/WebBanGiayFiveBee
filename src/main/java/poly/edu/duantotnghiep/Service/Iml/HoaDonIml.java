package poly.edu.duantotnghiep.Service.Iml;

import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Repository.ChiTietSanPhamRepository;
import poly.edu.duantotnghiep.Repository.HoaDonRepository;
import poly.edu.duantotnghiep.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service

public class HoaDonIml implements HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Override
    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.getAllHoaDon();
    }


    @Override
    public HoaDon taohoadon(HoaDon hd) {
        String maHoaDon = "HD" + String.format("%05d", (int) (Math.random() * 100000));
        hd.setMahoadon(maHoaDon);
        if (hd.getNgaysua() == null) hd.setNgaysua(new Date());
        hd.setTrangthai(0);
        return  hoaDonRepository.save(hd);
    }

    @Override
    public List<HoaDon> getAllHoaDonChuaThanhToan() {
        return hoaDonRepository.findHoaDonByTrangThai();
    }

    @Override
    public void delete(UUID id) {
      hoaDonRepository.deleteById(id);
    }

        @Override
        public void updatesoluonghuyhd(UUID id, ChiTietSanPham chiTietSanPham , ChiTietHoaDon chiTietHoaDon) {
//            int sl = ;
//            int ct = chiTietSanPhamRepository.updateSoLuongCTSPById(sl,id);
        }


}
