package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.Model.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getSanPhamALL();

    void addSanPham(SanPham sanPham);

    void deleteSanPham(UUID id);

    void updateSanPham(SanPham sanPham, UUID id);

    SanPham getSanPhamById(UUID id);

}
