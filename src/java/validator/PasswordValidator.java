/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String password = (String) value;
        UIComponent passwordComponent = component.findComponent("sifre");
        String originalPassword = (String) ((jakarta.faces.component.UIInput) passwordComponent).getValue();
        
        if (originalPassword == null || !originalPassword.equals(password)) {
            throw new ValidatorException(new FacesMessage("Şifreler eşleşmiyor."));
        }
    }
}
