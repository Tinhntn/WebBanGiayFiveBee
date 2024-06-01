package poly.edu.duantotnghiep.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;

import java.util.List;

public interface ChiTietSanPhamService {
    List<ChiTieSanPhamCustom> getAllCTSP();
    Page<ChiTieSanPhamCustom> phanTrang(int page, int size);

}
