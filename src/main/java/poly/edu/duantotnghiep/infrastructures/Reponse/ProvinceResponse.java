package poly.edu.duantotnghiep.infrastructures.Reponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProvinceResponse {
    private int code;
    private String message;
    private List<Province> data;

    @Getter
    @Setter
    public static class Province{
        @JsonProperty("ProvinceID")
        private int ProvinceID;
        @JsonProperty("ProvinceName")
        private String ProvinceName;
    }



}
