package poly.edu.duantotnghiep.infrastructures.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class NhanVienRequest {
    private UUID id;
    private String manhanvien;
    private String hovaten;
    private Date ngaysinh;
    private String gioitinh;
    private String diachi;
    private String sdt;
    private String email;
    private String matkhau;
    private String idcv;
    private String hinh;
    private int trangthai;
}
