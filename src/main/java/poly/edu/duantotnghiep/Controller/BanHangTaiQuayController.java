package poly.edu.duantotnghiep.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.DAO.KhachHangCustom;
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

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/banhangtaiquay")
public class BanHangTaiQuayController {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    KhachHangRepository khachHangRepository;
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
    KhuyenMaiRepository khuyenMaiRepository;
    @Autowired
    HttpSession session;


    @GetMapping("/hienthi")
    public String bhtq(Model model, @RequestParam(defaultValue = "0") int page) {
        int size = 5;
        //list chitietsanpham phan trang
        Page<ChiTieSanPhamCustom> CTSP = chiTietSanPhamService.phanTrang(page, size);
        model.addAttribute("CTSP", CTSP.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", CTSP.getTotalPages());
        //list hoadon
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
        }
        return "redirect:/banhangtaiquay/hienthi";

    }

    @GetMapping("/deletehdc/{id}")
    public String deletehdc(Model model, @PathVariable String id) {
        hoaDonService.updateSoLuongCTSanPhamByHoaDonId(UUID.fromString(id));
        hoaDonService.delete(UUID.fromString(id));
        return "redirect:/banhangtaiquay/hienthi";
    }

    @PostMapping("/updatehdc/{id}")
    public String updateslhhd(@PathVariable String id, @RequestParam int solm) {
        // Lấy thông tin chi tiết hóa đơn từ service hoặc repository
        hoaDonService.updateSoLuongCTSanPhamByHoaDonId(UUID.fromString(id));

        return "redirect:/banhangtaiquay/hienthi";
    }


    @PostMapping("/updateSoLuong")
    public String capNhatSoLuongHoaDonChiTiet(@RequestParam("id") UUID id, @RequestParam("soLuong") int soLuong, RedirectAttributes redirectAttributes) {
        UUID idHoaDon;
        System.out.println(id);
        try {
            chiTietSanPhamService.updateChiTietSanPhamSuaCTHD(id, soLuong);
            chiTietHoaDonService.updateSoLuongHoaDonChiTietById(id, soLuong);
            idHoaDon = chiTietHoaDonRepository.findHoaDonIdByChiTietId(id);
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/banhangtaiquay/hienthi";
        }
        return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
    }


