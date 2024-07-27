package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.Model.Hang;

import java.util.List;

public interface HangService {
    List<Hang> getHangALL();
    void addHangModal(Hang hang);

}
