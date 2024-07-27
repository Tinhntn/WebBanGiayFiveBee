package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.infrastructures.Reponse.CalculateFeeResponse;
import poly.edu.duantotnghiep.infrastructures.request.CalculateFeeRequest;

public interface ShippingService {
    CalculateFeeResponse calculateFee(CalculateFeeRequest request);

}
