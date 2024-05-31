package poly.edu.duantotnghiep.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;

@Controller
@RequestMapping("/banhangtaiquay")
public class BanHangTaiQuayController {
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
        return "banhangtaiquay";
    }
}
