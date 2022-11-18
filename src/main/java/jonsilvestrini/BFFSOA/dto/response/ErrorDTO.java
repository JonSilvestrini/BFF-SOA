package jonsilvestrini.BFFSOA.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorDTO{
	@JsonProperty("code")
	private Integer code;

	@JsonProperty("msg")
	private String msg;

	@JsonProperty("exceptionMsg")
	private String exceptionMsg;

}
