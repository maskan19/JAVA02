package kr.or.ddit.mvc.service;

import java.util.List;

import kr.or.ddit.mvc.dao.IBoardDao;
import kr.or.ddit.mvc.dao.BoardDaoImpl;
import kr.or.ddit.mvc.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	//Service객체는 Dao객체를 사용하기 때문에 Dao객체가 저장될 변수가 필요하다.
	private IBoardDao boardDao;
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}

	@Override
	public int insertBoard(String board_title, String board_writer, String board_content) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(board_title, board_writer, board_content);
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(String board_title, String board_content, int board_no) {
		// TODO Auto-generated method stub
		return boardDao.updateBoard(board_title, board_content, board_no);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		// TODO Auto-generated method stub
		return boardDao.getAllBoard();
	}

	@Override
	public List<BoardVO> getBoardSearch(String boardTitle) {
		// TODO Auto-generated method stub
		return boardDao.getBoardSearch(boardTitle);
	}

	@Override
	public BoardVO read(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.read(boardNo);
	}
	
	

}
