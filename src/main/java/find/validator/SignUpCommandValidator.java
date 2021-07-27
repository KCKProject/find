package find.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import find.vo.SignUpCommand;

public class SignUpCommandValidator implements Validator{

	private static final String PWD_EXP = 
			"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{6,15}$\r\n";

	private Pattern pattern;
	
	public SignUpCommandValidator() {
		pattern = Pattern.compile(PWD_EXP);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return SignUpCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SignUpCommand command = (SignUpCommand)target;
		
		if(!command.getUserPassword().isEmpty()) {
			if(!command.isPasswordEqual()) {
				errors.rejectValue("userPwdChk","nomatch","일치하지 않습니다");
			}else {
				Matcher matcher = pattern.matcher(command.getEmail());
				if(!matcher.matches()) {
					errors.rejectValue("userPassword", "wrong", "영문,숫자,특수문자 조합 6~15자리로 작성해주세요");
				}
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "필수 입력사항입니다");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required", "필수 입력사항입니다");
		ValidationUtils.rejectIfEmpty(errors, "phone", "required", "필수 입력사항입니다");
	}

}
