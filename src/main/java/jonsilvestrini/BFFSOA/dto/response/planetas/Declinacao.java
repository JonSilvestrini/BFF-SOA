
package jonsilvestrini.BFFSOA.dto.response.planetas;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "negativo",
    "grau",
    "minutos",
    "segundos",
    "raw"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
public class Declinacao {

    @JsonProperty("negativo")
    public Boolean negativo;
    @JsonProperty("grau")
    public Integer grau;
    @JsonProperty("minutos")
    public Integer minutos;
    @JsonProperty("segundos")
    public Double segundos;
    @JsonProperty("raw")
    public Double raw;

}
