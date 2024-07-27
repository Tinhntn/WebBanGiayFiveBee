package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.Model.DanhMuc;

import java.util.List;

public interface DanhMucService {

    List<DanhMuc> getDanhMucALL();

    void addDanhMucModal(DanhMuc danhMuc);

}
