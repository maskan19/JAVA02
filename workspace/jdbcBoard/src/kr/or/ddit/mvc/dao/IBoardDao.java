package kr.or.ddit.mvc.dao;

import java.util.List;

import kr.or.ddit.mvc.vo.BoardVO;

/**
 *   /**+엔터 입력시 작성자가 표시된다.
 * @author PC-25
 * 
 * 실제 DB와 연결해서 SQL문을 수행하고 결과를 작성해서 Service에 전달하는 Interface
 * 
 * 각각의 메서드 하나가 DB와 관련된 작업 1개를 수행하도록한다.
 *
 */
public interface IBoardDao {
	/**
	 * BoardVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param boardVo //insert할 데이터가 저장된 BoardVO 객체
	 * @return insert //성공: 1, 실패: 0
	 */
	public int insertBoard(String board_title, String board_writer, String board_content);
	
	/**
	 * 글 번호를 인수로 받아서 해당 글을 삭제하는 메서드
	 * @param boardNo 삭제할 게시글 번호
	 * @return 삭제 성공: 1, 삭제 실패: 0
	 */
	public int deleteBoard(int boardNo);

	/**
	 * BoardVO자료를 이용하여 게시글 제목과 내용을 Update하는 메서드
	 * @param boardVo Update할 게시글 정보가 저장된 BoardVO객체
	 * @return 작업 성공: 1, 작업 실패:0
	 */
	public int updateBoard(String board_title, String board_content, int board_no);
	
	/**
	 * DB의 전체 회원 정보를 가져와서 List에 담아 반환하는 메서드
	 * @return BoardVO객체를 담고 있는 List 객체
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 게시글 제목를 인수로 받아서 해당 게시글의 개수를 반환하는 메서드
	 * @param boardTitle 검색할 게시글 제목
	 * @return 검색된 게시글 개수
	 */
	public List<BoardVO> getBoardSearch(String boardTitle);
	
	/**
	 * 조회할 게시글을 선택하는 메서드
	 * @param boardNo 조회할 게시글 번호
	 * @return 조회할 게시글의 내용
	 */
	public BoardVO read(int boardNo);
	
}
