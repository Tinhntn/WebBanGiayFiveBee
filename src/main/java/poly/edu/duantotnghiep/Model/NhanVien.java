package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "nhanvien")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String manhanvien;
    private String hovaten;
    private Date ngaysinh;
    private String gioitinh;
    private String diachi;
    private String sdt;
    private String email;
    private String matkhau;
    private String idcv;
    private String hinh;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;
}
