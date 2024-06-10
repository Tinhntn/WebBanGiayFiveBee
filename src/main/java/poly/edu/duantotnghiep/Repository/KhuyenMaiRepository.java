package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.KhuyenMai;

import java.util.UUID;
@Repository
public interface KhuyenMaiRepository  extends JpaRepository<KhuyenMai, UUID> {
    KhuyenMai findKhuyenMaiByMakhuyenmai(@Param("maKhuyenMai")String maKhuyenMai);
    KhuyenMai findKhuyenMaiById(UUID id);
}
