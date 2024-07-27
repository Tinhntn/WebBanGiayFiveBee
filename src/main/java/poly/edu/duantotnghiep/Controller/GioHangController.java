package poly.edu.duantotnghiep.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.duantotnghiep.DAO.ChiTietGioHangCustom;
import poly.edu.duantotnghiep.DAO.ChiTietSanPhamUserCustom;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.GioHangChiTiet;
import poly.edu.duantotnghiep.Service.ChiTietSanPhamService;
import poly.edu.duantotnghiep.Service.GioHangChiTietService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/giohang")
public class GioHangController {
     @Autowired
     GioHangChiTietService gioHangChiTietService;
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("/hienthi")
    public String hienthi(Model model, HttpSession session){
        String idGioHang = "755483FC-9AC6-4AA7-A4ED-FA7D118D17F5";
        List<ChiTietGioHangCustom> listGiohang = gioHangChiTietService.getAllGioHang(UUID.fromString(idGioHang));
        model.addAttribute("listGioHang", listGiohang);
        Float tongtien = gioHangChiTietService.getTongTien(UUID.fromString(idGioHang));
        model.addAttribute("tongtienctt",tongtien);

        // Tính toán tổng tiền thanh toán
        return "user/giohang/giohang";
    }

    @PostMapping("/congsoluong/{idGioHangChiTiet}")
    public String cong(@PathVariable("idGioHangChiTiet") UUID idGioHangChiTiet,Model model,RedirectAttributes redirectAttributes){
        GioHangChiTiet ghct = gioHangChiTietService.getGHCTByID(idGioHangChiTiet);
        String idctsp = ghct.getIdchitietsanpham();
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamById(UUID.fromString(idctsp));
        int sl = ghct.getSoluong() + 1 ;
        if (sl > chiTietSanPham.getSoluong()+ghct.getSoluong()){
            redirectAttributes.addFlashAttribute("message", "Số lượng trong kho khong du");
            return "redirect:/giohang/hienthi";
        }
        ghct.setSoluong(sl);
        ghct.setTongtien(ghct.getDongia()*sl);
        gioHangChiTietService.updatesl(ghct);
        int slctspud = chiTietSanPham.getSoluong() -1;
        chiTietSanPham.setSoluong(slctspud);
        chiTietSanPhamService.updateChiTietSanPham(chiTietSanPham,UUID.fromString(idctsp));
        if(chiTietSanPham.getSoluong()==0){
            chiTietSanPham.setTrangthai(0);
            chiTietSanPhamService.updateChiTietSanPham(chiTietSanPham,UUID.fromString(idctsp));
        }else{
            chiTietSanPham.setTrangthai(1);
            chiTietSanPhamService.updateChiTietSanPham(chiTietSanPham,UUID.fromString(idctsp));
        }

        return "redirect:/giohang/hienthi";
    }

    @PostMapping("/trusoluong/{idGioHangChiTiet}")
    public String tru(@PathVariable("idGioHangChiTiet") UUID idGioHangChiTiet, Model model,
                      RedirectAttributes redirectAttributes){
        GioHangChiTiet ghct = gioHangChiTietService.getGHCTByID(idGioHangChiTiet);


        int sl = ghct.getSoluong() - 1 ;
        if (sl < 1){
            redirectAttributes.addFlashAttribute("message", "Số lượng tối thiểu là 1");
            sl = 1;
        }
        ghct.setSoluong(sl);
        ghct.setTongtien(ghct.getDongia()*sl);
        gioHangChiTietService.updatesl(ghct);
        String idctsp = ghct.getIdchitietsanpham();
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamById(UUID.fromString(idctsp));
        int slctspud = chiTietSanPham.getSoluong() + 1;
        chiTietSanPham.setSoluong(slctspud);
        chiTietSanPhamService.updateChiTietSanPham(chiTietSanPham,UUID.fromString(idctsp));
        if(chiTietSanPham.getSoluong()==0){
            chiTietSanPham.setTrangthai(0);
            chiTietSanPhamService.updateChiTietSanPham(chiTietSanPham,UUID.fromString(idctsp));
        }else{
            chiTietSanPham.setTrangthai(1);
            chiTietSanPhamService.updateChiTietSanPham(chiTietSanPham,UUID.fromString(idctsp));
        }
        return "redirect:/giohang/hienthi";
    }

