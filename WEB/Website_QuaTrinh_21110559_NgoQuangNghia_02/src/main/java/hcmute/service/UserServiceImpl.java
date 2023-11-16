package hcmute.service;


import java.util.List;

import hcmute.dao.IUserDao;
import hcmute.dao.UserDaoImpl;
import hcmute.entity.User;

public class UserServiceImpl  implements IUserService{
	IUserDao userDao = new UserDaoImpl();

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findOne(int id) {
		return userDao.findOne(id);
	}

	@Override
	public int countAll() {
		return userDao.countAll();
	}

	@Override
	public List<User> paginationPage(int index) {
		return userDao.paginationPage(index);
	}
	

}
