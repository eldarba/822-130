package c.dao.books;

public interface BookDao {

	/**
	 * 
	 * save a book to storage
	 * 
	 * @param book
	 * @return
	 * @throws DaoException
	 */
	int save(Book book) throws DaoException;

	/**
	 * 
	 * get a book from storage
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	Book get(int id) throws DaoException;

	/**
	 * update book in storage or throws an exception if the book is not in the
	 * database.
	 * 
	 * @param book
	 * @throws DaoException if the specified book not found
	 */
	void update(Book book) throws DaoException;

	/**
	 * delete book from storage
	 * 
	 * @param id
	 * @throws DaoException if the book of the specified id not found
	 */
	void delete(int id) throws DaoException;

}
