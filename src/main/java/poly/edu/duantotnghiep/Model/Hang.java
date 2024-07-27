package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "hang")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idhang;
    private String mahang;
    private String tenhang;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;
}
