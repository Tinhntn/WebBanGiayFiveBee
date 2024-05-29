package poly.edu.duantotnghiep.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.Date;
import java.util.UUID;

@Table(name = "mausac")
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String ma;
    private String ten;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;

}
