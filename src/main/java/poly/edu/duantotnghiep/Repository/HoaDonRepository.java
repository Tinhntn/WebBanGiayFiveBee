package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.Model.HoaDon;

import java.util.List;
import java.util.UUID;
@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query(value = "select * from hoadon",nativeQuery = true)
    List<HoaDon> getAllHoaDon();

    @Query(value = "select * from hoadon where trangthai = 0",nativeQuery = true)
    List<HoaDon> findHoaDonByTrangThai();


}
