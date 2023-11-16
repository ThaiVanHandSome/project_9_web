package hcmute.service;

import java.util.List;

import hcmute.dao.BookDaoImpl;
import hcmute.dao.IBookDao;
import hcmute.entity.Book;

public class BookServiceimpl implements IBookService{
	IBookDao bookDao = new BookDaoImpl();
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Book findOne(int bookid) {
		return bookDao.findOne(bookid);
	}
	
	@Override
	public void insert(Book book) {
		bookDao.insert(book);
		
	}
	
	@Override
	public void update(Book book) {
		bookDao.update(book);
	}

	@Override
	public void delete(int bookid) {
		bookDao.delete(bookid);
	}

	@Override
	public int countAll() {
		return bookDao.countAll();
	}

	@Override
	public List<Book> paginationPage(int index, int numberOfPage) {
		return bookDao.paginationPage(index, numberOfPage);
	}

	@Override
	public List<Book> findBookByAuthor(int author_id) {
		return bookDao.findBookByAuthor(author_id);
	}

	@Override
	public List<Book> findAll_DESC() {
		return bookDao.findAll_DESC();
	}
}
