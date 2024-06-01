package poly.edu.duantotnghiep.Controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Repository.HoaDonRepository;
import poly.edu.duantotnghiep.Service.HoaDonService;
=======
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Service.ChiTietSanPhamService;
>>>>>>> 251681b45cf1ae81cf7964a04672666a8f57dc33

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/banhangtaiquay")
public class BanHangTaiQuayController {
<<<<<<< HEAD
    HoaDonRepository hoaDonRepository;
    @Autowired
   private HoaDonService hoaDonService;
    @GetMapping("/hienthi")
    public String bhtq(Model model){
        List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
        model.addAttribute("listMaHoaDon", list);
=======
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @GetMapping("/hienthi")
    public String bhtq(Model model, @RequestParam(defaultValue = "0") int page){

        int size = 2;
        Page<ChiTieSanPhamCustom> CTSP = chiTietSanPhamService.phanTrang(page,size);
        model.addAttribute("CTSP",CTSP.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",CTSP.getTotalPages());
//        List<ChiTieSanPhamCustom> lst = chiTietSanPhamService.getAllCTSP();
//        model.addAttribute("lstCTSP",lst);
>>>>>>> 251681b45cf1ae81cf7964a04672666a8f57dc33
        return "banhangtaiquay";
    }
        @PostMapping("/taoHoaDon")
        public String taoHoaDon(@ModelAttribute("hoadon") HoaDon hd, Model model) {
            List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
            if (list.size() >= 5) {
                model.addAttribute("error", "Chỉ được tạo tối đa 5 hóa đơn chờ.");
            } else {
                hoaDonService.taohoadon(hd);
                return "redirect:/banhangtaiquay/hienthi";
            }
            // Trả về trang chính
            List<HoaDon> updatedList = hoaDonService.getAllHoaDonChuaThanhToan();
            model.addAttribute("listMaHoaDon", updatedList);
            return "banhangtaiquay";
        }

    @GetMapping("/deletehdc/{id}")
    public String deletehdc(Model model, @PathVariable String id) {
        hoaDonService.delete(UUID.fromString(id));
        return "redirect:/banhangtaiquay/hienthi";
    }

//    @PostMapping("/update/{id}")
//    public String updateslhhd(@PathVariable String id, @ModelAttribute("chitietsp") ChiTietSanPham ct) {
//        hoaDonService.updatesoluonghuyhd(UUID.fromString(id), ct);
//        return "redirect:/chi-tiet-sp/hien-thi";
//    }


}
