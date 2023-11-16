package hcmute.entity;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BooksEntity_21110559 implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookid;
    @Column(name = "isbn")
	private int isbn;
    @Column(name = "title")
	private String title;
    @Column(name = "publisher")
	private String publisher;
    @Column(name = "price")
	private float price;
    @Column(name = "description")
    private String description;
    @Column(name = "publish_date", columnDefinition = "DATE") 
    private String publish_date;
    @Column(name = "cover_image")
	private String cover_image;
    @Column(name = "quantity")
	private int quantity;
    @OneToMany(mappedBy = "book")
	List<BookAuthorEntity_21110559> bookAuthorEntities;
    @OneToMany(mappedBy = "book")
	List<RatingEntity_21110559> ratingEntities;
}
