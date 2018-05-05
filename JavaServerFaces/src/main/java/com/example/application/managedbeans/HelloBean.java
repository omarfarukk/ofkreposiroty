package com.example.application.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.application.exception.ExceptionUtils;
import com.example.application.service.CalculatorService;
import com.example.application.utils.RestControllerUtils;
import com.example.application.validation.ApplicationValidator;

@ManagedBean
@RequestScoped
public class HelloBean implements Serializable {
	private static Logger logger = LoggerFactory.getLogger(HelloBean.class);
	private static final long serialVersionUID = 1L;
	private String surfaceProfilesParam;
	private String[] surfaceProfiles;
	private long waterVolume;
	@EJB
	private ApplicationValidator applicationValidator;
	@EJB
	CalculatorService calculatorService;
	@EJB
	RestControllerUtils restControllerUtils;
	@EJB
	ExceptionUtils exceptionUtils;
	
	
	public long getWaterVolume() {
		return this.waterVolume;
	}
	public void setWaterVolume(long waterVolume) {
		 this.waterVolume = waterVolume;
	}
	
	
	public void setSurfaceProfilesParam(String surfaceProfilesParam) {
		this.surfaceProfilesParam = surfaceProfilesParam;
	}
	public String getSurfaceProfilesParam() {
		return this.surfaceProfilesParam;
	}
	public String setSurfaceProfiles() {
		return this.surfaceProfilesParam;
	}
	
	public String calculateWaterValume() {
		logger.info("calculateWaterValume() entered");
		try {
			this.surfaceProfiles = restControllerUtils.consturctInputArray(surfaceProfilesParam);
			this.waterVolume = calculatorService.calculateWaterVolume(this.surfaceProfiles);
		}catch(Throwable th) {
			logger.info("calculateWaterValume() Exiting with Exception",th);
			FacesMessage message  = new FacesMessage(th.getCause().getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", message);
			return "hello";
		}
		logger.info("calculateWaterValume() Exiting without Exception");
		return "welcome";
	}
	
	public void validateInput(FacesContext fc, UIComponent uic, Object param) throws ValidatorException {
		logger.info("validateInput() entered");
		String parameter = (String)param;
		if(!applicationValidator.isSurfaceProfilesInputValid(parameter)) {
			logger.info("validateInput() Exiting after Invalidating the Inputs");
			FacesMessage message = new FacesMessage("Please provide the numbers in comma separated (1,2,3..)/ space separated(1 2 3...) / without any separator(123...)");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
			
		}
		logger.info("validateInput() Exiting without Exception");
	}

}