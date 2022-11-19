
package jonsilvestrini.BFFSOA.dto.response.terra;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lon"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
public class Coord {

    @JsonProperty("lat")
    public Double lat;
    @JsonProperty("lon")
    public Double lon;

}
