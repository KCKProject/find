package find.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import find.vo.LostBoardWriteCommand;

public class BoardLostCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return LostBoardWriteCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		LostBoardWriteCommand command = (LostBoardWriteCommand)target;
//		
//		MultipartFile img = command.getImg();
//		String fileName = img.getOriginalFilename();
//		System.out.println("img 값 : "+img);
//		System.out.println("fileName 값 : "+fileName);
//		
//		if(fileName=="") {
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "img", "required", "필수 입력사항입니다");
//		}
//		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lostDate", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "character", "required", "필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memo", "required", "필수 입력사항입니다.");
		
	}
	
}
