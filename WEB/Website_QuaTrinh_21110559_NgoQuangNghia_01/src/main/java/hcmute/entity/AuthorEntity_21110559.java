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
@Table(name = "author")
public class AuthorEntity_21110559 implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
	private int authorID;
    @Column(name = "author_name")
	private String authorName;
    @Column(name = "date_of_birth", columnDefinition = "DATE") 
    private String dateOfBirth;
    @OneToMany(mappedBy = "author")
  	List<BookAuthorEntity_21110559> bookAuthorEntities;
}
