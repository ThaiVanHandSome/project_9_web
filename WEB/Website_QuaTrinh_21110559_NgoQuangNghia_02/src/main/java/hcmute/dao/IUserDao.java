package hcmute.dao;

import java.util.List;

import hcmute.entity.Book;
import hcmute.entity.User;

public interface IUserDao {
	List<User> findAll();
	User findOne(int id);
	int countAll();
	List<User> paginationPage(int index);
}
