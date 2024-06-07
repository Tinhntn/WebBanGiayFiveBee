package poly.edu.duantotnghiep.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import poly.edu.duantotnghiep.DAO.KhachHangCustom;
import poly.edu.duantotnghiep.Model.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    KhachHang getKhachHangByID(UUID id);
    UUID findIdKhachHangBySdt(String sdt);
    Page<KhachHangCustom> getALlKhachHang(int page, int size);
    List<KhachHang> getALlKhachHanglist();
    KhachHang getKhachHangByMakhachhang(String maKhachHang);

}
