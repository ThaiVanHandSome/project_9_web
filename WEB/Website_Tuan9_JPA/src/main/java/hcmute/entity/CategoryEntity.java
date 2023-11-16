package hcmute.entity;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name="Category")
@NamedQuery(name="Category.findAll", query="SELECT c from CategoryEntity c")
public class CategoryEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CategoryID;
	@Column(columnDefinition ="nvarchar(1000)")
	private String CategoryName;
	@Column(columnDefinition ="nvarchar(1000)")
	private String icon;
	@OneToMany(mappedBy ="category", fetch=FetchType.EAGER)
	private List<ProductEntity> products;
}
