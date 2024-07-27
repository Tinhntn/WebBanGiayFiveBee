package poly.edu.duantotnghiep.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.Banner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Model.*;
import poly.edu.duantotnghiep.Repository.*;

import poly.edu.duantotnghiep.DAO.KhachHangCustom;

import poly.edu.duantotnghiep.Model.ChiTietHoaDon;
import poly.edu.duantotnghiep.Model.ChiTietSanPham;
import poly.edu.duantotnghiep.Model.HoaDon;
import poly.edu.duantotnghiep.Model.KhachHang;
import poly.edu.duantotnghiep.Repository.ChiTietHoaDonRepository;
import poly.edu.duantotnghiep.Repository.ChiTietSanPhamRepository;
import poly.edu.duantotnghiep.Repository.HoaDonRepository;
import poly.edu.duantotnghiep.Repository.KhachHangRepository;


import poly.edu.duantotnghiep.Service.*;


import poly.edu.duantotnghiep.Service.ChiTietHoaDonService;
import poly.edu.duantotnghiep.Service.HoaDonService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;

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
        KhuyenMaiRepository khuyenMaiRepository;
        @Autowired
        KhuyenMaiService khuyenMaiService;
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


        return "admin/banhangtaiquay/banhangtaiquay";
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
    public String updateslhhd(@PathVariable String id, @RequestParam int solm) {
        // Lấy thông tin chi tiết hóa đơn từ service hoặc repository
        hoaDonService.updateSoLuongCTSanPhamByHoaDonId(UUID.fromString(id));

        return "redirect:/banhangtaiquay/hienthi";
    }


    @PostMapping("/updateSoLuong")
    public String capNhatSoLuongHoaDonChiTiet(@RequestParam("id") UUID id, Model model, @RequestParam("soLuong") int soLuong, RedirectAttributes redirectAttributes) {
        UUID idHoaDon;
        ChiTietHoaDon chiTietHoaDon = chiTietHoaDonService.findById(id);
        UUID idCTSP = chiTietHoaDon.getIdchitietsanpham();
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamById(idCTSP);
        int soLuongHDCT = chiTietHoaDonRepository.getSoLuongById(id);
        int soLuongCTSP = chiTietSanPham.getSoluong();
        int tongKho = soLuongCTSP + soLuongHDCT;
        model.addAttribute("tongkho",tongKho);


        idHoaDon = chiTietHoaDonRepository.findHoaDonIdByChiTietId(id);
        if (soLuong > soLuongCTSP) {
            redirectAttributes.addFlashAttribute("error", "Số lượng trong kho không đủ .");
            return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
        }
        chiTietHoaDon.setDongia(chiTietSanPham.getGiaban()*soLuong);
        chiTietSanPhamService.updateChiTietSanPhamSuaCTHD(id, soLuong);
        chiTietHoaDonService.updateSoLuongHoaDonChiTietById(id, soLuong);


        return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
    }


        @GetMapping("/detailhd/{id}")
        public String detailHD(@PathVariable String id, Model model, @RequestParam(defaultValue = "0") int page) {
            // Lấy thông tin hóa đơn từ dịch vụ
            HoaDon hd = hoaDonService.detailHD(UUID.fromString(id));
            model.addAttribute("hoadon", hd);

            // Lấy tổng tiền hóa đơn từ dịch vụ
            Float tongtienhd = hoaDonService.hienthiTongTienHD(UUID.fromString(id));

            // Kiểm tra giá trị tongtienhd trước khi thêm vào model
            if (tongtienhd != null) {
                model.addAttribute("tongtienhd", tongtienhd);
            } else {
                // Xử lý trường hợp tongtienhd là null (ví dụ: đặt giá trị mặc định hoặc thông báo lỗi)
                model.addAttribute("tongtienhd", 0.0f); // giá trị mặc định
            }

            UUID idKhachHang = hd.getIdkhachhang();
            UUID idKhuyenMai = hd.getIdkhuyenmai();

            if (idKhuyenMai != null) {
                KhuyenMai km = khuyenMaiRepository.findById(idKhuyenMai).orElse(null);
                if (km != null) {
                    String maKM = km.getMakhuyenmai();
                    model.addAttribute("maKM", maKM);
                    Float gtg = km.getGiatri();
                    model.addAttribute("gtg", gtg);

                    // Tính toán tổng tiền thanh toán sau khi áp dụng khuyến mãi
                    Float tongtientt = (tongtienhd != null ? tongtienhd : 0.0f) - (gtg != null ? gtg : 0.0f);
                    model.addAttribute("tttt", tongtientt);
                }
            } else {
                // Tính toán tổng tiền thanh toán khi không có khuyến mãi
                Float tongtientt = (tongtienhd != null ? tongtienhd : 0.0f);
                model.addAttribute("tttt", tongtientt);
            }

            if (idKhachHang != null) {
                KhachHang khachHang = khachHangRepository.findById(idKhachHang).orElse(null);
                if (khachHang != null) {
                    String tenkh = khachHang.getTenkhachhang();
                    model.addAttribute("tenkh", tenkh);
                    String sdt = khachHang.getSdt();
                    model.addAttribute("sdt", sdt);
                }
            }

            // Xử lý phân trang cho ChiTietSanPham
            int size = 5;
            Page<ChiTieSanPhamCustom> CTSP = chiTietSanPhamService.phanTrang(page, size);
            model.addAttribute("CTSP", CTSP.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", CTSP.getTotalPages());

            // Lấy danh sách hóa đơn chưa thanh toán
            List<HoaDon> list = hoaDonService.getAllHoaDonChuaThanhToan();
            model.addAttribute("listMaHoaDon", list);

            // Lấy danh sách chi tiết hóa đơn
            List<ChiTietHoaDonCustom> chiTietHoaDonList = chiTietHoaDonService.findByHoaDonId(UUID.fromString(id));
            model.addAttribute("chiTietHoaDonList", chiTietHoaDonList);

            return "admin/banhangtaiquay/banhangtaiquay";
        }



        @PostMapping("/addCTHD/{ctspid}")
        public String addCTHD(@RequestParam("ctspid") UUID ctspid,
                              @RequestParam("soluong1") int soluong,
                              @RequestParam("idhd") UUID idhd,
                              RedirectAttributes redirectAttributes,
                              Model model,
                              ChiTietHoaDon cthd) {
            try {
                ChiTieSanPhamCustom ct = chiTietSanPhamService.getChiTietCustomSanPhamById(ctspid);
                model.addAttribute("CTSPCustomBHTQ", ct);
                ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamById(ctspid);
                List<ChiTietHoaDon> listcthd = chiTietHoaDonService.getKtraTrungCTSP(chiTietSanPham.getId(), idhd);

                model.addAttribute("CTSPCustomBHTQ", ct);

                if (listcthd.size() >= 1) {
                    redirectAttributes.addFlashAttribute("error", "Sản phẩm đã tồn tại trong giỏ hàng.");
                    return "redirect:/banhangtaiquay/detailhd/" + idhd;
                }
                if (soluong <= 0) {
                    redirectAttributes.addFlashAttribute("error", "Số lượng phải từ 1 trở lên.");
                    return "redirect:/banhangtaiquay/detailhd/" + idhd;
                }
                if (soluong > chiTietSanPham.getSoluong()) {
                    redirectAttributes.addFlashAttribute("error", "Số lượng trong kho không đủ.");
                    return "redirect:/banhangtaiquay/detailhd/" + idhd;
                }

                cthd.setIdchitietsanpham(ctspid);
                cthd.setSoluong(soluong);
                cthd.setIdhoadon(idhd);
                float dongia = (float) (ct.getGiaBan() * cthd.getSoluong());
                cthd.setDongia(dongia);

                chiTietSanPham.setSoluong(chiTietSanPham.getSoluong() - cthd.getSoluong());
                if(chiTietSanPham.getSoluong() == 0){
                    chiTietSanPham.setTrangthai(0);
                }
                chiTietSanPhamService.updateSLSP(chiTietSanPham);
                chiTietHoaDonService.addCTHD(cthd);


                return "redirect:/banhangtaiquay/detailhd/" + idhd;
            } catch (IllegalArgumentException e) {
                redirectAttributes.addFlashAttribute("error", "Dữ liệu không hợp lệ.");
                return "redirect:/banhangtaiquay/detailhd/" + idhd;
            }
        }
        @GetMapping("/deleteCTHoaDon/{id}")
    public String deleteCTHoaDon(@PathVariable("id") String id, @RequestParam("idctsanpham") String idctsanpham) {
        Integer soLuong = chiTietHoaDonService.getSoLuongById(UUID.fromString(id));
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getChiTietSanPhamById(UUID.fromString(idctsanpham));
        chiTietSanPham.setSoluong(chiTietSanPham.getSoluong() + soLuong);
            if(chiTietSanPham.getSoluong() > 0){
                chiTietSanPham.setTrangthai(1);
            }
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

        @PostMapping("/xoakhachhang/{hoadonId}")
        public String xoakh(@PathVariable("hoadonId") UUID hoadonId, Model model) {
            HoaDon hd = hoaDonService.detailHD(hoadonId);
            hd.setIdkhachhang(null);
            hoaDonService.updateHoaDon(hd, hoadonId);
            return "redirect:/banhangtaiquay/detailhd/" + hoadonId;
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

        return "redirect:/banhangtaiquay/detailhd/" + id;
    }


    @GetMapping("/findKhuyenMaiByMa/{id}")
    public String getKhuyenMaiByMa(@PathVariable("id") UUID id, @RequestParam("maKhuyenMai") String maKhuyenMai, HttpSession session) {
        if (maKhuyenMai == null || maKhuyenMai.isEmpty()) {
            session.setAttribute("errorMessage", "Không được để trống mã khuyến mãi");
            return "forward:/banhangtaiquay/detailhd/" + id;

        }
//        UUID idkhachhang = khachHangService.findIdKhachHangBySdt(sdt);
//        System.out.println("iD KhachHang: " + idkhachhang);
//
//        HoaDon hoaDon = hoaDonService.detailHD(idHoaDon);
//        hoaDon.setIdkhachhang(idkhachhang);
//
//        hoaDonRepository.save(hoaDon);
//        return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;

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


    @GetMapping("/danhsachkhachhang/{id}")
    String danhsachkhachhang(Model model, @PathVariable("id") UUID id, @RequestParam(defaultValue = "0") int page) {


//            int size = 1;
//            Page<KhachHangCustom> listKhachHang = khachHangService.getALlKhachHang(page, size);
//            System.out.println(listKhachHang);
//            model.addAttribute("listKhachHang", listKhachHang);


        List<KhachHang> listKhachHang = khachHangService.getALlKhachHanglist();
        model.addAttribute("listKhachHang", listKhachHang);

        return "admin/banhangtaiquay/listKhachHangBHTQ";
    }


    @PostMapping("/addkhachhangvaohd/{id}/{maKhachHang}")
    String addkhachhangvaohd(@PathVariable("id") UUID idHoaDon, @PathVariable("maKhachHang") String maKhachHang) {
        KhachHang khachHang = khachHangService.getKhachHangByMakhachhang(maKhachHang);
        System.out.println(khachHang.getMatkhau());
        HoaDon hoaDon = hoaDonService.detailHD(idHoaDon);
        hoaDon.setIdkhachhang(khachHang.getId());
        hoaDonRepository.save(hoaDon);

        return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
    }

    //Tìm khuyến mại bằng mã khuyến mại

    @GetMapping("/findkhuyenmaibymakh/{id}")
    public String findkhuyenmaibymakh(@PathVariable("id") UUID idHoaDon, @RequestParam("makhuyenmai") String maKhuyenMai) {

        KhuyenMai khuyenMai = khuyenMaiRepository.findKhuyenMaiByMakhuyenmai(maKhuyenMai);

        HoaDon hoaDon = hoaDonService.detailHD(idHoaDon);
        hoaDon.setIdkhuyenmai(khuyenMai.getId());

        hoaDonRepository.save(hoaDon);
        return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;

    }

    //Xóa Khuyến mại trong Hóa đơn
    @PostMapping("/xoakhuyenmai/{id}")
    public String xoakhuyenmai(@PathVariable UUID id) {
        HoaDon hd = hoaDonService.detailHD(id);
        hd.setIdkhuyenmai(null);
        hoaDonService.updateHoaDon(hd, id);
        return "redirect:/banhangtaiquay/detailhd/" + id;
    }

    @GetMapping("/danhsachkhuyenmai/{id}")
    String danhsachkhuyenmai(@PathVariable("id") UUID idHoaDon, Model model, @RequestParam(defaultValue = "0") int page) {


//            int size = 1;
//            Page<KhachHangCustom> listKhachHang = khachHangService.getALlKhachHang(page, size);
//            System.out.println(listKhachHang);
//            model.addAttribute("listKhachHang", listKhachHang);

        List<KhuyenMai> listKhuyenMai = khuyenMaiService.getAllKhuyenMailist();
        model.addAttribute("listKhuyenMai", listKhuyenMai);

        return "admin/banhangtaiquay/listKhuyenMaiBHTQ";
    }

    @PostMapping("/addkhuyenmaivaohd/{id}/{idkhuyenmai}")
    String addkhuyenmaivaohd(@PathVariable("id") UUID idHoaDon, @PathVariable("idkhuyenmai") UUID idKhuyenMai) {


        HoaDon hoaDon = hoaDonService.detailHD(idHoaDon);
        hoaDon.setIdkhuyenmai(idKhuyenMai);

        hoaDonRepository.save(hoaDon);

        return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
    }


//        @PostMapping("/thanhtoan/{id}")
//        String findidkhachhangbysdt(@PathVariable("id") UUID idHoaDon,
//                                    RedirectAttributes redirectAttributes,
//                                    @RequestParam("thanhtien") Float thanhtien,
//                                    @RequestParam(value = "tienkhachdua",defaultValue = "0") String tienkhachduaStr
//
//        ){
//            HoaDon hoaDon = hoaDonService.detailHD(idHoaDon);
//            if (tienkhachduaStr.equals("0")) {
//                redirectAttributes.addFlashAttribute("error", "Không được để trống tiền khách đưa và tiền thừa");
//                return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
//            }
//
//            else {
//                hoaDon.setThanhtien(thanhtien);
//                hoaDon.setTrangthai(1);
//                hoaDonRepository.save(hoaDon);
//                return "redirect:/banhangtaiquay/hienthi";
//            }
//        }


    @PostMapping("/thanhtoan/{id}")
    String findidkhachhangbysdt(@PathVariable("id") UUID idHoaDon,
                                RedirectAttributes redirectAttributes,
                                @RequestParam("thanhtien") Float thanhtien,
                                @RequestParam(value = "tienkhachdua", defaultValue = "0") String tienkhachduaStr,
                                @RequestParam(value = "tienthua", defaultValue = "0") String tienthuaStr

    ) {
        HoaDon hoaDon = hoaDonService.detailHD(idHoaDon);
        List<ChiTietHoaDonCustom> chiTietHoaDonList = chiTietHoaDonService.findByHoaDonId(idHoaDon);

        if (tienkhachduaStr.equals("0")) {
            redirectAttributes.addFlashAttribute("error", "khong duoc de trong tien khach dua.");
            return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
        }
        if (tienthuaStr.equals("0")) {
            redirectAttributes.addFlashAttribute("error", "khong duoc de trong tien thua.");
            return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
        }
        if (chiTietHoaDonList.size() <= 0) {
            redirectAttributes.addFlashAttribute("error", " Không có sản phẩm trong giỏ hàng .");
            return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
        }
        else {
            hoaDon.setThanhtien(thanhtien);
            hoaDon.setTrangthai(1);
            hoaDonRepository.save(hoaDon);
            redirectAttributes.addFlashAttribute("thanhcong","thanh toan thanh cong");
            return "redirect:/banhangtaiquay/hienthi";
        }
    }


    @PostMapping("/trutienkhachdua/{id}")
    public String truTienKhachDua(@PathVariable("id") UUID idHoaDon,
                                  @RequestParam(value = "tienkhachdua", defaultValue = "0") String tienkhachduaStr,
                                  @RequestParam("thanhtien") Float thanhtien,
                                  Model model,
                                  RedirectAttributes redirectAttributes) {


        // Kiểm tra xem tienkhachduaStr có chứa số hợp lệ không
        if (!tienkhachduaStr.matches("^\\d*\\.?\\d+$")) {
            redirectAttributes.addFlashAttribute("error", "Tiền khách đưa phải là số.");
            return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
        }

        // Chuyển đổi chuỗi sang số
        Float tienkhachdua = Float.parseFloat(tienkhachduaStr);

        // Kiểm tra xem tienkhachdua có lớn hơn 0 không
        if (tienkhachdua <= 0) {
            redirectAttributes.addFlashAttribute("error", "Tiền khách đưa phải lớn hơn 0.");
            return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
        }
        if (tienkhachdua <= thanhtien) {
            redirectAttributes.addFlashAttribute("error", "Tiền khách đưa phải lớn hơn tổng tiền thanh toán.");
            return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
        }

        // Tính tiền thừa
        float tienthua = tienkhachdua - thanhtien;

        // Lưu giá trị vào flash attribute
        redirectAttributes.addFlashAttribute("tienkhachdua", tienkhachdua);
        redirectAttributes.addFlashAttribute("tienthua", tienthua);


        return "redirect:/banhangtaiquay/detailhd/" + idHoaDon;
    }

}

