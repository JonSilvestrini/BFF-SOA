package jonsilvestrini.BFFSOA.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jonsilvestrini.BFFSOA.constants.ErrorMessages;
import jonsilvestrini.BFFSOA.dto.response.ErrorDTO;
import jonsilvestrini.BFFSOA.exception.NotFoundException;

public class Controller {

	protected ResponseEntity<ErrorDTO> errorHandler(Exception e) {
		e.printStackTrace();
		if (e instanceof NotFoundException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDTO.builder()
					.code(HttpStatus.NOT_FOUND.value())
					.msg(ErrorMessages.NOT_FOUND)
					.exceptionMsg(e.getMessage()).build());
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorDTO.builder()
				.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.msg(ErrorMessages.INTERNAL_SERVER)
				.exceptionMsg(e.getMessage()).build());

	}

}
