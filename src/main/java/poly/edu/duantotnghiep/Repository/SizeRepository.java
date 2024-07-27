package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.DAO.SizeCustom;
import poly.edu.duantotnghiep.DAO.SizeDAO;
import poly.edu.duantotnghiep.Model.Size;

import java.util.List;
import java.util.UUID;

@Repository
public interface SizeRepository extends JpaRepository<Size, UUID> {

    @Query(value = "select * from Size", nativeQuery = true)
    List<Size> getSizeALL();


    @Query(value = "SELECT DISTINCT s.id AS id, " +
            "s.ma AS ma, " +
            "s.ten AS ten, " +
            "s.ngaytao AS ngayTao, " +
            "s.ngaysua AS ngaySua, " +
            "s.trangthai AS trangThai " +
            "FROM Size s " +
            "JOIN ChiTietSanPham c ON s.id = c.size " +
            "JOIN DanhMuc d ON c.danhmuc = d.id " +
            "JOIN Hang h ON c.hang = h.idHang " +
            "JOIN MauSac ms ON c.mausac = ms.id " +
            "JOIN ChatLieu cl ON c.chatlieu = cl.id " +
            "WHERE c.idSanPham = :id " +
            "AND c.trangthai = 1 " +
            "AND d.id = :idDanhMuc " +
            "AND h.idHang = :idHang " +
            "AND ms.id = :idMauSac " +
            "AND cl.id = :idChatLieu " +
            "ORDER BY s.ten ASC", nativeQuery = true)
    List<SizeCustom> getSizeDetailsByIdSanPhamAndCriteria(@Param("id") UUID id,
                                                          @Param("idDanhMuc") UUID idDanhMuc,
                                                          @Param("idHang") UUID idHang,
                                                          @Param("idMauSac") UUID idMauSac,
                                                          @Param("idChatLieu") UUID idChatLieu);




}
