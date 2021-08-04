package find.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import find.vo.SignUpCommand;

public class SignUpCommandValidator implements Validator{

   // ��й�ȣ ���Խ� (����,����,Ư������ ���� 6~15�ڸ���)
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
      
      ValidationUtils.rejectIfEmpty(errors, "userPassword", "required", "�ʼ� �Է»����Դϴ�");
      
      if(!command.getUserPassword().isEmpty()) {
         boolean matcher = Pattern.matches(PWD_EXP,command.getUserPassword());
         if(matcher != true) {
            errors.rejectValue("userPassword", "wrong", "����,����,Ư������ ���� 6~15�ڸ��� �ۼ����ּ���");
         }else if(!command.isPasswordEqual()) {
            errors.rejectValue("userPwdChk","nomatch","��ġ���� �ʽ��ϴ�");
         }
      }

      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "�ʼ� �Է»����Դϴ�");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required", "�ʼ� �Է»����Դϴ�");
      ValidationUtils.rejectIfEmpty(errors, "phone", "required", "�ʼ� �Է»����Դϴ�");
   }

}