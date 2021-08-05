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
		System.out.println("채워야 할 부분");
		dao.writeFindBoard();
	}
}
