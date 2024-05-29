package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "khachhang")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String makhachhang;
    private String loaikhachhang;
    private String tenkhachhang;
    private String diachi;
    private String gioitinh;
    private String email;
    private String sdt;
    private Date ngaysinh;
    private Date ngaythamgia;
    private int tichdiem;
    private int diemexp;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;

}
