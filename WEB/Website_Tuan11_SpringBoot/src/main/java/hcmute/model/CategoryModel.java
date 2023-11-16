package hcmute.model;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel{
	private Long categoryId;
	@NotEmpty
	@Length(min=5)
	private String categoryName;
	private String icon;
	private MultipartFile imageFile;
	private Boolean isEdit = false;
}
