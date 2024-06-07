package poly.edu.duantotnghiep.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Model.*;
import poly.edu.duantotnghiep.Repository.*;
import poly.edu.duantotnghiep.Service.ChiTietHoaDonService;
import poly.edu.duantotnghiep.Service.HoaDonService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.Service.ChiTietSanPhamService;
import poly.edu.duantotnghiep.Service.KhachHangService;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

    @Controller
    @RequestMapping("/banhangtaiquay")
    public class BanHangTaiQuayController {
        @Autowired
        HoaDonRepository hoaDonRepository;
        @Autowired
        KhachHangRepository khachHangRepository;
        @Autowired
        KhuyenMaiRepository khuyenMaiRepository;
        @Autowired
        KhachHangService khachHangService;
        @Autowired
        private HoaDonService hoaDonService;
        @Autowired
        ChiTietSanPhamService chiTietSanPhamService;
        @Autowired
        ChiTietHoaDonService chiTietHoaDonService;
        @Autowired
        ChiTietHoaDonRepository chiTietHoaDonRepository;
        @Autowired
        ChiTietSanPhamRepository chiTietSanPhamRepository;
        @Autowired
        HttpSession session;

        @GetMapping("/hienthi")
        public String bhtq(Model model, @RequestParam(defaultValue = "0") int page){
            int size = 5;
            Page<ChiTieSanPhamCustom> CTSP = chiTietSanPhamService.phanTrang(page,size);
            model.addAttribute("CTSP",CTSP.getContent());
            model.addAttribute("currentPage",page);
            model.addAttribute("totalPages",CTSP.getTotalPages());
    //        List<ChiTieSanPhamCustom> lst = chiTietSanPhamService.getAllCTSP();
    //        model.addAttribute("lstCTSP",lst);
            List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
            model.addAttribute("listMaHoaDon", list);

            return "banhangtaiquay";
        }
        @PostMapping("/taoHoaDon")
        public String taoHoaDon(@ModelAttribute("hoadon") HoaDon hd, Model model, RedirectAttributes redirectAttributes, @RequestParam(defaultValue = "0") int page) {
            List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
            if (list.size() >= 5) {
                redirectAttributes.addFlashAttribute("error", "Chỉ được tạo tối đa 5 hóa đơn chờ.");
                return "redirect:/banhangtaiquay/hienthi?page=" + page;
            } else {
                hoaDonService.taohoadon(hd);
                return "redirect:/banhangtaiquay/hienthi";
            }
        }

        @GetMapping("/deletehdc/{id}")
        public String deletehdc(Model model, @PathVariable String id) {
            hoaDonService.updateSoLuongCTSanPhamByHoaDonId(UUID.fromString(id));
            hoaDonService.delete(UUID.fromString(id));
            return "redirect:/banhangtaiquay/hienthi";
        }

        @PostMapping("/updatehdc/{id}")
        public String updateslhhd(@PathVariable String id,@RequestParam int solm) {
            // Lấy thông tin chi tiết hóa đơn từ service hoặc repository
           hoaDonService.updateSoLuongCTSanPhamByHoaDonId(UUID.fromString(id));

            return "redirect:/banhangtaiquay/hienthi";
        }

        @GetMapping("/detailhd/{id}")
        public String detailHD(@PathVariable String id, Model model, @RequestParam(defaultValue = "0") int page){
            HoaDon hd = hoaDonService.detailHD(UUID.fromString(id));
            model.addAttribute("hoadon", hd);
            Float tongtienhd = hoaDonService.hienthiTongTienHD(UUID.fromString(id));
            model.addAttribute("tongtienhd", tongtienhd);

            UUID idKhachHang = hd.getIdkhachhang();
            UUID idKhuyenMai = hd.getIdkhuyenmai();
            System.out.println(idKhuyenMai);
            if(idKhuyenMai != null) {
                KhuyenMai km = khuyenMaiRepository.findById(idKhuyenMai).orElse(null);
                String maKM = km.getMakhuyenmai();
                model.addAttribute("maKM", maKM);
               Float gtg = km.getGiatri();
               model.addAttribute("gtg",gtg);
                Float tongtientt = tongtienhd - gtg;
                model.addAttribute("tttt",tongtientt);
            }else{
                if(tongtienhd != null) {
                    Float tongtientt = tongtienhd - 0;
                    model.addAttribute("tttt", tongtientt);
                }
            }

            if(idKhachHang != null) {
                KhachHang khachHang = khachHangRepository.findById(idKhachHang).orElse(null);
                String tenkh = khachHang.getTenkhachhang();
                model.addAttribute("tenkh", tenkh);
                String sdt = khachHang.getSdt();
                model.addAttribute("sdt", sdt);
            }


            int size = 5;
            Page<ChiTieSanPhamCustom> CTSP = chiTietSanPhamService.phanTrang(page,size);
            model.addAttribute("CTSP",CTSP.getContent());
            model.addAttribute("currentPage",page);
            model.addAttribute("totalPages",CTSP.getTotalPages());
    //        List<ChiTieSanPhamCustom> lst = chiTietSanPhamService.getAllCTSP();
    //        model.addAttribute("lstCTSP",lst);
            List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
            model.addAttribute("listMaHoaDon", list);

            List<ChiTietHoaDonCustom> chiTietHoaDonList = chiTietHoaDonService.findByHoaDonId(UUID.fromString(id));
            model.addAttribute("chiTietHoaDonList", chiTietHoaDonList);
            return "banhangtaiquay";
        }

        @GetMapping("/deleteCTHoaDon/{id}")
        public String deleteCTHoaDon(@PathVariable("id") String id, @RequestParam("idctsanpham") String idctsanpham){
            Integer soLuong = chiTietHoaDonService.getSoLuongById(UUID.fromString(id));
            ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamById(UUID.fromString(idctsanpham));
            chiTietSanPham.setSoluong(chiTietSanPham.getSoluong() + soLuong);
            chiTietSanPhamRepository.save(chiTietSanPham);
            UUID idHoaDon = chiTietHoaDonRepository.findHoaDonIdByChiTietId(UUID.fromString(id));
            chiTietHoaDonRepository.deleteById(UUID.fromString(id));

            return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
        }

        @GetMapping("/showCTSPThemCTHD/{idhd}/{id}")
        public String detail(@PathVariable UUID idhd,@PathVariable UUID id, Model model){
           ChiTieSanPhamCustom ct = chiTietSanPhamService.getChiTietCustomSanPhamById(id);
            model.addAttribute("CTSPCustomBHTQ", ct);
            return "detailCTSPThemSoLuongCTHD";
        }
        @PostMapping("/addCTHD/{id}")
        public String addCTHD(@PathVariable UUID id, @RequestParam("soluong") int soluong,
                              @RequestParam("idhd") UUID idhd, Model model, ChiTietHoaDon cthd){
            ChiTieSanPhamCustom ct = chiTietSanPhamService.getChiTietCustomSanPhamById(id);
            cthd.setIdchitietsanpham(id);
           cthd.setSoluong(soluong);
            cthd.setIdhoadon(idhd);
            float dongia = (float) (ct.getGiaBan() * cthd.getSoluong());
            cthd.setDongia(dongia);
            ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamById(id);
            chiTietSanPham.setSoluong(chiTietSanPham.getSoluong() - cthd.getSoluong());
            chiTietSanPhamService.updateSLSP(chiTietSanPham);
//            cthd.setIdhoadon(idHoaDon); // Gán id của hóa đơn
            chiTietHoaDonService.addCTHD(cthd);
            return "redirect:/banhangtaiquay/detailhd/" + idhd;
        }

        @PostMapping("/xoakhachhang/{id}")
        public String xoakh(@PathVariable UUID id, Model model){
           HoaDon hd = hoaDonService.detailHD(id);
           hd.setIdkhachhang(null);
           hoaDonService.updateHoaDon(hd,id);
            return "redirect:/banhangtaiquay/detailhd/" + id;
        }

        @GetMapping("/findidKHbysdt/{id}")
        String findidkhachhangbysdt(@PathVariable("id") UUID idHoaDon, @RequestParam("sdt") String sdt){

            UUID idkhachhang = khachHangService.findIdKhachHangBySdt(sdt);
            System.out.println("iD KhachHang: " + idkhachhang);

            HoaDon hoaDon = hoaDonService.detailHD(idHoaDon);
            hoaDon.setIdkhachhang(idkhachhang);

            hoaDonRepository.save(hoaDon);
            return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
        }

        @PostMapping("/thanhtoan/{id}")
        String findidkhachhangbysdt(@PathVariable("id") UUID idHoaDon, @RequestParam("thanhtien") Float thanhtien){
            HoaDon hoaDon = hoaDonService.detailHD(idHoaDon);
            hoaDon.setThanhtien(thanhtien);
            hoaDon.setTrangthai(1);
            hoaDonRepository.save(hoaDon);
            return "redirect:/banhangtaiquay/hienthi";
        }





}
