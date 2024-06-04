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
    private Float tongtien;
    private Float tienkhachdua;
    private Float tongtiengiam;
    private int trangthai;
}
