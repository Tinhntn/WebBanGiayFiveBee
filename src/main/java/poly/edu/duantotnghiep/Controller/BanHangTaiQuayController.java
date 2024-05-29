package poly.edu.duantotnghiep.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.duantotnghiep.Model.HoaDon;

import java.util.List;

@Controller
@RequestMapping("/banhangtaiquay")
public class BanHangTaiQuayController {
    @GetMapping("/hienthi")
    public String bhtq(Model model){
        return "banhangtaiquay";
    }
}
