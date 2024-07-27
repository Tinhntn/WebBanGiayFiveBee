package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import poly.edu.duantotnghiep.Service.TinhThanhService;
import poly.edu.duantotnghiep.infrastructures.Reponse.DistrictResponse;
import poly.edu.duantotnghiep.infrastructures.Reponse.ProvinceResponse;
import poly.edu.duantotnghiep.infrastructures.Reponse.WardResponse;

@Service
public class TinhThanhServiceImpl implements TinhThanhService {

    @Value("${ghn.api.key}")
    private String apiKey;

    private static final String PROVINCE_URL = "https://online-gateway.ghn.vn/shiip/public-api/master-data/province";
    private static final String DISTRICT_URL = "https://online-gateway.ghn.vn/shiip/public-api/master-data/district";
    private static final String WARD_URL = "https://online-gateway.ghn.vn/shiip/public-api/master-data/ward";

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Token", apiKey);
        return headers;
    }

    @Override
    public ProvinceResponse getProvinces() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ProvinceResponse> response = restTemplate.exchange(
                PROVINCE_URL,
                HttpMethod.GET,
                entity,
                ProvinceResponse.class
        );

        return response.getBody();
    }

    @Override
    public DistrictResponse getDistricts(String provinceID) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = DISTRICT_URL + "?province_id=" + provinceID;
        ResponseEntity<DistrictResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                DistrictResponse.class
        );

        return response.getBody();
    }

    @Override
    public WardResponse getWards(String districtID) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = WARD_URL + "?district_id=" + districtID;
        ResponseEntity<WardResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                WardResponse.class
        );

        return response.getBody();
    }

}
