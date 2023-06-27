package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Result;

public class SavedataDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/janken";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Result> findAll() {
		List<Result> rList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT ID,WIN,LOSE,DRAW FROM SAVEDATA";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("ID");
				int win = rs.getInt("WIN");
				int lose = rs.getInt("LOSE");
				int draw = rs.getInt("DRAW");
				Result r1 = new Result();
				r1.setId(id);
				r1.setWin(win);
				r1.setLose(lose);
				r1.setDraw(draw);
				rList.add(r1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rList;
	}
}
