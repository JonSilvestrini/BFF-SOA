package jonsilvestrini.BFFSOA.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IsAliveDTO {
	@JsonProperty("isAlive")
	private boolean isAlive;
	
	@JsonProperty("msg")
	private String msg;

}
