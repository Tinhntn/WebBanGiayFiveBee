package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.Model.KhuyenMai;
import poly.edu.duantotnghiep.Model.LichSuTrangThai;

import java.util.List;
import java.util.UUID;

@Repository
public interface LichSuTrangThaiRepository extends JpaRepository<LichSuTrangThai, UUID> {
    @Query(value = "select * from lichsutrangthai where idhoadon = :idhoadon",nativeQuery = true)
    List<LichSuTrangThai> getLichSuByIdHoaDon(@Param("idhoadon") UUID id);
}
