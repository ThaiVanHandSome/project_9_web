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
@Table(name="book_author",uniqueConstraints = {@UniqueConstraint(columnNames = {"bookid","author_id"})}) 
public class BookAuthorEntity_21110559 implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name="author_id")
	private AuthorEntity_21110559 author;
	@ManyToOne
	@JoinColumn(name="bookid")
	private BooksEntity_21110559 book;
}
