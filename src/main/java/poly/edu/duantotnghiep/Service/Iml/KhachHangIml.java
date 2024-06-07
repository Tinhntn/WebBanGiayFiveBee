package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.KhachHangCustom;
import poly.edu.duantotnghiep.Model.KhachHang;
import poly.edu.duantotnghiep.Repository.KhachHangRepository;
import poly.edu.duantotnghiep.Service.KhachHangService;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangIml implements KhachHangService {
@Autowired
    KhachHangRepository khachHangRepository;
    @Override
    public KhachHang getKhachHangByID(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }
    @Override
    public UUID findIdKhachHangBySdt(String sdt) {
        return khachHangRepository.findIdKhachHangBySdt(sdt);
    }

    @Override
    public List<KhachHang> getALlKH() {
        return khachHangRepository.getAllKH();
    }

//    public Page<KhachHangCustom> getALlKhachHang(int page, int size) {
//        return khachHangRepository.getAllKhachHang(PageRequest.of(page, size));
//    }


    public List<KhachHang> getALlKhachHanglist(){
        return khachHangRepository.getAllKhachHanglist();

    }

    @Override
    public KhachHang getKhachHangByMakhachhang(String maKhachHang) {
        return khachHangRepository.getKhachHangByMakhachhang(maKhachHang);
    }

}
