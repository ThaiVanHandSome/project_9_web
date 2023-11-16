package hcmute.service;

import java.util.List;

import hcmute.entity.BookAuthorEntity;
import hcmute.entity.BooksEntity;

public interface IBooksService {
	List<BooksEntity> findAll();
	void insert(BooksEntity booksEntity);
	void update (BooksEntity booksEntity);
	void delete(int bookid) throws Exception;
	BooksEntity findById(int bookid);
}
