package hcmute.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Videos",uniqueConstraints = {@UniqueConstraint(columnNames = {"categoryId"})}) 
public class VideosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int videoid;

    @Column(name = "Title")
    private String title;
    
    @Column(name = "Poster")
    private String poster;

    @Column(name = "Views")
    private int views;

    @Column(name = "Description")
    private String description;

    @Column(name = "Active") 
    private int active;

    @OneToMany(mappedBy = "video")
	List<SharesEntity> sharesEntities;
    
    @OneToMany(mappedBy = "video")
	List<FavoritesEntity> favoritesEntities;
    
    @ManyToOne
	@JoinColumn(name="categoryId")
	private CategoryEntity category;
    
}
