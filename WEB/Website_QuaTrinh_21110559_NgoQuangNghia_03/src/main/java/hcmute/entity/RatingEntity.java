package hcmute.entity;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
public class RatingEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private int bookid;
	private int isbn;
	private String title;
	private String publisher;
	private Double price;
    private String description;
	Date publish_date = new Date();
	private String cover_image;
	private int quantity;
}
