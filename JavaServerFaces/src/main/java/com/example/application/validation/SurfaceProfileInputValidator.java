package com.example.application.validation;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
public class SurfaceProfileInputValidator implements Validator {

	private String surfaceProfileValues;
	@EJB
	private ApplicationValidator applicationValidator;
	
	@Override
	public void validate(FacesContext fc, UIComponent uic, Object param) throws ValidatorException {
		
		surfaceProfileValues = (String)param;
		if(!applicationValidator.isSurfaceProfilesInputValid(surfaceProfileValues)) {
			FacesMessage message = new FacesMessage("Please provide the numbers in comma separated (1,2,3..)/ space separated(1 2 3...) / without any separator(123...)");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
			
		}
	}

	public String getSurfaceProfileValues() {
		return surfaceProfileValues;
	}

	public void setSurfaceProfileValues(String surfaceProfileValues) {
		this.surfaceProfileValues = surfaceProfileValues;
	}
	
}
