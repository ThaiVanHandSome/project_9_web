package hcmute.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hcmute.entity.VideosEntity;

public class VideosDAO extends AbstractDAO<VideosEntity>{
	public Long countAll() {
	    entitymanager.getTransaction().begin();
		TypedQuery<Long> count = entitymanager.createQuery("select count(o) from VideosEntity o", Long.class);
	    entitymanager.getTransaction().commit();
		return count.getSingleResult();
	}
	public List<VideosEntity> paginationPage(int index, int numberOfPage) {
	    entitymanager.getTransaction().begin();
	    TypedQuery<VideosEntity> query = entitymanager.createQuery("select o from VideosEntity o", VideosEntity.class);
	    List<VideosEntity> author = query.getResultList();
	    entitymanager.getTransaction().commit();

	    int startIndex = index * numberOfPage;
	    int endIndex = Math.min(startIndex + numberOfPage, author.size());

	    return author.subList(startIndex, endIndex);
	}
}
