package poly.edu.duantotnghiep.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.duantotnghiep.DAO.ChiTietGioHangCustom;
import poly.edu.duantotnghiep.DAO.ChiTietHoaDonCustom;
import poly.edu.duantotnghiep.DAO.HoaDonDAOCustom;
import poly.edu.duantotnghiep.Model.*;
import poly.edu.duantotnghiep.Service.*;
import poly.edu.duantotnghiep.infrastructures.Reponse.CalculateFeeResponse;
import poly.edu.duantotnghiep.infrastructures.Reponse.DistrictResponse;
import poly.edu.duantotnghiep.infrastructures.Reponse.ProvinceResponse;
import poly.edu.duantotnghiep.infrastructures.Reponse.WardResponse;
import poly.edu.duantotnghiep.infrastructures.request.CalculateFeeRequest;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
@Controller
@RequestMapping("/banhangonline")
public class BanHangOnlineController {
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

    @Autowired
    private TinhThanhService tinhThanhService;

    private final ShippingService shippingService;




    public BanHangOnlineController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }


    @GetMapping("/hienthi")
    public String hienthi(Model model){
        model.addAttribute("calculateFeeRequest", new CalculateFeeRequest());
     String idGioHang = "755483FC-9AC6-4AA7-A4ED-FA7D118D17F5";
     List<ChiTietGioHangCustom> ghct =   gioHangChiTietService.getAllBanHang(UUID.fromString(idGioHang));
     model.addAttribute("banhang",ghct);
     Float tongtien = gioHangChiTietService.getTongTien(UUID.fromString(idGioHang));
        Float tongtientt = tongtien;
     model.addAttribute("tongtien",tongtientt);

        // Tính toán tổng tiền thanh toán
        return "user/giohang/detailbanhang";
    }
    @GetMapping("/provinces")
    @ResponseBody
    public ProvinceResponse getProvinces() {
        System.out.println(tinhThanhService.getProvinces());
        return tinhThanhService.getProvinces();
    }

    @GetMapping("/districts")
    @ResponseBody
    public DistrictResponse getDistricts(@RequestParam String provinceID) {
        return tinhThanhService.getDistricts(provinceID);
    }

    @GetMapping("/wards")
    @ResponseBody
    public WardResponse getWards(@RequestParam String districtID) {
        return tinhThanhService.getWards(districtID);
    }//Combobox tỉnh, huyện, xã


    @PostMapping("/calculate-fee")
    @ResponseBody
    public CalculateFeeResponse calculateFee(@ModelAttribute CalculateFeeRequest request) {
        // Gán giá trị cố định cho các trường
        request.setService_type_id(2); // ID dịch vụ hàng nhẹ
        request.setFrom_district_id(3440); // ID quận Nam Từ Liêm người gửi cố định
        request.setHeight(25); // Chiều cao cố định
        request.setLength(35); // Chiều dài cố định
        request.setWeight(2000); // Cân nặng cố định
        request.setWidth(25); // Chiều rộng cố định

        System.out.println(request.getTo_district_id());
        System.out.println(request.getTo_ward_code());

        CalculateFeeResponse response = shippingService.calculateFee(request);

        return response;
    }

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_REGEX = "^\\d{10,15}$";
    private static final String NAME_REGEX = "^[A-Za-z\\s]+$";
    @PostMapping("/thanhtoan")
    public String thanhtoanaa(Model model, HoaDon hoaDon,@RequestParam(value = "tenkh", defaultValue = "") String tenKhachHang,
                              @RequestParam(value = "sdt", defaultValue = "") String sdt,
                              @RequestParam(value = "provinceName", defaultValue = "") String tinhthanh,
                              @RequestParam(value = "districtName", defaultValue = "") String quanhuyen,
                              @RequestParam(value = "wardName", defaultValue = "") String phuongxa,
                              @RequestParam(value = "ghichu", defaultValue = "") String ghichu,
                              @RequestParam(value = "phiVanChuyen", defaultValue = "") String phiVanChuyen,
                              @RequestParam(value = "email", defaultValue = "") String email, RedirectAttributes redirectAttributes){
        if (!email.matches(EMAIL_REGEX)) {
            redirectAttributes.addFlashAttribute("message", "Địa chỉ email không hợp lệ.");
            return "redirect:/banhangonline/hienthi";
        }
        // Kiểm tra định dạng số điện thoại
        if (!sdt.matches(PHONE_REGEX)) {
            redirectAttributes.addFlashAttribute("message", "Số điện thoại không hợp lệ.");
            return "redirect:/banhangonline/hienthi";
        }
        // Kiểm tra định dạng tên khách hàng
        if (!tenKhachHang.matches(NAME_REGEX) || tenKhachHang.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Tên khách hàng không hợp lệ.");
            return "redirect:/banhangonline/hienthi";
        }
        if (!tenKhachHang.matches(NAME_REGEX) || tenKhachHang.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Tên khách hàng không hợp lệ.");
            return "redirect:/banhangonline/hienthi";
        }
        if (ghichu.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Bạn hãy điền địa chỉ cụ thể.");
            return "redirect:/banhangonline/hienthi";
        }
        if (tinhthanh.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Bạn hãy chọn tỉnh thành.");
            return "redirect:/banhangonline/hienthi";
        }
        if (quanhuyen.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Bạn hãy chọn quận huyện.");
            return "redirect:/banhangonline/hienthi";
        }
        if (phuongxa.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Bạn hãy chọn phường xã.");
            return "redirect:/banhangonline/hienthi";
        }

        Float phiShip = Float.valueOf(phiVanChuyen);
        String idGioHang = "755483FC-9AC6-4AA7-A4ED-FA7D118D17F5";
        List<ChiTietGioHangCustom> ghct = gioHangChiTietService.getAllBanHang(UUID.fromString(idGioHang));
        model.addAttribute("banhang", ghct);
        Float tongtien = gioHangChiTietService.getTongTien(UUID.fromString(idGioHang));
        model.addAttribute("tongtien", tongtien);
        Random random = new Random();
        int randomNumber = 100000 + random.nextInt(900000); // Sinh số ngẫu nhiên từ 100000 đến 999999
        System.out.println(randomNumber);
        hoaDon.setTrangthai(2);
        hoaDon.setDonvigiao("Giao hàng nhanh");
        hoaDon.setEmailnguoinhan(email);
        hoaDon.setSdtnguoinhan(sdt);
        hoaDon.setTennguoinhan(tenKhachHang);
        hoaDon.setPhuongxa(phuongxa);
        hoaDon.setGhichu(ghichu);
        hoaDon.setLoaihoadon(2);
        hoaDon.setQuanhuyen(quanhuyen);
        hoaDon.setTinhthanh(tinhthanh);
        hoaDon.setThanhtien(tongtien-phiShip);
        String km = "3D60456B-43BE-4DEB-AFD6-A131DEC65E6D";
        hoaDon.setIdkhuyenmai(UUID.fromString(km));
        hoaDon.setLoaithanhtoan(1);
        // Chú ý thêm "f" để chỉ định kiểu dữ liệu là float
        hoaDon.setPhiship(phiShip);

        String idkh = "7C6AC49D-21BC-4D6D-89EA-00D85BBA9DC6";
        hoaDon.setIdkhachhang(UUID.fromString(idkh));
        hoaDon.setNgaytao(new Date());
        hoaDon.setMahoadon("HD" + String.valueOf(randomNumber));
        hoaDon.setNgaymua(new Date());
        hoaDonService.tao(hoaDon);


        for (ChiTietGioHangCustom gh : ghct) {
           ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.setId(UUID.randomUUID());
            chiTietHoaDon.setSoluong(gh.getSoLuong());
            chiTietHoaDon.setDongia(gh.getTongTien());
            chiTietHoaDon.setIdchitietsanpham(gh.getIdChiTietSanPham());
            chiTietHoaDon.setIdhoadon(hoaDon.getId());
            chiTietHoaDon.setNgaytao(new Date());
            chiTietHoaDon.setNgayban(new Date());
            chiTietHoaDonService.addCTHD(chiTietHoaDon);
        }
        redirectAttributes.addFlashAttribute("thanhcong","Đặt hàng thành công ");

        return "redirect:/banhangonline/donhang";
    }

    @GetMapping("/donhang")
    public String hienthidonhang (Model model){

        String idkh = "7C6AC49D-21BC-4D6D-89EA-00D85BBA9DC6";
        List<HoaDonDAOCustom> hdchoxacnhan = hoaDonUserService.getHoaDonChoXacNhan(UUID.fromString(idkh));
        model.addAttribute("hdchoxacnhan",hdchoxacnhan);
        Integer listhdchoxacnhan = hdchoxacnhan.size();
        model.addAttribute("listhdchoxacnhan",listhdchoxacnhan);

        List<HoaDonDAOCustom> hdChoLayHang = hoaDonUserService.getHoaDonCholayHang(UUID.fromString(idkh));
        model.addAttribute("hdChoLayHang",hdChoLayHang);
        Integer listhdChoLayHang = hdChoLayHang.size();
        model.addAttribute("listhdChoLayHang",listhdChoLayHang);

        List<HoaDonDAOCustom> hdDangGiao = hoaDonUserService.getHoaDonDangGiao(UUID.fromString(idkh));
        model.addAttribute("hdDangGiao",hdDangGiao);
        Integer listhdDangGiao = hdDangGiao.size();
        model.addAttribute("listhdDangGiao",listhdDangGiao);

        List<HoaDonDAOCustom> hdDaGiao = hoaDonUserService.getHoaDonDaGiao(UUID.fromString(idkh));
        model.addAttribute("hdDaGiao",hdDaGiao);

        Integer listhdDaGiao = hdDaGiao.size();
        model.addAttribute("listhdDaGiao",listhdDaGiao);

        List<HoaDonDAOCustom> listhDaHuy = hoaDonUserService.getHoaDonDaHuy(UUID.fromString(idkh));
        model.addAttribute("listhDaHuy",listhDaHuy);
        Integer DaHuy = listhDaHuy.size();
        model.addAttribute("listDaHuy",DaHuy);

        List<HoaDonDAOCustom> getall = hoaDonUserService.getAll(UUID.fromString(idkh));
        model.addAttribute("getall",getall);

        return "user/donhang/showdonhang";
    }

    @GetMapping("/detailhd/{id}")
    public String detailHD(@PathVariable String id, Model model) {
        UUID orderId;
        try {
            orderId = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            // Xử lý lỗi nếu ID không hợp lệ
            return "error/invalidUUID"; // Hoặc trang lỗi phù hợp
        }
       HoaDon hoaDon = hoaDonService.getAllHoaDonById(orderId);
        model.addAttribute("hoaDon", hoaDon);
        List<ChiTietHoaDonCustom> chiTietHoaDonList = chiTietHoaDonService.findByHoaDonId(orderId);
        model.addAttribute("chiTietHoaDonList", chiTietHoaDonList);
        return "user/donhang/modaldonhang :: modalContent"; // Sử dụng cú pháp Thymeleaf fragment
    }


    @PostMapping("/huydh/{id}")
    public String huydonhang(@PathVariable UUID id,@RequestParam(value = "ghichu",
       defaultValue = "trong") String ghichu,
            Model model,RedirectAttributes redirectAttributes) {
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
         return "redirect:/banhangonline/donhang";
    }



}
