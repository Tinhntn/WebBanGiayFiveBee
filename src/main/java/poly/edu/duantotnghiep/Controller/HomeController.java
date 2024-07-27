package poly.edu.duantotnghiep.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/trangchu")
    public String trangChu(Model model) {
//        List<TrangChuResponse> productList = sanPhamService.getListTrangChu("");

//        List<TrangChuResponse> firstEightProducts = productList.subList(0, Math.min(productList.size(), 8));
//        model.addAttribute("listTrangChu", firstEightProducts);
//        model.addAttribute("listBanChay", sanPhamService.getListBanChay(""));
//        model.addAttribute("viewBanner", "/views/user/banner.jsp");
        model.addAttribute("viewContent", "/WEB-INF/views/banhangtaiquay.html");
        return "layout";
    }

    @GetMapping("/hienthi")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/otherpage")
    public String otherPage(Model model) {
        return "otherpage";
    }
}
