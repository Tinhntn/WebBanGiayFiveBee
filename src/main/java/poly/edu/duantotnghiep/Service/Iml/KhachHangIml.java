package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.KhachHang;
import poly.edu.duantotnghiep.Repository.KhachHangRepository;
import poly.edu.duantotnghiep.Service.KhachHangService;

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
}
