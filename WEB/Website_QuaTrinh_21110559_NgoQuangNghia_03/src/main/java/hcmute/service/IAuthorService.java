package hcmute.service;

import java.util.List;

import hcmute.entity.AuthorEntity;

public interface IAuthorService {
	List<AuthorEntity> findAll();
	void insert(AuthorEntity authorEntity);
	void update (AuthorEntity authorEntity);
	void delete(int authorid) throws Exception;
	AuthorEntity findById(int authorid);
}
