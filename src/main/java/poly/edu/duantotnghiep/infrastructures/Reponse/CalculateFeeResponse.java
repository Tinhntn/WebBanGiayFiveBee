package poly.edu.duantotnghiep.infrastructures.Reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateFeeResponse {
    private int code;
    private String message;
    private Data data;

    @Getter
    @Setter
    public static class Data {
        @JsonProperty("total")
        private int total;
//        private int service_fee;
//        private int insurance_fee;
//        private int pick_station_fee;
//        private int coupon_value;
//        private int r2s_fee;
    }
}
