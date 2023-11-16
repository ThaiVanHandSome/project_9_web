package hcmute.service;

import java.util.List;

import hcmute.entity.UsersEntity;

public interface IUsersService {
	List<UsersEntity> findAll();
	void insert(UsersEntity usersEntity);
	void edit (UsersEntity usersEntity);
	void delete(int id) throws Exception;
	UsersEntity findById(int id);
}
