package poly.edu.duantotnghiep.Controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poly.edu.duantotnghiep.DAO.HoaDonCustom;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.DAO.HoaDonLichSuCustom;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Model.KhachHang;
import poly.edu.duantotnghiep.Model.LichSuTrangThai;
import poly.edu.duantotnghiep.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import poly.edu.duantotnghiep.Service.KhachHangService;
import poly.edu.duantotnghiep.Service.LichSuTrangThaiService;
import poly.edu.duantotnghiep.infrastructures.request.LichSuTrangThaiRequest;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/hoadon")
public class HoaDonController {

    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    LichSuTrangThaiService lichSuTrangThaiService;

    @GetMapping("")
    public String getHoaDon(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "5") int size) {
        Page<HoaDonCustom> lstHoaDon = hoaDonService.getAllHoaDonDaThanhToan(page, size);
        model.addAttribute("lstHD", lstHoaDon);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", lstHoaDon.getTotalPages());
        model.addAttribute("hoaDonDaGiao", hoaDonService.hoadondagiao());
        model.addAttribute("hoaDonDangGiao", hoaDonService.hoadondangiao());
        model.addAttribute("hoaDonChuaThanhToan", hoaDonService.hoadonchuathanhtoan());
        model.addAttribute("hoaDonDaThanhToan", hoaDonService.hoadondathanhtoan());
        model.addAttribute("hoaDonDaHuy", hoaDonService.hoadondahuy());
        return "admin/hoa-don/hoadon";
    }

    @GetMapping("/{id}")
    public String getHoaDonByID(Model model, @PathVariable("id") UUID id) {
        List<LichSuTrangThai> lichSuTrangThais = lichSuTrangThaiService.getAllbyIdHoaDon(id);
        model.addAttribute("lichSuTrangThai",lichSuTrangThais);
        HoaDonLichSuCustom hoaDonLichSu = hoaDonService.getLichSu(id);
        model.addAttribute("lichSu",hoaDonLichSu);
        HoaDonCustom hoaDonCustom = hoaDonService.getHoaDonByIdHoaDon(id);
        model.addAttribute("lstHD",hoaDonCustom);
        return "admin/hoa-don/chitiethoadon";
    }
    @PostMapping("/updatehoadon")
    public String capNhatThongTinKhachHang(@ModelAttribute("lichSu")HoaDonLichSuCustom hoaDonLichSuCustom){
        UUID idKhachHang = khachHangService.getIdKhachHangByIdHoaDon(hoaDonLichSuCustom.getId());
        KhachHang khachHang = khachHangService.getKhachHangByID(idKhachHang);
        khachHang.setTenkhachhang(hoaDonLichSuCustom.getTenKhachHang());
        khachHang.setDiachi(hoaDonLichSuCustom.getDiaChi());
        khachHang.setEmail(hoaDonLichSuCustom.getEmail());
        khachHang.setSdt(hoaDonLichSuCustom.getSdtKhachHang());
        khachHangService.update(khachHang,idKhachHang);
        return "redirect:/hoadon/"+hoaDonLichSuCustom.getId();
    }
    @PostMapping("/doi-trang-thai")
    @ResponseBody
    public ResponseEntity<?> DoiTrangThai(@RequestBody LichSuTrangThaiRequest lichSuTrangThaiRequest){

        System.out.println("idhoadonla");
        System.out.println(lichSuTrangThaiRequest.getIdhoadon());
        try {
            String idhoadon = lichSuTrangThaiRequest.getIdhoadon();
            UUID idhoadonep = UUID.fromString(idhoadon);
            String ghichu = lichSuTrangThaiRequest.getGhichu();
            int trangthai = lichSuTrangThaiRequest.getTrangthai();
            lichSuTrangThaiService.DoiTrangThai(idhoadonep, ghichu, trangthai);
            return ResponseEntity.badRequest().body(Map.of("message", "Đổi trạng thái thành công"));
        } catch (Exception e) {
            // Ghi lại log lỗi để kiểm tra sau
            e.printStackTrace();
            return ResponseEntity.badRequest().body(Map.of("message", "Đã xảy ra lỗi: " + e.getMessage()));
        }

    }


}
