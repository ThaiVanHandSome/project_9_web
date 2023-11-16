package hcmute.entity;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rating", uniqueConstraints = {@UniqueConstraint(columnNames = {"bookid","userid"})}) 
public class RatingEntity_21110559 implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name="userid")
	private UsersEntity_21110559 user;
	@ManyToOne
	@JoinColumn(name="bookid")
	private BooksEntity_21110559 book;
	private int rating;
	private String review_text;
}
