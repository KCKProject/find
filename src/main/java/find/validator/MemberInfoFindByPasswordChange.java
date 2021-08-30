package find.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import find.vo.Member;

public class MemberInfoFindByPasswordChange implements Validator {
	private static final String PWD_EXP = 
	         "^.*(?=^.{6,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
	private Pattern pattern;
	  
	public MemberInfoFindByPasswordChange() {
	      pattern = Pattern.compile(PWD_EXP);
	}
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfoFindByPasswordChange.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member command = (Member)target;
		
		// 비밀번호 형식
		boolean matcher = Pattern.matches(PWD_EXP,command.getUserPasswordNew());
        if(matcher != true) {
           errors.rejectValue("userPasswordNew", "wrong", "영문, 숫자, 특수문자 포함 6~15로 만들어주세요");
        }
        
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPasswordNew", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPasswordNewConfirm", "required", "필수 입력사항입니다.");
	}

}
