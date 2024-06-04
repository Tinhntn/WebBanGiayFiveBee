package poly.edu.duantotnghiep.DAO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class KhachHangDAO {

    private UUID id;
    private String makhachhang;
    private String loaikhachhang;
    private String tenkhachhang;
    private String diachi;
    private String gioitinh;
    private String email;
    private String sdt;
    private Date ngaysinh;
    private Date ngaythamgia;
    private int tichdiem;
    private int diemexp;
    private Date ngaytao;
    private Date ngaysua;
    private int trangthai;

}
