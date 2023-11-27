package vn.iostar.ajax.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.ajax.Entity.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	//Tìm Kiếm theo nội dung tên
	List<Product> findByProductNameContaining(String name);

	//Tìm kiếm và Phân trang
	Page<Product> findByProductNameContaining(String name, Pageable pageable);

	Optional<Product> findByProductName(String name);

	Optional<Product> findByCreateDate(Date createAt);
}