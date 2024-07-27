package poly.edu.duantotnghiep.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Service.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/hoadononline")
public class HoaDonOnlineController {

    @Autowired
    HoaDonAdminService hoaDonAdminService;
    @Autowired
    GioHangChiTietService gioHangChiTietService;
    @Autowired
    HoaDonUserService hoaDonUserService;

    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    ChiTietHoaDonService chiTietHoaDonService;
    @Autowired
    HoaDonService hoaDonService;

    @GetMapping("/hienthi")
    public String hienthi(Model model){
        List<HoaDonDAOCustom> listHoaDonCXN = hoaDonAdminService.getHoaDonOLChoxacnhan();
        model.addAttribute("listHoaDonCXN", listHoaDonCXN);
        Integer sizecxn = listHoaDonCXN.size();
        model.addAttribute("sizecxn",sizecxn);

        List<HoaDonDAOCustom> listHoaDonCLH = hoaDonAdminService.getHoaDonOLChoLayHang();
        model.addAttribute("listHoaDonCLH", listHoaDonCLH);
        Integer sizeclh = listHoaDonCLH.size();
        model.addAttribute("sizeclh",sizeclh);

        List<HoaDonDAOCustom> listHoaDonDG = hoaDonAdminService.getHoaDonOLDangGiao();
        model.addAttribute("listHoaDonDG", listHoaDonDG);
        Integer sizedg = listHoaDonDG.size();
        model.addAttribute("sizedg",sizedg);

        List<HoaDonDAOCustom> listHoaDonHT = hoaDonAdminService.getHoaDonOlHoanThanh();
        model.addAttribute("listHoaDonHT", listHoaDonHT);
        Integer sizeht = listHoaDonHT.size();
        model.addAttribute("sizeht",sizeht);

        List<HoaDonDAOCustom> listHoaDonDH = hoaDonAdminService.getHoaDonOlDaHuy();
        model.addAttribute("listHoaDonDH", listHoaDonDH);
        Integer sizeDH = listHoaDonDH.size();
        model.addAttribute("sizeDH",sizeDH);

        System.out.println(listHoaDonCXN.size());
        return "admin/hoa-don/hoadononline";
    }



    @PostMapping("/huydh/{id}")
    public String huydonhang(@PathVariable UUID id, @RequestParam(value = "ghichu",
            defaultValue = "trong") String ghichu,
                             Model model, RedirectAttributes redirectAttributes) {
        HoaDon hd = hoaDonService.detailHD(id);
        hd.setGhichu(ghichu);
        hd.setTrangthai(6);
        hoaDonService.updateHoaDon(hd,id);
        List<ChiTietHoaDonCustom> chiTietHoaDonList = chiTietHoaDonService.findByHoaDonId(id);

        for(ChiTietHoaDonCustom ct : chiTietHoaDonList){
            ChiTietSanPham dt = chiTietSanPhamService.getChiTietSanPhamById(ct.getIdchitietsanpham());
            System.out.println(ct.getSoluong());
            System.out.println(dt.getSoluong());
            dt.setSoluong(dt.getSoluong()+ ct.getSoluong());
            chiTietSanPhamService.updateSLSP(dt);
        }
        redirectAttributes.addFlashAttribute("thanhcong","Hủy thành công");
        return "redirect:/hoadononline/hienthi";
    }

    @PostMapping("/xacnhanhoadoncho/{id}")
    public String xacnhanhoadoncho(@PathVariable UUID id,

                             Model model, RedirectAttributes redirectAttributes) {
        HoaDon hd = hoaDonService.detailHD(id);
        hd.setTrangthai(3);
        hd.setIdnhanvien("F89287E1-83BB-4B9D-B7EB-12E77A384DB6");
        hoaDonService.updateHoaDon(hd,id);
        redirectAttributes.addFlashAttribute("thanhcong","thành công");
        return "redirect:/hoadononline/hienthi";
    }

    @PostMapping("/xacnhanhoadondg/{id}")
    public String xacnhanhoadondg(@PathVariable UUID id,
                                  @RequestParam(value = "tennguoigiao", defaultValue = "trong") String tennguoigiao,
                                  @RequestParam(value = "sdtnguoigiao", defaultValue = "trong") String sdtnguoigiao,

                                   Model model, RedirectAttributes redirectAttributes) {
        HoaDon hd = hoaDonService.detailHD(id);
        hd.setTennguoigiao(tennguoigiao);
        hd.setSdtnguoigiao(sdtnguoigiao);
        hd.setTrangthai(4);
        hoaDonService.updateHoaDon(hd,id);
        redirectAttributes.addFlashAttribute("thanhcong","thành công");
        return "redirect:/hoadononline/hienthi";
    }
    @PostMapping("/xacnhanhoadonhoanthanh/{id}")
    public String xacnhanhoadonhoanthanh(@PathVariable UUID id,
                                  Model model, RedirectAttributes redirectAttributes) {
        HoaDon hd = hoaDonService.detailHD(id);
        hd.setTrangthai(5);
        hoaDonService.updateHoaDon(hd,id);
        redirectAttributes.addFlashAttribute("thanhcong","thành công");
        return "redirect:/hoadononline/hienthi";
    }


}
