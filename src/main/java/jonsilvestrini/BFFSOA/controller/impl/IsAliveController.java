package jonsilvestrini.BFFSOA.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jonsilvestrini.BFFSOA.controller.Controller;
import jonsilvestrini.BFFSOA.dto.response.IsAliveDTO;
import jonsilvestrini.BFFSOA.service.IsAliveService;

@RestController
@Tag(name = "isalive")
public class IsAliveController extends Controller {
	@Autowired
	private IsAliveService isAliveService;

	@GetMapping(value = "/isalive")
	@Operation(summary = "endpoint para verificar se o servdor está em execução")
	public ResponseEntity<IsAliveDTO> testConnection(){
		return ResponseEntity.ok(isAliveService.check());

	}

}
