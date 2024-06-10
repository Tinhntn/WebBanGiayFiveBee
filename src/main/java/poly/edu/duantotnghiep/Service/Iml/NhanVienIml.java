package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.NhanVien;
import poly.edu.duantotnghiep.Repository.NhanVienRepository;
import poly.edu.duantotnghiep.Service.NhanVienService;
import poly.edu.duantotnghiep.infrastructures.request.NhanVienRequest;

@Service
public class NhanVienIml implements NhanVienService {
    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public NhanVienRequest findNhanVienByEmailAndMatKhau(String email, String matKhau) {
        NhanVien nhanVien = nhanVienRepository.findNhanVienByEmailAndMatKhau(email, matKhau);
        if (nhanVien != null) {
            NhanVienRequest nhanVienRequest = new NhanVienRequest();
            nhanVienRequest.setEmail(nhanVien.getEmail());
            nhanVienRequest.setDiachi(nhanVien.getDiachi());
            nhanVienRequest.setGioitinh(nhanVien.getGioitinh());
            nhanVienRequest.setHinh(nhanVien.getHinh());
            nhanVienRequest.setHovaten(nhanVien.getHovaten());
            nhanVienRequest.setId(nhanVien.getId());
            nhanVienRequest.setMatkhau(nhanVien.getMatkhau());
            nhanVienRequest.setIdcv(nhanVien.getIdcv());
            nhanVienRequest.setManhanvien(nhanVien.getManhanvien());
            nhanVienRequest.setNgaysinh(nhanVien.getNgaysinh());
            nhanVienRequest.setSdt(nhanVien.getSdt());
            nhanVienRequest.setTrangthai(nhanVien.getTrangthai());
            return nhanVienRequest;
        } else {
            return null;
        }
    }
}
