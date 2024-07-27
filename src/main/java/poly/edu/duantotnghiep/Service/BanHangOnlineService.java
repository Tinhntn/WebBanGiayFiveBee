package poly.edu.duantotnghiep.Service;

import org.springframework.data.repository.query.Param;
import poly.edu.duantotnghiep.DAO.*;
import poly.edu.duantotnghiep.Model.Size;

import java.util.List;
import java.util.UUID;

public interface BanHangOnlineService {

    List<SizeCustom> getSizeById(UUID id, UUID idDanhMuc, UUID idHang,UUID idMauSac, UUID idChatLieu);
    List<MauSacCustom> getMauSacByIdSP(UUID id);
    UUID getIdSPById(UUID id);
    List<ChiTietSanPhamUserCustom> getAllCTSP();
    ChiTieSanPhamCustom timkiemCTSP(UUID idSanPham,UUID idMauSac,UUID idChatLieu,UUID idHang,UUID idSize,UUID idDanhMuc);
}
