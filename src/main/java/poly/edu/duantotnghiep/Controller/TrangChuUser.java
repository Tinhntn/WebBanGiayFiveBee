package poly.edu.duantotnghiep.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.duantotnghiep.DAO.*;
import poly.edu.duantotnghiep.Model.SanPham;
import poly.edu.duantotnghiep.Model.Size;
import poly.edu.duantotnghiep.Repository.*;
import poly.edu.duantotnghiep.Service.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/trangchuuser")
public class TrangChuUser {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    KhachHangRepository khachHangRepository;
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Autowired
    KhuyenMaiService khuyenMaiService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    ChiTietHoaDonService chiTietHoaDonService;
    @Autowired
    ChiTietHoaDonRepository chiTietHoaDonRepository;
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Autowired
    BanHangOnlineService banHangOnlineService;

    @GetMapping("/hienthi")
    public String hienthi(Model model){
        List<ChiTietSanPhamUserCustom> listSanPham = banHangOnlineService.getAllCTSP();
        model.addAttribute("listSanPham", listSanPham);
        return "user/sanpham/trangchu";
    }

    @GetMapping("/detailsanpham/{id}")
    public String detailsp(@PathVariable("id") UUID id, Model model) {
        ChiTieSanPhamCustom dt = chiTietSanPhamService.getChiTietCustomSanPhamById(id);

        UUID idDanhMuc = dt.getDanhMuc();
        UUID idHang =  dt.getHang();
        UUID  idChatLieu = dt.getChatLieu();
        UUID  idMauSac = dt.getMauSac();
        UUID idSP = banHangOnlineService.getIdSPById(id);
        List<SizeCustom> listSize = banHangOnlineService.getSizeById(idSP, idDanhMuc, idHang,idMauSac, idChatLieu);
        model.addAttribute("listSize", listSize);

        List<MauSacCustom> listMauSac = banHangOnlineService.getMauSacByIdSP(idSP);
        model.addAttribute("listMauSac", listMauSac);

        model.addAttribute("detailsp", dt);
        return "user/sanpham/detailSanPham";
    }



    @PostMapping("/timkiemCTSP")
    public String timKiemCTSP(@RequestParam("idSanPham") UUID idSanPham,
                              @RequestParam("idMauSac") UUID idMauSac,
                              @RequestParam("idChatLieu") UUID idChatLieu,
                              @RequestParam("idHang") UUID idHang,
                              @RequestParam("idSize") UUID idSize,
                              @RequestParam("idDanhMuc") UUID idDanhMuc,
                              Model model
                             ) {

        ChiTieSanPhamCustom chiTietSanPham = banHangOnlineService.timkiemCTSP(idSanPham, idMauSac, idChatLieu, idHang, idSize, idDanhMuc);


        if (chiTietSanPham != null) {
            UUID id = chiTietSanPham.getId();
            return "redirect:/trangchuuser/detailsanpham/" + id;
        } else {
            // Nếu không tìm thấy, điều hướng về trang chủ hoặc trang thông báo lỗi
            return "redirect:/trangchuuser/hienthi"; // Ví dụ điều hướng về trang chủ
        }
    }
}
