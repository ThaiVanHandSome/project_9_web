package hcmute.service.impl;

import java.util.List;

import hcmute.dao.IUsersDAO;
import hcmute.dao.impl.UsersDAOImpl;
import hcmute.entity.UsersEntity;
import hcmute.service.IUsersService;

public class UsersServiceImpl implements IUsersService{
	IUsersDAO usersDAO = new UsersDAOImpl();
	@Override
	public List<UsersEntity> findAll() {
		return usersDAO.findAll();
	}

	@Override
	public void insert(UsersEntity usersEntity) {
		usersDAO.insert(usersEntity);
	}

	@Override
	public void edit(UsersEntity usersEntity) {
		usersDAO.edit(usersEntity);
	}

	@Override
	public void delete(int id) throws Exception {
		usersDAO.delete(id);
	}

	@Override
	public UsersEntity findById(int id) {
		return usersDAO.findById(id);
	}

}
