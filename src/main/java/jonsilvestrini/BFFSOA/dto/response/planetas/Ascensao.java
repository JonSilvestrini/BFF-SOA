
package jonsilvestrini.BFFSOA.dto.response.planetas;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "negativo",
    "horas",
    "minutos",
    "segundos",
    "raw"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@Builder
public class Ascensao {

    @JsonProperty("negativo")
    public Boolean negativo;
    @JsonProperty("horas")
    public Integer horas;
    @JsonProperty("minutos")
    public Integer minutos;
    @JsonProperty("segundos")
    public Double segundos;

}
