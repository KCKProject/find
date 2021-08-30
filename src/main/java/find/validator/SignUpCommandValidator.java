package find.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import find.vo.SignUpCommand;

public class SignUpCommandValidator implements Validator{

   // 비밀번호 체크 (영문, 숫자, 특수문자 포함 6~15 자리)
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
      
      if(!command.getUserPassword().isEmpty()) {
         boolean matcher = Pattern.matches(PWD_EXP,command.getUserPassword());
         if(matcher != true) {
            errors.rejectValue("userPassword", "wrong", "영문, 숫자, 특수문자 포함 6~15로 만들어주세요");
         }else if(!command.isPasswordEqual()) {
            errors.rejectValue("userPwdChk","nomatch","비밀번호 불일치");
         }
      }

      ValidationUtils.rejectIfEmpty(errors, "userPassword", "required", "필수입력사항");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "필수입력사항");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required", "필수입력사항");
      ValidationUtils.rejectIfEmpty(errors, "phone", "required", "필수입력사항");
      
      //pwdQ 처리필요
      ValidationUtils.rejectIfEmpty(errors, "pwdA", "required", "필수입력사항");
   }

}