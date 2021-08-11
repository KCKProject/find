package find.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import find.dao.FindDao;

@Service
public class FindBoardWriteService {

	@Autowired
	private FindDao dao;

	public FindBoardWriteService(FindDao dao) {
		this.dao = dao; 
	}
	
	public void boardRegist() {
		System.out.println("梨꾩썙�빞 �븷 遺�遺�");
		dao.writeFindBoard();
	}

	public void writeReview(String review, long boardNum) {
		dao.writeReview(review, boardNum);
	}
}
