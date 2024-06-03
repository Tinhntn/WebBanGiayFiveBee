package poly.edu.duantotnghiep.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Repository.ChiTietHoaDonRepository;
import poly.edu.duantotnghiep.Repository.ChiTietSanPhamRepository;
import poly.edu.duantotnghiep.Repository.HoaDonRepository;
import poly.edu.duantotnghiep.Service.ChiTietHoaDonService;
import poly.edu.duantotnghiep.Service.HoaDonService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.Service.ChiTietSanPhamService;


import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/banhangtaiquay")
public class BanHangTaiQuayController {
    @Autowired
    HoaDonRepository hoaDonRepository;
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



    @GetMapping("/hienthi")
    public String bhtq(Model model, @RequestParam(defaultValue = "0") int page){
        int size = 5;
        Page<ChiTieSanPhamCustom> CTSP = chiTietSanPhamService.phanTrang(page,size);
        model.addAttribute("CTSP",CTSP.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",CTSP.getTotalPages());
//        List<ChiTieSanPhamCustom> lst = chiTietSanPhamService.getAllCTSP();
//        model.addAttribute("lstCTSP",lst);
        List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
        model.addAttribute("listMaHoaDon", list);
        return "banhangtaiquay";
    }
    @PostMapping("/taoHoaDon")
    public String taoHoaDon(@ModelAttribute("hoadon") HoaDon hd, Model model, RedirectAttributes redirectAttributes, @RequestParam(defaultValue = "0") int page) {
        List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
        if (list.size() >= 5) {
            redirectAttributes.addFlashAttribute("error", "Chỉ được tạo tối đa 5 hóa đơn chờ.");
            return "redirect:/banhangtaiquay/hienthi?page=" + page;
        } else {
            hoaDonService.taohoadon(hd);
            return "redirect:/banhangtaiquay/hienthi";
        }
    }

    @GetMapping("/deletehdc/{id}")
    public String deletehdc(Model model, @PathVariable String id) {
        hoaDonService.updateSoLuongCTSanPhamByHoaDonId(UUID.fromString(id));
        hoaDonService.delete(UUID.fromString(id));
        return "redirect:/banhangtaiquay/hienthi";
    }

    @PostMapping("/updatehdc/{id}")
    public String updateslhhd(@PathVariable String id,@RequestParam int solm) {
        // Lấy thông tin chi tiết hóa đơn từ service hoặc repository
       hoaDonService.updateSoLuongCTSanPhamByHoaDonId(UUID.fromString(id));

        return "redirect:/banhangtaiquay/hienthi";
    }

    @GetMapping("/detailhd/{id}")
    public String detailHD(@PathVariable String id, Model model, @RequestParam(defaultValue = "0") int page){
        HoaDon hd = hoaDonService.detailHD(UUID.fromString(id));
        model.addAttribute("hoadon", hd);
        int size = 5;
        Page<ChiTieSanPhamCustom> CTSP = chiTietSanPhamService.phanTrang(page,size);
        model.addAttribute("CTSP",CTSP.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",CTSP.getTotalPages());
//        List<ChiTieSanPhamCustom> lst = chiTietSanPhamService.getAllCTSP();
//        model.addAttribute("lstCTSP",lst);
        List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
        model.addAttribute("listMaHoaDon", list);

        List<ChiTietHoaDonCustom> chiTietHoaDonList = chiTietHoaDonService.findByHoaDonId(UUID.fromString(id));
        model.addAttribute("chiTietHoaDonList", chiTietHoaDonList);
        return "banhangtaiquay";
    }

    @GetMapping("/deleteCTHoaDon/{id}")
    public String deleteCTHoaDon(@PathVariable("id") String id, @RequestParam("idctsanpham") String idctsanpham){
        Integer soLuong = chiTietHoaDonService.getSoLuongById(UUID.fromString(id));
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamById(UUID.fromString(idctsanpham));
        chiTietSanPham.setSoluong(chiTietSanPham.getSoluong() + soLuong);
        chiTietSanPhamRepository.save(chiTietSanPham);
        UUID idHoaDon = chiTietHoaDonRepository.findHoaDonIdByChiTietId(UUID.fromString(id));
        chiTietHoaDonRepository.deleteById(UUID.fromString(id));

        return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
    }

}
