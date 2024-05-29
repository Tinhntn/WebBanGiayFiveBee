package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "hoadon")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String maHoaDon;
    private String idNhanVien;
    private String idKhachHang;
    private Date ngayMua;
    private Float thanhTien;
    private String idKhuyenMai;
    private String ghiChu;
    private Date ngayTao;
    private Date ngaySua;
    private Float tongTien;
    private Float tongTienGiam;
    private int trangThai;
}
