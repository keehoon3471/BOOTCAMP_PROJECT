package MiniProject;

import java.sql.*;
import java.util.*;

public class TeamDAO {
	private JdbcTemplate jt;
	Scanner sc = new Scanner(System.in);
	
	public TeamDAO() {
		jt = JdbcTemplate.getInstance();
	}
	
	public void insertTeam(String name) {		
		Connection conn= null;
		PreparedStatement pstmt = null;
		String sql1 = "insert into \"TEAM\" values (\"SEQ_TEAM\".nextval, ?, 1)";
		try {
			conn = jt.getConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,  name);
			pstmt.executeQuery();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<TeamVO> showAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<TeamVO> ls = new ArrayList<>();
		String sql3 = "select  * from TEAM ORDER BY \"NUMBER\" ASC";
		try {
			conn = jt.getConnection();
			pstmt = conn.prepareStatement(sql3);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TeamVO tmp = new TeamVO (
						rs.getInt(1), rs.getString(2),
						rs.getInt(3));
				ls.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (ls.size() == 0) ? null : ls;
	}
	
	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql4 = "select  COUNT(\"NUMBER\") from TEAM";
		int result=0;
		try {
			conn = jt.getConnection();
			pstmt = conn.prepareStatement(sql4);
			rs = pstmt.executeQuery();
			while(rs.next()) {
					result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public void updateVote(int option) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql3 = "UPDATE TEAM SET \"VOTE\"=\"VOTE\"+1 WHERE \"NUMBER\" = ?";
		try {
			conn = jt.getConnection();
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, option);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
