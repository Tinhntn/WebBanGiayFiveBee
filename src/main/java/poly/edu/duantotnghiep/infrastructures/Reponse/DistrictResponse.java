package poly.edu.duantotnghiep.infrastructures.Reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistrictResponse {
    private int code;
    private String message;
    private List<District> data;

    @Getter
    @Setter
    public static class District{
        @JsonProperty("DistrictID")
        private int DistrictID;
        @JsonProperty("ProvinceID")
        private int ProvinceID;
        @JsonProperty("DistrictName")
        private String DistrictName;
    }
}
