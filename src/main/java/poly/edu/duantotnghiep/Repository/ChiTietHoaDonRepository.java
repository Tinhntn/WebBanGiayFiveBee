package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.duantotnghiep.Model.ChiTietHoaDon;


import java.util.List;
import java.util.UUID;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, UUID> {


    List<ChiTietHoaDon> findByIdhoadon(UUID hoaDonId);

}
