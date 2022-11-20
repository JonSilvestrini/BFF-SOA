package jonsilvestrini.BFFSOA.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ImagemAleatoriaDTO {
    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("explicacao")
    private String explicacao;

    @JsonProperty("data")
    private String data;

    @JsonProperty("urlImagem")
    private String urlImagem;

}
