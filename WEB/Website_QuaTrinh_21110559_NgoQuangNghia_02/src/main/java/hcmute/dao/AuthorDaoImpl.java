package hcmute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.connection.DBConnectionSqlServer;
import hcmute.entity.Author;
import hcmute.entity.Book;

public class AuthorDaoImpl implements IAuthorDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public List<Author> findAll() {
		String sql = "SELECT * FROM author";
		List<Author> list = new ArrayList<Author>();
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setAuthorID(rs.getInt("author_id"));
				author.setAuthorName(rs.getString("author_name"));
				author.setDateOfBirth(rs.getDate("date_of_birth"));
				list.add(author);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}

		return list;
	}
	@Override
	public List<Author> findAuthorByAuthor(int author_id) {
		String sql = "SELECT author.*\r\n" + "FROM author\r\n"
				+ "INNER JOIN book_author ON author.author_id = book_author.author_id\r\n"
				+ "WHERE book_author.author_id = ?;";
		List<Author> list = new ArrayList<Author>();

		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, author_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setAuthorID(rs.getInt("author_id"));
				author.setAuthorName(rs.getString("author_name"));
				author.setDateOfBirth(rs.getDate("date_of_birth"));
				list.add(author);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}
}
