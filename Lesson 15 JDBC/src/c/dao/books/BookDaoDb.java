package c.dao.books;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * a DAO Data Access Object class - encapsulates all JDBC CRUD (Create, Read,
 * Update, Delete) actions
 */
public class BookDaoDb implements BookDao {

	// database details
	private String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
	private String user = "eldar1";
	private String password = "pass1";

	@Override
	public void save(Book book) throws DaoException {
		try (Connection con = DriverManager.getConnection(url, user, password);) {
			String sql = "insert into book values(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, book.getId()); // set the id
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDouble(4, book.getPrice());
			pstmt.setDate(5, Date.valueOf(book.getPublication())); // convert LocalDate to java.sql.Date
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// catch an SQLException and throw a DaoException instead
			// (the SQLException is cause)
			throw new DaoException("saving book: " + book + " faild", e);
		}
	}

	@Override
	public Book get(int id) throws DaoException {
		try (Connection con = DriverManager.getConnection(url, user, password);) {
			String sql = "select * from book where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// if we are here a book with the specifies ID was found
				Book book = new Book(id);
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				// convert java.sql.Date to java.time.LocatDate
				Date dateSql = rs.getDate("publication");
				LocalDate localDate = dateSql.toLocalDate();
				//
				book.setPublication(localDate);

				return book;
			} else {
				// if we are here a book with the specifies ID was NOT found
				return null;
				// or you can throw an exception that the book was not found
			}
		} catch (SQLException e) {
			// catch an SQLException and throw a DaoException instead
			// (the SQLException is cause)
			throw new DaoException("get book with id: " + id + " faild", e);
		}
	}

	@Override
	public void update(Book book) throws DaoException {
		try (Connection con = DriverManager.getConnection(url, user, password);) {
			String sql = "update book set title=?, author=?, price=?, publication=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setDouble(3, book.getPrice());
			pstmt.setDate(4, Date.valueOf(book.getPublication())); // convert LocalDate to java.sql.Date
			pstmt.setInt(5, book.getId()); // set the id
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new DaoException("update book " + book + " faild because it is not in the database");
			}
		} catch (SQLException e) {
			throw new DaoException("update book: " + book + " faild", e);
		}
	}

	@Override
	public void delete(int id) throws DaoException {
		try (Connection con = DriverManager.getConnection(url, user, password);) {
			String sql = "delete from book where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new DaoException("delete book " + id + " faild because it is not in the database");
			}
		} catch (SQLException e) {
			throw new DaoException("delete book with id: " + id + " faild", e);
		}
	}

}
