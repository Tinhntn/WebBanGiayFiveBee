package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.HoaDonCustom;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Model.LichSuTrangThai;
import poly.edu.duantotnghiep.Repository.HoaDonRepository;
import poly.edu.duantotnghiep.Repository.LichSuTrangThaiRepository;
import poly.edu.duantotnghiep.Service.HoaDonService;
import poly.edu.duantotnghiep.Service.LichSuTrangThaiService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class LichSuTrangThaiIml implements LichSuTrangThaiService {
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    LichSuTrangThaiRepository lichSuTrangThaiRepository;
    @Override
    public void addLichSu(UUID idhoadon, String ghiChu) {
        HoaDonCustom hoaDon = hoaDonService.getHoaDonByIdHoaDon(idhoadon);
        LichSuTrangThai lichSuTrangThai = new LichSuTrangThai();
        lichSuTrangThai.setIdhoadon(String.valueOf(hoaDon.getId()));
        lichSuTrangThai.setTrangthai(hoaDon.getTrangThai());
        lichSuTrangThai.setThoigian(new Date());
        lichSuTrangThai.setGhichu(ghiChu);
        lichSuTrangThaiRepository.save(lichSuTrangThai);

    }

    @Override
    public List<LichSuTrangThai> getAllbyIdHoaDon(UUID idhoadon) {
        return lichSuTrangThaiRepository.getLichSuByIdHoaDon(idhoadon);
    }

    @Override
    public void huyDon(UUID idhoadon,String ghichu) {
        HoaDonCustom hoaDon = hoaDonService.getHoaDonByIdHoaDon(idhoadon);
        hoaDonService.HuyDon(idhoadon);
        LichSuTrangThai lichSuTrangThai = new LichSuTrangThai();
        lichSuTrangThai.setIdhoadon(String.valueOf(hoaDon.getId()));
        lichSuTrangThai.setTrangthai(0);
        lichSuTrangThai.setThoigian(new Date());
        lichSuTrangThai.setGhichu(ghichu);
        lichSuTrangThaiRepository.save(lichSuTrangThai);
    }

    @Override
    public void DoiTrangThai(UUID idHoaDon, String ghiChu, int trangthai) {
        if(trangthai==0){
            //Hủy hóa đơn
            HoaDon hoaDon1 = hoaDonRepository.findById(idHoaDon).orElseThrow(()->new RuntimeException());
            hoaDon1.setTrangthai(6);
            LichSuTrangThai lichSuTrangThai = new LichSuTrangThai();
            lichSuTrangThai.setIdhoadon(String.valueOf(hoaDon1.getId()));
            lichSuTrangThai.setTrangthai(6);
            lichSuTrangThai.setThoigian(new Date());
            lichSuTrangThai.setGhichu(ghiChu);
            lichSuTrangThaiRepository.save(lichSuTrangThai);
            return;
        }else if(trangthai==1){
            HoaDon hoaDon5 = hoaDonRepository.findById(idHoaDon).orElseThrow(()->new RuntimeException());
            hoaDon5.setTrangthai(1);
            LichSuTrangThai lichSuTrangThai = new LichSuTrangThai();
            lichSuTrangThai.setIdhoadon(String.valueOf(hoaDon5.getId()));
            lichSuTrangThai.setTrangthai(1);
            lichSuTrangThai.setThoigian(new Date());
            lichSuTrangThai.setGhichu(ghiChu);
            lichSuTrangThaiRepository.save(lichSuTrangThai);
            return;
        }else if(trangthai==2){
            HoaDon hoaDon2 = hoaDonRepository.findById(idHoaDon).orElseThrow(()->new RuntimeException());
            hoaDon2.setTrangthai(2);
            LichSuTrangThai lichSuTrangThai = new LichSuTrangThai();
            lichSuTrangThai.setIdhoadon(String.valueOf(hoaDon2.getId()));
            lichSuTrangThai.setTrangthai(2);
            lichSuTrangThai.setThoigian(new Date());
            lichSuTrangThai.setGhichu(ghiChu);
            lichSuTrangThaiRepository.save(lichSuTrangThai);
            return;
        }else if(trangthai==3){
            HoaDon hoaDon3 = hoaDonRepository.findById(idHoaDon).orElseThrow(()->new RuntimeException());
            hoaDon3.setTrangthai(3);
            LichSuTrangThai lichSuTrangThai = new LichSuTrangThai();
            lichSuTrangThai.setIdhoadon(String.valueOf(hoaDon3.getId()));
            lichSuTrangThai.setTrangthai(3);
            lichSuTrangThai.setThoigian(new Date());
            lichSuTrangThai.setGhichu(ghiChu);
            lichSuTrangThaiRepository.save(lichSuTrangThai);
            return;
        }else if(trangthai==4){
            HoaDon hoaDon4 = hoaDonRepository.findById(idHoaDon).orElseThrow(()->new RuntimeException());
            hoaDon4.setTrangthai(4);
            LichSuTrangThai lichSuTrangThai = new LichSuTrangThai();
            lichSuTrangThai.setIdhoadon(String.valueOf(hoaDon4.getId()));
            lichSuTrangThai.setTrangthai(4);
            lichSuTrangThai.setThoigian(new Date());
            lichSuTrangThai.setGhichu(ghiChu);
            lichSuTrangThaiRepository.save(lichSuTrangThai);
            return;
        }
    }

}
