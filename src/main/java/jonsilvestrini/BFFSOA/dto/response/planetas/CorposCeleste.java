
package jonsilvestrini.BFFSOA.dto.response.planetas;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nome",
    "constelacao",
    "ascensao",
    "declinacao",
    "acima_horizonte",
    "visivel_olho_nu"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
public class CorposCeleste {

    @JsonProperty("nome")
    public String nome;
    @JsonProperty("constelacao")
    public String constelacao;
    @JsonProperty("ascensao")
    public Ascensao ascensao;
    @JsonProperty("declinacao")
    public Declinacao declinacao;
    @JsonProperty("acimaHorizonte")
    public Boolean acimaHorizonte;
    @JsonProperty("visivelOlhoNu")
    public Boolean visivelOlhoNu;

}
