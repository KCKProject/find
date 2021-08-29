package find.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberInfoFindByPasswordChange implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfoFindByPasswordChange.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPasswordNew", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPasswordNewConfirm", "required", "필수 입력사항입니다.");
	}

}
