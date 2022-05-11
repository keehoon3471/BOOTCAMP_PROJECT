package MiniProject;

import java.sql.*;

public class JdbcTemplate {
	private static JdbcTemplate instance;
	private JdbcTemplate() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static JdbcTemplate getInstance() {
		synchronized(JdbcTemplate.class) {
			if (instance == null) {
				instance = new JdbcTemplate();
			}
		}
		return instance;
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##project", "0000");
	}

}
