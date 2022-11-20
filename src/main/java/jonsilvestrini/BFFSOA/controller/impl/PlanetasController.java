package jonsilvestrini.BFFSOA.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jonsilvestrini.BFFSOA.controller.Controller;
import jonsilvestrini.BFFSOA.dto.response.ErrorDTO;
import jonsilvestrini.BFFSOA.dto.response.PlanetaDetalheDTO;
import jonsilvestrini.BFFSOA.dto.response.planetas.PlanetaVisivelResponseDTO;
import jonsilvestrini.BFFSOA.service.PlanetaService;

@RestController
@RequestMapping("/planetas")
@Tag(name = "Planetas Visíveis")
public class PlanetasController extends Controller{
	@Autowired
	private PlanetaService planetaVisivelServico;

	@Operation(summary = "Consulta planetas visíveis e informação sobre o clima")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = PlanetaVisivelResponseDTO.class))),
			@ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
	})
	@GetMapping("/visiveis")
	public ResponseEntity<?> getPlanetasVisiveis(HttpServletRequest request){
		try {
			return ResponseEntity.ok(planetaVisivelServico.getPlanetaVisivel(request));
		} catch (Exception e) {
			return this.errorHandler(e);
		}
	}

	@Operation(summary = "Detalhes sobre o planeta")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = PlanetaDetalheDTO.class))),
			@ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
	})
	@GetMapping("/detalhe/{name}")
	public ResponseEntity<?> getPlanetaDetalhe(@PathVariable("name") String name){
		try {
			return ResponseEntity.ok(planetaVisivelServico.getPlanetaDetalhe(name));
		} catch (Exception e) {
			return this.errorHandler(e);
		}
	}

}
