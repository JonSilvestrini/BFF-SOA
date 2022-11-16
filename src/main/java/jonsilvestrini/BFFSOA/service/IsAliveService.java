package jonsilvestrini.BFFSOA.service;

import org.springframework.stereotype.Service;

import jonsilvestrini.BFFSOA.dto.response.IsAliveDTO;

@Service
public class IsAliveService {
	
	public IsAliveDTO check() {
		var isAlive = new IsAliveDTO();
		isAlive.setAlive(true);
		isAlive.setMsg("Servidor está ok!");
		return isAlive;
		
	}
	
}
