package find.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberInfoFindById implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfoFindById.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "필수 입력사항입니다.");
		
	}

}
