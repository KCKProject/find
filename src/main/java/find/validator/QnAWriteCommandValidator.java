package find.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class QnAWriteCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return QnAWriteCommandValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contents", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "open", "required", "필수 입력사항입니다.");
	}

	

}
