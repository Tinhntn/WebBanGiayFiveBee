package poly.edu.duantotnghiep.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Repository.HoaDonRepository;
import poly.edu.duantotnghiep.Service.HoaDonService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/banhangtaiquay")
public class BanHangTaiQuayController {
    HoaDonRepository hoaDonRepository;
    @Autowired
   private HoaDonService hoaDonService;
    @GetMapping("/hienthi")
    public String bhtq(Model model){
        List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
        model.addAttribute("listMaHoaDon", list);
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
