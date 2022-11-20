package jonsilvestrini.BFFSOA.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jonsilvestrini.BFFSOA.controller.Controller;
import jonsilvestrini.BFFSOA.dto.response.ErrorDTO;
import jonsilvestrini.BFFSOA.dto.response.terra.TerraImagemDTO;
import jonsilvestrini.BFFSOA.service.TerraService;

@RestController
@Tag(name = "Terra")
public class TerraController extends Controller {

	@Autowired
	private TerraService terraService;

	@Operation(summary = "Mostra Imagens da Terra")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(
					schema = @Schema(implementation = TerraImagemDTO.class)))),
			@ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
	})
	@GetMapping("/terra/{date}")
	public ResponseEntity<?> getPlanetasVisiveis(@PathVariable(name = "date") String date){
		try {
			return ResponseEntity.ok(terraService.getTerraImages(date));
		} catch (Exception e) {
			return this.errorHandler(e);
		}
	}

}
