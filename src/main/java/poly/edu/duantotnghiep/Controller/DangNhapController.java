package poly.edu.duantotnghiep.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.duantotnghiep.Model.NhanVien;
import poly.edu.duantotnghiep.Service.KhachHangService;
import poly.edu.duantotnghiep.Service.NhanVienService;
import poly.edu.duantotnghiep.infrastructures.request.DangKyRequest;
import poly.edu.duantotnghiep.infrastructures.request.DangNhapRequest;
import poly.edu.duantotnghiep.infrastructures.request.KhachHangRequest;
import poly.edu.duantotnghiep.infrastructures.request.NhanVienRequest;
import poly.edu.duantotnghiep.infrastructures.Reponse.KhachHangReponse;

import java.util.Map;

@Controller
public class DangNhapController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    KhachHangService khachHangService;

    private HttpSession session;

    @GetMapping("/dang-nhap")
    public String dangNhap(Model model, @ModelAttribute("loginError") String loginError) {
        model.addAttribute("dangNhap", new DangNhapRequest());
        model.addAttribute("dangKy", new DangKyRequest());
        model.addAttribute("loginError", loginError);
        return "user/dangnhap";
    }

    @PostMapping("/dang-nhap")
    @ResponseBody
    public ResponseEntity<?> dangNhap(@RequestBody DangNhapRequest dangNhapRequest, HttpSession session) {
        String email = dangNhapRequest.getEmail();
        String matKhau = dangNhapRequest.getMatKhau();
        if (email == null || email.isEmpty() || matKhau == null || matKhau.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Vui Lòng điền đầy đủ thông tin"));
        }
        NhanVienRequest nhanVienRequest = nhanVienService.findNhanVienByEmailAndMatKhau(email,matKhau);
        KhachHangReponse khachHangReponse = khachHangService.getKhachHangByEmailAndMatKhau(email, matKhau);
        if (!khachHangService.emailValidate(khachHangReponse.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email không đúng định dạng"));
        }
        if(nhanVienRequest==null){
            if (khachHangReponse == null) {
                return ResponseEntity.badRequest().body(Map.of("message", "Thông tin đăng nhập sai"));
            } else {
                session.setAttribute("khachHang", khachHangReponse);
                return ResponseEntity.ok().body(Map.of("message", "Đăng nhập thành công"));
            }
        }else {
            session.setAttribute("nhanVien",nhanVienRequest);
            return ResponseEntity.ok().body(Map.of("message","Đăng nhập thành công"));
        }

    }


    @PostMapping("/dang-ky")
    @ResponseBody
    public ResponseEntity<?> dangKy(@RequestBody DangKyRequest dangKyRequest) {
        String emailDK = dangKyRequest.getEmailDK();
        String hoTen = dangKyRequest.getHoTen();
        String matKhauDK = dangKyRequest.getMatKhauDK();
        if (emailDK.isEmpty() || emailDK == null || hoTen.isEmpty() || hoTen == null || matKhauDK.isEmpty() || matKhauDK == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Vui lòng điền đầy đủ thông tin"));
        }
        if (!khachHangService.isPasswordValid(matKhauDK)) {
            return ResponseEntity.badRequest().body(Map.of("message", "Mật khẩu phải có ít nhất 6 ký tự và chứa ít nhất một chữ và một số"));
        }
        if (!khachHangService.emailValidate(emailDK)) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email không đúng định dạng"));
        }
        if (khachHangService.existsByEmail(dangKyRequest.getEmailDK())) {
            return ResponseEntity.badRequest().body(Map.of("message", "Tài khoản đã tồn tại"));
        }

        KhachHangRequest khachHangRequest = new KhachHangRequest();
        khachHangRequest.setEmail(emailDK);
        khachHangRequest.setMatKhau(matKhauDK);
        khachHangRequest.setHoVaTen(hoTen);
        khachHangService.add(khachHangRequest);
        return ResponseEntity.ok().body(Map.of("message", "Đăng ký thành công"));
    }

    @GetMapping("/dang-xuat")
    public String dangXuat() {
        session.setAttribute("khachHang", null);
        return "redirect:/";
    }

}
