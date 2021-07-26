package find.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import find.vo.AdminLoginCommand;
import find.vo.MemberLoginCommand;

public class MemberLoginCommandVaildator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberLoginCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "required");
	}
	
}
