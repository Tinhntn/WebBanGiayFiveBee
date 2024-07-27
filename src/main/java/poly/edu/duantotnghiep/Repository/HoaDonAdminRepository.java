package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Model.HoaDon;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonAdminRepository  extends JpaRepository<HoaDon, UUID> {

    @Query(value = "SELECT hoadon.ID AS idHoaDon, \n" +
            "       hoadon.maHoaDon, \n" +
            "   \n" +
            "       hoadon.ngaymua, \n" +
            "       hoadon.thanhtien, \n" +
            "       hoadon.idkhuyenmai, \n" +
            "       hoadon.ghichu, \n" +
            "       hoadon.ngaytao, \n" +
            "       hoadon.tongtien,   \n" +
            "       hoadon.donvigiao, \n" +
            "       hoadon.phiship, \n" +
            "       hoadon.tennguoinhan, \n" +
            "       hoadon.emailnguoinhan, \n" +
            "       hoadon.sdtnguoinhan, \n" +
            "       hoadon.tinhthanh, \n" +
            "       hoadon.quanhuyen, \n" +
            "       hoadon.phuongxa, \n" +
            "       hoadon.loaihoadon, \n" +
            "       hoadon.trangthai\n" +
            "FROM hoadon \n" +
            "\n" +
            "WHERE hoadon.trangthai = 2 AND hoadon.loaihoadon = 2"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getHoaDonOLChoxacnhan();

    @Query(value = "SELECT hoadon.ID AS idHoaDon, \n" +
            "       hoadon.maHoaDon, \n" +
            "   \n" +
            "       hoadon.ngaymua, \n" +
            "       hoadon.thanhtien, \n" +
            "       hoadon.idkhuyenmai, \n" +
            "       hoadon.ghichu, \n" +
            "       hoadon.ngaytao, \n" +
            "       hoadon.tongtien,   \n" +
            "       hoadon.donvigiao, \n" +
            "       hoadon.phiship, \n" +
            "       hoadon.tennguoinhan, \n" +
            "       hoadon.emailnguoinhan, \n" +
            "       hoadon.sdtnguoinhan, \n" +
            "       hoadon.tinhthanh, \n" +
            "       hoadon.quanhuyen, \n" +
            "       hoadon.phuongxa, \n" +
            "       hoadon.loaihoadon, \n" +
            "       hoadon.trangthai\n" +
            "FROM hoadon \n" +
            "\n" +
            "WHERE hoadon.trangthai = 3 AND hoadon.loaihoadon = 2"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getHoaDonOLChoLayHang();

    @Query(value = "SELECT hoadon.ID AS idHoaDon, \n" +
            "       hoadon.maHoaDon, \n" +
            "   \n" +
            "       hoadon.ngaymua, \n" +
            "       hoadon.thanhtien, \n" +
            "       hoadon.idkhuyenmai, \n" +
            "       hoadon.ghichu, \n" +
            "       hoadon.ngaytao, \n" +
            "       hoadon.tongtien,   \n" +
            "       hoadon.donvigiao, \n" +
            "       hoadon.phiship, \n" +
            "       hoadon.tennguoinhan, \n" +
            "       hoadon.emailnguoinhan, \n" +
            "       hoadon.sdtnguoinhan, \n" +
            "       hoadon.tinhthanh, \n" +
            "       hoadon.quanhuyen, \n" +
            "       hoadon.phuongxa, \n" +
            "       hoadon.loaihoadon, \n" +
            "       hoadon.tennguoigiao,\n" +
            "       hoadon.sdtnguoigiao,\n" +
            "       hoadon.trangthai\n" +
            "FROM hoadon \n" +
            "\n" +
            "WHERE hoadon.trangthai = 4 AND hoadon.loaihoadon = 2"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getHoaDonOLDangGiao();

    @Query(value = "SELECT hoadon.ID AS idHoaDon, \n" +
            "       hoadon.maHoaDon, \n" +
            "   \n" +
            "       hoadon.ngaymua, \n" +
            "       hoadon.thanhtien, \n" +
            "       hoadon.idkhuyenmai, \n" +
            "       hoadon.ghichu, \n" +
            "       hoadon.ngaytao, \n" +
            "       hoadon.tongtien,   \n" +
            "       hoadon.donvigiao, \n" +
            "       hoadon.phiship, \n" +
            "       hoadon.tennguoinhan, \n" +
            "       hoadon.emailnguoinhan, \n" +
            "       hoadon.sdtnguoinhan, \n" +
            "       hoadon.tinhthanh, \n" +
            "       hoadon.quanhuyen, \n" +
            "       hoadon.phuongxa, \n" +
            "       hoadon.loaihoadon, \n" +
            "       hoadon.tennguoigiao,\n" +
            "       hoadon.sdtnguoigiao,\n" +
            "       hoadon.trangthai\n" +
            "FROM hoadon \n" +
            "\n" +
            "WHERE hoadon.trangthai = 5 AND hoadon.loaihoadon = 2"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getHoaDonOLHoanThanh();

    @Query(value = "SELECT hoadon.ID AS idHoaDon, \n" +
            "       hoadon.maHoaDon, \n" +
            "   \n" +
            "       hoadon.ngaymua, \n" +
            "       hoadon.thanhtien, \n" +
            "       hoadon.idkhuyenmai, \n" +
            "       hoadon.ghichu, \n" +
            "       hoadon.ngaytao, \n" +
            "       hoadon.tongtien,   \n" +
            "       hoadon.donvigiao, \n" +
            "       hoadon.phiship, \n" +
            "       hoadon.tennguoinhan, \n" +
            "       hoadon.emailnguoinhan, \n" +
            "       hoadon.sdtnguoinhan, \n" +
            "       hoadon.tinhthanh, \n" +
            "       hoadon.quanhuyen, \n" +
            "       hoadon.phuongxa, \n" +
            "       hoadon.loaihoadon, \n" +
            "       hoadon.tennguoigiao,\n" +
            "       hoadon.sdtnguoigiao,\n" +
            "       hoadon.trangthai\n" +
            "FROM hoadon \n" +
            "\n" +
            "WHERE hoadon.trangthai = 6 AND hoadon.loaihoadon = 2"
            ,nativeQuery = true)
    List<HoaDonDAOCustom> getHoaDonOLDaHuy();
}
