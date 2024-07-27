package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.Hang;
import poly.edu.duantotnghiep.Repository.HangRepository;
import poly.edu.duantotnghiep.Service.HangService;

import java.util.List;

@Service
public class HangIml implements HangService {

    @Autowired
    private HangRepository hangRepository;

    @Override
    public List<Hang> getHangALL() {
        return hangRepository.getHangALL();
    }

    @Override
    public void addHangModal(Hang hang) {
        hangRepository.save(hang);
    }
}
