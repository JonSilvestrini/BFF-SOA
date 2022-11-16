package jonsilvestrini.BFFSOA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jonsilvestrini.BFFSOA.dto.response.IsAliveDTO;
import jonsilvestrini.BFFSOA.service.IsAliveService;

@RestController
public class IsAliveController {
	@Autowired
	private IsAliveService isAliveService;
	
	@GetMapping(value = "/isalive")
	public ResponseEntity<IsAliveDTO> testConnection(){
		return ResponseEntity.ok(isAliveService.check());
		
	}

}
