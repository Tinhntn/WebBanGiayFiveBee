package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.KhachHangCustom;
import poly.edu.duantotnghiep.Model.KhachHang;
import poly.edu.duantotnghiep.Repository.KhachHangRepository;
import poly.edu.duantotnghiep.Service.KhachHangService;
import poly.edu.duantotnghiep.infrastructures.Reponse.KhachHangReponse;
import poly.edu.duantotnghiep.infrastructures.request.KhachHangRequest;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class KhachHangIml implements KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    public KhachHang getKhachHangByID(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public UUID findIdKhachHangBySdt(String sdt) {
        return khachHangRepository.findIdKhachHangBySdt(sdt);
    }

    @Override
    public Page<KhachHangCustom> getALlKhachHang(int page, int size) {
        return null;
    }


    @Override
    public List<KhachHang> getALlKH() {
        return khachHangRepository.getAllKH();
    }

//    public Page<KhachHangCustom> getALlKhachHang(int page, int size) {
//        return khachHangRepository.getAllKhachHang(PageRequest.of(page, size));
//    }


    public List<KhachHang> getALlKhachHanglist(){
        return khachHangRepository.getAllKhachHanglist();

    }

    @Override
    public KhachHang getKhachHangByMakhachhang(String maKhachHang) {
        return khachHangRepository.getKhachHangByMakhachhang(maKhachHang);
    }

    @Override
    public KhachHang getKhachHangBySdt(String sdt) {
        return khachHangRepository.findKhachHangBySdt(sdt);
    }

    @Override
    public void dangKy(String hoTen, String email, String matKhau) {
        KhachHang khachHang = new KhachHang();
        khachHang.setTenkhachhang(hoTen);
        khachHang.setEmail(email);
        khachHang.setMatkhau(matKhau);
        khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHangReponse getKhachHangByEmailAndMatKhau(String email, String matKhau) {
        KhachHang khachHang = khachHangRepository.findKhachHangByEmailAndMatkhau(email, matKhau);
        if (khachHang != null) {
            KhachHangReponse khachHangReponse = new KhachHangReponse();
            khachHangReponse.setGioitinh(khachHang.getGioitinh());
            khachHangReponse.setDiachi(khachHang.getDiachi());
            khachHangReponse.setEmail(khachHang.getEmail());
            khachHangReponse.setId(khachHang.getId());
            khachHangReponse.setLoaikhachhang(khachHang.getLoaikhachhang());
            khachHangReponse.setMakhachhang(khachHang.getMakhachhang());
            khachHangReponse.setSdt(khachHang.getSdt());
            khachHangReponse.setMatkhau(khachHang.getMatkhau());
            khachHangReponse.setTenkhachhang(khachHang.getTenkhachhang());
            return khachHangReponse;
        }
        return null;
    }





    // Hàm tạo mã khách hàng tự tăng
    private String generateMaKhachHang() {
        // Lấy mã khách hàng lớn nhất hiện tại
        String maxMaKhachHang = khachHangRepository.getMaxMaKhachHang();
        if (maxMaKhachHang == null) {
            // Nếu chưa có khách hàng nào, trả về mã bắt đầu từ 1
            return "KH1";
        } else {
            // Nếu đã có mã khách hàng, tăng số lượng lên 1
            String numberPart = maxMaKhachHang.substring(2); // Lấy phần số từ mã khách hàng hiện tại
            int nextNumber = Integer.parseInt(numberPart) + 1; // Tăng số lượng lên 1
            return "KH" + nextNumber; // Tạo mã mới
        }
    }
    @Override
    public void add(KhachHangRequest khachHangRequest)  {

        KhachHang khachHang = new KhachHang();
        // Gán các giá trị cần thiết khác
        String maKhachHang = generateMaKhachHang();
        UUID id = UUID.randomUUID();
        khachHang.setId(id);
        khachHang.setMakhachhang(maKhachHang);
        khachHang.setEmail(khachHangRequest.getEmail());
        khachHang.setTenkhachhang(khachHangRequest.getHoVaTen());
        khachHang.setMatkhau(khachHangRequest.getMatKhau());
        khachHang.setNgaythamgia(new Date());
        khachHang.setTichdiem(0); // hoặc giá trị khởi tạo khác
        khachHang.setDiemexp(0); // hoặc giá trị khởi tạo khác
        khachHang.setNgaytao(new Date());
        khachHang.setNgaysua(new Date());
        khachHang.setTrangthai(1); // hoặc giá trị phù hợp khác
        khachHangRepository.save(khachHang);
        System.out.println(khachHangRepository.findById(khachHang.getId()));

    }

    @Override
    public boolean isPasswordValid(String password) {
        return password.matches("^(?=.*[a-zA-Z])(?=.*[0-9]).{6,}$");

    }

    @Override
    public boolean isSoDienThoai(String soDienThoai) {
        return soDienThoai.matches("^0[0-9]{9,10}$");
    }

    @Override
    public boolean existsByEmail(String email) {
        return khachHangRepository.existsByEmail(email);
    }

}
