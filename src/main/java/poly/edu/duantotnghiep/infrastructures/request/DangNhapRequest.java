package poly.edu.duantotnghiep.infrastructures.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DangNhapRequest {
    @NotEmpty(message = "Không được để trống email")
    private String email;

    @NotEmpty(message = "Không được để trống mật khẩu")
    private String matKhau;
}
