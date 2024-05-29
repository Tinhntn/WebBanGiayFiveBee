package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "giohang")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID idgiohang;
    private String idnhanvien;
    private String idkhachhang;
    private String idkhuyenmai;
    private String magiohang;
    private Date ngaymua;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;
    private String ghichu;

}
