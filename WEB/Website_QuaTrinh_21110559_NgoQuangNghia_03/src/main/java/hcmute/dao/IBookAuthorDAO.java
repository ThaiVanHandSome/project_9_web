package hcmute.dao;

import java.util.List;

import hcmute.entity.BookAuthorEntity;

public interface IBookAuthorDAO {
	List<BookAuthorEntity> findAll();
	void insert(BookAuthorEntity bookAuthorEntity);
	void edit (BookAuthorEntity bookAuthorEntity);
	void delete(int id) throws Exception;
	BookAuthorEntity findById(int id);
}
