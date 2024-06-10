package poly.edu.duantotnghiep.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.DAO.ChiTietSanPhamDAO;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Repository.*;
import poly.edu.duantotnghiep.Service.ChiTietHoaDonService;
import poly.edu.duantotnghiep.Service.ChiTietSanPhamService;
import poly.edu.duantotnghiep.Service.HoaDonService;
import poly.edu.duantotnghiep.Service.KhachHangService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/banhangonline")
public class TrangChuController {

    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    KhachHangRepository khachHangRepository;
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
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
    HttpSession session;

    @GetMapping("/viewsanpham")
    public String viewsanpham(Model model, @RequestParam(defaultValue = "0") int page,  @RequestParam(defaultValue = "false") boolean viewAll){

        int sizebanchay = 8;
        int sizetatca = 16;
        Page<ChiTieSanPhamCustom> CTSP ;

        if (viewAll) {
            CTSP = chiTietSanPhamService.findAllChiTietSanPhamCust(page, sizetatca);
        } else {
            CTSP = chiTietSanPhamService.findBestSellingProducts(page, sizebanchay);
        }

        model.addAttribute("products",CTSP.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",CTSP.getTotalPages());

        return "trangchu/trangChu";
    }

    @GetMapping("/detailCTSPOnline/{id}")
    public String detailCTSPOnline(Model model, @PathVariable("id")UUID id){

        ChiTieSanPhamCustom detailCTSPCustom = chiTietSanPhamService.getChiTietCustomSanPhamById(id);
        model.addAttribute("detailCTSPCustom", detailCTSPCustom);

        return "trangchu/detailCTSPOnline";
    }




}
