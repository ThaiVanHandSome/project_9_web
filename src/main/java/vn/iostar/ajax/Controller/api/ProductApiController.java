package vn.iostar.ajax.Controller.api;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import vn.iostar.ajax.Entity.*;
import vn.iostar.ajax.Model.*;

import vn.iostar.ajax.Service.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@RestController
@RequestMapping(path = "/api/product")
public class ProductApiController {
	@Autowired
	private IProductService productService;
	@Autowired
	IStorageService storageService;

	@GetMapping
	public ResponseEntity<?> getAllProduct() {
//return ResponseEntity.ok().body(categoryService.findAll());
		return new ResponseEntity<Response>(new Response(true, "Thành công", productService.findAll()), HttpStatus.OK);
	}

	@PostMapping(path = "/getProduct")
	public ResponseEntity<?> getProduct(@Validated @RequestParam("id") Long id) {
		Optional<Product> product = productService.findById(id);
		if (product.isPresent()) {
			// return ResponseEntity.ok().body(category.get());
			return new ResponseEntity<Response>(new Response(true, "Thành công", product.get()), HttpStatus.OK);
		} else {
			// return ResponseEntity.notFound().build();
			return new ResponseEntity<Response>(new Response(false, "Thất bại", null), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = "/addProduct")
	public ResponseEntity<?> addProduct(@Validated @RequestParam("productName") String productName,
			@Validated @RequestParam("quantity") int quantity,
			@Validated @RequestParam("unitPrice") double unitPrice,
			@Validated @RequestParam("images") MultipartFile images,
			@Validated @RequestParam("description") String description,
			@Validated @RequestParam("discount") double discount,
			@Validated @RequestParam("createDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date createDate,
			@Validated @RequestParam("status") short status
			){
		Optional<Product> optProduct = productService.findByProductName(productName);
		if (optProduct.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product đã tồn tại trong hệ thống");
			// return new ResponseEntity<Response>(new Response(false, "Loại sản phẩm này đã
			// tồn tại trong hệ thống", optCategory.get()), HttpStatus.BAD_REQUEST);
		} else {
			Product product = new Product();
			// kiểm tra tồn tại file, lưu file
			if (!images.isEmpty()) {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				// lưu file vào trường Images
				product.setImages(storageService.getSorageFilename(images, uuString));
				
				storageService.store(images, product.getImages());
			}
			product.setProductName(productName);
			product.setQuantity(quantity);
			product.setUnitPrice(unitPrice);
			product.setDescription(description);
			product.setDiscount(discount);
			product.setCreateDate(createDate);
			product.setStatus(status);
			productService.save(product);
			// return ResponseEntity.ok().body(category);
			return new ResponseEntity<Response>(new Response(true, "Thêm Thành công", product), HttpStatus.OK);
		}
	}
	
	@PutMapping(path = "/updateProduct")
	public ResponseEntity<?> updateCategory(@Validated @RequestParam("productId") Long productId,
			@Validated @RequestParam("productName") String productName,
			@Validated @RequestParam("quantity") int quantity,
			@Validated @RequestParam("unitPrice") double unitPrice,
			@Validated @RequestParam("images") MultipartFile images,
			@Validated @RequestParam("description") String description,
			@Validated @RequestParam("discount") double discount,
			@Validated @RequestParam("createDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date createDate,
			@Validated @RequestParam("status") short status
			){
		Optional<Product> optProduct = productService.findById(productId);
		if (optProduct.isEmpty()) {
			return new ResponseEntity<Response>(new Response(false, "Không tìm thấy Product", null),
					HttpStatus.BAD_REQUEST);
		} else if (optProduct.isPresent()) {
			// kiểm tra tồn tại file, lưu file
			if (!images.isEmpty()) {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				// lưu file vào trường Images
				optProduct.get().setImages(storageService.getSorageFilename(images, uuString));
			
				storageService.store(images, optProduct.get().getImages());
			}
			optProduct.get().setProductName(productName);
			optProduct.get().setQuantity(quantity);
			optProduct.get().setUnitPrice(unitPrice);
			optProduct.get().setDescription(description);
			optProduct.get().setDiscount(discount);
			optProduct.get().setCreateDate(createDate);
			optProduct.get().setStatus(status);
			
			productService.save(optProduct.get());
			// return ResponseEntity.ok().body(category);
			return new ResponseEntity<Response>(new Response(true, "Cập nhật Thành công", optProduct.get()),
					HttpStatus.OK);
		}
		return null;
	}

	@DeleteMapping(path = "/deleteProduct")
	public ResponseEntity<?> deleteProduct(@Validated @RequestParam("productId") Long productId) {
		Optional<Product> optProduct = productService.findById(productId);
		if (optProduct.isEmpty()) {
			return new ResponseEntity<Response>(new Response(false, "Không tìm thấy Product", null),
					HttpStatus.BAD_REQUEST);
		} else if (optProduct.isPresent()) {
			productService.delete(optProduct.get());
			// return ResponseEntity.ok().body(category);
			return new ResponseEntity<Response>(new Response(true, "Xóa Thành công", optProduct.get()), HttpStatus.OK);
		}
		return null;
	}
}
