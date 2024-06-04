package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.KhuyenMai;

import java.util.UUID;

public interface KhuyenMaiRepository  extends JpaRepository<KhuyenMai, UUID> {
}
