
package jonsilvestrini.BFFSOA.dto.response.terra;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "urlImage",
    "dateTime",
    "coord"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@Builder
public class TerraImagemDTO {

    @JsonProperty("urlImage")
    public String urlImage;
    @JsonProperty("dateTime")
    public String dateTime;
    @JsonProperty("coord")
    public Coord coord;

}
