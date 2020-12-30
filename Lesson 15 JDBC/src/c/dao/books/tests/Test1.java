package c.dao.books.tests;

import javax.swing.JOptionPane;

import c.dao.books.BookDao;
import c.dao.books.BookDaoDb;
import c.dao.books.DaoException;

public class Test1 {

	public static void main(String[] args) {

		BookDao bookDao = new BookDaoDb();

		{ // saving books using DAO
//			Book book1 = new Book(701, "English", "Dan", 59.30, LocalDate.of(2020, 1, 20));
//			Book book2 = new Book(702, "Hebrew", "Ronit", 30.90, LocalDate.of(2019, 4, 1));
//			Book book3 = new Book(703, "Arabic", "Yaniv", 48.70, LocalDate.of(2017, 6, 14));
//
//			try {
//				bookDao.save(book1);
//				bookDao.save(book2);
//				bookDao.save(book3);
//				System.out.println("books saved");
//			} catch (DaoException e) {
//				e.printStackTrace();
//			}
		}

		{ // getting a book
//			try {
//				int id = Integer.parseInt(JOptionPane.showInputDialog("enter book id"));
//				Book book = bookDao.get(id);
//				System.out.println(book);
//			} catch (DaoException e) {
//				e.printStackTrace();
//			}
		}

		{ // updating an existing book
//			try {
//				// get a book
//				int id = Integer.parseInt(JOptionPane.showInputDialog("enter book id"));
//				Book book = bookDao.get(id);
//				System.out.println(book);
//				if (book != null) {
//					// update the price in the object
//					book.setPrice(book.getPrice() * 1.1);
//					// update the price in the database
//					bookDao.update(book);
//					System.out.println(book);
//				} else {
//					System.out.println("book with id: " + id + " not found");
//				}
//			} catch (DaoException e) {
//				e.printStackTrace();
//			}
		}

		{ // updating a non existing book - will throw an exception
//			try {
//				// create a book instance
//				Book book = new Book(-1, "aaa", "vvv", 100, LocalDate.now());
//				bookDao.update(book);
//				System.out.println(book);
//			} catch (DaoException e) {
////				e.printStackTrace();
//				JOptionPane.showMessageDialog(null, e.getMessage());
//			}
		}

		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("enter book id to delete"));
			try {
				bookDao.delete(id);
				System.out.println("book " + id + " deleted");
			} catch (DaoException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}

	}

}
