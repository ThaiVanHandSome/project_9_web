package hcmute.service;

import java.util.List;

import hcmute.dao.AuthorDaoImpl;
import hcmute.dao.IAuthorDao;
import hcmute.entity.Author;

public class AuthorSeriveImpl implements IAuthorService{
	IAuthorDao authorDao = new AuthorDaoImpl();
	@Override
	public List<Author> findAll() {
		return authorDao.findAll();
	}
}
