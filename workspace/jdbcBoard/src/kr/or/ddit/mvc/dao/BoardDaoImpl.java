package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.mvc.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

public class BoardDaoImpl implements IBoardDao {

	@Override
	public int insertBoard(String board_title, String board_writer,
			String board_content) {
		Connection cn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			cn = DBUtil3.getConnection();
			String sql = "insert into jdbc_board values (board_seq.NEXTVAL, ?, ?, sysdate, '0', ?)";
			ps = cn.prepareStatement(sql);
			ps.setString(1, board_title);
			ps.setString(2, board_writer);
			ps.setString(3, board_content);

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
	public int deleteBoard(int boardNo) {
		Connection cn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			cn = DBUtil3.getConnection();
			String sql = "Delete From jdbc_board Where board_no = ?";

			ps = cn.prepareStatement(sql);
			ps.setInt(1, boardNo);
			cnt = ps.executeUpdate();

		} catch (Exception e) {
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
	public int updateBoard(String board_title, String board_content,
			int board_no) {
		Connection cn = null;
		PreparedStatement ps = null;
		String sql = "Update jdbc_board Set board_title = ?, board_content = ? where board_no = ?";
		int cnt = 0;
		try {
			cn = DBUtil3.getConnection();
			ps = cn.prepareStatement(sql);
			ps.setString(1, board_title);
			ps.setString(2, board_content);
			ps.setInt(3, board_no);
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
	public List<BoardVO> getAllBoard() {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		List<BoardVO> board = new ArrayList<>();
		try {
			String sql = "select * from jdbc_board";
			cn = DBUtil3.getConnection();
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				BoardVO post = new BoardVO();
				post.setBoard_no(rs.getInt("board_no"));
				post.setBoard_title(rs.getString("board_title"));
				post.setBoard_writer(rs.getString("board_writer"));
				post.setBoard_date(rs.getDate("board_date"));
				post.setBoard_cnt(rs.getInt("board_cnt"));
				post.setBoard_content(rs.getString("board_content"));
				board.add(post);
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
		return board;
	}

	@Override
	public List<BoardVO> getBoardSearch(String boardTitle) {
		Connection cn = null;
		Statement st = null;
		String sql = "select * from jdbc_board where board_title like '%"
				+ boardTitle + "%'";
		ResultSet rs = null;
		List<BoardVO> board = new ArrayList<>();
		try {
			cn = DBUtil3.getConnection();
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				BoardVO post = new BoardVO();
				post.setBoard_cnt(rs.getInt("board_cnt"));
				post.setBoard_content(rs.getString("board_content"));
				post.setBoard_date(rs.getDate("board_date"));
				post.setBoard_no(rs.getInt("board_no"));
				post.setBoard_title(rs.getString("board_title"));
				post.setBoard_writer(rs.getString("board_writer"));
				board.add(post);
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
		return board;
	}

	@Override
	public BoardVO read(int boardNo) {
		cntup(boardNo);
		Connection cn = null;
		Statement st = null;
		String sql = "select * from jdbc_board where board_no =" + boardNo;
		ResultSet rs = null;
		BoardVO post = new BoardVO();
		try {
			cn = DBUtil3.getConnection();
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				post.setBoard_cnt(rs.getInt("board_cnt"));
				post.setBoard_content(rs.getString("board_content"));
				post.setBoard_date(rs.getDate("board_date"));
				post.setBoard_no(rs.getInt("board_no"));
				post.setBoard_title(rs.getString("board_title"));
				post.setBoard_writer(rs.getString("board_writer"));
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
		return post;
	}

	private void cntup(int boardNo) {
		Connection cn = null;
		PreparedStatement ps = null;
		String sql = "Update jdbc_board Set board_cnt= board_cnt+1 where board_no =?";
		int cnt = 0;
		try {
			cn = DBUtil3.getConnection();
			ps = cn.prepareStatement(sql);
			ps.setInt(1, boardNo);
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
	}

}
