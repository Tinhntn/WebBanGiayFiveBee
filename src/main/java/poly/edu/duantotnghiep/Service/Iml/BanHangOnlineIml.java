package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.DAO.*;
import poly.edu.duantotnghiep.Model.Size;
import poly.edu.duantotnghiep.Repository.BanHangOnlineRepository;
import poly.edu.duantotnghiep.Repository.MauSacRepository;
import poly.edu.duantotnghiep.Repository.SizeRepository;
import poly.edu.duantotnghiep.Service.BanHangOnlineService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BanHangOnlineIml implements BanHangOnlineService {

    @Autowired
    private BanHangOnlineRepository banHangOnlineRepository;

    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private MauSacRepository mauSacRepository;



    @Override
    public List<SizeCustom> getSizeById(UUID id, UUID idDanhMuc, UUID idHang,UUID idMauSac, UUID idChatLieu) {
        return sizeRepository.getSizeDetailsByIdSanPhamAndCriteria(id,idDanhMuc,idHang,idMauSac,idChatLieu);
    }

    @Override
    public List<MauSacCustom> getMauSacByIdSP(UUID id) {
        return mauSacRepository.getMauSacDetailsByIdSanPham(id);
    }

    @Override
    public UUID getIdSPById(UUID id) {
        return banHangOnlineRepository.getIdSPById(id);
    }

    @Override
    public List<ChiTietSanPhamUserCustom> getAllCTSP() {
        return banHangOnlineRepository.getAllSP();
    }

    @Override
    public ChiTieSanPhamCustom timkiemCTSP(UUID idSanPham, UUID idMauSac, UUID idChatLieu, UUID idHang, UUID idSize, UUID idDanhMuc) {
        return banHangOnlineRepository.timkiemCTSP(idSanPham,idMauSac,idChatLieu,idHang,idSize,idDanhMuc);
    }
}
