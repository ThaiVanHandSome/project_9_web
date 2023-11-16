package hcmute.dao;

import java.util.List;

import hcmute.entity.Author;

public interface IAuthorDao {
	List<Author> findAll();
	List<Author> findAuthorByAuthor(int author_id);
}
