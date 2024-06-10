package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.KhachHang;
import poly.edu.duantotnghiep.Model.KhuyenMai;

import java.util.List;
import java.util.UUID;
@Repository

public interface KhuyenMaiRepository  extends JpaRepository<KhuyenMai, UUID> {

    @Query(value = "select * from KhuyenMai", nativeQuery = true)
    List<KhuyenMai> getAllKhuyenMailist();


    @Query(value = "SELECT * FROM KhuyenMai WHERE makhuyenmai = :makhuyenmai;", nativeQuery = true)
    KhuyenMai findKhuyenMaiByMakhuyenmai(@Param("makhuyenmai") String makhuyenmai);

}
