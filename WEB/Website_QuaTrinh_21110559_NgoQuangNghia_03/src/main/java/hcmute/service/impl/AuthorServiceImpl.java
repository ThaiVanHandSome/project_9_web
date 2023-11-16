package hcmute.service.impl;

import java.util.List;


import hcmute.entity.AuthorEntity;
import hcmute.service.IAuthorService;
import hcmute.dao.impl.AuthorDAOImpl;
import hcmute.dao.IAuthorDAO;
public class AuthorServiceImpl implements IAuthorService{
	IAuthorDAO authorDAO = new AuthorDAOImpl();

	@Override
	public List<AuthorEntity> findAll() {
		return authorDAO.findAll();
	}

	@Override
	public void insert(AuthorEntity authorEntity) {
		authorDAO.insert(authorEntity);
	}

	@Override
	public void update(AuthorEntity authorEntity) {
		authorDAO.update(authorEntity);
	}

	@Override
	public void delete(int authorid) throws Exception {
		authorDAO.delete(authorid);
	}

	@Override
	public AuthorEntity findById(int authorid) {
		return authorDAO.findById(authorid);
	}

}
