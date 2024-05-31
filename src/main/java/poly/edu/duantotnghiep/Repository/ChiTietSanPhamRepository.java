package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;

import java.util.UUID;

public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham,UUID>{
    @Query(value = "UPDATE ChiTietSanPham SET SoLuong = ?1 WHERE id = ?2", nativeQuery = true)
    int updateSoLuongCTSPById(int soLuong, UUID id);
}
