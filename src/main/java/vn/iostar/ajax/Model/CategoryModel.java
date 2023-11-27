package vn.iostar.ajax.Model;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {
	private Long categoryId;
	@NotEmpty
	@Length(min=5)
	private String categoryName;
	private String icon;
	private MultipartFile imagefile;
	private Boolean isEdit = false;
}
