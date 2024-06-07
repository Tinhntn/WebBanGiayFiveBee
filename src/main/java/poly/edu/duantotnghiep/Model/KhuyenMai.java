package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "khuyenmai")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String makhuyenmai;
    private String tenkhuyenmai;
    private Float giatri;
    private Date ngaybatdau;
    private Date ngayketthuc;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;
}
