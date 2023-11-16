package hcmute.service.impl;

import java.util.List;

import hcmute.dao.IBookAuthorDAO;
import hcmute.dao.impl.BookAuthorDAOImpl;
import hcmute.entity.BookAuthorEntity;

public class BookAuthorServiceImpl implements IBookAuthorDAO {
	IBookAuthorDAO bookAuthorDAO = new BookAuthorDAOImpl();

	@Override
	public List<BookAuthorEntity> findAll() {
		return bookAuthorDAO.findAll();
	}

	@Override
	public void insert(BookAuthorEntity bookAuthorEntity) {
		bookAuthorDAO.insert(bookAuthorEntity);
	}

	@Override
	public void edit(BookAuthorEntity bookAuthorEntity) {
		bookAuthorDAO.edit(bookAuthorEntity);		
	}

	@Override
	public void delete(int id) throws Exception {
		bookAuthorDAO.delete(id);		
	}

	@Override
	public BookAuthorEntity findById(int id) {
		return bookAuthorDAO.findById(id);
	}

}
