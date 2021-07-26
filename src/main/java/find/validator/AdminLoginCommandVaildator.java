package find.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import find.vo.AdminLoginCommand;

public class AdminLoginCommandVaildator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AdminLoginCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminPassword", "required");
		
	}

}
