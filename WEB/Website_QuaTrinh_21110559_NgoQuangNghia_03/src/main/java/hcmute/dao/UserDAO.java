package hcmute.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hcmute.entity.UsersEntity;

public class UserDAO extends AbstractDAO<UsersEntity>{
	public Long countAll() {
	    entitymanager.getTransaction().begin();
		TypedQuery<Long> count = entitymanager.createQuery("select count(o) from UsersEntity o", Long.class);
	    entitymanager.getTransaction().commit();
		return count.getSingleResult();
	}
	public List<UsersEntity> paginationPage(int index, int numberOfPage) {
	    entitymanager.getTransaction().begin();
	    TypedQuery<UsersEntity> query = entitymanager.createQuery("select o from UsersEntity o", UsersEntity.class);
	    List<UsersEntity> allUsers = query.getResultList();
	    entitymanager.getTransaction().commit();
	    int startIndex = index * numberOfPage;
	    int endIndex = Math.min(startIndex + numberOfPage, allUsers.size());
	    return allUsers.subList(startIndex, endIndex);
	}
}
