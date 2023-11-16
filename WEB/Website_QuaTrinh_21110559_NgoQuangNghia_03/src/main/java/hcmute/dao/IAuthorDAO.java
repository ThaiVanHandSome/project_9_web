package hcmute.dao;

import java.util.List;

import hcmute.entity.AuthorEntity;

public interface IAuthorDAO {
	List<AuthorEntity> findAll();
	void insert(AuthorEntity authorEntity);
	void update (AuthorEntity authorEntity);
	void delete(int authorid) throws Exception;
	AuthorEntity findById(int authorid);
}
