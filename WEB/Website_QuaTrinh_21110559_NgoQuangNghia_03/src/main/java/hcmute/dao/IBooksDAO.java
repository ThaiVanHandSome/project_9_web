package hcmute.dao;
import java.util.List;

import hcmute.entity.BooksEntity;
public interface IBooksDAO {
	List<BooksEntity> findAll();
	void insert(BooksEntity booksEntity);
	void update (BooksEntity booksEntity);
	void delete(int bookid) throws Exception;
	BooksEntity findById(int bookid);
}
