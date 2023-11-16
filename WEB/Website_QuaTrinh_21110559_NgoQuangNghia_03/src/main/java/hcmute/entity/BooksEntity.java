package hcmute.entity;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
@NamedQuery(name = "books.findAll", query = "SELECT c FROM BooksEntity c")
public class BooksEntity implements Serializable{
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
	private Double price;
    @Column(name = "description")
    private String description;
//	Date publish_date = new Date();
    @Column(name = "publish_date")
    private String publish_date;
    @Column(name = "cover_image")
	private String cover_image;
    @Column(name = "quantity")
	private int quantity;
}
