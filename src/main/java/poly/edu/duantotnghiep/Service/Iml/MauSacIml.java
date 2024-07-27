package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.MauSac;
import poly.edu.duantotnghiep.Repository.MauSacRepository;
import poly.edu.duantotnghiep.Service.MauSacService;

import java.util.List;

@Service
public class MauSacIml implements MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getMauSacALL() {
        return mauSacRepository.getMauSacALL();
    }

    @Override
    public void addMauSac(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }
}
