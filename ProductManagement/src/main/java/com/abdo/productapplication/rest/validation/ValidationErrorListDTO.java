package com.abdo.productapplication.rest.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorListDTO {
	
	private List<FieldErrorDTO> errorsList = new ArrayList<>();
	 
 
    public void addFieldError(String field, String error) {
        FieldErrorDTO errorDto = new FieldErrorDTO(field, error);
        errorsList.add(errorDto);
    }


	public List<FieldErrorDTO> getErrorsList() {
		return errorsList;
	}


	public void setErrorsList(List<FieldErrorDTO> errorsList) {
		this.errorsList = errorsList;
	}
    
    

}
