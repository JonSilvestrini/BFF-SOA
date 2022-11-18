
package jonsilvestrini.BFFSOA.dto.response.planetas;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "corposCelestes",
    "clima"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
public class PlanetaVisivelResponseDTO{

    @JsonProperty("corposCelestes")
    public List<CorposCeleste> corposCelestes = null;
    @JsonProperty("clima")
    public Clima clima;

}
