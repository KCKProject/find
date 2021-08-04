package find.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import find.vo.SignUpCommand;

public class SignUpCommandValidator implements Validator{

   // 비밀번호 정규식 (영문,숫자,특수문자 포함 6~15자리수)
   private static final String PWD_EXP = 
         "^.*(?=^.{6,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
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
      
      ValidationUtils.rejectIfEmpty(errors, "userPassword", "required", "필수 입력사항입니다");
      
      if(!command.getUserPassword().isEmpty()) {
         boolean matcher = Pattern.matches(PWD_EXP,command.getUserPassword());
         if(matcher != true) {
            errors.rejectValue("userPassword", "wrong", "영문,숫자,특수문자 조합 6~15자리로 작성해주세요");
         }else if(!command.isPasswordEqual()) {
            errors.rejectValue("userPwdChk","nomatch","일치하지 않습니다");
         }
      }

      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "필수 입력사항입니다");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required", "필수 입력사항입니다");
      ValidationUtils.rejectIfEmpty(errors, "phone", "required", "필수 입력사항입니다");
   }

}