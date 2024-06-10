package poly.edu.duantotnghiep.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.DAO.ChiTietSanPhamDAO;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {
    List<ChiTieSanPhamCustom> getAllCTSP();
    Page<ChiTieSanPhamCustom> phanTrang(int page, int size);
    ChiTietSanPham getChiTietSanPhamById(UUID idctsanpham);
    ChiTieSanPhamCustom getChiTietCustomSanPhamById(UUID idctsp);
    ChiTietSanPham updateSLSP(ChiTietSanPham chiTietSanPham);

    //Bán hàng online
    Page<ChiTieSanPhamCustom> findAllChiTietSanPhamCust(int page, int size);

    //Sản phẩm bán chạy
    Page<ChiTieSanPhamCustom> findBestSellingProducts(int page, int size);

    //Lấy ra bằng màu sắc
    ChiTieSanPhamCustom getChiTietSanPhamCTByIdAndMauSac(UUID id, UUID mausac);

}
