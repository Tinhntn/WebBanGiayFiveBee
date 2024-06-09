package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "giohangchitiet")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idgiohangchitiet;
    private String idgiohang;
    private String idchitietsanpham;
    private int soluong;
    private Float dongia;
    private Float dongiakhigiam;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;
}
