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
public class LichSuTrangThaiRequest {
    @NotEmpty(message = "Không được để trống idhoadon")
    private String idhoadon;

    @NotEmpty(message = "Không được để trống ghichu")
    private String ghichu;

    @NotEmpty(message = "Không được để trống trang thai")
    private int trangthai;
}
