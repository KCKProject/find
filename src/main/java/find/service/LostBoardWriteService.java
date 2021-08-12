package find.service;
 
import java.awt.PageAttributes.MediaType;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import
org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.dao.FindDao;
import find.vo.LostBoard;
import find.vo.LostBoardWriteCommand;
import find.vo.MemberAuthInfo;

@Service
public class LostBoardWriteService {

	@Autowired
	private FindDao dao;

	public LostBoardWriteService(FindDao dao) {
		this.dao = dao; 
	}
	
	public void boardRegist(LostBoardWriteCommand lc, 
			HttpSession session,
			MultipartHttpServletRequest request) throws IOException {
		MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		System.out.println("[service]session id�쓽 媛� : "+member.getUserId());
		
		String term = lc.getTerm();
		System.out.println("�꽆�뼱�삩 term �쓽 媛� : "+term);
		
		if(term==null) {
			member.setEmail("鍮꾧났媛�");
			member.setPhone("鍮꾧났媛�");
		}else if(term.equals("phoneAgree")) {
			member.setEmail("鍮꾧났媛�");
		}else if(term.equals("emailAgree")) {
			member.setPhone("鍮꾧났媛�");
		}
		
		// �씠誘몄��뙆�씪�뾽濡쒕뱶
		LostBoard lb = new LostBoard();
		
		MultipartFile img = lc.getImg();
		String originalFile = img.getOriginalFilename();
		String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		String storedFileName = UUID.randomUUID().toString().replace("-", "")+originalFileExtension;
		String filePath = request.getSession().getServletContext().getRealPath("resources/imgUpload");
		File file = new File(filePath,storedFileName);
		img.transferTo(file);
		
		System.out.println("�뾽濡쒕뱶�븳 �뙆�씪�� "+originalFile);
		System.out.println("�씠怨�, "+storedFileName+"�쑝濡� �뾽濡쒕뱶�릱�떎.");
		System.out.println(filePath+" 寃쎈줈�뿉 ���옣�릱�쑝�땲 �솗�씤.");
		System.out.println("�뙆�씪 �궗�씠利덈뒗 : "+img.getSize());

		
		// �뜽�꽕�씪(寃뚯떆�뙋 紐⑸줉�뿉�꽌 蹂댁뿬吏� �궗吏�) �깮�꽦
		// List�뿉�꽌 蹂댁뿬吏덈븣 異뺤냼蹂몄씤  �뜽�꽕�씪 �씠誘몄�瑜� �굹���궡硫�, �꽌踰꾩뿉 理쒖냼�븳�쓽 �뜲�씠�꽣 �쟾�넚 媛��뒫
		// �긽�꽭蹂닿린�럹�씠吏��뿉�꽌�뒗 �썝蹂몄씠誘몄� 異쒕젰
		BufferedImage sourceImg = ImageIO.read(new File(filePath,storedFileName));
		
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
		
		String thumbnailName = filePath+File.separator+"s_"+storedFileName;
		
		File newFile = new File(thumbnailName);
		String formatName = storedFileName.substring(storedFileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		thumbnailName.substring(filePath.length()).replace(File.separatorChar, '/');
		
		// System.out.println("formatName : "+formatName);
		// System.out.println("thumbnailName : "+thumbnailName);
	      
		lb.setTitle(lc.getTitle());
		lb.setWriter(member.getUserId());
		lb.setLocation(lc.getLocation());
		lb.setCharacter(lc.getCharacter());
		lb.setAnimal(lc.getAnimal());
		lb.setKind(lc.getKind());
		lb.setGender(lc.getGender());
		lb.setEmail(member.getEmail());
		lb.setPhone(member.getPhone());
		//lb.setLostDate(lc.getLostDate());
		lb.setMemo(lc.getMemo());
		lb.setOriginalFile(originalFile);
		lb.setOriginalFileExtension(originalFileExtension);
		lb.setStoredFileName(storedFileName);
		
	dao.writeLostBoard(lb);
	}


	public void writeReview(String review, long boardNum) {
		dao.writeReview2(review, boardNum);	
		
	}
}
