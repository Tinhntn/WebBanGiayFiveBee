package poly.edu.duantotnghiep.Service.Iml;


import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;

import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;

import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Repository.ChiTietHoaDonRepository;
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
    @Autowired
    ChiTietHoaDonRepository chiTietHoaDonRepository;

    @Override
    public List<HoaDonDAOCustom> getAllHoaDon() {
        return hoaDonRepository.getHoaDonDAO();
    }
    @Override
    public ChiTietHoaDon findbyid(UUID id) {
        return chiTietHoaDonRepository.findById(id).orElse(null);
    }
    @Override
    public List<HoaDon> getAllHoaDoncho() {
        return null;
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
    public void updateSoLuongCTSanPhamByHoaDonId(UUID hoaDonId) {
        // Lấy danh sách chi tiết hóa đơn liên quan đến hóa đơn có ID tương ứng
        List<ChiTietHoaDon> chiTietHoaDonList = chiTietHoaDonRepository.findByIdhoadon(hoaDonId);
        // Duyệt qua danh sách và cập nhật số lượng sản phẩm trong bảng ChiTietSanPham
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonList) {
            UUID idctSanPham = chiTietHoaDon.getIdchitietsanpham();
            int soLuongctHoaDon = chiTietHoaDon.getSoluong();
            // Lấy số lượng chi tiết sản phẩm ban đầu
            ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(idctSanPham).orElse(null);
            if (chiTietSanPham != null) {
                int soLuongBanDau = chiTietSanPham.getSoluong();
                // Tính toán và cập nhật số lượng mới
                int soLuongMoi = soLuongBanDau + soLuongctHoaDon;
                chiTietSanPham.setSoluong(soLuongMoi);

                // Lưu thay đổi vào cơ sở dữ liệu
                chiTietSanPhamRepository.save(chiTietSanPham);
            }
        }
    }




}
