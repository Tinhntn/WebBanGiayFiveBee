package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Model.HoaDon;


import java.util.List;
import java.util.UUID;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, UUID> {
    @Query(value = "select * from ChiTietHoaDon where idHoaDon = ?1 ", nativeQuery = true)
    List<ChiTietHoaDon> findChiTietHoaDonByIdhoadon(UUID id);
}
