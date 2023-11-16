package hcmute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.connection.DBConnectionSqlServer;
import hcmute.entity.Book;
import hcmute.entity.User;

public class UserDaoImpl  implements IUserDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		List<User> list = new ArrayList<User>();
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getInt("phone"));
				user.setPasswd(rs.getString("passwd"));
				user.setSignup_date(rs.getDate("signup_date"));
				user.setLast_login(rs.getDate("last_login"));
				user.setIs_admin(rs.getString("is_admin"));
				list.add(user);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}

		return list;
	}
	@Override
	public User findOne(int id) {
		String sql = "select * from users where id = ?";
		User model = new User();
		try {
			conn = new DBConnectionSqlServer().getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getInt("phone"));
				user.setPasswd(rs.getString("passwd"));
				user.setSignup_date(rs.getDate("signup_date"));
				user.setLast_login(rs.getDate("last_login"));
				user.setIs_admin(rs.getString("is_admin"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	@Override
	public int countAll() {
		String sql = "select count(*) from users";
		try {
			conn = new DBConnectionSqlServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public List<User> paginationPage(int index) {
		List<User> result = new ArrayList<User>();
		String sql = "SELECT * FROM users\r\n" + "ORDER BY id DESC OFFSET ? rows fetch next 3 rows only\r\n";
		try {
			conn = new DBConnectionSqlServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getInt("phone"));
				user.setPasswd(rs.getString("passwd"));
				user.setSignup_date(rs.getDate("signup_date"));
				user.setLast_login(rs.getDate("last_login"));
				user.setIs_admin(rs.getString("is_admin"));
				result.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end pagination");
		return result;

	}
}
