package c.dao.books;

public interface BookDao {

	/**
	 * 
	 * save a book to storage
	 * 
	 * @param book
	 * @throws DaoException
	 */
	void save(Book book) throws DaoException;

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
	 * update book in storage
	 * 
	 * @param book
	 * @throws DaoException
	 */
	void update(Book book) throws DaoException;

	/**
	 * delete book from storage
	 * 
	 * @param id
	 * @throws DaoException
	 */
	void delete(int id) throws DaoException;

}
