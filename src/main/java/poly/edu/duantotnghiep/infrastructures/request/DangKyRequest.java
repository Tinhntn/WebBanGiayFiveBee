package poly.edu.duantotnghiep.infrastructures.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DangKyRequest {

    @NotEmpty(message = "Không được để trống họ tên")
    private String hoTen;

    @NotEmpty(message = "Không được để trống email")
    @Email(message = "Email không đúng định dạng")
    private String emailDK;

    @NotEmpty(message = "Mật khẩu không được để trống")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{6,}$", message = "Mật khẩu phải có ít nhất 6 ký tự và chứa ít nhất một chữ và một số")
    private String matKhauDK;
}
