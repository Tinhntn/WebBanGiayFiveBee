package poly.edu.duantotnghiep.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.duantotnghiep.Model.NhanVien;
import poly.edu.duantotnghiep.Service.KhachHangService;
import poly.edu.duantotnghiep.Service.NhanVienService;
import poly.edu.duantotnghiep.infrastructures.request.DangKyRequest;
import poly.edu.duantotnghiep.infrastructures.request.DangNhapRequest;
import poly.edu.duantotnghiep.infrastructures.request.KhachHangRequest;
import poly.edu.duantotnghiep.infrastructures.request.NhanVienRequest;
import poly.edu.duantotnghiep.infrastructures.Reponse.KhachHangReponse;

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
        model.addAttribute("viewContent", "/dangnhap.jsp");
        return "dangnhap";
    }

    @PostMapping("/dang-nhap")
    public String dangNhap(Model model, @ModelAttribute("dangNhap") DangNhapRequest dangNhapRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes
    ) {
        String email = dangNhapRequest.getEmail();
        String matKhau = dangNhapRequest.getMatKhau();
        if (email == null || email.isEmpty() || matKhau == null || matKhau.isEmpty()) {
            redirectAttributes.addFlashAttribute("loginError", "Vui Lòng điền đầy đủ thông tin");
            return "redirect:/dang-nhap";
        }
        KhachHangReponse khachHangReponse = khachHangService.getKhachHangByEmailAndMatKhau(email, matKhau);
        if (khachHangReponse == null) {
            redirectAttributes.addFlashAttribute("loginError", "Thông tin đăng nhập sai");
            return "redirect:/dang-nhap";
        }
        return "redirect:/banhangtaiquay/hienthi";

    }

    @PostMapping("/dang-ky")
    public String dangKy(Model model, @ModelAttribute("dangKy") DangKyRequest dangKyRequest, RedirectAttributes redirectAttributes) {
        String emailDK = dangKyRequest.getEmailDK();
        String hoTen = dangKyRequest.getHoTen();
        String matKhauDK = dangKyRequest.getMatKhauDK();
        if (emailDK.isEmpty() || emailDK == null || hoTen.isEmpty() || hoTen == null || matKhauDK.isEmpty() || matKhauDK == null) {
            redirectAttributes.addFlashAttribute("loginError", "Vui lòng điền đầy đủ thông tin");
            return "redirect:/dang-nhap#register";
        }
        if (!khachHangService.isPasswordValid(matKhauDK)) {
            redirectAttributes.addFlashAttribute("loginError", "Mật khẩu phải có ít nhất 6 ký tự và chứa ít nhất một chữ và một số");
            return "redirect:/dang-nhap#register";
        }
        if (khachHangService.existsByEmail(dangKyRequest.getEmailDK())) {
            redirectAttributes.addFlashAttribute("loginError", "Tài khoản đã tồn tại");
            return "redirect:/dang-nhap#register";
        }

        KhachHangRequest khachHangRequest = new KhachHangRequest();
        khachHangRequest.setEmail(emailDK);
        khachHangRequest.setMatKhau(matKhauDK);
        khachHangRequest.setHoVaTen(hoTen);
        khachHangService.add(khachHangRequest);
        redirectAttributes.addFlashAttribute("successMessage", "Đăng ký thành công");
        return "redirect:/dang-nhap#register";
    }

    @GetMapping("/dang-xuat")
    public String dangXuat() {
        session.setAttribute("khachHang", null);
        return "redirect:/";
    }

}
