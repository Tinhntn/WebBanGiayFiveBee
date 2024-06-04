package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "chitiethoadon")
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID idhoadon;
    private UUID idchitietsanpham;
    private int soluong;
    private Float dongia;
    private Date ngayban;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;
}
