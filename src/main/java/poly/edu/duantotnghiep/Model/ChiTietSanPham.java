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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String idsanpham;
    private String size;
    private String danhmuc;
    private String chatlieu;
    private String mausac;
    private String idkhuyenmai;
    private Float gianhap;
    private Float giaban;
    private String qr;
    private String hinhanh;
    private int soluong;
    private String mota;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;

}
