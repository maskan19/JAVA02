package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.basic.singleton.MySingleton;
import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {
	
	private static MemberDaoImpl singleDao;

	private MemberDaoImpl() {
		
	}
	
	public static MemberDaoImpl getInstance() {
		if (singleDao == null)
			singleDao = new MemberDaoImpl();
		return singleDao;
	}
	

	@Override
	public int updatePartMember(Map<String, String> paramMap) {
		//int input, String mem_id, String cont
		
		
		Connection cn = null;
		PreparedStatement ps = null;
		
		String sql = "Update mymember Set " +paramMap.get("field") +  " =?  where mem_id = ?";
		
//		if (input == 1)
//			sql += "mem_name = ? ";
//		else if (input == 2)
//			sql += "mem_tel = ? ";
//		else if (input == 3)
//			sql += "mem_addr = ? ";
//		sql += "where mem_id = ?";
		
		int cnt =0;
		try {
			cn = DBUtil3.getConnection();
			ps = cn.prepareStatement(sql);

//			ps.setString(1, cont);
//			ps.setString(2, mem_id);
			
			ps.setString(1, paramMap.get("data"));
			ps.setString(2, paramMap.get("memid"));
			cnt = ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
				}
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e) {
				}
		}
		return cnt;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		Connection cn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			cn = DBUtil3.getConnection();
			String sql = "insert into mymember values (?,?,?,?)";
			ps = cn.prepareStatement(sql);
			ps.setString(1,  memVo.getMem_id());
			ps.setString(2,  memVo.getMem_name());
			ps.setString(3,  memVo.getMem_tel());
			ps.setString(4,  memVo.getMem_addr());
			
			cnt = ps.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
				}
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e) {
				}
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection cn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		String mem_id = "";
		try {
			cn = DBUtil3.getConnection();
			String sql = "Delete From mymember Where mem_id = ?";
			ps = cn.prepareStatement(sql);

			ps.setString(1, mem_id);
			cnt = ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
				}
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e) {
				}
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection cn = null;
		PreparedStatement ps = null;
		int cnt =0;
		try {
			String sql = "Update mymember Set mem_name = ?, mem_tel = ?, mem_addr = ?   where mem_id = ?";
			cn = DBUtil3.getConnection();
			ps = cn.prepareStatement(sql);

			ps.setString(1, memVo.getMem_name());
			ps.setString(2, memVo.getMem_tel());
			ps.setString(3, memVo.getMem_addr());
			ps.setString(4, memVo.getMem_id());
			cnt = ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
				}
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e) {
				}
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		Connection cn =null;
		ResultSet rs = null;
		Statement st = null;
		List<MemberVO> member = new ArrayList<>();
		try {
			String sql = "select * from mymember";
			cn = DBUtil3.getConnection();
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
			MemberVO mem = new MemberVO();
			mem.setMem_id(rs.getString("mem_id"));
			mem.setMem_name(rs.getString("mem_name"));
			mem.setMem_tel(rs.getString("mem_tel"));
			mem.setMem_addr(rs.getString("mem_addr"));
			member.add(mem);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
				}
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e) {
				}
		}
		return member;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			cn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, memId);
			rs = ps.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e2) {
				}
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e2) {
				}
		}
		return cnt;
	}

}
