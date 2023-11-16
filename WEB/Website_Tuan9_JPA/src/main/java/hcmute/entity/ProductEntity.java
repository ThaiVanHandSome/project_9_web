package hcmute.entity;
import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;
@Data
@Entity
@Table(name="Product")
@NamedQuery(name="Product.findAll", query="SELECT c from ProductEntity c")
public class ProductEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int ProductID;
	@Column(columnDefinition ="nvarchar(1000)")
	private String ProductName;
	@Column(columnDefinition ="nvarchar(2000)")
	private String Description;
	private int Price;
	@Column(columnDefinition ="nvarchar(1000)")
	private String imageLink;
	private int CategoryID;
	private int SellerID;
	private int Amount;
	private int stoke;
	@ManyToOne 
	@JoinColumn(name="CategoryID")
	private CategoryEntity category;
}
