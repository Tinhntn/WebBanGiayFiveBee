package poly.edu.duantotnghiep.infrastructures.Reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WardResponse {
    private int code;
    private String message;
    private List<District> data;

    @Getter
    @Setter
    public static class District{
        @JsonProperty("WardCode")
        private int WardCode;
        @JsonProperty("DistrictID")
        private int DistrictID;
        @JsonProperty("WardName")
        private String WardName;
    }
}
