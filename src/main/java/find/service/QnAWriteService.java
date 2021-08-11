package find.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import find.dao.FindDao;
import find.vo.QnABoard;
import find.vo.QnAWriteCommand;

@Service
public class QnAWriteService {

	@Autowired
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}

	public void qnAWrite(QnAWriteCommand qnAWriteCommand) {
		QnABoard newQnA = new QnABoard(
				qnAWriteCommand.getTitle(),qnAWriteCommand.getWriter(),qnAWriteCommand.getContents(),
				qnAWriteCommand.getOpen());
		
		
		dao.insertQnA(newQnA);
	}
}