    @GetMapping("/detailhd/{id}")
    public String detailHD(@PathVariable String id, Model model, @RequestParam(defaultValue = "0") int page) {
        HoaDon hd = hoaDonService.detailHD(UUID.fromString(id));
        model.addAttribute("hoadon", hd);
        UUID idKhachHang = hd.getIdkhachhang();
        if (idKhachHang != null) {
            KhachHang khachHang = khachHangRepository.findById(idKhachHang).orElse(null);
            String tenkh = khachHang.getTenkhachhang();
            model.addAttribute("tenkh", tenkh);
            String sdt = khachHang.getSdt();
            model.addAttribute("sdt", sdt);
        } else {
            model.addAttribute("tenkh", "");
        }
        UUID idKhuyenMai = hd.getIdkhuyenmai();
        if (idKhuyenMai != null) {
            KhuyenMai khuyenMai = khuyenMaiRepository.findKhuyenMaiById(idKhuyenMai);
            String maKhuyenMai = khuyenMai.getMakhuyenmai();
            Float giaTriGiam = khuyenMai.getGiatri();
            session.setAttribute("maKhuyenMai", maKhuyenMai);
            session.setAttribute("giaTriGiam", giaTriGiam);
        } else {
            session.setAttribute("maKhuyenMai", "");
            session.setAttribute("giaTriGiam", "");
        }
        int size = 5;
        Page<ChiTieSanPhamCustom> CTSP = chiTietSanPhamService.phanTrang(page, size);
        model.addAttribute("CTSP", CTSP.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", CTSP.getTotalPages());
        //        List<ChiTieSanPhamCustom> lst = chiTietSanPhamService.getAllCTSP();
        //        model.addAttribute("lstCTSP",lst);
        List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
        model.addAttribute("listMaHoaDon", list);
        List<ChiTietHoaDonCustom> chiTietHoaDonList = chiTietHoaDonService.findByHoaDonId(UUID.fromString(id));
        model.addAttribute("chiTietHoaDonList", chiTietHoaDonList);
        return "banhangtaiquay";
    }

    @GetMapping("/deleteCTHoaDon/{id}")
    public String deleteCTHoaDon(@PathVariable("id") String id, @RequestParam("idctsanpham") String idctsanpham) {
        Integer soLuong = chiTietHoaDonService.getSoLuongById(UUID.fromString(id));
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamById(UUID.fromString(idctsanpham));
        chiTietSanPham.setSoluong(chiTietSanPham.getSoluong() + soLuong);
        chiTietSanPhamRepository.save(chiTietSanPham);
        UUID idHoaDon = chiTietHoaDonRepository.findHoaDonIdByChiTietId(UUID.fromString(id));
        chiTietHoaDonRepository.deleteById(UUID.fromString(id));

        return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
    }

    @GetMapping("/showCTSPThemCTHD/{idhd}/{id}")
    public String detail(@PathVariable UUID idhd, @PathVariable UUID id, Model model) {
        ChiTieSanPhamCustom ct = chiTietSanPhamService.getChiTietCustomSanPhamById(id);
        model.addAttribute("CTSPCustomBHTQ", ct);
        return "detailCTSPThemSoLuongCTHD";
    }

    @PostMapping("/addCTHD/{id}")
    public String addCTHD(@PathVariable UUID id, @RequestParam("soluong") int soluong,
                          @RequestParam("idhd") UUID idhd, Model model, ChiTietHoaDon cthd) {
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
    public String xoakh(@PathVariable UUID id, Model model) {
        HoaDon hd = hoaDonService.detailHD(id);
        hd.setIdkhachhang(null);
        hoaDonService.updateHoaDon(hd, id);
        return "redirect:/banhangtaiquay/detailhd/" + id;
    }

    //check đúng định dạng sdt
    private static final Pattern SDT_PATTERN = Pattern.compile("^[0-9]{10,11}$");

    @GetMapping("/findidKHbysdt/{id}")
    String findidkhachhangbysdt(@PathVariable("id") UUID id, HttpSession session, @RequestParam("sdt") String sdt) {


        if (sdt == null || sdt.isEmpty() || !SDT_PATTERN.matcher(sdt).matches()) {
            session.setAttribute("errorMessage", "Số điện thoại không hợp lệ");
            return "redirect:/banhangtaiquay/detailhd/" + id;
        }
        KhachHang khachHang = khachHangService.getKhachHangBySdt(sdt);
        if (khachHang == null) {
            session.setAttribute("errorMessage", "Khách hàng không tồn tại");
            return "redirect:/banhangtaiquay/detailhd/" + id;
        }

        UUID idkhachhang = khachHang.getId();
        HoaDon hoaDon = hoaDonService.detailHD(id);
        hoaDon.setIdkhachhang(idkhachhang);
        hoaDonRepository.save(hoaDon);
        session.setAttribute("tenkh", khachHang.getTenkhachhang());
        return "redirect:/banhangtaiquay/detailhd/" + id;
    }

    @GetMapping("/findKhuyenMaiByMa/{id}")
    public String getKhuyenMaiByMa(@PathVariable("id") UUID id, @RequestParam("maKhuyenMai") String maKhuyenMai, HttpSession session) {
        if (maKhuyenMai == null || maKhuyenMai.isEmpty()) {
            session.setAttribute("errorMessage", "Không được để trống mã khuyến mãi");
            return "forward:/banhangtaiquay/detailhd/" + id;
        }
        KhuyenMai khuyenMai = khuyenMaiRepository.findKhuyenMaiByMakhuyenmai(maKhuyenMai);
        if (khuyenMai == null) {
            session.setAttribute("errorMessage", "Mã khuyến mãi không tồn tại");
            return "redirect:/banhangtaiquay/detailhd/" + id;
        }
        UUID idKhuyenMai = khuyenMai.getId();
        HoaDon hoaDon = hoaDonService.detailHD(id);
        hoaDon.setIdkhuyenmai(idKhuyenMai);
        hoaDonRepository.save(hoaDon);
        Float giaTriGiam = khuyenMai.getGiatri();
        session.setAttribute("maKhuyenMai", maKhuyenMai);
        session.setAttribute("giaTriGiam", giaTriGiam);
        return "redirect:/banhangtaiquay/detailhd/" + id;
    }

    @GetMapping("/danhsachkhachhang")
    String danhsachkhachhang(Model model, @RequestParam(defaultValue = "0") int page) {

//            int size = 1;
//            Page<KhachHangCustom> listKhachHang = khachHangService.getALlKhachHang(page, size);
//            System.out.println(listKhachHang);
//            model.addAttribute("listKhachHang", listKhachHang);

        List<KhachHang> listKhachHang = khachHangService.getALlKhachHanglist();
        model.addAttribute("listKhachHang", listKhachHang);

        return "khachHang";
    }

}
