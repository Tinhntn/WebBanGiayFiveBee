package poly.edu.duantotnghiep.Controller;

import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HoaDonController {

    @Autowired
    HoaDonService hoaDonService;
    @GetMapping("")
    public String show(Model model){
        return "index";
    }
    @GetMapping("/hoa-don")
    public String getAllHoaDon(Model model){
        List<HoaDonDAOCustom> lstHoaDon = hoaDonService.getAllHoaDon();
        model.addAttribute("lstHoaDon",lstHoaDon);
        return "hoadon";
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/jspPage")
    public String jspPage(Model model) {
        model.addAttribute("message", "Hello from JSP!");
        return "jspPage";
    }

}
