package br.com.java.project.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** HttpsStatus.BAD_REQUEST
 * @author T3008LZG
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceBadRequestException extends RuntimeException {

	public ResourceBadRequestException(String message) {
		super(message);
	}

}
