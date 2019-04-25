package br.com.java.project.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class ResourceCreatedException extends RuntimeException {
	
	public ResourceCreatedException(String message){
		super(message);
		
	}

}
