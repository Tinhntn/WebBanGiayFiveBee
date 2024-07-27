package poly.edu.duantotnghiep.DAO;

import java.util.Date;
import java.util.UUID;

public interface MauSacCustom {
    UUID getId();
    String getMa();
    String getTen();
    Date getNgaySua();
    Date getNgayTao();
    int getTrangThai();
}
