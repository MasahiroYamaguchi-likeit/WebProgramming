package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.xml.bind.DatatypeConverter;

import model.User;

public class UserDAO {

	public User findByLoginInfo(String loginId, String password) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			//ハッシュを生成したい元の文字列
			String source = password;
			//ハッシュ生成前にバイト配列に置き換える際のCharset
			Charset charset = StandardCharsets.UTF_8;
			//ハッシュアルゴリズム
			String algorithm = "MD5";

			//ハッシュ生成処理
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);
			//標準出力
			System.out.println(result);

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, result);
			ResultSet rs = pStmt.executeQuery();
			if (!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginIdData, nameData);

		} catch (SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	/**
	 * 全てのユーザ情報を取得する
	 * @return
	 */
	public List<User> findAll() {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user where login_id not in ('admin')";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public void InsertData(String loginId, String name, String birthDate, String password)
			throws ServletException, SQLException, NoSuchAlgorithmException {

		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		String sql = "INSERT INTO user (login_id,name,birth_date,password,create_date,update_date ) VALUES (?,?,?,?,now(),now())";

		conn = DBManager.getConnection();

		//ハッシュを生成したい元の文字列
		String source = password;
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		String result = DatatypeConverter.printHexBinary(bytes);
		//標準出力
		System.out.println(result);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, loginId);
		stmt.setString(2, name);
		stmt.setString(3, birthDate);
		stmt.setString(4, result);

		stmt.executeUpdate();

		stmt.close();

	}

	public User DetailData(String ID) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE id = ? ";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, ID);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			int id = rs.getInt("id");
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");
			return new User(id, loginId, name, birthDate, password, createDate, updateDate);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public void Update(String id, String name, String birthdate, String password)
			throws ServletException, SQLException, NoSuchAlgorithmException {

		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		String sql = "UPDATE user SET name =? ,birth_date =?,password =? ,update_date =now() WHERE id = ?";

		conn = DBManager.getConnection();

		//ハッシュを生成したい元の文字列
		String source = password;
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		String result = DatatypeConverter.printHexBinary(bytes);
		//標準出力
		System.out.println(result);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, birthdate);
		stmt.setString(3, result);
		stmt.setString(4, id);

		stmt.executeUpdate();

		stmt.close();

	}

	public void Update2(String id, String name, String birthdate)
			throws ServletException, SQLException {

		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		String sql = "UPDATE user SET name =? ,birth_date =?,update_date =now() WHERE id = ?";

		conn = DBManager.getConnection();

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, birthdate);
		stmt.setString(3, id);

		stmt.executeUpdate();

		stmt.close();

	}

	public void DataDelete(String id)
			throws ServletException, SQLException {

		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		String sql = "DELETE FROM user WHERE id = ?;";

		conn = DBManager.getConnection();

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);

		stmt.executeUpdate();

		stmt.close();

	}

	public List<User> DataSearch(String loginId, String name, String birthDateS, String birthDateE) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user where login_id not in ('admin')";

			if(!loginId.equals("")) {
				sql += " AND login_id ='" + loginId + "'";
			}

			if(!name.equals("")) {

				sql += " AND name like '%" + name + "%'";
			}

			if(!birthDateS.equals("")) {
				sql += " AND birth_date >='" + birthDateS + "'";
			}

			if(!birthDateE.equals("")) {
				sql += " AND birth_date <='" + birthDateE + "'";
			}

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int Id = rs.getInt("id");
				String UserIdData = rs.getString("login_id");
				String nameData = rs.getString("name");
				Date birthData = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(Id, UserIdData, nameData, birthData, password, createDate, updateDate);

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}
}
