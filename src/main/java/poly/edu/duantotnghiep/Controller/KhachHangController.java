package poly.edu.duantotnghiep.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import poly.edu.duantotnghiep.Model.KhachHang;
import poly.edu.duantotnghiep.Service.KhachHangService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;


    @GetMapping("index1")
    public String index(@RequestParam(name = "page", defaultValue = "1") int page, Model model, @ModelAttribute("kh") String successMessage) {
//       int size=5;
//        Page<KhachHangCustom> khachHangPage = khachHangService.getALlKhachHang(page,size);
//        model.addAttribute("khachHangPage", khachHangPage);
//        model.addAttribute("kh", khachHangRequest);
        model.addAttribute("successMessage", successMessage);
//        model.addAttribute("view", "/views/admin/khach-hang/index.jsp");
        List<KhachHang> listKhachHang = khachHangService.getALlKhachHanglist();
        model.addAttribute("listKhachHang", listKhachHang);
        return "admin/khach-hang/createkh";
    }
    @GetMapping("/view-add")
    public String viewadd(Model model){
        model.addAttribute("kh1",new KhachHang());
        return "admin/khach-hang/add";
    }
    @PostMapping("/add")
    public String add( @ModelAttribute("kh1") KhachHang kh1, BindingResult result){
        khachHangService.add1(kh1);
        return "redirect:/khach-hang/index1";
    }
    @GetMapping("/delete/{id}")
    public String xoa(@PathVariable("id") UUID id){
        khachHangService.delete(id);
        return "redirect:/khach-hang/index1";
    }
    @GetMapping("/detail/{id}")
    public String detail( @PathVariable("id") UUID id, Model model){

        KhachHang khachHang=khachHangService.detail(id);

        model.addAttribute("kh1",khachHang);
model.addAttribute("id",id);
        return "admin/khach-hang/update";
    }
    @PostMapping("/update/{id}")
    public String update( @PathVariable("id")UUID id, @ModelAttribute("kh1") KhachHang khachHang){
        khachHangService.update(khachHang,id);
        return "redirect:/khach-hang/index1";
    }

}
