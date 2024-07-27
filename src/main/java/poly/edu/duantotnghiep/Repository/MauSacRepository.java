package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.DAO.MauSacCustom;
import poly.edu.duantotnghiep.DAO.SizeCustom;
import poly.edu.duantotnghiep.Model.MauSac;

import java.util.List;
import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {

    @Query(value = "select * from MauSac", nativeQuery = true)
    List<MauSac> getMauSacALL();

    @Query(value = "SELECT DISTINCT m.id AS id, " +
            "m.ma AS ma, " +
            "m.ten AS ten, " +
            "m.ngaytao AS ngayTao, " +
            "m.ngaysua AS ngaySua, " +
            "m.trangthai AS trangThai " +
            "FROM MauSac m " +  // Sử dụng bảng Size trực tiếp
            "JOIN ChiTietSanPham c ON m.id = c.MauSac " +
            "WHERE c.idSanPham = :id ", nativeQuery = true)
    List<MauSacCustom> getMauSacDetailsByIdSanPham(@Param("id") UUID id);

}
