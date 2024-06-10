package poly.edu.duantotnghiep.Service;

import org.springframework.data.repository.query.Param;
import poly.edu.duantotnghiep.Model.KhuyenMai;

import java.util.List;

public interface KhuyenMaiService {

    List<KhuyenMai> getAllKhuyenMailist();

    KhuyenMai findKhuyenMaiByMakhuyenmai(String makhuyenmai);

}
