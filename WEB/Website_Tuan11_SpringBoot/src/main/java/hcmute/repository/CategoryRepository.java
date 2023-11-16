package hcmute.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.entity.Category;
@Repository
//Long là kiểu dữ liệu của khóa chính
public interface CategoryRepository extends JpaRepository<Category, Long>{
	// viết thêm tìm kiếm, phân trang
}
