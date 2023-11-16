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

@Table(name="Shares",uniqueConstraints = {@UniqueConstraint(columnNames = {"Videoid","Username"})}) 
public class SharesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shareId;

    @Column(name = "Emails")
    private String emails;

    @Column(name = "SharedDate", columnDefinition = "DATE")
    private Date sharedDate;

    @ManyToOne
	@JoinColumn(name="VideoId")
	private VideosEntity video;
    @ManyToOne
	@JoinColumn(name="Username")
	private UsersEntity user;
}
