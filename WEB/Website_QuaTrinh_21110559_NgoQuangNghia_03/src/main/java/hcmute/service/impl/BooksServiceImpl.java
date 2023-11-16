package hcmute.service.impl;

import java.util.List;

import hcmute.entity.BooksEntity;
import hcmute.service.IBooksService;
import hcmute.dao.impl.BooksDAOImpl;
import hcmute.dao.IBooksDAO;
public class BooksServiceImpl implements IBooksService{
	IBooksDAO booksDAO = new BooksDAOImpl();
	
	@Override
	public List<BooksEntity> findAll() {
		return  booksDAO.findAll();
	}

	@Override
	public void insert(BooksEntity booksEntity) {
		 booksDAO.insert(booksEntity);		
	}

	@Override
	public void update(BooksEntity booksEntity) {
		 booksDAO.update(booksEntity);		
	}

	@Override
	public void delete(int bookid) throws Exception {
		 booksDAO.delete(bookid);		
	}

	@Override
	public BooksEntity findById(int bookid) {
		return  booksDAO.findById(bookid);
	}

}
