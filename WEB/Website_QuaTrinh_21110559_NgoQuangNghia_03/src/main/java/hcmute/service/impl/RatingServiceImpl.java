package hcmute.service.impl;

import java.util.List;

import hcmute.dao.IRatingDAO;
import hcmute.entity.RatingEntity;
import hcmute.dao.impl.RatingDAOImpl;
public class RatingServiceImpl implements IRatingDAO{
	IRatingDAO ratingDAO = new RatingDAOImpl();

	@Override
	public List<RatingEntity> findAll() {
		return ratingDAO.findAll();
	}

	@Override
	public void insert(RatingEntity ratingEntity) {
		ratingDAO.insert(ratingEntity);
	}

	@Override
	public void edit(RatingEntity ratingEntity) {
		ratingDAO.edit(ratingEntity);
	}

	@Override
	public void delete(int id) throws Exception {
		ratingDAO.delete(id);
	}

	@Override
	public RatingEntity findById(int id) {
		return ratingDAO.findById(id);
	}

}
