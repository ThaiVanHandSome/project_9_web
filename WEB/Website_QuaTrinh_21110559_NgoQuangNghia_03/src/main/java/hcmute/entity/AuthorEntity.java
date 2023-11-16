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
@Table(name = "author")
@NamedQuery(name = "author.findAll", query = "SELECT c FROM AuthorEntity c")
public class AuthorEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
	private int authorID;
    @Column(name = "author_name")
	private String authorName;
//	@Column(name="date_of_birth") 
//	@Temporal(TemporalType.DATE)
//    private Date date_of_birth;
    @Column(name = "date_of_birth")
   	private String dateOfBirth;
}
