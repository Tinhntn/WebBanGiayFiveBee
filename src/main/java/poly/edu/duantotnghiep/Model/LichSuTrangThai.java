package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "lichsutrangthai")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LichSuTrangThai {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String idhoadon;
    private Date thoigian;
    private int trangthai;
    private String ghichu;
}
