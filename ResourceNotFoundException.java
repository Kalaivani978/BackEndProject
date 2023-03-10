package com.example.FSJDSwiggy.ExceptionHandling;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/* To handle the exception in our project we used ResourceNotFoundexception class.
 * we have also extend the parent exception which is RuntimeException.
 * if the user have exception. To identify which exception, we have used the serialVersionUID. if the serialVers
 * ionUID is 1L, then the exception is resourceNotFound. 
 * 
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
 
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}