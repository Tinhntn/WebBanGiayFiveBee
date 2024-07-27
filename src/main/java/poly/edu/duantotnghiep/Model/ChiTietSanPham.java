package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "chitietsanpham")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID idsanpham;
    private UUID hang;
    private UUID size;
    private UUID danhmuc;
    private UUID chatlieu;
    private UUID mausac;
    private UUID idkhuyenmai;
    private Float gianhap;
    private Float giaban;
    @Column(name = "QR", insertable = false, updatable = false)
    private String qr;
    private String hinhanh;
    private int soluong;
    private String mota;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;

}
