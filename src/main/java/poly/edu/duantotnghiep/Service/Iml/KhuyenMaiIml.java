package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.KhuyenMai;
import poly.edu.duantotnghiep.Repository.KhuyenMaiRepository;
import poly.edu.duantotnghiep.Service.KhuyenMaiService;

import java.util.List;
@Service

public class KhuyenMaiIml implements KhuyenMaiService {

    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<KhuyenMai> getAllKhuyenMailist() {
        return khuyenMaiRepository.getAllKhuyenMailist();
    }

    @Override
    public KhuyenMai findKhuyenMaiByMakhuyenmai(String makhuyenmai) {
        return khuyenMaiRepository.findKhuyenMaiByMakhuyenmai(makhuyenmai);

    }
}
