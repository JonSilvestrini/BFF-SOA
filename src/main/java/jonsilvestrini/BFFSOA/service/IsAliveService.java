package jonsilvestrini.BFFSOA.service;

import java.util.concurrent.Future;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import jonsilvestrini.BFFSOA.dto.response.IsAliveDTO;
import jonsilvestrini.BFFSOA.external.WebClientEngine;

@Service
public class IsAliveService {
	private WebClientEngine webCliEng = new WebClientEngine();
	
	public IsAliveDTO check() {
		System.out.println("");
		Future<String> res = webCliEng.callUrl("https://visible-planets-api.herokuapp.com/v3?latitude=-22.5838&longitude=-47.4098");
		var isAlive = new IsAliveDTO();
		isAlive.setAlive(true);
		isAlive.setMsg("Servidor está ok!");
		JSONObject obj;
		try {
			obj = new JSONObject(res.get());
			JSONObject meta = obj.getJSONObject("meta");
			String time = meta.getString("time");
			System.out.println(time);
		} catch (Exception e) {
			System.out.println(e);
		}
		return isAlive;
		
	}
	
}
