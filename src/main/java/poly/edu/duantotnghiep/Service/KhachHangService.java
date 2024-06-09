package poly.edu.duantotnghiep.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import poly.edu.duantotnghiep.DAO.KhachHangCustom;
import poly.edu.duantotnghiep.Model.KhachHang;
import poly.edu.duantotnghiep.infrastructures.Reponse.KhachHangReponse;
import poly.edu.duantotnghiep.infrastructures.request.KhachHangRequest;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    KhachHang getKhachHangByID(UUID id);

    UUID findIdKhachHangBySdt(String sdt);

    Page<KhachHangCustom> getALlKhachHang(int page, int size);

    List<KhachHang> getALlKhachHanglist();

    KhachHang getKhachHangBySdt(String sdt);

    void dangKy(String hoTen, String email, String matKhau);

    KhachHangReponse getKhachHangByEmailAndMatKhau(String email, String matKhau);

    void add(KhachHangRequest khachHangRequest) ;

    boolean isPasswordValid(String password);

    boolean isSoDienThoai(String soDienThoai);

    boolean existsByEmail(String email);
    List<KhachHang> getALlKH();



    KhachHang getKhachHangByMakhachhang(String maKhachHang);


}
