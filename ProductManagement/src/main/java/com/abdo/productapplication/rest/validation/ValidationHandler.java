package com.abdo.productapplication.rest.validation;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * 
 * Exception Handler. 
 * This class handle the validation errors and create the List of  ValidationErrorListDTO
 * 
 * @author atawakol
 *
 */
@ControllerAdvice
public class ValidationHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody()
    public ValidationErrorListDTO processValidationError(MethodArgumentNotValidException ex) {
        
		ValidationErrorListDTO dto = new ValidationErrorListDTO();
		BindingResult result = ex.getBindingResult();
       
        result.getFieldErrors().stream().forEach(fe -> dto.addFieldError(fe.getField(), fe.getDefaultMessage()));
        
        return dto;
    }
 
	
}
