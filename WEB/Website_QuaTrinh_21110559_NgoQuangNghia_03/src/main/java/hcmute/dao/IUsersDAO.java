package hcmute.dao;

import java.util.List;

import hcmute.entity.UsersEntity;
public interface IUsersDAO {
	List<UsersEntity> findAll();
	void insert(UsersEntity usersEntity);
	void edit (UsersEntity usersEntity);
	void delete(int id) throws Exception;
	UsersEntity findById(int id);
}