    @PostMapping("/deleteCTGH/{idGioHangChiTiet}")
    public String xoagh( @PathVariable("idGioHangChiTiet") UUID idGioHangChiTiet,
                         RedirectAttributes redirectAttributes, Model model) {
        GioHangChiTiet ghct = gioHangChiTietService.getGHCTByID(idGioHangChiTiet);
        String idctsp = ghct.getIdchitietsanpham();
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamById(UUID.fromString(idctsp));
        chiTietSanPham.setSoluong(chiTietSanPham.getSoluong()+ghct.getSoluong());
        chiTietSanPhamService.updateChiTietSanPham(chiTietSanPham,UUID.fromString(idctsp));
        gioHangChiTietService.xoaGHCT(idGioHangChiTiet);
        redirectAttributes.addFlashAttribute("thanhcong", "Đã xóa sản phẩm thành công ");
        return "redirect:/giohang/hienthi";
    }

    @PostMapping("/addGHCT")
    public String addSPGHCT(@RequestParam("idctsp") UUID idctsp, @RequestParam("giaBan") Float giaBan,
                            @RequestParam("soluongmua") String soluongmuaStr ,
                            @RequestParam("soluongkho") int soluongkho,
                            Model model, RedirectAttributes redirectAttributes){
        String idGioHang = "755483FC-9AC6-4AA7-A4ED-FA7D118D17F5";
       List<ChiTietGioHangCustom> chiTiet = gioHangChiTietService.getAllGioHang(UUID.fromString(idGioHang));
        int soluongmua = Integer.parseInt(soluongmuaStr);
        try {
       if(soluongkho<=soluongmua){
           redirectAttributes.addFlashAttribute("message", "Sản phẩm trong kho không đủ");
           return "redirect:/trangchuuser/detailsanpham/" + idctsp;
       }
        if(soluongmua < 1 ){
            redirectAttributes.addFlashAttribute("message", "Số lượng phải từ 1 trở lên ");
            return "redirect:/trangchuuser/detailsanpham/" + idctsp;
        }
        } catch (NumberFormatException e) {
            redirectAttributes.addFlashAttribute("message", "Số lượng phải là một số hợp lệ.");
            return "redirect:/trangchuuser/detailsanpham/" + idctsp;
        }

        for (ChiTietGioHangCustom ct : chiTiet) {
            if (ct.getIdChiTietSanPham().equals(idctsp)) {
                redirectAttributes.addFlashAttribute("message", "Sản phẩm đã tồn tại trong giỏ hàng");
                return "redirect:/trangchuuser/detailsanpham/" + idctsp;
            }
        }

        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        ChiTietSanPham ctsp = chiTietSanPhamService.getChiTietSanPhamById(idctsp);
        gioHangChiTiet.setSoluong(soluongmua);
        gioHangChiTiet.setDongia(ctsp.getGiaban());
        gioHangChiTiet.setTongtien(ctsp.getGiaban());
        gioHangChiTiet.setIdgiohang("755483fc-9ac6-4aa7-a4ed-fa7d118d17f5");
        gioHangChiTiet.setIdchitietsanpham(idctsp.toString());
        gioHangChiTiet.setTrangthai(1);
        gioHangChiTietService.addGGHCT(gioHangChiTiet);
        ctsp.setSoluong(soluongkho-soluongmua);
        chiTietSanPhamService.updateSLSP(ctsp);
        redirectAttributes.addFlashAttribute("thanhcong", "Đã thêm sản phẩm thành công vào giỏ hàng");

        return "redirect:/trangchuuser/detailsanpham/" + idctsp;
    }

    @PostMapping("/chonctgh/{idGioHangChiTiet}")
    public String submitSelected(Model model,
                                 @RequestParam("idGioHangChiTiet") UUID idGioHangChiTiet
                                 ) {
        GioHangChiTiet ghct = gioHangChiTietService.getGHCTByID(idGioHangChiTiet);
        if(ghct.getTrangthai() == 1){
            ghct.setTrangthai(2);
            gioHangChiTietService.updatesl(ghct);
        }else if(ghct.getTrangthai() == 2){
            ghct.setTrangthai(1);
            gioHangChiTietService.updatesl(ghct);
        }
        return "redirect:/giohang/hienthi";
    }







}


