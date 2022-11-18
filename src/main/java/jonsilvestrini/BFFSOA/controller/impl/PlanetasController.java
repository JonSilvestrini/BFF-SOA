package jonsilvestrini.BFFSOA.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
import jonsilvestrini.BFFSOA.dto.response.planetas.PlanetaVisivelResponseDTO;

@RestController
@RequestMapping("/planetas")
@Tag(name = "Planetas Visíveis")
public class PlanetasController extends Controller{


	@Operation(summary = "Consulta planetas visíveis e informação sobre o clima")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = PlanetaVisivelResponseDTO.class))),
			@ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
	})
	@GetMapping("/visiveis")
	public ResponseEntity<?> getPlanetasVisiveis(){
		try {
			return ResponseEntity.ok(new PlanetaVisivelResponseDTO());
		} catch (Exception e) {
			return this.errorHandle(e);
		}
	}

}
