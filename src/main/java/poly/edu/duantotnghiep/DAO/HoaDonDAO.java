package poly.edu.duantotnghiep.DAO;
import lombok.*;

import java.util.Date;

@Getter
@Setter
public class HoaDonDAO {
    private String idhoadon;
    private String mahoadon;
    private String tenhanvien;
    private String tenkhachhang;
    private Date ngaymua;
    private Double thanhTien;
    private Double khuyenmai;
    private String ghichu;
    private Date ngaytao;
    private Date ngaysua;
    private Double tongtien;
    private Double tongtiengiam;
    private int trangthai;
    private Double tienkhachdua;
}
