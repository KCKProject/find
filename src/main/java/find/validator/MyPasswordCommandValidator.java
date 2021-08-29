package find.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import find.utils.SHA256Util;
import find.vo.MyPasswordUpdateCommand;

public class MyPasswordCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MyPasswordCommandValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MyPasswordUpdateCommand command = (MyPasswordUpdateCommand)target;
		
		String currentOrigin = command.getUserPasswordCurrentChk();
		String current = command.getUserPasswordCurrent();
		String current_sha = null;
		String salt = command.getSalt();
		try {
			current_sha = SHA256Util.SHA256Encrypt(current,salt);
		} catch (Exception e) {			
			e.printStackTrace();
		}
//		String pwdNew = command.getUserPasswordNew();
//		String pwdNew_sha = null;
//		try {
//			pwdNew_sha = SHA256Util.SHA256Encrypt(pwdNew,salt);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		if(!current_sha.equals(currentOrigin)) {
			errors.rejectValue("userPasswordCurrent","wrong","현재 비밀번호가 틀립니다.");
		}
//		if(current_sha.equals(pwdNew_sha)) {
//			errors.rejectValue("userPasswordNew","same","변경할 비밀번호와 기존 비밀번호가 같습니다.");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPasswordCurrent", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPasswordNew", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPasswordNewConfirm", "required", "필수 입력사항입니다.");
	}

}
