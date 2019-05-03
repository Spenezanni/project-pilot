package br.com.java.project.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class ResourceCreatedException extends RuntimeException {
	
	/**
	 * Created Valid for real 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceCreatedException(String message){
		super(message);
		
	}

}
