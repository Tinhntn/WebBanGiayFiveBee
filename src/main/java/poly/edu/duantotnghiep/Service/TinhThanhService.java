package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.infrastructures.Reponse.DistrictResponse;
import poly.edu.duantotnghiep.infrastructures.Reponse.ProvinceResponse;
import poly.edu.duantotnghiep.infrastructures.Reponse.WardResponse;

public interface TinhThanhService {
    ProvinceResponse getProvinces();
    DistrictResponse getDistricts(String provinceID);
    WardResponse getWards(String districtID);

}
