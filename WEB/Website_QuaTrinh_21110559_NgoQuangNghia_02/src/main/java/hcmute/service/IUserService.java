package hcmute.service;

import java.util.List;

import hcmute.entity.User;

public interface IUserService {
	List<User> findAll();
	User findOne(int id);
	int countAll();
	List<User> paginationPage(int index);
}
