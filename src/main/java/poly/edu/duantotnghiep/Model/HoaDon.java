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
    private String idkhachhang;
    @Temporal(TemporalType.DATE)
    private Date ngaymua;
    private Float thanhtien;
    private String idkhuyenmai;
    private String ghichu;
    @Temporal(TemporalType.DATE)
    private Date ngaytao;
    @Temporal(TemporalType.DATE)
    private Date ngaysua;
<<<<<<< HEAD
=======
    private Float tongtien;
    private Float tienkhachdua;
>>>>>>> 251681b45cf1ae81cf7964a04672666a8f57dc33
    private Float tongtiengiam;
    private int trangthai;
}
