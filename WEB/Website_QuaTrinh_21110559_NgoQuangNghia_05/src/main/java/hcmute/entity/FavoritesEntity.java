package hcmute.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="Favorites",uniqueConstraints = {@UniqueConstraint(columnNames = {"VideoId","Username"})}) 
public class FavoritesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favoritesId;

    @Column(name = "LikedDate", columnDefinition = "DATE")
    private Date likedDate;

    @ManyToOne
	@JoinColumn(name="VideoId")
	private VideosEntity video;
    @ManyToOne
	@JoinColumn(name="Username")
	private UsersEntity user;
}
