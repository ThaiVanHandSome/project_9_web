package hcmute.service;

import java.util.List;

import hcmute.entity.BookAuthorEntity;

public interface IBookAuthorService {
	List<BookAuthorEntity> findAll();
	void insert(BookAuthorEntity bookAuthorEntity);
	void edit (BookAuthorEntity bookAuthorEntity);
	void delete(int id) throws Exception;
	BookAuthorEntity findById(int id);
}
