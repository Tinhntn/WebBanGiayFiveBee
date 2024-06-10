package poly.edu.duantotnghiep.infrastructures.Reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangReponse {
    private UUID id;
    private String makhachhang;
    private String loaikhachhang;
    private String tenkhachhang;
    private String diachi;
    private String gioitinh;
    private String email;
    private String matkhau;
    private String sdt;
}
