package poly.edu.duantotnghiep.infrastructures.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculateFeeRequest {
    int service_type_id;
    int from_district_id;
    int to_district_id;
    String to_ward_code;
    int height;
    int length;
    int weight;
    int width;

}
