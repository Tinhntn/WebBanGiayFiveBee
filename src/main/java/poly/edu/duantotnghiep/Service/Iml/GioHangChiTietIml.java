package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.ChiTietGioHangCustom;
import poly.edu.duantotnghiep.Model.GioHangChiTiet;
import poly.edu.duantotnghiep.Repository.GioHangChiTietRepository;
import poly.edu.duantotnghiep.Service.GioHangChiTietService;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangChiTietIml implements GioHangChiTietService {
    @Autowired
    GioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public List<ChiTietGioHangCustom> getAllGioHang(UUID idGioHang) {
        return gioHangChiTietRepository.getGioHang(idGioHang);
    }

    @Override
    public GioHangChiTiet getGHCTByID(UUID idGioHangChiTiet) {
        return gioHangChiTietRepository.getGioHangChiTietByIdgiohangchitiet(idGioHangChiTiet);
    }

    @Override
    public GioHangChiTiet updatesl(GioHangChiTiet gioHangChiTiet) {
        return gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Override
    public void xoaGHCT(UUID idGioHangChiTiet) {
        gioHangChiTietRepository.deleteById(idGioHangChiTiet);
    }

    @Override
    public Float getTongTien(UUID idGioHang) {
        return gioHangChiTietRepository.getTongTien(idGioHang);
    }

    @Override
    public GioHangChiTiet addGGHCT(GioHangChiTiet gioHangChiTiet) {
        return gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Override
    public List<ChiTietGioHangCustom> getAllBanHang(UUID idGioHang) {
        return gioHangChiTietRepository.getAllBanHang(idGioHang);
    }
}
