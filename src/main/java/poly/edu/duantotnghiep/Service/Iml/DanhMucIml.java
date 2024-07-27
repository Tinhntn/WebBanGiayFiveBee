package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.DanhMuc;
import poly.edu.duantotnghiep.Repository.DanhMucRepository;
import poly.edu.duantotnghiep.Service.DanhMucService;

import java.util.List;

@Service
public class DanhMucIml implements DanhMucService {

    @Autowired
    private DanhMucRepository danhMucRepository;

    @Override
    public List<DanhMuc> getDanhMucALL() {
        return danhMucRepository.getDanhMucALL();
    }

    @Override
    public void addDanhMucModal(DanhMuc danhMuc) {
        danhMucRepository.save(danhMuc);
    }
}
