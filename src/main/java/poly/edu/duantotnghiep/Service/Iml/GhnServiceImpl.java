package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import poly.edu.duantotnghiep.Service.ShippingService;
import poly.edu.duantotnghiep.infrastructures.Reponse.CalculateFeeResponse;
import poly.edu.duantotnghiep.infrastructures.request.CalculateFeeRequest;

@Service
public class GhnServiceImpl implements ShippingService {

    @Value("${ghn.api.url}")
    private String apiUrl;

    @Value("${ghn.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GhnServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public CalculateFeeResponse calculateFee(CalculateFeeRequest request) {
        String url = apiUrl; // Điều chỉnh endpoint theo API của bạn
        HttpHeaders headers = new HttpHeaders();
        headers.set("Token", apiKey);
        HttpEntity<CalculateFeeRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<CalculateFeeResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, CalculateFeeResponse.class);
        return response.getBody();
    }


}
