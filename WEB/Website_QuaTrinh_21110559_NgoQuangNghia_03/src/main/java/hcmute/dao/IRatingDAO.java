package hcmute.dao;
import java.util.List;

import hcmute.entity.RatingEntity;
public interface IRatingDAO {
	List<RatingEntity> findAll();
	void insert(RatingEntity ratingEntity);
	void edit (RatingEntity ratingEntity);
	void delete(int id) throws Exception;
	RatingEntity findById(int id);
}
