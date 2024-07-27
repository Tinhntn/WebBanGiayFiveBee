package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "size")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String ma;
    private String ten;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;
}
