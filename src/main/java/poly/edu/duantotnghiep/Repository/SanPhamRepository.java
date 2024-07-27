package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.Model.SanPham;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {

    @Query(value = "select * from SanPham where trangthai = 1", nativeQuery = true)
    List<SanPham> getSanPhamALL();

    @Query(value = "select * from SanPham where id = :id", nativeQuery = true)
    SanPham getSanPhamById(UUID id);

}
