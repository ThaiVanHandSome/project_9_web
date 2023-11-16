package hcmute.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Category")
public class CategoryEntity {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int categoryId;

	    @Column(name = "CategoryName")
	    private String categoryName;

	    @Column(name = "Categorycode")
	    private String categorycode;

	    @Column(name = "Images")
	    private String images;

	    @Column(name = "Status")
	    private int status;
	    
	    @OneToMany(mappedBy = "category")
		List<VideosEntity> videosEntities;
}
