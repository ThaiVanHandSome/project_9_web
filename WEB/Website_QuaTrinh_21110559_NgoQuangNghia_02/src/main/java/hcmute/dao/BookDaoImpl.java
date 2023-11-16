package hcmute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.connection.DBConnectionSqlServer;
import hcmute.entity.Book;

public class BookDaoImpl implements IBookDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public List<Book> findAll() {
		String sql = "select * from books";
		List<Book> list = new ArrayList<Book>();
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getInt("bookid"));
				book.setIsbn(rs.getInt("isbn"));
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setPublish_date(rs.getDate("publish_date"));
				book.setDescription(rs.getString("description"));
				book.setCover_image(rs.getString("cover_image"));
				book.setQuantity(rs.getInt("quantity"));
				list.add(book);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}

	@Override
	public Book findOne(int bookid) {
		String sql = "select * from books where bookid = ?";
		Book model = new Book();
		try {
			conn = new DBConnectionSqlServer().getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookid);
			rs = ps.executeQuery();
			while (rs.next()) {
				model.setBookid(rs.getInt("bookid"));
				model.setIsbn(rs.getInt("isbn"));
				model.setTitle(rs.getString("title"));
				model.setPublisher(rs.getString("publisher"));
				model.setPrice(rs.getInt("price"));
				model.setDescription(rs.getString("description"));
				model.setPublish_date(rs.getDate("publish_date"));
				model.setCover_image(rs.getString("cover_image"));
				model.setQuantity(rs.getInt("quantity"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	@Override
	public void insert(Book book) {
		String sql = "INSERT INTO books (isbn, title, publisher, price, description, publish_date, cover_image, quantity VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getIsbn()); 
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());
			ps.setDate(6, book.getPublish_date());
			ps.setString(7, book.getCover_image());
			ps.setInt(8, book.getQuantity());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update(Book book) {
		String sql = "UPDATE books SET title = ? , publisher = ?, price = ?,  description = ?, publish_date = ?, cover_image = ?, quantity = ? WHERE bookid = ?";
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getPublisher());
			ps.setInt(3, book.getPrice());
			ps.setString(4, book.getDescription());
			ps.setDate(5, book.getPublish_date());
			ps.setString(6, book.getCover_image());
			ps.setInt(7, book.getQuantity());
			ps.setInt(8, book.getBookid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int bookid) {
		String sql = "delete from books" + " where bookid  = ?;";
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookid);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int countAll() {
		String sql = "select count(*) from books";
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
	public List<Book> paginationPage(int index, int numberOfPage) {
		List<Book> result = new ArrayList<Book>();
		String sql = "SELECT * FROM books\r\n" + "ORDER BY bookid\r\n";
		try {
			conn = new DBConnectionSqlServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, numberOfPage);
			ps.setInt(2, index * numberOfPage);
			ResultSet rs = ps.executeQuery();
			Book book;
			while (rs.next()) {
				book = new Book();
				book.setBookid(rs.getInt("bookid"));
				book.setDescription(rs.getString("description"));
				book.setCover_image(rs.getString("cover_image"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setIsbn(rs.getInt("isbn"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPublish_date(rs.getDate("publish_date"));
				book.setTitle(rs.getString("title"));
				result.add(book);

				System.out.println("book in paginnationPage" + book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end pagination");
		return result;

	}


	@Override
	public List<Book> findBookByAuthor(int author_id) {
		String sql = "SELECT books.*\r\n" + "FROM books\r\n"
				+ "INNER JOIN book_author ON books.bookid = book_author.bookid\r\n"
				+ "WHERE book_author.author_id = ?;";
		List<Book> list = new ArrayList<Book>();

		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, author_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getInt("bookid"));
				book.setDescription(rs.getString("description"));
				book.setCover_image(rs.getString("cover_image"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setIsbn(rs.getInt("isbn"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPublish_date(rs.getDate("publish_date"));
				book.setTitle(rs.getString("title"));
				list.add(book);
				System.out.println(book);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}
	@Override
	public List<Book> findAll_DESC() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Book> findAll_DESC() {
//		String sql = "SELECT books.*,rating.rating\r\n" + "FROM books\r\n"
//				+ "Inner JOIN rating ON books.bookid = rating.bookid\r\n" + "GROUP BY books.bookid,rating.rating\r\n"
//				+ "ORDER BY AVG(rating.rating) DESC;";
//		List<Book> list = new ArrayList<Book>();
//		try {
//			conn = new DBConnectionSqlServer().getConnection();
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				Book book = new Book();
//				book.setBookid(rs.getInt("bookid"));
//				book.setTitle(rs.getString("title"));
//				book.setPrice(rs.getInt("price"));
//				book.setCover_image(rs.getString("cover_image"));
//				book.setRating(rs.getInt("rating"));
//				list.add(book);
//				System.out.println(book);
//			}
//			conn.close();
//
//		} catch (Exception e) {
//			System.out.println("false");
//		}
//		return list;
//	}
}
