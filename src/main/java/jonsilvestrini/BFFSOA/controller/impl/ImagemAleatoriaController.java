package jonsilvestrini.BFFSOA.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jonsilvestrini.BFFSOA.controller.Controller;
import jonsilvestrini.BFFSOA.dto.response.ErrorDTO;
import jonsilvestrini.BFFSOA.dto.response.ImagemAleatoriaDTO;
import jonsilvestrini.BFFSOA.service.ImagemService;

@RestController
@Tag(name = "Imagens")
public class ImagemAleatoriaController extends Controller {

	@Autowired
	private ImagemService imagemService;

	@Operation(summary = "Mostra Imagens aleatórias relacionadas a NASA")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ImagemAleatoriaDTO.class))),
			@ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
	})
	@GetMapping("/nasa/imagem")
	public ResponseEntity<?> getImagem(){
		try {
			return ResponseEntity.ok(imagemService.getImagem());
		} catch (Exception e) {
			return this.errorHandler(e);
		}
	}

}
