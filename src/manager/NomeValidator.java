package manager;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("nomeValidator")
public class NomeValidator implements Validator {
	
	public void validate(FacesContext context, UIComponent ui,  Object obj){
		 String nome = (String) obj;
		 
		  if (nome.length() < 3){
			  FacesMessage message = new FacesMessage("Nome Invalido");
			  message.setSeverity(FacesMessage.SEVERITY_ERROR);
			  throw new ValidatorException(message);
		  }

	}
	

}
