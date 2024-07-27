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
    private String mahoadon;
    private String idnhanvien;
    private UUID idkhachhang;
    @Temporal(TemporalType.DATE)
    private Date ngaymua;
    private Float thanhtien;
    private UUID idkhuyenmai;
    private String ghichu;
    private String tinhthanh;
    private String quanhuyen;
    private String phuongxa;
    private String tennguoinhan;
    private String sdtnguoinhan;
    private String emailnguoinhan;
    private String donvigiao;
    private Float phiship;
    private Integer loaihoadon;
    private Integer loaithanhtoan;
    @Temporal(TemporalType.DATE)
    private Date ngaytao;
    @Temporal(TemporalType.DATE)
    private Date ngaysua;
    private Float tongtien;
    private Float tienkhachdua;
    private Float tongtiengiam;
    private String sdtnguoigiao;
    private String tennguoigiao;

    private int trangthai;
}
