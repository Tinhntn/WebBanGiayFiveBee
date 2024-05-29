package poly.edu.duantotnghiep.Controller;

import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hoadon")
public class HoaDonController {

    @Autowired
    HoaDonService hoaDonService;
    @GetMapping("/hienthi")
    public String getAllHoaDon(Model model){
        List<HoaDon> lstHoaDon = hoaDonService.getAllHoaDon();
        model.addAttribute("lstHoaDon",lstHoaDon);
        model.addAttribute("HoaDon",new HoaDon());
        return "hoadon";
    }
}
