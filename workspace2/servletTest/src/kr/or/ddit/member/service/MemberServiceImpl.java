package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	//Service객체는 Dao객체를 사용하기 때문에 Dao객체가 저장될 변수가 필요하다.
	private IMemberDao memDao;//이 인터페이스를 구현한 어떤 객체건 상관 없음
	
	private static MemberServiceImpl memService;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if (memService == null)
			memService = new MemberServiceImpl();
		return memService;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		return memDao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return memDao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return memDao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return memDao.getAllMember();
	}

	@Override
	public int getMemberCount(String memId) {
		return memDao.getMemberCount(memId);
	}

	@Override
	public int updatePartMember(Map<String, String> paramMap) {
		return memDao.updatePartMember(paramMap);
	}

}
