package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private SqlMapClient smc;
	private static MemberDaoImpl singleDao;

	private MemberDaoImpl() {
		smc = SqlMapUtil.getSqlMapClient();
	}

	public static MemberDaoImpl getInstance() {
		if (singleDao == null)
			singleDao = new MemberDaoImpl();
		return singleDao;
	}

	@Override
	public int updatePartMember(Map<String, String> paramMap) {

		int cnt = 0;
		try {
			cnt = smc.update("mymember.updatePartMember", paramMap);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("mymember.insertMember", memVo);
			if (obj == null)
				cnt = 1; // insert 성공 여부 판단. 성공시 null반환함
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = smc.delete("mymember.deleteMember", memId);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mymember.updateMember", memVo);

		} catch (SQLException e) {
			// TODO: handle exception
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> member = new ArrayList<>();
		try {
			member = smc.queryForList("mymember.selectMembers");
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return member;
	}

	@Override
	public int getMemberCount(String memId) {
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("mymember.selectMember", memId);
		} catch (SQLException e) {
		}
		return cnt;
	}

	@Override
	public MemberVO getMember(String memId) {
		MemberVO memVo = new MemberVO();
		try {
			memVo = (MemberVO) smc.queryForObject("mymember.getMember", memId);
		} catch (SQLException e) {
			memVo = null;
		}
		return memVo;
	}

}
