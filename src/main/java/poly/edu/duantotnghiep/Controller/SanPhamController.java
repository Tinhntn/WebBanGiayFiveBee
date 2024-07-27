package poly.edu.duantotnghiep.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.duantotnghiep.DAO.ChiTieSanPhamCustom;
import poly.edu.duantotnghiep.Model.*;
import poly.edu.duantotnghiep.Service.ChiTietSanPhamService;
import poly.edu.duantotnghiep.Service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private HangService hangService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private DanhMucService danhMucService;
    @Autowired
    private ChatLieuService chatLieuService;
    @Autowired
    private MauSacService mauSacService;

    @GetMapping("/hienthi")
    public String hienthi(Model model){

        List<SanPham> listSanPham = sanPhamService.getSanPhamALL();
        model.addAttribute("listSanPham", listSanPham);
        return "admin/sanpham/listSanPham";

    }

    @GetMapping("/showAddSanPham")
    public String showAddSanPhamForm() {
        return "admin/sanpham/addSanPham"; // tên của file JSP không cần phần mở rộng .jsp
    }

    @PostMapping("/addsanpham")
    public String addSanPham(@RequestParam("maSanPham") String maSanPham,
                             @RequestParam("tenSanPham") String tenSanPham,
                             @RequestParam("trangThai") Integer trangThai
                             ){

        Date ngayTao = new Date();

        SanPham sanPham = new SanPham();
        sanPham.setMasanpham(maSanPham);
        sanPham.setTensanpham(tenSanPham);
        sanPham.setNgaytao(ngayTao);
        sanPham.setTrangthai(trangThai);

        sanPhamService.addSanPham(sanPham);
        return "redirect:/sanpham/hienthi";

    }

    @GetMapping("deletesanpham/{id}")
    public String deleteSanPham(@PathVariable("id")UUID id){
        sanPhamService.deleteSanPham(id);
        return "redirect:/sanpham/hienthi";
    }

    @GetMapping("detailsanpham/{id}")
    public String detailSanPham(@PathVariable("id")UUID id, Model model){
        SanPham detailSanPham = sanPhamService.getSanPhamById(id);
        model.addAttribute("detailSanPham", detailSanPham);
        return "admin/sanpham/updateSanPham";
    }

    @PostMapping("/updatesanpham/{id}")
    public String updateSanPham(@PathVariable("id") UUID id,
                                @RequestParam("maSanPham") String maSanPham,
                                @RequestParam("tenSanPham") String tenSanPham,
                                @RequestParam("ngayTao") String ngayTao,
                                @RequestParam("trangThai") Integer trangThai
    ) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date ngaySua = new Date();
        Date ngayT = sdf.parse(ngayTao);


        SanPham sanPham = new SanPham();
        sanPham.setId(id);
        sanPham.setMasanpham(maSanPham);
        sanPham.setTensanpham(tenSanPham);
        sanPham.setNgaytao(ngayT);
        sanPham.setNgaysua(ngaySua);
        sanPham.setTrangthai(trangThai);

        sanPhamService.updateSanPham(sanPham,id);
        return "redirect:/sanpham/hienthi";

    }


    //Chi tiết sản phẩm


    @GetMapping("/getIdsanpham/{id}")
    public String getTenSanPham(@PathVariable("id") UUID id, Model model, @RequestParam(defaultValue = "0") int page){

        int size = 10;

        SanPham detailSanPham = sanPhamService.getSanPhamById(id);
        List<Hang> comboxHang = hangService.getHangALL();
        List<Size> comboxSize = sizeService.getSizeALL();
        List<DanhMuc> comboxDanhMuc = danhMucService.getDanhMucALL();
        List<ChatLieu> comboxChatLieu = chatLieuService.getChatLieuALL();
        List<MauSac> comboxMauSac = mauSacService.getMauSacALL();

        List<ChiTieSanPhamCustom> CTSP = chiTietSanPhamService.getChiTietSanPhamByIdSanPham(id);

        model.addAttribute("detailSanPham", detailSanPham);
        model.addAttribute("comboxHang", comboxHang);
        model.addAttribute("comboxSize", comboxSize);
        model.addAttribute("comboxDanhMuc", comboxDanhMuc);
        model.addAttribute("comboxChatLieu", comboxChatLieu);
        model.addAttribute("comboxMauSac", comboxMauSac);

        model.addAttribute("CTSP", CTSP);

        return "admin/sanpham/addCTSanPham";
    }


    @PostMapping("/addctsanpham/{id}")
    public String addCTSanPham(@PathVariable("id") UUID idSanPham,
                               @RequestParam("hang") UUID hang,
                               @RequestParam("size") UUID size,
                               @RequestParam("danhMuc") UUID danhMuc,
                               @RequestParam("chatLieu") UUID chatLieu,
                               @RequestParam("mauSac") UUID mauSac,
                               @RequestParam( value = "giaNhap" ,defaultValue = "0") Float giaNhap,
                               @RequestParam(value = "giaBan",defaultValue = "0") Float giaBan,
                               @RequestParam("hinhAnh") MultipartFile hinhAnh,
                               @RequestParam(value = "soLuong",defaultValue = "0") Integer soLuong,
                               @RequestParam("moTa") String moTa,
                               @RequestParam("trangThai") Integer trangThai
                                ) {

        // Lấy dữ liệu từ form và tạo đối tượng ChiTietSanPham
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setIdsanpham(idSanPham);
        ctsp.setHang(hang);
        ctsp.setSize(size);
        ctsp.setDanhmuc(danhMuc);
        ctsp.setChatlieu(chatLieu);
        ctsp.setMausac(mauSac);
        ctsp.setGianhap(giaNhap);
        ctsp.setGiaban(giaBan);
        ctsp.setSoluong(soLuong);
        ctsp.setMota(moTa);
        ctsp.setNgaytao(new Date());
        ctsp.setTrangthai(trangThai);

        // Xử lý tệp hình ảnh
        if (!hinhAnh.isEmpty()) {
            try {
                // Lấy tên gốc của file
                String fileName = hinhAnh.getOriginalFilename();

                // Thiết lập đường dẫn của file vào đối tượng ChiTietSanPham
                ctsp.setHinhanh("/img/" + fileName); // Đường dẫn để truy cập ảnh từ frontend
            } catch (Exception e) {
                e.printStackTrace();
                // Xử lý khi có lỗi xảy ra khi lưu tệp
            }
        }

           // Lưu chi tiết sản phẩm vào cơ sở dữ liệu
        chiTietSanPhamService.addChiTietSanPham(ctsp);

        return "redirect:/sanpham/getIdsanpham/" + idSanPham;
    }

    @GetMapping("/deleteCTSanPham/{idsp}")
    public String deleteCTSanPham(@PathVariable("idsp") UUID idSP, @RequestParam("id") UUID id){
        chiTietSanPhamService.deleteCTSanPham(id);
        return "redirect:/sanpham/getIdsanpham/" + idSP;
    }

    @GetMapping("/detailctsp/{id}")
    public String detailCTSP(@PathVariable("id") UUID id, @RequestParam("idctsp") UUID idCTSP, Model model){

        ChiTieSanPhamCustom detailCTSP = chiTietSanPhamService.getChiTietCustomSanPhamById(idCTSP);
        List<Hang> comboxHang = hangService.getHangALL();
        List<Size> comboxSize = sizeService.getSizeALL();
        List<DanhMuc> comboxDanhMuc = danhMucService.getDanhMucALL();
        List<ChatLieu> comboxChatLieu = chatLieuService.getChatLieuALL();
        List<MauSac> comboxMauSac = mauSacService.getMauSacALL();


        model.addAttribute("detailCTSP", detailCTSP);
        model.addAttribute("comboxHang", comboxHang);
        model.addAttribute("comboxSize", comboxSize);
        model.addAttribute("comboxDanhMuc", comboxDanhMuc);
        model.addAttribute("comboxChatLieu", comboxChatLieu);
        model.addAttribute("comboxMauSac", comboxMauSac);

        return "admin/sanpham/updateCTSanPham";
    }

    //Update chi tiết sản phẩm

    @PostMapping("/updatectsanpham")
    public String updateCTSanPham(@RequestParam("id") UUID idSanPham,
                               @RequestParam("idctsp") UUID idCTSP,
                               @RequestParam("hang") UUID hang,
                               @RequestParam("size") UUID size,
                               @RequestParam("danhMuc") UUID danhMuc,
                               @RequestParam("chatLieu") UUID chatLieu,
                               @RequestParam("mauSac") UUID mauSac,
                               @RequestParam("giaNhap") Float giaNhap,
                               @RequestParam("giaBan") Float giaBan,
                               @RequestParam("hinhAnh") MultipartFile hinhAnh,
                               @RequestParam("soLuong") Integer soLuong,
                               @RequestParam("moTa") String moTa,
                               @RequestParam("trangThai") Integer trangThai
    ) {
        // Lấy dữ liệu từ form và tạo đối tượng ChiTietSanPham
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setId(idCTSP);
        ctsp.setIdsanpham(idSanPham);
        ctsp.setHang(hang);
        ctsp.setSize(size);
        ctsp.setDanhmuc(danhMuc);
        ctsp.setChatlieu(chatLieu);
        ctsp.setMausac(mauSac);
        ctsp.setGianhap(giaNhap);
        ctsp.setGiaban(giaBan);
        ctsp.setSoluong(soLuong);
        ctsp.setMota(moTa);
        ctsp.setNgaytao(new Date());
        ctsp.setTrangthai(trangThai);

        // Xử lý tệp hình ảnh
        if (!hinhAnh.isEmpty()) {
            try {
                // Lấy tên gốc của file
                String fileName = hinhAnh.getOriginalFilename();

                // Thiết lập đường dẫn của file vào đối tượng ChiTietSanPham
                ctsp.setHinhanh("/img/" + fileName); // Đường dẫn để truy cập ảnh từ frontend
            } catch (Exception e) {
                e.printStackTrace();
                // Xử lý khi có lỗi xảy ra khi lưu tệp
            }
        }

        // Lưu chi tiết sản phẩm vào cơ sở dữ liệu
        chiTietSanPhamService.updateChiTietSanPham(ctsp, idCTSP);

        return "redirect:/sanpham/getIdsanpham/" + idSanPham;
    }


    //Add hãng nhanh modal
    @PostMapping("/addhangmodal/{id}")
    public String addHangModal(@PathVariable("id") UUID id,
                               @RequestParam("mahang") String maHang,
                               @RequestParam("tenhang") String tenHang,
                               @RequestParam("trangthai") Integer trangThai
                                ){
        Hang hang = new Hang();
        hang.setMahang(maHang);
        hang.setTenhang(tenHang);
        hang.setNgaytao(new Date());
        hang.setTrangthai(trangThai);

        hangService.addHangModal(hang);

        return "redirect:/sanpham/getIdsanpham/" + id;
    }

    //Add Size nhanh modal
    @PostMapping("/addsizemodal/{id}")
    public String addSizeModal(@PathVariable("id") UUID id,
                               @RequestParam("masize") String maSize,
                               @RequestParam("tensize") String tenSize,
                               @RequestParam("trangthai") Integer trangThai
    ){
        Size size = new Size();
        size.setMa(maSize);
        size.setTen(tenSize);
        size.setNgaytao(new Date());
        size.setTrangthai(trangThai);

        sizeService.addSizeModal(size);

        return "redirect:/sanpham/getIdsanpham/" + id;
    }

    //Add Chất Liệu nhanh modal
    @PostMapping("/addchatlieumodal/{id}")
    public String addchatlieuModal(@PathVariable("id") UUID id,
                               @RequestParam("machatlieu") String maCL,
                               @RequestParam("tenchatlieu") String tenCL,
                               @RequestParam("trangthai") Integer trangThai
    ){
        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setMa(maCL);
        chatLieu.setTen(tenCL);
        chatLieu.setNgaytao(new Date());
        chatLieu.setTrangthai(trangThai);

        chatLieuService.addChatLieuModal(chatLieu);

        return "redirect:/sanpham/getIdsanpham/" + id;
    }

    //Add Danh Mục nhanh modal
    @PostMapping("/adddanhmucmodal/{id}")
    public String addDanhMucModal(@PathVariable("id") UUID id,
                                   @RequestParam("madanhmuc") String maDM,
                                   @RequestParam("tendanhmuc") String tenDM,
                                   @RequestParam("trangthai") Integer trangThai
    ){
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setMa(maDM);
        danhMuc.setTen(tenDM);
        danhMuc.setNgaytao(new Date());
        danhMuc.setTrangthai(trangThai);

        danhMucService.addDanhMucModal(danhMuc);

        return "redirect:/sanpham/getIdsanpham/" + id;
    }

    //Add Màu Sắc nhanh modal
    @PostMapping("/addmausacmodal/{id}")
    public String addMauSacModal(@PathVariable("id") UUID id,
                                  @RequestParam("mamausac") String maMS,
                                  @RequestParam("tenmausac") String tenMS,
                                  @RequestParam("trangthai") Integer trangThai
    ){
        MauSac mauSac = new MauSac();
        mauSac.setMa(maMS);
        mauSac.setTen(tenMS);
        mauSac.setNgaytao(new Date());
        mauSac.setTrangthai(trangThai);

        mauSacService.addMauSac(mauSac);

        return "redirect:/sanpham/getIdsanpham/" + id;
    }

}
