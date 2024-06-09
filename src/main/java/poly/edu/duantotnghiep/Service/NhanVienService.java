package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.Model.NhanVien;
import poly.edu.duantotnghiep.infrastructures.request.NhanVienRequest;

public interface NhanVienService {
    NhanVienRequest findNhanVienByEmailAndMatKhau(String email, String matKhau);

}
