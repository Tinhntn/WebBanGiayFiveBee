package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.Size;
import poly.edu.duantotnghiep.Repository.SizeRepository;
import poly.edu.duantotnghiep.Service.SizeService;

import java.util.List;

@Service
public class SizeIml implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getSizeALL() {
        return sizeRepository.getSizeALL();
    }

    @Override
    public void addSizeModal(Size size) {
        sizeRepository.save(size);
    }
}
