package poly.edu.duantotnghiep.DAO;



import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class ChiTietSanPhamDAO {
    private UUID id;
    private String tensanpham;
    private String tenhang;
    private String tensize;
    private String tendanhmuc;
    private String tenchatlieu;
    private String tenmausac;
    private String tenkhuyenmai;
    private Double gianhap;
    private Double giaban;
    private String qr;
    private String hinhanh;
    private int soluong;
    private String mota;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;
}
