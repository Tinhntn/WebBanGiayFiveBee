package poly.edu.duantotnghiep.infrastructures.request;

import com.microsoft.sqlserver.jdbc.StringUtils;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class KhachHangRequest {
    @NotBlank(message = "Họ và tên không được trống")
    private String hoVaTen;

    @Email(message = "Địa chỉ email không hợp lệ")
    private String email;

    @NotBlank(message = "Không được để trống số điện thoại")
    private String soDienThoai;

    @NotEmpty(message = "Mật Khẩu không được để trống")
    private String matKhau;

    @NotBlank(message = "Địa chỉ không được trống")
    private String diaChi;

    @NotBlank(message = "Không được để trống mã khách hàng")
    private String makhachhang;

    @NotBlank(message = "Không được để trống loại khách hàng")
    private String loaikhachhang;

    @NotBlank(message = "Không được đê trống giới tính")
    private String gioitinh;

    @NotBlank(message = "Không được để trống ngày sinh")
    private Date ngaysinh;

    @NotBlank(message = "Không được để trống ngày tham gia")
    private Date ngaythamgia;

    @NotBlank(message = "Không được để trống tích điểm")
    private int tichdiem;

    @NotBlank(message = "Không được để trống điểm exp")
    private int diemexp;

    @NotBlank(message = "Không được để trống ngày sửa")
    private Date ngaytao;

    @NotBlank(message = "Không được để trống ngày sửa")
    private Date ngaysua;

    @NotBlank(message = "Không được để trống trạng thái")
    private int trangthai;


    public boolean validNull() {
        return
                StringUtils.isEmpty(hoVaTen) ||
                        email == null ||
                        soDienThoai == null ||
                        matKhau == null ||
                        diaChi == null||
                        hoVaTen==null||
                        gioitinh==null||
                        ngaytao==null||
                        ngaysua==null;


    }
}
