package vn.iostar.ajax.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	private Long productId;

	private String productName;

	private int quantity;

	private double unitPrice;

	private String images;

	private String description;

	private double discount;

	private Date createDate;

	private short status;

}
