package hcmute.entity;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name="Category")
@NamedQuery(name="Category.findAll", query="SELECT c from CategoryEntity c")
public class CategoryEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryID;
	@Column(columnDefinition ="nvarchar(1000)")
	private String categoryName;
	@Column(columnDefinition ="nvarchar(1000)")
	private String icon;
}
