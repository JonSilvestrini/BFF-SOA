
package jonsilvestrini.BFFSOA.dto.response.planetas;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ceu",
    "visibilidade",
    "nuvens"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
public class Clima {

    @JsonProperty("ceu")
    public String ceu;
    @JsonProperty("visibilidade")
    public Integer visibilidade;
    @JsonProperty("nuvens")
    public Integer nuvens;

}
