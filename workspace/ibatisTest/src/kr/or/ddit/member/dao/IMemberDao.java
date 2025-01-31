package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

/**
 *   /**+엔터 입력시 작성자가 표시된다.
 * @author PC-25
 * 
 * 실제 DB와 연결해서 SQL문을 수행하고 결과를 작성해서 Service에 전달하는 Interface
 * 
 * 각각의 메서드 하나가 DB와 관련된 작업 1개를 수행하도록한다.
 *
 */
public interface IMemberDao {
	/**
	 * MemberVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVo //insert할 데이터가 저장된 MemberVO 객체
	 * @return insert //성공: 1, 실패: 0
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원 ID를 인수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param memId 삭제할 회원 ID
	 * @return 삭제 성공: 1, 삭제 실패: 0
	 */
	public int deleteMember(String memId);

	/**
	 * MemberVO자료를 이용하여 회원 정보를 Update하는 메서드
	 * @param memVo Update할 회원 정보가 저장된 MemberVo객체
	 * @return 작업 성공: 1, 작업 실패:0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * DB의 전체 회원 정보를 가져와서 List에 담아 반환하는 메서드
	 * @return MemberVO객체를 담고 있는 List 객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 회원 ID를 인수로 받아서 해당 회원의 개수를 반환하는 메서드
	 * @param memId 검색할 회원 ID
	 * @return 검색된 회원ID개수
	 */
	public int getMemberCount(String memId);
	
	/**
	 * Map의 정보를 이용하여 회원 정보 중 원하는 컬럼을 수정하는 메서드
	 * Key값 정보 : 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
	 * @param paramMap Update할 회원 정보가 저장된 Map객체
	 * @return 작업 성공: 1, 작업 실패:0
	 */
	public int updatePartMember(Map<String, String> paramMap);
	
}
