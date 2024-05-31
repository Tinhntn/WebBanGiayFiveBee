package poly.edu.duantotnghiep.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Service.ChiTietSanPhamService;

import java.util.List;

@Controller
@RequestMapping("/banhangtaiquay")
public class BanHangTaiQuayController {
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @GetMapping("/hienthi")
    public String bhtq(Model model){
        List<ChiTieSanPhamCustom> lst = chiTietSanPhamService.getAllCTSP();
        model.addAttribute("lstCTSP",lst);
        return "banhangtaiquay";
    }
}
