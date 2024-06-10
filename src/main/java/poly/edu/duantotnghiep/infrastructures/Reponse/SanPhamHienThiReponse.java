package poly.edu.duantotnghiep.infrastructures.Reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamHienThiReponse {
    private UUID id;
    private String ten;
    private String anh;
    private BigDecimal gia;
    private Integer idMauSac;
    private Date ngayTao;
}

