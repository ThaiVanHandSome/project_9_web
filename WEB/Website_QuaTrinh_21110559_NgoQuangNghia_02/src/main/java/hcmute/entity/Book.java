package hcmute.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book implements Serializable{
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
	private int price;
    @Column(name = "description")
    private String description;
    @Column(name = "publish_date", columnDefinition = "DATE") 
    private Date publish_date;
    @Column(name = "cover_image")
	private String cover_image;
    @Column(name = "quantity")
	private int quantity;

}
