package find.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import find.vo.SignUpCommand;

public class SignUpCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SignUpCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SignUpCommand command = (SignUpCommand)target;
		
		if(command.getEmail()==null || command.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}
		
		if(!command.getUserPassword().isEmpty()) {
			if(!command.isPasswordEqual()) {
				errors.rejectValue("userPwdChk","일치하지 않습니다.");
			}
		}
	}

}
