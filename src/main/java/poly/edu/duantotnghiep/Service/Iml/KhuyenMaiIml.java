package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.KhuyenMai;
import poly.edu.duantotnghiep.Repository.KhuyenMaiRepository;
import poly.edu.duantotnghiep.Service.KhuyenMaiService;
@Service
public class KhuyenMaiIml implements KhuyenMaiService {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Override
    public KhuyenMai getKhuyenMaiByMaKM(String maKhuyenMai) {
        return khuyenMaiRepository.findKhuyenMaiByMakhuyenmai(maKhuyenMai);
    }
}
